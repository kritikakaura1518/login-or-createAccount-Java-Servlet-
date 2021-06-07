package test;
import java.sql.*;
public class LoginDao {
	static Connection con = DBUtil.getDBConnection();
	 static PreparedStatement ps,ps1;
	 static boolean status=false;
	public static boolean validate(String n, String p) throws SQLException {
		
			
		
		// TODO Auto-generated method stub
		 
		 
		  ps=con.prepareStatement("select * from logininfo where username=? and password=?");
		  ps.setString(1, n);
		  ps.setString(2, p);
		  ResultSet rs=ps.executeQuery();
		  status=rs.next();  
		  
		return status;
	}
public static boolean check(String uname)throws SQLException {
	
	ps=con.prepareStatement("select * from logininfo where username=?" );
			 ps.setString(1, uname);
			 ResultSet rs=ps.executeQuery();
			  status=rs.next();  
			  
			return status;
			
	
}
	public static boolean AddAccount(String uname, String pwd, String name, String n, String ag, String oc, String l) throws SQLException {
		// TODO Auto-generated method stub
		int age = Integer.parseInt(ag);
		double p=Double.parseDouble(l);
		 
		 ps=con.prepareStatement("insert into userinfo values(?,?,?,?,?,?,?)");
		 ps.setString(1, uname);
		  ps.setString(2, pwd);
		  ps.setString(3, name);
		  ps.setString(4, n);
		  ps.setInt(5, age);
		  ps.setString(6, oc);
		  ps.setFloat(7, (float) p);
		  ResultSet rs=ps.executeQuery();
		  ps1=con.prepareStatement("insert into logininfo values(?,?)");
		  ps1.setString(1, uname);
		  ps1.setString(2, pwd);
		  ResultSet rs1=ps1.executeQuery();
		  status=rs.next();
		return status;
	}
}
