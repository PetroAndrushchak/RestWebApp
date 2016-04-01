package com.gmailtesting.tests;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gmailtesting.businesslogic.Login;
import com.gmailtesting.businesslogic.MainPageBL;
import com.gmailtesting.data.Message;
import com.gmailtesting.data.UrlRepository;
import com.gmailtesting.data.User;
import com.gmailtesting.data.UserRepository;
import com.gmailtesting.tools.WebDriverUtils;

public class TestGmail {

	@DataProvider
	public Object[][] draftsMessage() {
		Message message = null;
		return new Object[][] { { UserRepository.getUser1(), message }};
	}

	@Test(dataProvider = "draftsMessage")
	public void testDraftsMessage(User user, Message message) {

		WebDriverUtils.load(UrlRepository.Urls.GMAIL_HOST.toString());

		Login login = new Login();
		login.loginInGmail(user);

		MainPageBL mainPage = new MainPageBL();
		mainPage.createDraftMessage(message);
		mainPage.openLastDraftMessage();

		Message messageDraft = mainPage.getMessage();
		Assert.assertEquals(message.getMessageToData(), messageDraft.getMessageToData());
		Assert.assertEquals(message.getMessageCcData(), messageDraft.getMessageCcData());
		Assert.assertEquals(message.getMessageBccData(), messageDraft.getMessageBccData());
		Assert.assertEquals(message.getSubjectData(), messageDraft.getSubjectData());
		Assert.assertEquals(message.getTextMessageData(), messageDraft.getTextMessageData());

		mainPage.sendMessage();

	}

	@AfterMethod
	public void afterTest() {
	}

}
