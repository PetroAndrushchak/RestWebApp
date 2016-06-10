package com.gmailtesting.logging;

import java.util.List;

import javax.ws.rs.core.Response;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.gmailtesting.data.ITestLog;
import com.gmailtesting.service.WebServiceClient;
import com.gmailtesting.tools.TestLogUtils;

public class CustomListener extends TestListenerAdapter implements IInvokedMethodListener {

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		
		List<ITestLog> list = TestLogUtils.getAllLogsForCurrentThread();
		TestLogUtils.cleanLogsForCurrentThread();
		
		if(list != null && list.size() >= 1){
			Response response = WebServiceClient.sendLogsInDataBase(list);
			System.err.println(response.getStatus());
		}else{
			return;
		}
	}

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		
		
	}
	
}
