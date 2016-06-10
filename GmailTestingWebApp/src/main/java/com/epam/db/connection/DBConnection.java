package com.epam.db.connection;

import com.epam.parser.DBPropertiesReader;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DBConnection {

	private static volatile HikariDataSource instance;

	private DBConnection() {
	}

	private static void initialize() {

		HikariConfig config = new HikariConfig();
		
				config.setDriverClassName(DBPropertiesReader.getPropertie("driver.class.name"));
		config.setJdbcUrl(DBPropertiesReader.getPropertie("jdbc.url"));																				
		config.setUsername(DBPropertiesReader.getPropertie("username")); 
		config.setPassword(DBPropertiesReader.getPropertie("password")); 

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
}
