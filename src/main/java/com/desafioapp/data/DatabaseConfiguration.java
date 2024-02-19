package com.desafioapp.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.desafioapp.util.AwardsConstants;

public class DatabaseConfiguration implements IDatabaseConfiguration {
	
	
	private Connection conn;
	
	public DatabaseConfiguration() {
		this.conn = createConnection();
	}
	
	public void createDatabase() {
		try {
			Statement stmt = this.conn.createStatement();
			stmt.executeUpdate(AwardsConstants.DROP_TABLES);
			stmt.executeUpdate(AwardsConstants.CREATE_MOVIES);
			stmt.executeUpdate(AwardsConstants.CREATE_PRODUCERS);
			stmt.executeUpdate(AwardsConstants.CREATE_STUDIOS);
			stmt.executeUpdate(AwardsConstants.CREATE_AWARDS);
			stmt.executeUpdate(AwardsConstants.CREATE_AWARDS_VIEW);
			System.out.println("Created database.");
		} catch (SQLException se) {// JDBC
			se.printStackTrace();
		} catch (Exception e) {// Class.forName
			e.printStackTrace();
		} 
	}

	public Connection getConnection() {
		return conn;
	}

	private Connection createConnection() {
		try {
			Class.forName(AwardsConstants.JDBC_DRIVER);
			System.out.println("Connecting to H2...");
			return DriverManager.getConnection(AwardsConstants.DB_URL, AwardsConstants.USER, AwardsConstants.PASS);
		} catch (SQLException se) {//JDBC
			se.printStackTrace();
		} catch (Exception e) {//Class.forName
			e.printStackTrace();
		}
		return null;
	}
	
}
