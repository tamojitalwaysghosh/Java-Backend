package jdbc;

import java.sql.*;

public class JdbcExample {
	public static void main(String[] args) {
		try {
			//step 1: register the driver --> import
			
			//step 2: load the driver 
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//step 3: establish the connection
			String url = "jdbc:mysql://127.0.0.1:3306/emp";
			String userName = "root";
			String password = "Moumita#1999";
			
			Connection con = DriverManager.getConnection(url, userName,password);
			
			//step 4: create statement
			Statement stm = con.createStatement();
			
			//step 5: execute query
			String query = "INSERT INTO employee VALUES(7, 'rob', 24, 'Finance')";
			
			stm.executeUpdate(query);
			
			//step 6: close connection
			con.close();
			
			System.out.println("Data executed successfully");
		}
		catch(Exception e) {
			
			
			System.out.println(e.getMessage());
		}
	}
}
