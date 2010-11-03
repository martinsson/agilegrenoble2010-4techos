package org.agile.grenoble.data;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.agile.grenoble.questions.AnswerType;
import org.agile.grenoble.questions.ConfigurationType;
import org.agile.grenoble.questions.QuestionType;
import org.agile.grenoble.questions.QuestionsType;
import org.agile.grenoble.user.User;

import com.mysql.jdbc.exceptions.MySQLSyntaxErrorException;

import java.sql.Connection ;

import javax.swing.JTextField;

public class AnswersStorage {

	Connection conn = null ; 
	int schemaVersion = 2 ;
	
	private Connection getConnection() {
		if (conn == null ) {
			conn = createConnection();
			return conn ;
		} else {
			return conn ;
		}
	}
	
	private Connection createConnection() {
		Connection conn = null; 
		try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
	        conn = DriverManager.getConnection("jdbc:mysql://localhost/?" + 
		                                    "user=root&password=agile123");

		 } catch (SQLException e) {
		     // handle any errors of type SQL
		     System.out.println("SQLException: " + e.getMessage());
		     System.out.println("SQLState: " + e.getSQLState());
		     System.out.println("VendorError: " + e.getErrorCode());
		 } catch (InstantiationException e) {
			 System.out.println("SQLException: " + e.getMessage());
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			System.out.println("SQLException: " + e.getMessage());
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("SQLException: " + e.getMessage());
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
				res = stat.executeQuery("select * from NokiaTest.versions order by anId");
			} catch (MySQLSyntaxErrorException e) {
				System.out.println("No result: " +e );
				//e.printStackTrace();
			}
			if (res == null ) {
				stat.close();
				initDB(conn,questions);				
			} else {
				System.out.println("Up2date table, doing nothing");
				//TODO we should check the version installed of the schema
				res.close();
				stat.close();
			}
		}
	}
	
	private void initDB(Connection conn,QuestionsType questions) throws SQLException {
		Statement stat = conn.createStatement() ;
		//add the ifnot exist, as the installation may be incremental
		executeQuery(stat, "Create database IF NOT EXISTS NokiaTest");
		executeQuery(stat, "Drop table IF EXISTS NokiaTest.surveys");
		executeQuery(stat, "Create table NokiaTest.surveys (anId INT AUTO_INCREMENT UNIQUE, aName VARCHAR(56), anEmail VARCHAR(56), aDate TIMESTAMP)") ;
		executeQuery(stat, "Drop table IF EXISTS NokiaTest.versions");
		executeQuery(stat, "Create table NokiaTest.versions (anId INT AUTO_INCREMENT UNIQUE, aVersion VARCHAR(56), aDate TIMESTAMP)") ;
		executeQuery(stat, "insert into NokiaTest.versions (aVersion) values ("+schemaVersion+")");
		
		//TODO generate schema from table definition ... simple/complex....
		for (int i =0 ; i < questions.getQuestionArray().length; i++) {
				createTableForQuestions(stat,questions.getQuestionArray(i),i);
		}	
		stat.close();
	}

	private void executeQuery(Statement stat, String query) throws SQLException {
		stat.execute(query);
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

	private boolean createTableForQuestions(Statement stat,	QuestionType question, int indice) 
		throws SQLException {
		
		String fields = ""; 
		boolean res = stat.execute("Drop table IF EXISTS NokiaTest.question_"+indice);
		if (!res) System.out.println("failed to drop table question_"+indice);
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

	public User getorCreateUser(String pName, String pEmail) throws SQLException {
		Connection conn = getConnection();
		User user = null ; 
		if (conn != null) { 
			Statement stat = conn.createStatement();
			ResultSet res = stat.executeQuery("Select anId, aName, anEmail from nokiatest.surveys where aName='"+pName+"' ;") ;
			user = new User();
			if ((res != null) && res.next() ) {
				user.setName(res.getString(2));
				user.setEmail(res.getString(3));
				user.setId(res.getInt(1));
			} else {
				System.out.println("No result, should create a new one");
				user = createUser(stat, pName,pEmail);
			}
			res.close();
			stat.close();
			
		} else {
			System.out.println("ERROR GETTING A CONNECTION ") ;
		} //end if 
		return user ; 
	}
	
	
	private User createUser(Statement stat, String pName, String pEmail) throws SQLException {
		boolean ok = stat.execute("INSERT INTO nokiatest.surveys (aName,anEmail) VALUES ('"+pName+"','"+pEmail+"');");
		if (!ok) System.out.println("Fail to add a new user") ;
		User iUser = new User();
		iUser.setName(pName);
		iUser.setEmail(pEmail);
		ResultSet res = stat.executeQuery("SELECT LAST_INSERT_ID();");
		if (res.next()) {
			iUser.setId(res.getInt(1));
		} else {
			System.out.println("Can not get id generated for user ") ;
			iUser.setId(-1);
		}
		res.close();
		System.out.println("Create a user : " + pName + ", " + iUser.getEmail() + ","+ iUser.getId() );
		return iUser ; 
	}

	public void storeAnswers(QuestionsType questions, int pUserId) throws SQLException {
		Connection conn = getConnection();
		if (conn != null) { 
			Statement stat = conn.createStatement();
			boolean res = true ; 
			for (int i =0 ; i < questions.getQuestionArray().length; i++) {
				res &= storePointForQuestions(stat,questions.getQuestionArray(i),pUserId,i);
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

	private boolean storePointForQuestions(Statement stat, QuestionType question, int pUserId, int indice) throws SQLException {
		String fields = getPoints(question);
		String query = "Insert into NokiaTest.question_"+indice+" VALUES (" +pUserId +","+fields+") ; ";
		System.out.println ("Query is : " + query );
		int res = stat.executeUpdate(query);
		System.out.println("We have update "+res + " rows");
		return (res==1); 
	}
	
}
