package com.gmailtesting.components;

import org.openqa.selenium.WebElement;

public class Button extends GlobalComponent implements GlobalButton {

	//WebElement element;

	public Button(WebElement element) {
		this.element = element;
	}

	@Override
	public void click() {
		element.click();
	}

	@Override
	public void submit() {
		element.submit();
	}

}
