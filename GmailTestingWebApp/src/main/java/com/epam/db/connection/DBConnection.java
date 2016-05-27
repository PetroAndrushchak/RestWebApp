package com.epam.db.connection;

import static org.testng.AssertJUnit.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DBConnection {

	private static volatile HikariDataSource instance;

	private DBConnection() {
	}

	private static void initialize() {

		HikariConfig config = new HikariConfig();

		config.setDriverClassName("com.mysql.jdbc.Driver");
		config.setJdbcUrl("jdbc:mysql://localhost:3306/gmailtesting?useUnicode=true&amp;characterEncoding=utf8");
																									
		config.setUsername("root"); 
		config.setPassword("root"); 

		config.addDataSourceProperty("cachePrepStmts", "true");
		config.addDataSourceProperty("prepStmtCacheSize", "250");
		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
		config.addDataSourceProperty("useServerPrepStmts", "true");
		config.setMinimumIdle(5);
		config.setMaximumPoolSize(20);
		config.setConnectionTimeout(10L * 1000);

		instance = new HikariDataSource(config);

	}

	public static HikariDataSource getDataSource() {
		if (instance == null) {
			synchronized (DBConnection.class) {
				if (instance == null) {
					initialize();
				}
			}
		}
		return instance;
	}

	public static void main(String[] args) {

		try (Connection connection = DBConnection.getDataSource().getConnection()) {
			System.out.println("Yay, we got our pooled connection to the" + " database!");
			assertTrue(connection.isValid(0));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// it is recommended to .close() a HikariDataSource once you
			// are done using it. Other datasources might have different
			// shutdown methods
			// if (ds instanceof HikariDataSource) {
			// ((HikariDataSource) ds).close();
			// }
		}
	}

}
