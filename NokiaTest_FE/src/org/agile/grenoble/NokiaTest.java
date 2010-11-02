package org.agile.grenoble;

import java.sql.SQLException;

import org.agile.grenoble.data.AnswersStorage;
import org.agile.grenoble.data.xml.QuestionsReader;
import org.agile.grenoble.gui.NokiaControler;
import org.agile.grenoble.gui.NokiaSwing;
import org.agile.grenoble.questions.QuestionsType;
import org.agile.grenoble.user.User;

public class NokiaTest {
	
	public static void main (String[] argv) {
		System.out.println(Messages.getString("NokiaTest.label")); //$NON-NLS-1$
	
		//parse arguments
		QuestionsType questions=null;
		AnswersStorage storage = new AnswersStorage();
		try {
			
			questions = loadAndMarshallQuestions();
			
			NokiaControler nc = new NokiaControler();
			nc.setQuestions(questions);
			ncSetDatabase(questions, storage, nc);
			nc.startHomePage(); //blocker call
			User user = nc.startUserRegistration();
			nc.setNokiaSwing(initMainGui(questions, user));
			nc.startQuestions(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(Messages.getString("NokiaTest.EndLabel")); //$NON-NLS-1$
	}

	private static void ncSetDatabase(QuestionsType questions,
			AnswersStorage storage, NokiaControler nc) throws SQLException {
		storage.initializeDB(questions);
		nc.setStorage(storage);
	}

	private static QuestionsType loadAndMarshallQuestions() throws Exception {
		QuestionsType questions;
		String filename = Configuration.getString("NokiaTest.questionsPath") ; //$NON-NLS-1$
		QuestionsReader.printItems(filename);
		questions = QuestionsReader.readItems(filename);
		return questions;
	}

	private static NokiaSwing initMainGui(QuestionsType questions, User user)
			throws Exception {
		NokiaSwing gui = new NokiaSwing();
		gui.setVisible(true); // blocker call
		gui.setUserName(user);
		gui.generateQuestionDisplay(questions);
		return gui;
	}
	
}
