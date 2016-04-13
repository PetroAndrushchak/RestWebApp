package com.gmailtesting.tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.gmailtesting.logging.TestLog;

public class TestLogUtils {
	
	private static HashMap<Long, List<TestLog>> logs;

	static {
		logs = new HashMap<Long, List<TestLog>>();
	}
   
	public static synchronized void putLog(TestLog testLog){
		synchronized (TestLogUtils.class) {
			if(logs.get(Thread.currentThread().getId()) == null){
				logs.put(Thread.currentThread().getId(), new ArrayList<TestLog>());		
			}
			logs.get(Thread.currentThread().getId()).add(testLog);
		}
	}
	
	public static synchronized List<TestLog> getAllLogs(){
		List<TestLog> globalList = new ArrayList<TestLog>();
		for(List<TestLog> list : logs.values()){
			globalList.addAll(list);
		}
		return globalList;
	}

}
