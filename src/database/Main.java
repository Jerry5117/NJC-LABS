package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		getConnection();
	}
	

	public static Connection getConnection() throws Exception{
			String driver =  "com.mysql.jdbc.Driver";
			String url =  "jdbc:mysql://localhost:3306/jerrynew";
			String username ="root";
			String password = "1234";
			
			Connection conn = DriverManager.getConnection(url,username,password);

		    String query = "INSERT INTO employee (name,place)" + "VALUES (?, ? )";
		    
		    PreparedStatement preparedStmt = conn.prepareStatement(query);
		    preparedStmt.setString (1, "melvi");
		    preparedStmt.setString   (2, "kottayam");    
		    preparedStmt.execute();
	      	    
		    Statement mystatement = conn.createStatement();
		    ResultSet Main=mystatement.executeQuery("select * from employee");
		    while(Main.next())
		      {
		          System.out.println(Main.getString("id")+" "+Main.getString("name")+" "+Main.getString("place"));  
		          
		      }
			return conn;				
	}
}
