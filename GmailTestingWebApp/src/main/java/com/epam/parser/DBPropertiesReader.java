package com.epam.parser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBPropertiesReader {

	public static String DB_CREDENTIAL_PROPERTIE_FILE = "/DBCredentials.properties";
	private static Properties properties = new Properties();

	public static String getPropertie(String propertieName) {
		
		try {
			InputStream input = DBPropertiesReader.class.getResourceAsStream(DB_CREDENTIAL_PROPERTIE_FILE);
			properties.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties.getProperty(propertieName);
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		System.out.println(DBPropertiesReader.getPropertie("password"));

	}

}
