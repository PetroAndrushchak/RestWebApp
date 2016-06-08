package com.epam.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.epam.db.service.TestLogService;
import com.epam.model.TestLog;

@Path("/DataBaseStorageService")
public class DataBaseStorageService {
	

	@POST
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/sendLogsInDataBase")
	public Response sendLogsInDataBase(List<TestLog> testLogs) {
		for(TestLog log : testLogs){
			TestLogService.sendLogInDataBase(log);
		}
		return Response.ok("everything is okay").build();
	}
	
	@POST
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/sendOneLogInDataBase")
	public Response sendLogsInDataBase(TestLog testLogs) {
		TestLogService.sendLogInDataBase(testLogs);
		return Response.ok("everything is okay").build();
	}	
}
