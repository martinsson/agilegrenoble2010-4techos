package org.agile.grenoble;

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
		try {
			String filename = "E:\\build\\workspace\\NokiaTest_FE\\src\\org\\agile\\grenoble\\data\\xml\\questions.xml" ;
			QuestionsReader.printItems(filename);
			questions = QuestionsReader.readItems(filename);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//call master class
		NokiaSwing gui = initMainGUI();
		gui.generateQuestionDisplay(questions);
		NokiaControler nc = new NokiaControler();
		nc.setNokiaSwing(gui);
		nc.setQuestions(questions);
		
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		nc.startQuestions();
		
		
		
		System.out.println("HEllo, end of the nokia test");
	}

	
	
		
	
}
