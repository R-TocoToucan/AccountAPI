package com.bankAccount.springAPIs.accountAPI;
public class UserAccount {

	private long accountNo ;
	private double balance ;	
	private String customerName;
	private String email ;
	private String phoneNo ;
	
	
	public UserAccount(long accountNo, String customerName, String email, String phoneNo, double balance) {
		this.accountNo = accountNo;
		this.customerName = customerName;
		this.email = email;
		this.phoneNo = phoneNo;
		this.balance = balance;
	}
	
	
	public UserAccount() {
		// TODO Auto-generated constructor stub
		accountNo = 123456789;
		balance = 500.0;	
		customerName = "Minseok";
		email = "locomopp@gmail.com";
		phoneNo = "678-662-8147";
	}


	public long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	public void deposit(double amount) {
	    balance = balance + amount;
	    System.out.println(customerName + " deposited $" + amount + ". Current Balance is $" + balance);
	    }    

	public void withdraw(double amount) {
	    if (balance >= amount) {
	        balance = balance - amount;
	        System.out.println(customerName + " withdrew $" + amount + ". Current Balance is $" + balance);
	    }
	    if (balance < amount) {
	        System.out.println("Cannot withdraw due to insufficient funds. Current Balance is $" + balance);
	    }
	}
		
	public void printAccountInfo() {
	    System.out.println("Customer's name: "+ customerName + "\n Current balance :" + balance + "\n Customer email : "  + email 
	    		+ "\n Phone number: " + phoneNo);
			
	}
	
	
	
}
