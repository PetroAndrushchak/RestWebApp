package com.gmailtesting.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gmailtesting.components.Button;
import com.gmailtesting.components.Link;
import com.gmailtesting.components.TextField;
import com.gmailtesting.pagefactory.CustomFieldDecorator;
import com.gmailtesting.tools.WebDriverUtils;

public class NewMessageSection {

	public NewMessageSection() {
		PageFactory.initElements(new CustomFieldDecorator(WebDriverUtils.getWebDriver()), this);	
	}

	@FindBy(name = "to")
	private TextField sendToField;

	@FindBy(name = "cc")
	private TextField sendCcField;

	@FindBy(name = "bcc")
	private TextField sendBccField;

	@FindBy(xpath = "//div[@class='aA6']/span/span/span[1]")
	private Link sendCcButton;

	@FindBy(xpath = "//div[@class='aA6']/span/span/span[2]")
	private Link sendBccButton;

	@FindBy(name = "subjectbox")
	private TextField sendSubjectField;

	@FindBy(xpath = "//td[@class='Ap']/div[2]/div")
	private TextField sendTextMailField;

	@FindBy(className = "Ha")
	private Button saveAndCloseButton;

	@FindBy(xpath = "//table[@class = 'GS']/tbody/tr[1]/td[2]/div/div/div[1]/input")
	private TextField messageTo;

	@FindBy(xpath = "//table[@class = 'GS']/tbody/tr[2]/td[2]/div/div/div[1]/input")
	private TextField messageCc;

	@FindBy(xpath = "//table[@class = 'GS']/tbody/tr[3]/td[2]/div/div/div[1]/input")
	private TextField messageBcc;

	@FindBy(xpath = "//tr[@class='n1tfz']/td[1]/div/div[2]")
	private Button sendButton;

	public void clickSendCcButton() {
		sendCcButton.click();
	}

	public void clickSendBccButton() {
		sendBccButton.click();
	}

	public void clickSaveAndCloseButton() {
		saveAndCloseButton.click();
	}

	public void clickOnSendButton() {
		sendButton.click();
	}

	public void typeTextToField(String toSender) {
		sendToField.click();
		sendToField.sendKeysClear(toSender);
	}

	public void typeTextCcField(String toSender) {
		clickSendCcButton();
		sendCcField.click();
		sendCcField.sendKeysClear(toSender);
	}

	public void typeTextBccField(String toSender) {
		clickSendBccButton();

		sendBccField.click();
		sendBccField.sendKeysClear(toSender);
	}

	public void typeTextToSubjectField(String data) {

		sendSubjectField.click();
		sendSubjectField.sendKeysClear(data);
	}

	public void typeTextToMessageField(String data) {

		sendTextMailField.click();
		sendTextMailField.sendKeysClear(data);
	}

	public String getTextMessageTo() {
		return messageTo.getAttribute("value");
	}

	public String getTextMessageCc() {
		return messageCc.getAttribute("value");
	}

	public String getTextMessageBcc() {
		return messageBcc.getAttribute("value");
	}

	public String getTextSubjectField() {
		return sendSubjectField.getAttribute("value");
	}

	public String getTextMessageField() {
		return sendTextMailField.getText();
	}

}