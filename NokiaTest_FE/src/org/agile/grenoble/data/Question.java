package org.agile.grenoble.data;

public class Question {

	private String questionText = null;
	private Answers answers = null ; 
	
	public Question() {
	}
	
	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public void setAnswers(Answers answers) {
		this.answers = answers;
	}

	public Answers getAnswers() {
		return answers;
	}
	
	
}
