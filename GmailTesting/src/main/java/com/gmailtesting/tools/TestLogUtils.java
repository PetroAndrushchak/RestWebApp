package com.gmailtesting.tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.gmailtesting.logging.TestLog;

public class TestLogUtils {
	
	private static ConcurrentHashMap<Long, List<TestLog>> logs;

	static {
		logs = new ConcurrentHashMap<Long, List<TestLog>>();
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
	
	public static synchronized List<TestLog> getAllLogsForCurrentThread(){
		List<TestLog> globalList = new ArrayList<TestLog>();
		for(Long idThread : logs.keySet()){
			if(Thread.currentThread().getId() == idThread){
				globalList = logs.get(idThread);
			}
		}
		return globalList;
	}
	
	public static synchronized void cleanLogsForCurrentThread(){
		for(Long idThread : logs.keySet()){
			if(Thread.currentThread().getId() == idThread){
				logs.remove(idThread);
			}
		}
	}
	
	public static synchronized void cleanLogs(){
		for(Long key : logs.keySet()){
			logs.remove(key);
		}
	}

}
