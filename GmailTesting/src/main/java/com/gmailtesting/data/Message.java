package com.gmailtesting.data;

public class Message {
	
	@CellTitle(value = "To")
	private String messageToData;
	@CellTitle(value = "Cc")
	private String messageCcData;
	@CellTitle(value = "Bcc")
	private String messageBccData;
	@CellTitle(value = "Subject")
	private String subjectData;
	@CellTitle(value = "Message")
	private String textMessageData;

	public Message() {
	}

	public Message(String messageToData, String messageCcData, String messageBccData, String subjectData,
			String textMessageData) {
		this.messageToData = messageToData;
		this.messageCcData = messageCcData;
		this.messageBccData = messageBccData;
		this.subjectData = subjectData;
		this.textMessageData = textMessageData;
	}

	public String getMessageToData() {
		return messageToData;
	}

	public String getMessageCcData() {
		return messageCcData;
	}

	public String getMessageBccData() {
		return messageBccData;
	}

	public String getSubjectData() {
		return subjectData;
	}

	public String getTextMessageData() {
		return textMessageData;
	}

	public void setMessageToData(String messageToData) {
		this.messageToData = messageToData;
	}

	public void setMessageCcData(String messageCcData) {
		this.messageCcData = messageCcData;
	}

	public void setMessageBccData(String messageBccData) {
		this.messageBccData = messageBccData;
	}

	public void setSubjectData(String subjectData) {
		this.subjectData = subjectData;
	}

	public void setTextMessageData(String textMessageData) {
		this.textMessageData = textMessageData;
	}

	@Override
	public String toString() {
		return "Message [messageToData=" + messageToData + ", messageCcData=" + messageCcData + ", messageBccData="
				+ messageBccData + ", subjectData=" + subjectData + ", textMessageData=" + textMessageData + "]";
	}

	
	
}
