package org.agile.grenoble.data;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Matchers.any;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.agile.grenoble.data.xml.QuestionsReader;
import org.agile.grenoble.questions.QuestionsType;
import org.agile.grenoble.user.User;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import java.sql.Statement;

public class AnswersStorageTest {

	private static QuestionsType questionsType;
	private AnswersStorage answersStorage;
	Connection connection = mock(Connection.class);
	Statement statement = mock(Statement.class);

	@Before
	public void initTests() throws SQLException {
		answersStorage = spy(new AnswersStorage());
		when(answersStorage.getConnection()).thenReturn(connection);
		when(connection.createStatement()).thenReturn(statement);
		answersStorage.setConnection(connection);
	}
	
	@After
	public void afterTests() {
//		reset(answersStorage);
//		reset(connection);
//		reset(statement);
	}
	
	@BeforeClass
	public static void loadAndMarshallQuestions() throws Exception {
		String filename = "/org/agile/grenoble/data/xml/questionsForTests.xml"; //$NON-NLS-1$
		QuestionsReader.printItems(filename);
		questionsType = QuestionsReader.readItems(filename);
	}
	
	@Test
	public void testInitializeDB() {
		try {
			when(statement.executeQuery("select * from NokiaTest.versions order by anId")).thenReturn(null);
			answersStorage.initializeDB(questionsType);
			verify(statement).executeQuery("select * from NokiaTest.versions order by anId");
			verify(answersStorage).initDB(connection, questionsType);
		} catch (SQLException e) {
			assertFailureAndPrintStackTrace(e);
		}
	}

	@Test
	public void testInitDB() {
		try {
			answersStorage.initDB(connection, questionsType);
			verify(answersStorage).executeQuery(statement,"Create database IF NOT EXISTS NokiaTest");
			verify(answersStorage).executeQuery(statement,"Drop table IF EXISTS NokiaTest.surveys");
			//TODO remaining queries + refactoring
		} catch (SQLException e) {
			assertFailureAndPrintStackTrace(e);
		}
	}
	
	@Ignore
	public void testGetorCreateUser() {
		String pName = "pedro";
		String pEmail = "pedro@lan.com";
		try {
			when(statement.executeQuery("Select anId, aName, anEmail from nokiatest.surveys where aName='pedro' ;")).thenReturn(null);
//			ResultSet resultSet = mock(ResultSet.class);
//			when(resultSet.next()).thenReturn(true);
//			verify(resultSet).close();
			when(statement.executeQuery("SELECT LAST_INSERT_ID();")).thenReturn(null);
			answersStorage.getorCreateUser(pName, pEmail);
//			verify(answersStorage).createUser(statement, pName, pEmail);
		} catch (SQLException e) {
			assertFailureAndPrintStackTrace(e);
		}
	}

	@Test
	public void testStoreAnswers() throws Exception {
		try {
			answersStorage.storeAnswers(questionsType, 1);
			verify(statement,times(7)).executeUpdate(any(String.class));
		} catch (SQLException e) {
			assertFailureAndPrintStackTrace(e);
		}
	}
	
	@Ignore
	public void dropNokiaTestDatabase() {
		try {
			answersStorage.dropDatabaseIfExist();
		} catch (SQLException e) {
			assertFailureAndPrintStackTrace(e);
		}
	}
	
	private void assertFailureAndPrintStackTrace(SQLException e) {
		fail("should not have raised an exception");
		e.printStackTrace();
	}
}
