package com.gmailtesting.common;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.gmailtesting.data.UrlRepository;
import com.gmailtesting.logging.CustomListener;
import com.gmailtesting.tools.WebDriverUtils;

//@Listeners(CustomListener.class)
public class TestBase {
	
	private Logger logger = LoggerFactory.getLogger(TestBase.class);
	
	@BeforeClass
	public void beforeClass(){
		logger.debug("+++++  beforeClass" + this.getClass().getSimpleName() + " +++++");
	}

	@BeforeMethod(alwaysRun = true)
	public void beforeTest(Method method){
		logger.debug("+++++  beforeTest " + method.getName() + " +++++");
		WebDriverUtils.getWebDriver().manage().deleteAllCookies();
		WebDriverUtils.load(UrlRepository.Urls.GMAIL_HOST.toString());
	}
	
	@AfterMethod(alwaysRun = true)
	public void afterMethod() {
		WebDriverUtils.close();	
	}

}
