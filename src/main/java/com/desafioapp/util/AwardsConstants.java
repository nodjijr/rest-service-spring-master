package com.desafioapp.util;

public class AwardsConstants {
	
	public AwardsConstants() {
		super();
	}

	// JDBC driver name and database URL
	public static final String JDBC_DRIVER = "org.h2.Driver";
	public static final String DB_URL = "jdbc:h2:~/test";
	public static final String USER = "nodji";
	public static final String PASS = "";
	public static final String DROP_TABLES =  "DROP VIEW IF EXISTS AWARDSINTERVAL_VIEW ; DROP TABLE IF EXISTS AWARDSINTERVAL; DROP TABLE IF EXISTS MOVIES;DROP TABLE IF EXISTS PRODUCERS;DROP TABLE IF EXISTS STUDIOS;";
	public static final String CREATE_MOVIES = " CREATE TABLE MOVIES (id BIGINT auto_increment, year CHAR(4), title VARCHAR(255), studios VARCHAR(255), producers VARCHAR(255), winner BOOLEAN, PRIMARY KEY ( id ))";
	public static final String INSERT_MOVIES = "INSERT INTO MOVIES ( year, title, studios, producers, winner) VALUES ( ?, ?, ?, ?, ?)";
	public static final String DELETE_MOVIES = "DELETE FROM MOVIES WHERE ID=1";
	public static final String CREATE_PRODUCERS = " CREATE TABLE PRODUCERS (id BIGINT auto_increment, name VARCHAR(255), fk_id_movie BIGINT, PRIMARY KEY ( id ))";
	public static final String INSERT_PRODUCERS = "INSERT INTO PRODUCERS ( name, fk_id_movie) VALUES ( ?, ?)";
	public static final String DELETE_PRODUCERS = "DELETE FROM PRODUCERS WHERE ID=1";
	public static final String CREATE_STUDIOS = " CREATE TABLE STUDIOS (id BIGINT auto_increment, name VARCHAR(255), fk_id_movie BIGINT, PRIMARY KEY ( id ))";
	public static final String INSERT_STUDIOS = "INSERT INTO STUDIOS ( name, fk_id_movie) VALUES ( ?, ?)";
	public static final String DELETE_STUDIOS = "DELETE FROM STUDIOS WHERE ID=1";
	public static final String CREATE_AWARDS = " CREATE TABLE AWARDSINTERVAL (id BIGINT auto_increment, producer VARCHAR(255), interval INTEGER, previousWin INTEGER, followingWin INTEGER, PRIMARY KEY ( id ))";
	public static final String CREATE_AWARDS_VIEW = "CREATE VIEW AWARDSINTERVAL_VIEW AS  " + 
	"SELECT * FROM (  " + 
	"SELECT   " + 
	"  PRODUCERS   " + 
	", DATEDIFF('YEAR',CONCAT(MINIMO , '-01-01'), CONCAT(MAXIMO, '-01-01')) as INTERVAL  " + 
	", MINIMO AS PREVIOUSWIN  " + 
	", MAXIMO AS FOLLOWINGWIN  " + 
	"FROM (  " + 
	"SELECT   " + 
	"   M.PRODUCERS   " + 
	", (SELECT YEAR  FROM MOVIES  WHERE YEAR = (select MIN(YEAR ) from MOVIES M1 WHERE M1.PRODUCERS =M.PRODUCERS   )  LIMIT 1) AS MINIMO   " + 
	", (SELECT YEAR  FROM MOVIES  WHERE YEAR = (select MAX(YEAR ) from MOVIES M1 WHERE M1.PRODUCERS =M.PRODUCERS   )  LIMIT 1) AS MAXIMO  " + 
	"FROM MOVIES M  " + 
	"WHERE M.WINNER=1   " + 
	") WHERE DATEDIFF('YEAR',CONCAT(MINIMO , '-01-01'), CONCAT(MAXIMO, '-01-01'))>0 ORDER BY INTERVAL DESC LIMIT 1  " + 
	")  " + 
	"UNION ALL  " + 
	"SELECT * FROM (  " + 
	"SELECT   " + 
	"  PRODUCERS   " + 
	", DATEDIFF('YEAR',CONCAT(MINIMO , '-01-01'), CONCAT(MAXIMO, '-01-01')) as INTERVAL  " + 
	", MINIMO AS PREVIOUSWIN  " + 
	", MAXIMO AS FOLLOWINGWIN  " + 
	"FROM (  " + 
	"SELECT   " + 
	"   M.PRODUCERS   " + 
	", (SELECT YEAR  FROM MOVIES  WHERE YEAR = (select MIN(YEAR ) from MOVIES M1 WHERE M1.PRODUCERS =M.PRODUCERS   )  LIMIT 1) AS MINIMO   " + 
	", (SELECT YEAR  FROM MOVIES  WHERE YEAR = (select MAX(YEAR ) from MOVIES M1 WHERE M1.PRODUCERS =M.PRODUCERS   )  LIMIT 1) AS MAXIMO  " + 
	"FROM MOVIES M  " + 
	"WHERE M.WINNER=1   " + 
	") WHERE DATEDIFF('YEAR',CONCAT(MINIMO , '-01-01'), CONCAT(MAXIMO, '-01-01'))>0 ORDER BY INTERVAL ASC LIMIT 1  " + 
	");";

	
	
	

}
