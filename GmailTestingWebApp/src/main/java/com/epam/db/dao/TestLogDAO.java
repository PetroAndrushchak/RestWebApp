package com.epam.db.dao;

import com.epam.model.TestLog;

interface TestLogDAO {
	
	void sendLogInDataBase(TestLog log);
}
