package com.gmailtesting.data;

import java.util.Date;

import com.gmailtesting.testlogbuilder.IBuild;
import com.gmailtesting.testlogbuilder.IClassName;
import com.gmailtesting.testlogbuilder.IDate;
import com.gmailtesting.testlogbuilder.ILevel;
import com.gmailtesting.testlogbuilder.ILineNumber;
import com.gmailtesting.testlogbuilder.IMessage;
import com.gmailtesting.testlogbuilder.IMethodName;
import com.gmailtesting.testlogbuilder.IThreadName;

public class TestLog implements IMessage, IThreadName, IDate, ILevel, IClassName, ILineNumber, IMethodName, IBuild, ITestLog {

	private String message;
	private String threadName;
	private Date date;
	private String level;
	private String className;
	private int lineNumber;
	private String methodName;

	public static IMessage get() {
		return new TestLog();
	}
	
	@Override
	public IThreadName setMessage(String message) {
		this.message = message;
		return this;
	}
	
	@Override
	public IBuild setMethodName(String methodName) {
		this.methodName = methodName;
		return this;
	}

	@Override
	public IMethodName setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
		return this;
	}

	@Override
	public ILineNumber setClassName(String className) {
		this.className = className;
		return this;
	}

	@Override
	public IClassName setLevel(String level) {
		this.level = level;
		return this;
	}

	@Override
	public ILevel setDate(Date date) {
		this.date = date;
		return this;
	}

	@Override
	public IDate setThreadName(String threadName) {
		this.threadName = threadName;
		return this;
	}

	@Override
	public ITestLog build() {		
		return this;
	}

	@Override
	public String getMessage() {	
		return message;
	}

	@Override
	public String getThreadName() {
		return threadName;
	}

	@Override
	public Date getDate() {
		return date;
	}

	@Override
	public String getLevel() {
		return level;
	}

	@Override
	public String getClassName() {
		return className;
	}

	@Override
	public int getLineNumber() {
		return lineNumber;
	}

	@Override
	public String getMethodName() {
		return methodName;
	}

}
