package org.agile.grenoble;

import org.agile.grenoble.data.AnswersStorage;
import org.agile.grenoble.data.xml.QuestionsReader;
import org.agile.grenoble.gui.NokiaControler;
import org.agile.grenoble.gui.NokiaSwing;
import org.agile.grenoble.questions.QuestionsType;
import org.agile.grenoble.user.User;

/**
 * 
 * 
 * 
 * @author build
 *
 */
public class NokiaTest {

	 
	private static NokiaSwing initMainGUI() {
		NokiaSwing myDisplay = new NokiaSwing();
		myDisplay.setVisible(true);
		return myDisplay;
	}
	
	
	private static final String FILENAME = "src/org/agile/grenoble/data/xml/questions.xml" ;
	
	/**
	 * 
	 * @param argv
	 */
	public static void main (String[] argv) {
		System.out.println(Messages.getString("NokiaTest.label")); //$NON-NLS-1$

		ClassLoader.getSystemResource(".");
		
		//parse arguments
		QuestionsType questions=null;
		AnswersStorage storage = new AnswersStorage();
		try {
			
			String filename = Configuration.getString("NokiaTest.questionsPath") ; //$NON-NLS-1$
			QuestionsReader.printItems(filename);
			questions = QuestionsReader.readItems(filename);
			//call master class
			NokiaSwing gui = initMainGUI();
			gui.generateQuestionDisplay(questions);
			NokiaControler nc = new NokiaControler();
			nc.setNokiaSwing(gui);
			nc.setQuestions(questions);
			storage.initializeDB(questions);
			
			
			nc.setStorage(storage);
			nc.startHomePage(); //blocker call
			User user = nc.startUserRegistration(); // blocker call
			nc.startQuestions(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		System.out.println(Messages.getString("NokiaTest.EndLabel")); //$NON-NLS-1$
	}

	
	
		
	
}
