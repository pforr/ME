package com.dtt.nuocsach.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connect {

	private static final String DATABASE_URL = "jdbc:mysql://123.25.30.83:8306/ns_portalcore_gem";
	private static final String USERNAME = "gemnuocsach";
	private static final String PASSWORD = "gemns321";

	public static Connection getconect() throws SQLException {
		Properties info = new Properties();
		info.put("user", USERNAME);
		info.put("password", PASSWORD);
		System.out.println("Connecting database...");
		java.sql.Connection conn = DriverManager.getConnection(DATABASE_URL, info);
		return conn;

	}

}
