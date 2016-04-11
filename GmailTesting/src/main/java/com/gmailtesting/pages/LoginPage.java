package com.gmailtesting.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gmailtesting.components.Button;
import com.gmailtesting.components.Label;
import com.gmailtesting.components.TextField;
import com.gmailtesting.pagefactory.CustomFieldDecorator;
import com.gmailtesting.tools.WebDriverUtils;

public class LoginPage {

	@FindBy(id = "Email")
	private TextField fieldEmail;

	@FindBy(id = "next")
	private Button buttonNext;

	@FindBy(id = "Passwd")
	private TextField fieldPassword;

	@FindBy(id = "signIn")
	private Button buttonSignIn;

	@FindBy(xpath = "//div[@class='gb_8a']")
	private Label lable;


	public LoginPage() {
		PageFactory.initElements(new CustomFieldDecorator(WebDriverUtils.getWebDriver()), this);
	}

	public void setEmail(String data) {
		fieldEmail.click();
		fieldEmail.sendKeysClear(data);
	}

	public void clickNextButton() {
		buttonNext.click();
	}

	public void setPassword(String data) {
		fieldPassword.click();
		fieldPassword.sendKeysClear(data);
	}

	public void clickEnterButton() {
		buttonSignIn.click();
		
		 new WebDriverWait(WebDriverUtils.getWebDriver(), 30)
		 .until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
		
	}
}
