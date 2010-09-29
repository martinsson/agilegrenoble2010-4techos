package org.agile.grenoble.data;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.agile.grenoble.questions.AnswerType;
import org.agile.grenoble.questions.AnswersType;
import org.agile.grenoble.questions.ConfigurationType;
import org.agile.grenoble.questions.QuestionType;
import org.agile.grenoble.questions.QuestionsType;

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

	public void initializeDB(QuestionsType questions) throws SQLException {
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
				initDB(conn,questions);				
			} else {
				res.close();
				stat.close();
			}
		}
	}
	
	private void initDB(Connection conn,QuestionsType questions) throws SQLException {
		Statement stat = conn.createStatement() ;
		//add the ifnot exist, as the installation may be incremental
		boolean res = stat.execute("Create database IF NOT EXISTS NokiaTest");
		if (res) {
			System.out.println("Creation of database succeed" );
		}
		
		res = createSurveyTable(stat);
		//TODO generate schema from table definition ... simple/complex....
		for (int i =0 ; i < questions.getQuestionArray().length; i++) {
				res &= createTableForQuestions(stat,questions.getQuestionArray(i),i);
		}	
		if (res) {
			System.out.println("Creation of table surveys succeed" );
		} else {
			System.out.println("Creation of table surveys failed" );
		}
		stat.close();

		
	}

	private int getNbFields(QuestionType question) {
		int nb = 0;
		if (question.getConfiguration().getType()== ConfigurationType.Type.SINGLE) {
			nb = 1;
		} else if (question.getConfiguration().getType()== ConfigurationType.Type.MULTIPLE) {
			nb = question.getConfiguration().getNumber();
		} else {
			//complex 
			for (int i=0; i < question.getQuestionArray().length; i ++) {
				QuestionType child = question.getQuestionArray(i);
				nb += getNbFields(child);
			} //end for 
		} //end if 
		
		return nb ;
	}

	private boolean createSurveyTable(Statement stat) throws SQLException {		
		boolean res = stat.execute("Drop table IF EXISTS NokiaTest.surveys");
		res &= stat.execute("Create table NokiaTest.surveys (anId INT AUTO_INCREMENT UNIQUE, aName VARCHAR(56), aDate TIMESTAMP)");
		return res ;
	}




	private boolean createTableForQuestions(Statement stat,	QuestionType question, int indice) 
		throws SQLException {
		
		String fields = ""; 
		boolean res = stat.execute("Drop table IF EXISTS NokiaTest.question_"+indice);
		int nb = getNbFields(question);
		for (int i=0; i < nb;i++) {
			if (i>0) fields += "," ;
			fields += "anAnswers_"+i+" INT" ;
		} //end for  
		String query = "Create table  IF NOT EXISTS NokiaTest.question_"+indice+" (anId INT UNIQUE, "+fields+")";
		System.out.println ("Query is : " + query );
		res = stat.execute(query);		
		return res; 
	}

	public void storeAnswers(QuestionsType questions, int pUserId) throws SQLException {
		Connection conn = getConnection();
		if (conn != null) { 
			Statement stat = conn.createStatement();
			boolean res = true ; 
			for (int i =0 ; i < questions.getQuestionArray().length; i++) {
				res &= StorePointForQuestions(stat,questions.getQuestionArray(i),pUserId,i);
		}	
		} else {
			System.out.println("ERROR GETTING A CONNECTION ") ;
		} //end if 
	}


	private String getPoints(QuestionType question) {
		String points = null ;
		if (question.getConfiguration().getType()== ConfigurationType.Type.SINGLE) {
			//
			points = getQuestionPoint(question);
			if (points == null ) points = "0";
		} else if (question.getConfiguration().getType()== ConfigurationType.Type.MULTIPLE) {
			points = getQuestionPoint(question);
			if (points == null ) points = "0";
		} else {
			//complex 
			for (int i=0; i < question.getQuestionArray().length; i ++) {
				QuestionType child = question.getQuestionArray(i);
				if (points != null) {
					points += ","+ getPoints(child);
				} else {
					points = getPoints(child);
				}
			} //end for 
		} //end if 	
		return points ;
	}



	/*
	 * works for single and multiple ... we do some loop free ... but who cares ...
	 */
	private String getQuestionPoint(QuestionType question) {
		String points=null;
		for (int i=0; i < question.getAnswers().getAnswerArray().length; i++) {
			if ( question.getAnswers().getAnswerArray(i).getSelected() == AnswerType.Selected.TRUE ) {
				if (points != null) points += "," ;
				points= question.getAnswers().getAnswerArray(i).getPoint() ;
			}
		}
		//System.out.println("We have update points for question : " + question.getLabel() + ", and we have found : " + points );
		return points ; 
	}

	private boolean StorePointForQuestions(Statement stat, QuestionType question, int pUserId, int indice) throws SQLException {
		String fields = getPoints(question);
		String query = "Insert into NokiaTest.question_"+indice+" VALUES (" +pUserId +","+fields+") ; ";
		System.out.println ("Query is : " + query );
		int res = stat.executeUpdate(query);
		System.out.println("We have update "+res + " rows");
		return (res==1); 
	}
	
}
