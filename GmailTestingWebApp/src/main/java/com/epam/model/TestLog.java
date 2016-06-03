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

	private TestLog(TestLogBuilder builder){
		message = builder.message;
		threadName = builder.threadName;
		date = builder.date;
		level = builder.level;
		className = builder.className;
		lineNumber = builder.lineNumber;
		methodName = builder.className;
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
	
	public static class TestLogBuilder {

		private int id;
		
		private String message;
		private String threadName;
		
		private Date date;
		private String level;
		private String className;
		private int lineNumber;
		private String methodName;
		
		public TestLogBuilder(){
			
		}
		
		public TestLogBuilder setMessage(String message){
			this.message = message;
			return this;
		}
		
		public TestLogBuilder setThreadName(String threadName){
			this.threadName = threadName;
			return this;
		}
		
		public TestLogBuilder setDate(Date date){
			this.date = date;
			return this;
		}
		
		public TestLogBuilder setLevel(String level){
			this.level = level;
			return this;
		}
		
		public TestLogBuilder setClassName(String className){
			this.className = className;
			return this;
		}
		
		public TestLogBuilder setLineNumber(int lineNumber){
			this.lineNumber = lineNumber;
			return this;
		}
		
		public TestLogBuilder setMethodName(String methodName){
			this.methodName = methodName;
			return this;
		}
		
		public TestLogBuilder setID(int id){
			this.id = id;
			return this;
		}
		
		public TestLog build(){
			return new TestLog(this);
		}

	}
}
