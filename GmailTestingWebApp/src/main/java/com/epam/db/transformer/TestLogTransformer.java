package com.epam.db.transformer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.epam.model.TestLog;

public class TestLogTransformer {
	
	public static List<TestLog> getTestLogList(ResultSet result){
		List<TestLog> list = new LinkedList<>();
		TestLog log = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		try {
			while(result.next()){
				log = new TestLog();
				log.setId(result.getInt(1));
				log.setMessage(result.getString(2));
				log.setThreadName(result.getString(3));					
				try {
					log.setDate(sdf.parse(result.getString(4)));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				log.setLevel(result.getString(5));
				log.setClassName(result.getString(6));
				log.setLineNumber(result.getInt(7));
				log.setMethodName(result.getString(8));	
				list.add(log);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
