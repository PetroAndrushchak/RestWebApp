package com.epam.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.common.TestLogComparator;
import com.epam.db.service.TestLogService;
import com.epam.model.TestLog;

public class ShowLogsOnWebPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowLogsOnWebPage() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 List<TestLog> list = TestLogService.getAllLogsFromDB();
		 list.sort(new TestLogComparator());
		 
		 response.setContentType("text/html");
		 request.setAttribute("myList", list);
		 request.getRequestDispatcher("/index.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
}
