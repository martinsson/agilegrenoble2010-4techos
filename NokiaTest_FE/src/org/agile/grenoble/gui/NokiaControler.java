package org.agile.grenoble.gui;

import org.agile.grenoble.questions.QuestionsType;

public class NokiaControler {

	public NokiaControler() {
	}
	
	QuestionsType iQuestions = null; 
	NokiaSwing iNokiaSwing = null; 
	
	public void setQuestions(QuestionsType qt) {
		iQuestions = qt ; 
	}
	
	public void setNokiaSwing(NokiaSwing ns ) {
		iNokiaSwing = ns ; 
	}
	
	public void startQuestions() {
		iNokiaSwing.DisplayFirstquestion();
	}
	
	
}
