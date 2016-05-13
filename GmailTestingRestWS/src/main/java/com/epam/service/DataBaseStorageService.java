package com.epam.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.stereotype.Service;
import com.epam.model.TestLog;

@Service
@Path("/DataBaseStorageService")
public class DataBaseStorageService {

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/sendLogsInDataBase")
	public String sendLogsInDataBase(List<TestLog> testLogs) {
		if (testLogs == null){
			return "Empty list";
		}else{
			return "Everything is okay";
		}
	}

	@GET
	@Produces("text/plain")
	@Path("/sendHello")
	public String sendLogsInDataBase(@QueryParam("hello") String hello) {
		System.err.println("Hello");
		return hello;
	}
}
