package com.fidelity.calcpi;

import java.math.BigDecimal;

public interface PiCalculator {
	/**
	 * How accurate should PI be calculated?
	 * @return the digits of PI
	 */
	BigDecimal compute(int digits);
}
