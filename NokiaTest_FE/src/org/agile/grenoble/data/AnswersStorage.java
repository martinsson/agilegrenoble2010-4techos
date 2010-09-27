package org.agile.grenoble.data;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.agile.grenoble.questions.AnswersType;

import com.mysql.jdbc.exceptions.MySQLSyntaxErrorException;

import java.sql.Connection ;

public class AnswersStorage {

	Connection conn = null ; 
	
	private Connection getConnection() {
		if (conn == null ) {
			return createConnection();
		} else {
			return conn ;
		}
	}
	
	
	private Connection createConnection() {
		Connection conn = null; 
		try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
	        conn = DriverManager.getConnection("jdbc:mysql://localhost/NokiaTest?" + 
		                                    "user=root&password=agile123");

		 } catch (SQLException ex) {
		     // handle any errors
		     System.out.println("SQLException: " + ex.getMessage());
		     System.out.println("SQLState: " + ex.getSQLState());
		     System.out.println("VendorError: " + ex.getErrorCode());
		 } catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn ; 
	}

	public void initializeDB() throws SQLException {
		Connection conn = getConnection();
		if (conn != null) { 
			Statement stat = conn.createStatement();
			ResultSet res = null; 
			try {
				res = stat.executeQuery("select * from NokiaTest.NokiaTest");
			} catch (MySQLSyntaxErrorException e) {
				System.out.println("No result: " +e );
				//e.printStackTrace();
			}
			if (res == null ) {
				stat.close();
				initDB(conn);				
			} else {
				res.close();
				stat.close();
			}
		}
	}
	
	private void initDB(Connection conn) throws SQLException {
		Statement stat = conn.createStatement() ;
		//add the ifnot exist, as the installation may be incremental
		boolean res = stat.execute("Create database IF NOT EXISTS NokiaTest");
		if (res) {
			System.out.println("Creation of database succeed" );
		}
		//TODO generate schema from table definition ... simple/complex....
		res = stat.execute("Create table IF NOT EXISTS NokiaTest.surveys (anId INT AUTO_INCREMENT UNIQUE, aName VARCHAR(56), aDate TIMESTAMP)");
		res = stat.execute("Create table IF NOT EXISTS NokiaTest.question1 (anId INT, anAnswers INT)");
		res = stat.execute("Create table IF NOT EXISTS NokiaTest.question2 (anId INT, anAnswers INT)");
		res = stat.execute("Create table IF NOT EXISTS NokiaTest.question3 (anId INT, anAnswers1 INT, anAnswers2 INT)");
		if (res) {
			System.out.println("Creation of table surveys succeed" );
		} else {
			System.out.println("Creation of table surveys failed" );
		}
		stat.close();

		
		
	}


	public void storeAnswer(AnswersType answer,int value) {
		
	}
	
}
