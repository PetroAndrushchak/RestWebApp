package com.epam.db.transformer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
				log = new TestLog.TestLogBuilder().setID(result.getInt(1))
												  .setMessage(result.getString(2))
												  .setThreadName(result.getString(3))
												  .setDate(sdf.parse(result.getString(4)))
												  .setLevel(result.getString(5))
												  .setClassName(result.getString(6))
												  .setLineNumber(result.getInt(7))
												  .setMethodName(result.getString(8))
												  .build();

				list.add(log);
			}
		} catch (SQLException |ParseException e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
