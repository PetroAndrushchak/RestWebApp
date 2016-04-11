package com.gmailtesting.components;

import org.openqa.selenium.WebElement;

public class TextField extends GlobalComponent implements GlobalTextField {

	//WebElement textField;

	public TextField(WebElement textField) {
		this.element = textField;
	}

	@Override
	public void clear() {
		element.clear();
	}

	@Override
	public void sendKeys(String text) {
		element.sendKeys(text);

	}

	@Override
	public void sendKeysClear(String text) {

		element.clear();
		element.sendKeys(text);
	}

	@Override
	public void click() {

		element.click();
	}

}
