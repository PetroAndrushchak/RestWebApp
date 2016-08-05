package com.gmailtesting.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gmailtesting.components.Button;
import com.gmailtesting.components.Link;
import com.gmailtesting.pagefactory.CustomFieldDecorator;
import com.gmailtesting.tools.WebDriverUtils;

public class MainPage {

	@FindBy(xpath = "//div[@class='z0']/div")
	private Button composeButton;

	@FindBy(xpath = "//div[@class='r9gPwb']/div[1]/div[1]/div/div[4]//a")
	private Link draftButton;

	@FindBy(xpath = "//div[@class='AO']/div[1]/div[1]/div/div[2]//div[@class='Cp']//tr[1]")
	private Link lastDraftsMessage;
	  
	 @FindBy(xpath = "//div[@class='r9gPwb']/div[1]/div[1]/div/div[1]//a")
	 private Link inboxButton;

	public MainPage() {
		PageFactory.initElements(new CustomFieldDecorator(WebDriverUtils.getWebDriver()), this);
	}

	public MainPage clickOnDraftsButton() {
		draftButton.click();
		return new MainPage();
	}

	public void clickComposeButton() {
		composeButton.click();
	}

	public void clickOnLastDraftMessage() {
		lastDraftsMessage.click();
	}
	
	public void clickOnInboxMessage(){
		inboxButton.click();
	}
}
