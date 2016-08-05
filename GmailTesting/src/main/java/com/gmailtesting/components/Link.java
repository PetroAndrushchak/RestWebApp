package com.gmailtesting.components;

import org.openqa.selenium.WebElement;

public class Link extends GlobalComponent implements GlobalLink {

	public Link(WebElement element) {
		this.element = element;
	}

	@Override
	public void click() {
		element.click();
	}

	@Override
	public String getUrl() {
		return element.getAttribute("url");
	}

}
