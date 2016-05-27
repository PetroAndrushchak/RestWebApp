package com.epam.db.dao;

import java.util.List;

import com.epam.model.TestLog;

interface TestLogDAO {
	
	void sendLogInDataBase(TestLog log);
}
