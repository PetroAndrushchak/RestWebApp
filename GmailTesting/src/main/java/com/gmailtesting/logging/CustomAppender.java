package com.gmailtesting.logging;

import java.util.Date;

import com.gmailtesting.data.ITestLog;
import com.gmailtesting.data.TestLog;
import com.gmailtesting.tools.TestLogUtils;

import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.AppenderBase;

public class CustomAppender extends AppenderBase<LoggingEvent> {

	private ITestLog testLog;

	@Override
	protected void append(LoggingEvent eventObject) {

		testLog = TestLog.get().setMessage(eventObject.getMessage())
		              .setThreadName(eventObject.getThreadName())
		              .setDate(new Date(eventObject.getTimeStamp()))
		              .setLevel(eventObject.getLevel().levelStr)
		              .setClassName(eventObject.getCallerData()[0].getClassName())
		              .setLineNumber(eventObject.getCallerData()[0].getLineNumber())
		              .setMethodName(eventObject.getCallerData()[0].getMethodName())
		              .build();
		
		TestLogUtils.putLog(testLog);

	}

}
