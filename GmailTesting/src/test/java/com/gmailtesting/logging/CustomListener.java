package com.gmailtesting.logging;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.gmailtesting.tools.WebDriverUtils;

public class CustomListener  extends TestListenerAdapter{
			
	@Override
	public void onTestStart(ITestResult tr) {
		WebDriverUtils.getWebDriver().manage().deleteAllCookies();
	}

	@Override
	public void onStart(ITestContext testContext) {
		System.out.println("SUIT START");
	}

	@Override
	public void onFinish(ITestContext testContext) {
		
		System.out.println("SUIT FINISH");
		
		//TODO Send logs via Rest Api
	
	}

}
