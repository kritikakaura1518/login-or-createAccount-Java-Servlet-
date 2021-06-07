package test;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	public static Connection getDBConnection(){
		Connection con=null;
	
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","KRITIKAKAURA","kritika@1928");
			//System.out.print("Connection done");
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return con;

	}}
