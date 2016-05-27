package com.epam.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import com.epam.db.transformer.TestLogTransformer;
import com.epam.model.TestLog;

public class TestLogDAOImp extends AbstractDAO implements TestLogDAO {

	private static final String SQL_INSERT_LOG = "Insert into log (message,thread_name,time,level,class_name,line_number,method_name) value(?,?,?,?,?,?,?)";
	private static final String SQL_INSERT_IN_LOGS_TABLE = "Insert into logs (log_id) values ((SELECT id FROM log WHERE time=?))";
	private static final String SQL_GET_ALL_ACTIVE_LOGS = "select L.id, L.message, L.thread_name, L.time, L.level, L.class_name, L.line_number, L.method_name from  log L join logs lg on l.id = lg.log_id where lg.active = '1'";
	public TestLogDAOImp(Connection con) {
		super(con);
	}

	@Override
	public void sendLogInDataBase(TestLog log) {
		try {
			PreparedStatement st = connection.prepareStatement(SQL_INSERT_LOG);
			st.setString(1, log.getMessage());
			st.setString(2, log.getThreadName());
			st.setTimestamp(3, new Timestamp(log.getDate().getTime()));
			st.setString(4, log.getLevel());
			st.setString(5, log.getClassName());
			st.setInt(6, log.getLineNumber());
			st.setString(7, log.getMethodName());
			st.executeUpdate();
			
			st = connection.prepareStatement(SQL_INSERT_IN_LOGS_TABLE);
			st.setTimestamp(1, new Timestamp(log.getDate().getTime()));
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<TestLog> getAllLogsFromDB() {
		
		try {
			PreparedStatement st = connection.prepareStatement(SQL_GET_ALL_ACTIVE_LOGS);
			ResultSet result = st.executeQuery();
			
			return TestLogTransformer.getTestLogList(result);
						
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
