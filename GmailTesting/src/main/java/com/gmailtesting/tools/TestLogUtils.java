package com.gmailtesting.tools;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.gmailtesting.data.ITestLog;

public class TestLogUtils {
	
	private static ConcurrentHashMap<Long, List<ITestLog>> logs;

	static {
		logs = new ConcurrentHashMap<Long, List<ITestLog>>();
	}
   
	public static synchronized void putLog(ITestLog testLog){
		synchronized (TestLogUtils.class) {
			if(logs.get(Thread.currentThread().getId()) == null){
				logs.put(Thread.currentThread().getId(), new ArrayList<ITestLog>());		
			}
			logs.get(Thread.currentThread().getId()).add(testLog);
		}
	}
			
	public static synchronized List<ITestLog> getAllLogsForCurrentThread(){
		return logs.get(Thread.currentThread().getId());
	}
	
	public static synchronized void cleanLogsForCurrentThread(){
		logs.remove(Thread.currentThread().getId());
	}
	
	public static synchronized void cleanLogs(){
		for(Long key : logs.keySet()){
			logs.remove(key);
		}
	}

}
