package com.bankAccount.springAPIs.accountAPI;

import java.lang.module.FindException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAccountController {
	
	@Autowired
	UserAccountDAO userDAO = new UserAccountDAO();
	
	@GetMapping(path="/accountDetails")
	public ArrayList<UserAccount> getAccountDetails() {
		return userDAO.readUsers();
	}
	
	@GetMapping(path="/accountDetails/{accountNo}")
	@ResponseStatus(code = HttpStatus.OK)
	public UserAccount getAccountDetail(@PathVariable double accountNo) {
		
	    UserAccount user = userDAO.readUser(accountNo);
	    return user;  
	}
	
	@PostMapping(path="/createNewAccount")
	public String createNewUser(@RequestBody UserAccount newUser) {
		userDAO.createUser(newUser);
		return "User added - " + newUser.getCustomerName();
	}

	
	@PutMapping(path="/accountDetails")
	public String updateUser(UserAccount user){
		userDAO.updateUser(user);
		return "User data updated";
	}
			
			
			
	@DeleteMapping(path="/accountDetails")
	public String deleteUser(UserAccount user){
		userDAO.deleteUser(user);
		return "User deleted - "+ user.getCustomerName();
	}

}