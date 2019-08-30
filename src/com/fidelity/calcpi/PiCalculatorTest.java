package com.fidelity.calcpi;


import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.fidelity.calcpi.PiCalculatorFactory.Method;

public class PiCalculatorTest {

	@Test
	public void testMachin(){
		run_test(Method.Machin, 1000);
	}
	
	@Test
	public void testMadhava(){
		run_test(Method.Madhava, 6);
	}
	
	private void run_test(Method m, int digits){
		PiCalculator calc = PiCalculatorFactory.create(m);
		BigDecimal pi = calc.compute(digits);
		System.out.println(m + " to " + digits + " accuracy: " + pi);
		Assert.assertEquals(Math.PI, pi.doubleValue(), 0.0001);
	}

}
