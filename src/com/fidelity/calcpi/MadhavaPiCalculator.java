package com.fidelity.calcpi;

import java.math.BigDecimal;

public class MadhavaPiCalculator implements PiCalculator {

	@Override
	public BigDecimal compute(int digits) {
		// when will this have converged?
		BigDecimal allowedDiff = BigDecimal.ONE.divide(BigDecimal.TEN.pow(digits));
		//System.out.println("Allowed difference is: " + allowedDiff);
		
		int k = 0;
		BigDecimal pi = BigDecimal.ZERO;
		final int MAX_ITER = 1000 * 1000 * 100;
		
		while (k < MAX_ITER){
			double term = 4 * Math.pow(-1, k) / (2*k+1);
			BigDecimal update = new BigDecimal(term);
			pi = pi.add(update);

			// converged if the update value is less than allowed difference
			if (update.abs().compareTo(allowedDiff) < 0){
				return pi;
			}

			// if (k%100000 == 0) System.out.println(k + " terms: " + pi);
			++k;
		}
		
		throw new IllegalArgumentException("Too many iterations to compute to " + digits + " digits.");
	}

}
