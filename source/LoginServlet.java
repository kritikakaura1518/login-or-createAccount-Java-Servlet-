package test;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {
 
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
  {
   // TODO Auto-generated method stub 
	 PrintWriter out=res.getWriter();
  String uname=req.getParameter("username");
  String pwd=req.getParameter("password");
  try {
	  
	   if(LoginDao.validate(uname, pwd))
		{
		 
		RequestDispatcher rd=req.getRequestDispatcher("servlet2");
		   rd.forward(req,res);
		   
		}
	  else
	  {
	  
	   
	   RequestDispatcher rd=req.getRequestDispatcher("login.html");
	   rd.include(req,res);
	   out.println("User name or password is incorrect");
	   
	  }
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
  
  }
  
 

}