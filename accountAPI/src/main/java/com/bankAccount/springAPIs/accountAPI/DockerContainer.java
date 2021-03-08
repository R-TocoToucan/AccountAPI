package com.bankAccount.springAPIs.accountAPI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DockerContainer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		    final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		    final String DB_URL = "jdbc:mysql://bankdb.co4tnknl39h0.us-east-2.rds.amazonaws.com:3306/bankDB";
		    final String USER = "admin";
		    final String PASS = "809iolPP";
		    
		    Connection conn = null;
		    
		    try {
		    	Class.forName("com.mysql.jdbc.Driver");
		    	System.out.println("Connecting to database...");
		     
				conn = DriverManager.getConnection(DB_URL, USER, PASS);
				
			      System.out.println("Creating table in given database...");
			      Statement stmt = conn.createStatement();
			      
			      String sql = "CREATE TABLE IF NOT EXISTS TestJava " +
			                   "(accountNo INTEGER not NULL, " +
			                   " customerName VARCHAR(255), " + 
			                   " email VARCHAR(255), " + 
			                   " phoneNo VARCHAR(255), " + 
			                   " balance INTEGER, " + 
			                   " PRIMARY KEY ( accountNo ))"; 

			      stmt.executeUpdate(sql);
			      System.out.println("Created table in given database...");
				
			} catch (SQLException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}