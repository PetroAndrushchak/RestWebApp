package com.gmailtesting.logging;

import java.util.Date;

public class TestLog {
	
	private String message;
	private String threadName;
	private Date date;
	private String level;
	private String className;
	private int lineNumber;
	private String methodName;
	
	public TestLog(String message, String threadName, Date date, String level, String className, int lineNumber,
			String methodName) {
		super();
		this.message = message;
		this.threadName = threadName;
		this.date = date;
		this.level = level;
		this.className = className;
		this.lineNumber = lineNumber;
		this.methodName = methodName;
	}

	public TestLog() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getThreadName() {
		return threadName;
	}

	public void setThreadName(String threadName) {
		this.threadName = threadName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	
	
	
	
	

}
