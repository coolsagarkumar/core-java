package com.billing.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CommonDAO {
	
	
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Ente your user id: ");
		String userid = scan.next();
		System.out.println("Enter your password: ");
		String password = scan.next();
		
		// connectiono is an interface which is coming from driver and use for create connection.
		Connection con = null;
		// prepare statement is for query
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// class is an keyword which used for load the another class or driver or source.
		Class.forName("org.postgresql.Driver");
//		System.out.println("Driver loaded...");
		//Create connection to the database. 
		//driver manager is a method which manager the driver
		con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/billingdb","postgres","sahil123");
		pstmt = con.prepareStatement("select userid, password from users where userid=? and password=?");
		pstmt.setString(1,userid );
		pstmt.setString(2, password);
		rs = pstmt.executeQuery();
		if(rs.next()) {
			System.out.println("welcome "+userid);
		}
		else {
			System.out.println("invalid userid or password");
		}
		if(rs!=null) {
			rs.close();
		}
		if(pstmt!=null) {
			pstmt.close();
		}
		if(con!=null) {
			con.close();
		}
		
	}

}
