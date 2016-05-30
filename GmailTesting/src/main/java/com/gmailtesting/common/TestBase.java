package com.gmailtesting.common;

import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.gmailtesting.data.UrlRepository;
import com.gmailtesting.tools.WebDriverUtils;

public class TestBase {
	
	@BeforeMethod(alwaysRun = true)
	public void beforeTest(Method method){
		WebDriverUtils.getWebDriver().manage().deleteAllCookies();
		WebDriverUtils.load(UrlRepository.Urls.GMAIL_HOST.toString());
	}
	
	@AfterMethod(alwaysRun = true)
	public void afterMethod() {
		WebDriverUtils.close();	
	}

}
