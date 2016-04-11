package com.gmailtesting.data;

public class MessageRepository {
			
	private MessageRepository() {
	}
	
	public static Message getMessage() {
		
		Message message = new Message();
		message.setMessageToData("petroandrushchak2@gmail.com");
		message.setMessageBccData("petroandrushchak3@gmail.com");
		message.setMessageCcData("petroandrushchak4@gmail.com");
		message.setSubjectData("Test subject");
		message.setTextMessageData("Hello World !!!!");
		return message;
	}
}
