package com.bankAccount.springAPIs.accountAPI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class UserAccountDAO {
	
	
	ArrayList<UserAccount> javaClass = new ArrayList<UserAccount>();

	final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    final String DB_URL = "jdbc:mysql://bankdb.co4tnknl39h0.us-east-2.rds.amazonaws.com:3306/bankDB";
    final String USER = "admin";
    final String PASS = "809iolPP";
    
    Connection conn = null;
	
	
	
		public void createUser(UserAccount newUser) {
			javaClass.add(newUser);
		}
		
		public ArrayList<UserAccount> readUsers() {
			return javaClass;
		}
		
		public UserAccount readUser(double accountNo) {
			for(UserAccount account: javaClass) {
				if (accountNo == account.getAccountNo()) {
					return account;
				}
			}
			return null;
		}
		
		public void updateUser(UserAccount user) {
			for(UserAccount account : javaClass) {
				if (user.getAccountNo() == account.getAccountNo()) {
					account.setCustomerName(user.getCustomerName());
					account.setEmail(user.getEmail());
					account.setPhoneNo(user.getPhoneNo());
					account.setBalance(user.getBalance());
				}
			}
		}
		
		public void deleteUser(UserAccount user) {
			javaClass.remove(user);
		}
		
		
		public void deposit(UserAccount newUser, double amount) {
		    newUser.setBalance(newUser.getBalance() + amount);
		
		    System.out.println(newUser.getCustomerName() + " deposited $" + amount + ". Current Balance is $" + newUser.getBalance());
		    }
		
		
		public void withdraw(UserAccount newUser, double amount) {
			if (newUser.getBalance() >= amount) {
		        newUser.setBalance(newUser.getBalance() - amount);
		        System.out.println(newUser.getCustomerName() + " withdrew $" + amount + ". Current Balance is $" + newUser.getBalance());
		    }
		    if (newUser.getBalance() < amount) {
		        System.out.println("Cannot withdraw due to insufficient funds. Current Balance is $" + newUser.getBalance());
		    }
		}
		
		
		public void printAccountInfo(UserAccount newUser) {
		    System.out.println("Customer's name: "+ newUser.getCustomerName() + "\nCurrent balance :" + newUser.getBalance() 
		    + "\nCustomer email : "  + newUser.getEmail() + "\nPhone number: " + newUser.getPhoneNo());
				
		}
		
		public void createStatement(String query) {
			
			Connection conn = null;
			
			 try {
			    	Class.forName("com.mysql.jdbc.Driver");
			    	System.out.println("Accessing database...");
			     
					conn = DriverManager.getConnection(DB_URL, USER, PASS);
					
				      System.out.println("Creating statement for given database...");
				      Statement stmt = conn.createStatement();
				      
				      String sql = query; 

				      stmt.executeUpdate(sql);
				     
				} catch (SQLException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		}
		
		
		public void createUserDB(UserAccount newUser) {
			String query = "INSERT INTO TestJava (accountNo, customerName, email, phoneNo, balance) "
						+ "VALUES ('" + newUser.getAccountNo() + "', '" + newUser.getCustomerName() + "', '" +
						newUser.getEmail() + "', '" + newUser.getPhoneNo()+ "', '" + newUser.getBalance() + "')";
			
			createStatement(query);
			
			System.out.println("Data inserted to database.");	
		}
		
		public void updateUserDB(UserAccount newUser) {
			String query = "UPDATE TestJava " +
						  "SET customerName = '" + newUser.getCustomerName() + "', email = '" + newUser.getEmail() 
						  + "', phoneNo = '" + newUser.getPhoneNo() + "', balance = '" + newUser.getBalance() + "'" +
						  "WHERE accountNo = " + newUser.getAccountNo();
			
			createStatement(query);
			
			System.out.println("Data updated in database");
			
		}
		
		public void viewUserDB(UserAccount user) {
			
			Connection conn = null;
			
			 try {
			    	Class.forName("com.mysql.jdbc.Driver");
			    	System.out.println("Accessing database...");
			     
					conn = DriverManager.getConnection(DB_URL, USER, PASS);
					
				      System.out.println("Creating statement for given database...");
				      Statement stmt = conn.createStatement();
				      
				      String sql ="SELECT * " +
							      "FROM TestJava " +
							      "WHERE accountNo = " + user.getAccountNo(); 
 
				      stmt.executeQuery(sql);
				     
				} catch (SQLException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				System.out.println("Displaying user info from database");
		
		}
		
		public void deleteUserDB(UserAccount user) {
			String query = "DELETE FROM TestJava " +
						   "WHERE accountNo = " + user.getAccountNo();
			
			createStatement(query);
			
			System.out.println("Data deleted from database");
		}



	
}
