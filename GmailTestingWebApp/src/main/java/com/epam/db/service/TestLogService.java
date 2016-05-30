package com.epam.db.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.epam.db.connection.DBConnection;
import com.epam.db.dao.TestLogDAOImp;
import com.epam.model.TestLog;

public class TestLogService {
	
	public static List<TestLog> getAllLogsFromDB(){
		List<TestLog> list = null;
		try (Connection con = DBConnection.getDataSource().getConnection()) {
			TestLogDAOImp testlogDAO = new TestLogDAOImp(con);
			list = testlogDAO.getAllLogsFromDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnection.getDataSource().close();
		}
		return list;
	}
	
}
