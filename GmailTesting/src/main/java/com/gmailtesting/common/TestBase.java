package com.gmailtesting.common;

import java.lang.reflect.Method;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.gmailtesting.data.UrlRepository;
import com.gmailtesting.logging.TestLog;
import com.gmailtesting.tools.TestLogUtils;
import com.gmailtesting.tools.WebDriverUtils;

public class TestBase {
	
	private Logger logger = LoggerFactory.getLogger(TestBase.class);
	
	@BeforeClass
	public void beforeClass(){
		logger.debug("+++++  beforeClass" + this.getClass().getSimpleName() + " +++++");
	}

	@BeforeMethod
	public void beforeTest(Method method){
		logger.debug("+++++  beforeTest" + method.getName() + " +++++");
		WebDriverUtils.getWebDriver().manage().deleteAllCookies();
		WebDriverUtils.load(UrlRepository.Urls.GMAIL_HOST.toString());
	}
	
	@AfterClass
	public void afterTest() {		
		WebDriverUtils.getWebDriver().close();
		
	}

}
