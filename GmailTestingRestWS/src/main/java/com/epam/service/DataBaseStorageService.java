package com.epam.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.epam.model.TestLog;
import com.google.gson.Gson;

@Service
@Path("/DataBaseStorageService")
public class DataBaseStorageService {

	private Gson gson = new Gson();
	List<TestLog> globalLog = new ArrayList<>();
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/sendLogsInDataBase")
	public Response sendLogsInDataBase(List<TestLog> testLogs) {
		System.err.println("Hello");
		globalLog.addAll(testLogs);
		for(TestLog log : testLogs){
			System.err.println("**********"+log.getMessage()+"***************");
		}
		System.err.println("local = "+testLogs.size());
		System.err.println("gloval = "+globalLog.size());
		return Response.ok("everything is okay").build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/sendOneLogInDataBase")
	public Response sendLogsInDataBase(TestLog testLogs) {
		System.err.println("Hello");
		System.err.println(testLogs);
		return Response.ok("everything is okay").build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/sendHello")
	public Response sendLogsInDataBase(@QueryParam("hello") String hello) {
		System.err.println("Hello");
		TestLog testLog = new TestLog();
		testLog.setLevel("Debug");
		testLog.setMethodName("Test");
		return Response.ok(gson.toJson(testLog)).build();
	}
}
