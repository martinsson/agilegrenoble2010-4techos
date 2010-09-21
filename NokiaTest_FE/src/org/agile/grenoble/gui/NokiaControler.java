package org.agile.grenoble.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.agile.grenoble.questions.QuestionsType;

public class NokiaControler implements  ActionListener{

	public NokiaControler() {
	}
	
	QuestionsType iQuestions = null; 
	NokiaSwing iNokiaSwing = null; 
	int currentQuestionIndex = -1 ;
	
	public void setQuestions(QuestionsType qt) {
		iQuestions = qt ; 
	}
	
	public void setNokiaSwing(NokiaSwing ns ) {
		iNokiaSwing = ns ; 
	}
	
	public void startQuestions() {
		currentQuestionIndex = 0 ;
		iNokiaSwing.DisplayFirstquestion();
		registerNextQuestion();
		
	}
	
	private void registerNextQuestion( ) {
		iNokiaSwing.registerOnClickNavBarEvent(this);
	}
	

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
