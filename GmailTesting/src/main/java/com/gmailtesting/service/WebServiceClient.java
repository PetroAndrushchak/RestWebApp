package com.gmailtesting.service;

import java.util.List;

import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;

import com.gmailtesting.data.ITestLog;
import com.google.gson.Gson;

public class WebServiceClient {

	public static String WEB_SERVICE_URL = "http://localhost:9080/GmailTestingRestWS/DataBaseStorageService/";
	public static String SEND_LOGS_IN_DATA_BASE = "sendLogsInDataBase";
	public static String SEND_LOG_IN_DATA_BASE = "sendOneLogInDataBase";
	
	public static String CONTENT_TYPE_JSON = "application/json";

	public static Response sendLogsInDataBase(List<ITestLog> testLogs) {

		WebClient client = WebClient.create(WEB_SERVICE_URL + SEND_LOGS_IN_DATA_BASE,true);

		client = client.accept(CONTENT_TYPE_JSON).type(CONTENT_TYPE_JSON);

		Response response = client.post(new Gson().toJson(testLogs));

		return response;

	}
	
	public static Response sendLogInDataBase(ITestLog testLog) {

		WebClient client = WebClient.create(WEB_SERVICE_URL + SEND_LOG_IN_DATA_BASE,true);

		client = client.accept(CONTENT_TYPE_JSON).type(CONTENT_TYPE_JSON);

		Response response = client.post(new Gson().toJson(testLog));

		return response;

	}
}
