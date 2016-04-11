package com.gmailtesting.logging;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;

public class CustomAppender extends AppenderBase<ILoggingEvent>{
	
	@Override
	protected void append(ILoggingEvent eventObject) {
		// TODO Auto-generated method stub
		System.out.println("Append !!!!");
		System.out.println(eventObject.getFormattedMessage());
		System.out.println(eventObject.getLoggerName());
		System.out.println(eventObject.getMessage());
		System.out.println(eventObject.getThreadName());
		System.out.println(eventObject.getTimeStamp());
		System.out.println(eventObject.hasCallerData());
		System.out.println(eventObject.getArgumentArray());
		System.out.println(eventObject.getLevel());	
		
	}

}
