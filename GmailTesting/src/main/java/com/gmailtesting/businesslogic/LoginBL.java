package com.gmailtesting.businesslogic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gmailtesting.data.User;
import com.gmailtesting.pages.LoginPage;

public class LoginBL {

	private LoginPage emailPage;
	
	public LoginBL(){
		this.emailPage = new LoginPage();
	}
	
	private Logger logger = LoggerFactory.getLogger(LoginBL.class);

	public void loginInGmail(User user) {
	
		logger.info("Start login in GMAIL ");

		emailPage.setEmail(user.getEmail());
		emailPage.clickNextButton();
		emailPage.setPassword(user.getPassword());
		emailPage.clickEnterButton();

		logger.info("Finish login in GMAIL ");

	}

}
