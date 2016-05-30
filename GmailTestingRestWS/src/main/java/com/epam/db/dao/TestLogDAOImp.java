package com.epam.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.epam.model.TestLog;
import com.mysql.jdbc.Statement;

public class TestLogDAOImp extends AbstractDAO implements TestLogDAO {

	private static final String SQL_INSERT_LOG = "Insert into log (message,thread_name,time,level,class_name,line_number,method_name) value(?,?,?,?,?,?,?)";
	private static final String SQL_INSERT_IN_LOGS_TABLE = "Insert into logs (log_id) values (?)";
	public TestLogDAOImp(Connection con) {
		super(con);
	}

	@Override
	public void sendLogInDataBase(TestLog log) {
		try {
			PreparedStatement st = connection.prepareStatement(SQL_INSERT_LOG,Statement.RETURN_GENERATED_KEYS);
			st.setString(1, log.getMessage());
			st.setString(2, log.getThreadName());
			st.setTimestamp(3, new Timestamp(log.getDate().getTime()));
			st.setString(4, log.getLevel());
			st.setString(5, log.getClassName());
			st.setInt(6, log.getLineNumber());
			st.setString(7, log.getMethodName());
			st.executeUpdate();
			
			ResultSet key = st.getGeneratedKeys();
			key.next();
			int id = key.getInt(1);
			
			st = connection.prepareStatement(SQL_INSERT_IN_LOGS_TABLE);
			st.setInt(1,id);
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
