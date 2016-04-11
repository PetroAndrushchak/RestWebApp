package com.gmailtesting.components;

import org.openqa.selenium.WebElement;

public abstract class GlobalComponent {

	protected WebElement element;

	protected GlobalComponent() {
	}

	public String getAttribute(String attribute) {
		return element.getAttribute(attribute);
	}

	public String getText() {
		return element.getText();
	}

}
