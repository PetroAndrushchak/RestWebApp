package com.epam.model;

import java.io.Serializable;
import java.util.Date;

public class TestLog implements Serializable, Comparable<TestLog>{

	private static final long serialVersionUID = 1L;
	
	private int id;
	
	private String message;
	private String threadName;
	
	private Date date;
	private String level;
	private String className;
	private int lineNumber;
	private String methodName;

	
	public TestLog() {
		super();
	}

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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
	
	@Override
	public String toString() {
		return "TestLog [message=" + message + ", threadName=" + threadName + ", date=" + date + ", level=" + level
				+ ", className=" + className + ", lineNumber=" + lineNumber + ", methodName=" + methodName + "]";
	}

	@Override
	public int compareTo(TestLog o) {
		return this.getDate().compareTo(o.getDate());		
	}
}
