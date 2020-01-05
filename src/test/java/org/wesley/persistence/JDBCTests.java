package org.wesley.persistence;


import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JDBCTests {

	private static final Logger logger = LoggerFactory.getLogger(JDBCTests.class);
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) { // TODO: handle exception
			e.printStackTrace();
		}
	}

	@Test 
	public void testConnection() {
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "book_ex", "book_ex");
			logger.info(con.toString()); 
		} catch (Exception e) { 
		// TODO: handle exception 
		fail(e.getMessage()); } 
		
	
	}
}
