package com.gmailtesting.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;

import com.gmailtesting.logging.TestLog;
import com.google.gson.Gson;

public class WebServiceClient {

	public static String WEB_SERVICE_URL = "http://localhost:9080/GmailTestingRestWS/DataBaseStorageService/";
	public static String SEND_LOGS_IN_DATA_BASE = "sendLogsInDataBase";
	
	public static String CONTENT_TYPE_JSON = "application/json";

	public static Response sendLogsInDataBase(List<TestLog> testLogs) {

		WebClient client = WebClient.create(WEB_SERVICE_URL + SEND_LOGS_IN_DATA_BASE,true);

		client = client.accept(CONTENT_TYPE_JSON).type(CONTENT_TYPE_JSON);

		Response response = client.post(new Gson().toJson(testLogs));

		return response;

	}

	public static void main(String[] args) {
		List<TestLog> list = new ArrayList<>();
		TestLog testLog = new TestLog();
		testLog.setLevel("Debug");
		testLog.setDate(new Date());
		list.add(testLog);

		WebServiceClient.sendLogsInDataBase(list);
	}

}
