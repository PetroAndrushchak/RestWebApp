package com.gmailtesting.logging;

import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.gmailtesting.tools.TestLogUtils;

public class CustomListener  extends TestListenerAdapter{
			
	@Override
	public void onTestStart(ITestResult tr) {
		System.out.println("TEST START");
	}

	@Override
	public void onStart(ITestContext testContext) {
		System.out.println("SUIT START");
	}

	@Override
	public void onFinish(ITestContext testContext) {
		
		System.out.println("SUIT FINISH");
		List<TestLog> list = TestLogUtils.getAllLogs();
		System.out.println("Size onFinish= " + list.size());
	
		for(TestLog log : list){
			System.out.println(log.getThreadName() + " " + log.getMessage());
		}
		//TODO Send logs via Rest Api
	
	}

}
