package org.agile.grenoble.data;

import static org.junit.Assert.fail;

import java.sql.SQLException;

import org.agile.grenoble.data.xml.QuestionsReader;
import org.agile.grenoble.questions.QuestionsType;
import org.junit.BeforeClass;
import org.junit.Test;

public class AnswersStorageTest {

	private AnswersStorage answersStorage = new AnswersStorage();
	private static QuestionsType questionsType;
	
	@BeforeClass
	public static void loadAndMarshallQuestions() throws Exception {
		String filename = "/org/agile/grenoble/data/xml/questionsForTests.xml"; //$NON-NLS-1$
		QuestionsReader.printItems(filename);
		questionsType = QuestionsReader.readItems(filename);
	}
	
	@Test
	public void testInitializeDB() {
		try {
			answersStorage.initializeDB(questionsType);
		} catch (SQLException e) {
			assertFailureAndPrintStackTrace(e);
		}
	}

	@Test
	public void testGetorCreateUser() {
		try {
			answersStorage.getorCreateUser("pedro", "pedro@lan.com");
		} catch (SQLException e) {
			assertFailureAndPrintStackTrace(e);
		}
	}

	@Test
	public void testStoreAnswers() throws Exception {
		try {
			answersStorage.storeAnswers(questionsType, 1);
		} catch (SQLException e) {
			assertFailureAndPrintStackTrace(e);
		}
	}
	
	@Test
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
