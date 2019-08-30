package com.fidelity.calcpi;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class CalculatePiServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		out.println("<html><h2>Response (calculate PI) at " + new Date() + "</h2>");
		
		// get request parameters
		String arg = null;
		PiCalculatorFactory.Method method;
		try {
			arg = req.getParameter("method");
			method = PiCalculatorFactory.Method.valueOf(arg);
		} catch (Exception e){
			// use default
			out.println("<h3>Unknown method {" + arg + "}, so using default</h3>");
			method = PiCalculatorFactory.Method.Machin;
		}
		int digits;
		try {
			arg = req.getParameter("digits");
			digits = Integer.parseInt(arg);
		} catch (Exception e){
			out.println("<h3>Can't understand digits {" + arg + "}, so using default</h3>");
			digits = 4;
		}

		// calculate
		out.println("<h4>Result of computing PI to " + digits + " digits using the method of " + method + "</h4>");
		out.println("<p>");
		PiCalculator calc = PiCalculatorFactory.create(method);
		BigDecimal pi = calc.compute(digits);
		
		// break into 50-character columns
		String s = pi.toString();
		final int INCR = 50;
		for (int i=0; i < s.length(); i += INCR){
			int end = i + INCR;
			if (end > s.length()){
				end = s.length();
			}
			out.println(s.substring(i, end));
			out.println("<br/>");
		}
		out.println("</p>");
		out.println("</html>");
	}
	
}
