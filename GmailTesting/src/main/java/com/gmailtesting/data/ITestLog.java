package com.gmailtesting.data;

import java.util.Date;

public interface ITestLog {

	String getMessage();

	String getThreadName();

	Date getDate();

	String getLevel();

	String getClassName();

	int getLineNumber();

	String getMethodName();

}
