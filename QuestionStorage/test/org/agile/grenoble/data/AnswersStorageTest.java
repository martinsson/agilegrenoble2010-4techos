package org.agile.grenoble.data;

import static org.junit.Assert.fail;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;

import org.agile.grenoble.data.xml.QuestionsReader;
import org.agile.grenoble.questions.QuestionType;
import org.agile.grenoble.questions.QuestionsType;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

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
	
	@BeforeClass
	public static void loadAndMarshallQuestions() throws Exception {
		String filename = "/org/agile/grenoble/data/xml/questionsForTests.xml"; //$NON-NLS-1$
		QuestionsReader.printItems(filename);
		questionsType = QuestionsReader.readItems(filename);
	}
	
	@Test
	public void testInitializeDB() {
		try {
			when(statement.executeQuery(AnswersStorage.SELECT_FROM_NOKIA_TEST_VERSIONS_ORDER_BY_AN_ID)).thenReturn(null);
			answersStorage.initializeDB(questionsType);
			verify(answersStorage).initDB(connection, questionsType);
		} catch (SQLException e) {
			assertFailureAndPrintStackTrace(e);
		}
	}

	@Test
	public void testInitDB() {
		try {
			answersStorage.initDB(connection, questionsType);
			verify(answersStorage).executeQuery(statement,AnswersStorage.CREATE_DATABASE_IF_NOT_EXISTS_NOKIA_TEST);
			verify(answersStorage).executeQuery(statement,AnswersStorage.DROP_TABLE_IF_EXISTS_NOKIA_TEST_SURVEYS);
			verify(answersStorage).executeQuery(statement,AnswersStorage.CREATE_TABLE_NOKIA_TEST_SURVEYS);
			verify(answersStorage).executeQuery(statement,AnswersStorage.DROP_TABLE_IF_EXISTS_NOKIA_TEST_VERSIONS);
			verify(answersStorage).executeQuery(statement,AnswersStorage.CREATE_TABLE_NOKIA_TEST_VERSIONS);
			verify(answersStorage).executeQuery(statement,AnswersStorage.INSERT_INTO_NOKIA_TEST_VERSIONS);
			verify(answersStorage, times(7)).createTableForQuestions(any(Statement.class), any(QuestionType.class), anyInt());
		} catch (SQLException e) {
			assertFailureAndPrintStackTrace(e);
		}
	}
	
	@Ignore
	public void testGetorCreateUser() {
		String pName = "pedro";
		String pEmail = "pedro@lan.com";
		try {
			when(statement.executeQuery(MessageFormat.format(AnswersStorage.SELECT_AN_ID_A_NAME_AN_EMAIL_FROM_NOKIATEST_SURVEYS,pName))).thenReturn(null);
			when(statement.execute(MessageFormat.format(AnswersStorage.INSERT_INTO_NOKIATEST_SURVEYS_A_NAME_AN_EMAIL, pName, pEmail))).thenReturn(true);
			//TODO gérer l'appel à createUser
			answersStorage.getorCreateUser(pName, pEmail);
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
	
	private void assertFailureAndPrintStackTrace(SQLException e) {
		fail("should not have raised an exception");
		e.printStackTrace();
	}
}
