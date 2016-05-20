package com.gmailtesting.logging;

import java.util.List;

import javax.ws.rs.core.Response;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.gmailtesting.service.WebServiceClient;
import com.gmailtesting.tools.TestLogUtils;

public class CustomListener extends TestListenerAdapter implements IInvokedMethodListener {

	@Override
	public void onStart(ITestContext testContext) {
		System.out.println("SUIT START ");
		System.out.println("Thread id = " + Thread.currentThread().getId());
	}
	
	@Override
	public void onTestStart(ITestResult tr) {
		System.out.println("TEST START ");
		System.out.println("Thread id = " + Thread.currentThread().getId());
	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		
		System.out.println("After method = " + method.getTestMethod().getMethodName()+ " " + "Thread id = " + Thread.currentThread().getId() ) ;

		List<TestLog> list = TestLogUtils.getAllLogsForCurrentThread();
		TestLogUtils.cleanLogsForCurrentThread();
		System.out.println("Size logs list = " + list.size());

		for (TestLog log : list) {
			System.out.println(Thread.currentThread().getId() + " " + log.getMessage());
		}
		
		if(list.size() != 0){
			Response response = WebServiceClient.sendLogsInDataBase(list);
			System.err.println(response.getStatus());
		}else{
			return;
		}
	}
	
	@Override
	public void onFinish(ITestContext testContext) {
		System.out.println("SUIT FINISH ");
		System.out.println("Thread id = " + Thread.currentThread().getId());
	}
	
	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {

	}
}
