package com.gmailtesting.logging;

import java.util.Date;

import com.gmailtesting.tools.TestLogUtils;

import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.AppenderBase;

public class CustomAppender extends AppenderBase<LoggingEvent>{
	
	private TestLog testLog;
	
	@Override
	protected void append(LoggingEvent eventObject) {
		
		testLog = new TestLog();
		testLog.setMessage(eventObject.getMessage());
		testLog.setThreadName(eventObject.getThreadName());
		testLog.setDate(new Date(eventObject.getTimeStamp()));
		testLog.setLevel(eventObject.getLevel().levelStr);
		testLog.setClassName(eventObject.getCallerData()[0].getClassName());		
		testLog.setLineNumber(eventObject.getCallerData()[0].getLineNumber());
		testLog.setMethodName(eventObject.getCallerData()[0].getMethodName());
		
		TestLogUtils.putLog(testLog);

	}

}
