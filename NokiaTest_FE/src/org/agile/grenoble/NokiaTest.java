package org.agile.grenoble;

import org.agile.grenoble.data.xml.QuestionsReader;
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
	
	
	private static void updateGraphics(NokiaSwing gui, QuestionsType questions) {
		gui.addQuestions(questions);
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
			QuestionsReader.printItems();
			questions = QuestionsReader.readItems();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//call master class
		NokiaSwing gui = initMainGUI();
		updateGraphics(gui,questions);
		System.out.println("HEllo, end of the nokia test");
	}

	
	
		
	
}
