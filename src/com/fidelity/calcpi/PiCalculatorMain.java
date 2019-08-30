package com.fidelity.calcpi;


import java.math.BigDecimal;

import com.fidelity.calcpi.PiCalculatorFactory.Method;

public class PiCalculatorMain {

	public static void main(String[] args){
		new PiCalculatorMain().run_tests();
	}
	
	private void run_tests(){
		run_test(Method.Machin, 1000);
		run_test(Method.Madhava, 6);
	}
	
	private void run_test(Method m, int digits){
		// long start = System.currentTimeMillis();
		PiCalculator calc = PiCalculatorFactory.create(m);
		BigDecimal pi = calc.compute(digits);
		System.out.println(m + " to " + digits + " accuracy: " + pi);
		// long end = System.currentTimeMillis();
		// System.out.println("Took: " + (end-start) + "ms");
	}

}
