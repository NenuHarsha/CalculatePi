package com.fidelity.calcpi;

import java.math.BigDecimal;

public class MachinPiCalculator implements PiCalculator {

	@Override
	public BigDecimal compute(int digits) {
		// when will this have converged?
		BigDecimal allowedDiff = BigDecimal.ONE.divide(BigDecimal.TEN.pow(digits));
		//System.out.println("Allowed difference is: " + allowedDiff);
		
		int k = 0;
		BigDecimal pi = BigDecimal.ZERO;
		
		while (true){
			double term = 4 * (4 * compute_arctan_term(k, 0.2) - compute_arctan_term(k, 1.0/239));
			BigDecimal update = new BigDecimal(term);
			pi = pi.add(update);

			// converged if the update value is less than allowed difference
			if (update.abs().compareTo(allowedDiff) < 0){
				return pi;
			}

			//System.out.println(k + " terms: " + pi);
			++k;
		}
		
	}

	private double compute_arctan_term(int k, double x){
		double num = Math.pow(-1, k) * Math.pow(x, 2*k + 1);
		return (num / (2*k+1));
	}
}
