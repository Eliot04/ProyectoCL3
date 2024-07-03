package Dao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class ParseoDouble {
	    public static double getDoubleParameter(HttpServletRequest request, String parameterName) throws ServletException {
	        String parameterValue = request.getParameter(parameterName);
	        try {
	            return Double.parseDouble(parameterValue);
	        } catch (NumberFormatException e) {
	            throw new ServletException("Invalid format for parameter: " + parameterName, e);
	        }
	    }
	

}
