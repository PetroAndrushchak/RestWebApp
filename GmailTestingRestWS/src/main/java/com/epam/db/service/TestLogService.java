package com.epam.db.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import com.epam.db.connection.DBConnection;
import com.epam.db.dao.TestLogDAOImp;
import com.epam.model.TestLog;

public class TestLogService {

	public static void sendLogInDataBase(TestLog testlog) {
		try (Connection con = DBConnection.getDataSource().getConnection()) {
			TestLogDAOImp testlogDAO = new TestLogDAOImp(con);
			testlogDAO.sendLogInDataBase(testlog);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
}
