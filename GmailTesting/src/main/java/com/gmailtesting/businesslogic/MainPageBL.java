package com.gmailtesting.businesslogic;

import com.gmailtesting.data.Message;
import com.gmailtesting.pages.MainPage;
import com.gmailtesting.pages.NewMessage;

public class MainPageBL {

	private MainPage mainPage;
	private NewMessage newMessage;
//	private Logger logger = Logger.getLogger(Login.class);

	public MainPageBL() {
		this.mainPage = new MainPage();
	}

	public void createDraftMessage(Message message) {

//		logger.info("Create message");

		mainPage.clickComposeButton();
		newMessage = new NewMessage();

		newMessage.typeTextToField(message.getMessageToData());
		newMessage.typeTextCcField(message.getMessageCcData());
		newMessage.typeTextBccField(message.getMessageBccData());
		newMessage.typeTextToSubjectField(message.getSubjectData());
		newMessage.typeTextToMessageField(message.getTextMessageData());

		newMessage.clickSaveAndCloseButton();

//		logger.info("Finish create message (Click and save)");
	}

	public void openLastDraftMessage() {

//		logger.info("Open last draft message");

		mainPage = mainPage.clickOnDraftsButton();
		mainPage.clickOnLastDraftMessage();
		newMessage = new NewMessage();
	}

	public Message getMessage() {
//		logger.info("get info from message");

		Message message = new Message();
		message.setMessageToData(newMessage.getTextMessageTo());
		message.setMessageCcData(newMessage.getTextMessageCc());
		message.setMessageBccData(newMessage.getTextMessageBcc());
		message.setSubjectData(newMessage.getTextSubjectField());
		message.setTextMessageData(newMessage.getTextMessageField());

		return message;
	}

	public void sendMessage() {
//		logger.info("click on button send button");
		newMessage.clickOnSendButton();
		
	}
	public void goToInboxMessages(){
		mainPage.clickOnInboxMessage();
	}

}
