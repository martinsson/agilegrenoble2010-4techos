package org.agile.grenoble;

import org.agile.grenoble.data.*;
import org.agile.grenoble.gui.*;

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
	
	private static Question[] buildQuestions() {
		Question[] questions = new Question[2];
		questions[0]=new Question();
		questions[0].setQuestionText("My first SingleChoice Agile question ? ");
		Answers answers = new SingleChoice();
		String[] texts= { "answers 1" , "answers 2" , "..." };
		answers.setTexts(texts);
		questions[0].setAnswers(answers);
		
		
		questions[1]=new Question();
		questions[1].setQuestionText("My first MultipleChoice Agile question ? ");
		answers = new MultipleChoice();
		//String[] texts= { "answers 1" , "answers 2" , "..." };
		answers.setTexts(texts);
		questions[1].setAnswers(answers);
		return questions;
	}
	
	private static void updateGraphics(NokiaSwing gui, Question[] questions) {
		gui.addQuestions(questions);
	}
	
	/**
	 * 
	 * @param argv
	 */
	public static void main (String[] argv) {
		System.out.println("HEllo, welcome to the nokia test");
		//parse arguments
		Question[] questions = buildQuestions();
		//call master class
		NokiaSwing gui = initMainGUI();
		updateGraphics(gui,questions);
		System.out.println("HEllo, end of the nokia test");
	}

	
	
		
	
}
