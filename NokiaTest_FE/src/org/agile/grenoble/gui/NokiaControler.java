package org.agile.grenoble.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.agile.grenoble.questions.QuestionsType;
/*
 * MVC model, the controler will control the gui, and send proper information 
 * to storage mechanism
 * It control also the logic.
 */
public class NokiaControler implements  ActionListener{

	/* constructor */
	public NokiaControler() {
	}
	
	//the list of questions
	QuestionsType iQuestions = null;

	//	the GUI
	NokiaSwing iNokiaSwing = null;
	
	//the current question (will allow future back button too)
	int currentQuestionIndex = -1 ;
	
	/* set the  questions list, on the controller*/
	public void setQuestions(QuestionsType qt) {
		iQuestions = qt ; 
	}
	
	/* Set the GUI to the Controller */
	public void setNokiaSwing(NokiaSwing ns ) {
		iNokiaSwing = ns ; 
	}
	
	/* start the survey */
	public void startQuestions() {
		currentQuestionIndex = 0 ;
		iNokiaSwing.DisplayFirstquestion();
		registerNextQuestion();
		
	}
	
	/* 
	 * register on the GUI in order to be informed
	 *  of a click on the next button 
	 *  */
	
	private void registerNextQuestion( ) {
		iNokiaSwing.registerOnClickNavBarEvent(this);
	}
	

	/*
	 * When clicking on the next, receive an event.
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (currentQuestionIndex == iQuestions.sizeOfQuestionArray() -1 ) {
			iNokiaSwing.TerminateTest();
		} else {
			currentQuestionIndex++;
			boolean isLast = ( currentQuestionIndex == iQuestions.sizeOfQuestionArray()-1); 
			iNokiaSwing.nextQuestion(currentQuestionIndex,isLast);
		}
	}
	
	
}
