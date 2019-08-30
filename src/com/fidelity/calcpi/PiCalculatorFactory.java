package com.fidelity.calcpi;

public class PiCalculatorFactory {
	
	public static enum Method {
		Madhava,
		Machin,
	}
	
	public static PiCalculator create(Method m){
		if (m == Method.Madhava){
			return new MadhavaPiCalculator();
		}
		else if (m == Method.Machin){
			return new MachinPiCalculator();
		}
		throw new UnsupportedOperationException("Not implemented: " + m.toString());
	}
}
