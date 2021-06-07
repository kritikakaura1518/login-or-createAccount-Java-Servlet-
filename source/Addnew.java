package test;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
public class Addnew extends HttpServlet {
	 /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	  {
		 PrintWriter out=res.getWriter();
		  String uname=req.getParameter("username");
		  String pwd=req.getParameter("password");
		  String name=req.getParameter("n1");
		  String n=req.getParameter("gender");
		  String ag=req.getParameter("n3");
		  String oc=req.getParameter("n4");
		  String l=req.getParameter("n5");
		 
		 
		 try {
			 if(LoginDao.check(uname))
			  {
				 res.setContentType("text/html");  
				 out.println("<script type=\"text/javascript\">");  
				 out.println("alert('Username already exist.');");  
				 out.println("</script>");
				  RequestDispatcher rd=req.getRequestDispatcher("newaccount.html");
				   rd.include(req,res);
				  
			  }
			 else if(LoginDao.AddAccount(uname, pwd, name, n, ag, oc, l))
			{
				 res.setContentType("text/html");  
				 out.println("<script type=\"text/javascript\">");  
				 out.println("alert('Account Created.');");  
				 out.println("</script>");
				RequestDispatcher rd=req.getRequestDispatcher("login.html");
				   rd.include(req,res);
			}
			else
			{
				out.print("not added");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  
	  }
	
}

