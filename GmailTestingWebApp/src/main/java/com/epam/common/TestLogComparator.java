package com.epam.common;

import java.util.Comparator;
import java.util.Date;

import com.epam.model.TestLog;

public class TestLogComparator implements Comparator<TestLog>{

	@Override
	public int compare(TestLog o1, TestLog o2) {
		
		Date date1 = o1.getDate();
		Date date2 = o2.getDate();
		if(date1.after(date2)){
    		return -1;
    	}
    	
    	if(date1.before(date2)){
    		return 1;
    	}
    	
    	if(date1.equals(date2)){
    		return 0;
    	}
    	return 0;
	}
	
}
