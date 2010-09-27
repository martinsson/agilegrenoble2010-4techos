package org.agile.grenoble;

import org.agile.grenoble.data.AnswersStorage;
import org.agile.grenoble.data.xml.QuestionsReader;
import org.agile.grenoble.gui.NokiaControler;
import org.agile.grenoble.gui.NokiaSwing;
import org.agile.grenoble.questions.QuestionsType;

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
	
	
	/**
	 * 
	 * @param argv
	 */
	public static void main (String[] argv) {
		System.out.println("HEllo, welcome to the nokia test");
		//parse arguments
		QuestionsType questions=null;
		AnswersStorage storage = new AnswersStorage();
		try {
			storage.initializeDB();
			String filename = "E:\\build\\workspace\\NokiaTest_FE\\src\\org\\agile\\grenoble\\data\\xml\\questions.xml" ;
			QuestionsReader.printItems(filename);
			questions = QuestionsReader.readItems(filename);
			//call master class
			NokiaSwing gui = initMainGUI();
			gui.generateQuestionDisplay(questions);
			NokiaControler nc = new NokiaControler();
			nc.setNokiaSwing(gui);
			nc.setQuestions(questions);
		
			Thread.currentThread().sleep(500);
			nc.startQuestions();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		System.out.println("HEllo, end of the nokia test");
	}

	
	
		
	
}
