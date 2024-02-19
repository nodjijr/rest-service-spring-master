package com.desafioapp.data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;

import org.springframework.beans.factory.annotation.Autowired;

import com.desafioapp.util.AwardsConstants;

public class CSVToH2 {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "org.h2.Driver";
	static final String DB_URL = "jdbc:h2:~/test";

	// Database credentials
	static final String USER = "sa";
	static final String PASS = "";

	public static Boolean status = false;

	public static void main(String[] args) {
		System.out.println("CSVCreated");
	}

	public String adjustmentTrimming(String strTrimming) {
		strTrimming = strTrimming.replaceAll("^\\s+", "");
		strTrimming = strTrimming.replaceAll("\\s+$", "");
		return strTrimming;
	}

	public String adjustment(String[] csvLista, int position) {
		if (csvLista.length > position && csvLista[position] != null && position < 4) {
			return adjustmentTrimming(csvLista[position]);
		} else {
			return "N/D";
		}
	}

	public Boolean loadCSVToH2() {
		String line = "";
		String cvsSplitBy = ";";
		PreparedStatement prepStatement;
		int recordCount = 0;
		BufferedReader csvFilmes = null;
		try {
			Connection conn = this.getConnection();
			csvFilmes = new BufferedReader(new FileReader(this.getCsvFile()));
			while ((line = csvFilmes.readLine()) != null) {
				String[] csvLista = line.split(cvsSplitBy);
				String year = adjustmentTrimming(adjustment(csvLista, 0));
				String title = adjustmentTrimming(adjustment(csvLista, 1));
				String studios = adjustmentTrimming(adjustment(csvLista, 2));
				String producers = adjustmentTrimming(adjustment(csvLista, 3));
				String winner = "False";
				int idMovie = 0;
				if (csvLista.length > 4 && csvLista[4] != null) { // especial adjustment for field winner
					winner = "True";
				}
				try {
					conn.setAutoCommit(false);
					prepStatement = conn.prepareStatement(AwardsConstants.INSERT_MOVIES);
					prepStatement.setString(1, year);
					prepStatement.setString(2, title);
					prepStatement.setString(3, studios);
					prepStatement.setString(4, producers);
					prepStatement.setString(5, winner);
					recordCount = recordCount + prepStatement.executeUpdate();
					idMovie = recordCount;
					updateProducers(producers.split(","), conn.prepareStatement(AwardsConstants.INSERT_PRODUCERS), idMovie);
					updateStudios(studios.split(","), conn.prepareStatement(AwardsConstants.INSERT_STUDIOS), idMovie);
					conn.commit();
				} catch (Exception ex) {
					System.out.println(ex.toString());
				}
			}
			prepStatement = conn.prepareStatement(AwardsConstants.DELETE_MOVIES);
			prepStatement.executeUpdate();
			prepStatement = conn.prepareStatement(AwardsConstants.DELETE_STUDIOS);
			prepStatement.executeUpdate();
			prepStatement = conn.prepareStatement(AwardsConstants.DELETE_PRODUCERS);
			prepStatement.executeUpdate();

		} catch (FileNotFoundException e) {
			status = false;
			e.printStackTrace();
		} catch (IOException e) {
			status = false;
			e.printStackTrace();
		} catch (Exception ex) {
			System.out.println(ex.toString());
		} finally {
			if (csvFilmes != null) {
				try {
					csvFilmes.close();
					status = true;
				} catch (IOException e) {
					status = false;
					e.printStackTrace();
				}
			}
		}

		System.out.println("Total records: " + recordCount);
		return status;
	}


	private void updateStudios(String[] studios, PreparedStatement prepareStatement, int idMovie) throws Exception {
		try {
			for (int i = 0; i < studios.length; i++) {
				prepareStatement.setString(1, adjustmentTrimming(studios[i]));
				prepareStatement.setInt(2, idMovie);
				prepareStatement.executeUpdate();
			}
		} catch (Exception e) {
			throw e;
		}
	}

	private void updateProducers(String[] producers, PreparedStatement preparedStatement, int idMovie) throws Exception {
		try {
			for (int i = 0; i < producers.length; i++) {
				preparedStatement.setString(1, adjustmentTrimming(producers[i]));
				preparedStatement.setInt(2, idMovie);
				preparedStatement.executeUpdate();
			}
		} catch (Exception e) {
			throw e;
		}
	}

	private Connection getConnection() {
		DatabaseConfiguration dbConfig = new DatabaseConfiguration();
		dbConfig.createDatabase();
		return dbConfig.getConnection();
	}

	private String getCsvFile() {
		String path = getClass().getClassLoader().getResource("movielist.csv").getPath();
		System.out.println("Path -> CSVFile");
		return Paths.get(path.replaceAll("/C:", "C:")).toString();
	}
}