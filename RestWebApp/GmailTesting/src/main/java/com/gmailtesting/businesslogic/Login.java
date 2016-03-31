package com.gmailtesting.businesslogic;

import com.gmailtesting.data.User;
import com.gmailtesting.pages.LoginPage;

public class Login {

	private LoginPage emailPage;
//	private Logger logger = Logger.getLogger(Login.class);

	public void loginInGmail(User user) {

//		logger.info("Start login in GMAIL");

		emailPage = new LoginPage();
		emailPage.setEmail(user.getEmail());
		emailPage.clickNextButton();
		emailPage.setPassword(user.getPassword());
		emailPage.clickEnterButton();

//		logger.info("Finish login in GMAIL");

	}

}
