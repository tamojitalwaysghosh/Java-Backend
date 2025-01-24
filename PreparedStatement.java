package jdbc;

import java.sql.*;
import java.util.Scanner;

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
			PreparedStatement pstm = con.prepareStatement("INSERT INTO employee VALUES (?,?,?,?)");
			
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("Enter the numbre of users: ");
			int n = scanner.nextInt();
			
			for(int i=0;i<n;i++) {
				System.out.println("Enter the emp id: ");
				
				int id = scanner.nextInt();
				
				pstm.setInt(1, id);
				
				System.out.println("Enter emp name: ");
				
				String name = scanner.next();
				
				pstm.setString(2,  name);
				
				System.out.println("enter the emp age");
				
				int age = scanner.nextInt();
				
				pstm.setInt(3, age);
				
				System.out.println("enter the student dept");
				String dept = scanner.next();
				pstm.setString(4, dept);
			}
			pstm.executeUpdate();
			
			//step 6: close connection
			con.close();
			
			System.out.println("Data executed successfully");
		}
		catch(Exception e) {
			
			
			System.out.println(e.getMessage());
		}
	}
}
