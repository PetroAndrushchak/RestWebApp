package com.gmailtesting.businesslogic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gmailtesting.data.Message;
import com.gmailtesting.pages.MainPage;
import com.gmailtesting.pages.NewMessageSection;

public class MainPageBL {

	private MainPage mainPage;
	private NewMessageSection newMessageSection;
	private Logger logger = LoggerFactory.getLogger(MainPageBL.class);

	public MainPageBL() {
		this.mainPage = new MainPage();
		this.newMessageSection = new NewMessageSection();
	}

	public void createDraftMessage(Message message) {

		logger.info("Create message");

		mainPage.clickComposeButton();
		newMessageSection.typeTextToField(message.getMessageToData());
		newMessageSection.typeTextToSubjectField(message.getSubjectData());
		newMessageSection.typeTextToMessageField(message.getTextMessageData());
		newMessageSection.clickSaveAndCloseButton();

		logger.info("Finish creating message (Click and save)");
	}

	public void openLastDraftMessage() {
		logger.info("Open the last draft message");
		mainPage = mainPage.clickOnDraftsButton();
		mainPage.clickOnLastDraftMessage();
	}

	public Message getMessage() {

		Message message = new Message();
		message.setMessageToData(newMessageSection.getTextMessageTo());
		message.setSubjectData(newMessageSection.getTextSubjectField());
		message.setTextMessageData(newMessageSection.getTextMessageField());

		return message;
	}

	public void sendMessage() {
		logger.info("Click on the send button");
		newMessageSection.clickOnSendButton();
	}

	public void goToInboxMessages() {
		mainPage.clickOnInboxMessage();
	}

}
