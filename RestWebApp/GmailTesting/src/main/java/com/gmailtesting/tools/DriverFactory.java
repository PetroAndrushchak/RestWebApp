package com.gmailtesting.tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	public static WebDriver getDriver(String driverType) {

		WebDriver driver = null;
		switch (driverType) {
		case "Firefox":
			driver = new FirefoxDriver();
			break;
		case "Chrome":
			System.setProperty("webdriver.chrome.driver",
					"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
			driver = new ChromeDriver();
			break;
		default:
			driver = new FirefoxDriver();
			break;
		}
		return driver;
	}
}
