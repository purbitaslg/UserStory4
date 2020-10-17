package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {
	
	static DbConnector db;
	
	public DbConnector() {
		
		super();
		
	}
	
	public static DbConnector getInstance() {
		
		if(db==null)
		db=new DbConnector();
		return db;
	}
	
	public static Connection getConnection() throws SQLException {
		return (DriverManager.getConnection("jdbc:mysql://localhost:3306/schemaone","root","Admindxc"));
	}

}
