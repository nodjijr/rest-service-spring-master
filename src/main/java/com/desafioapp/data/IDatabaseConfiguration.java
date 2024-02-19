package com.desafioapp.data;

import java.sql.Connection;

public interface IDatabaseConfiguration {
	
	public void createDatabase();
	public Connection getConnection();
	

}
