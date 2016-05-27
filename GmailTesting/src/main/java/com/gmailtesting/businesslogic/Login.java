package com.gmailtesting.businesslogic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gmailtesting.data.User;
import com.gmailtesting.pages.LoginPage;

public class Login {

	private LoginPage emailPage;
	
	private Logger logger = LoggerFactory.getLogger(Login.class);

	public void loginInGmail(User user) {
	
		logger.info("Start login in GMAIL ");

		emailPage = new LoginPage();
		emailPage.setEmail(user.getEmail());
		emailPage.clickNextButton();
		emailPage.setPassword(user.getPassword());
		emailPage.clickEnterButton();

		logger.info("Finish login in GMAIL ");

	}

}
