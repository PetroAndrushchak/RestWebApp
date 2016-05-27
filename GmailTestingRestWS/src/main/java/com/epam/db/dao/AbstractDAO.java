package com.epam.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public abstract class AbstractDAO {

	protected Connection connection = null;
	protected PreparedStatement preparedStatement = null;
	protected ResultSet resultSet = null;

	public AbstractDAO(Connection con) {
		connection = con;
	}

}
