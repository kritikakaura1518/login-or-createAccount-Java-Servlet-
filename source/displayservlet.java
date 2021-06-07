package test;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class displayservlet extends HttpServlet {
	 
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	  {
		PrintWriter out = res.getWriter();
		res.setContentType("text/html"); 
		 
		String n = req.getParameter("username"); 
		
		out.print("welcome"+n);
		  
		}
		
	  }