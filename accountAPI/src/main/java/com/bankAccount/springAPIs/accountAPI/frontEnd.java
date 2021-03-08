package com.bankAccount.springAPIs.accountAPI;

public class frontEnd {

	public static void main(String[] args) {
		
		UserAccountDAO studentDAO = new UserAccountDAO();



		UserAccount deep = new UserAccount();
		UserAccount dolores = new UserAccount(1231231, "Dolores Muwanga", "dmuwanga@uef.com", "214-616-8921", 2880000);
		
		studentDAO.createUser(deep);		
		studentDAO.createUser(dolores);

		deep.deposit(1000);
		deep.printAccountInfo();
		
		//studentDAO.createUserDB(deep);
		studentDAO.viewUserDB(deep);
		//studentDAO.deleteUserDB(dolores);
	}
}
