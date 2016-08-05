package com.gmailtesting.tests;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gmailtesting.businesslogic.LoginBL;
import com.gmailtesting.businesslogic.MainPageBL;
import com.gmailtesting.common.TestBase;
import com.gmailtesting.data.Message;
import com.gmailtesting.data.MessageRepository;
import com.gmailtesting.data.User;
import com.gmailtesting.data.UserRepository;

public class TestGmail  extends TestBase{
			
	@DataProvider
	public Object[][] draftsMessage() {
		return new Object[][] { { UserRepository.getUser2(), MessageRepository.getMessage() }};
	}

	@Test(dataProvider = "draftsMessage")
	public void testDraftsMessage(User user, Message message) {
			
		LoginBL login = new LoginBL();
		login.loginInGmail(user);

		MainPageBL mainPage = new MainPageBL();
		mainPage.createDraftMessage(message);
		mainPage.openLastDraftMessage();

		Message messageDraft = mainPage.getMessage();
		Assert.assertEquals(message.getMessageToData(), messageDraft.getMessageToData());
		Assert.assertEquals(message.getSubjectData(), messageDraft.getSubjectData());
		Assert.assertEquals(message.getTextMessageData(), messageDraft.getTextMessageData());

	}
	

	
	

}
