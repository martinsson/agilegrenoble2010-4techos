package org.agile.grenoble.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.agile.grenoble.questions.AnswersType;
import org.agile.grenoble.questions.QuestionType;
import org.agile.grenoble.questions.QuestionsType;


public class NokiaSwing  extends JFrame {
	
	private static final int globalHeight = 400;
	private static final int globalWidth = 400;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8322709712160036058L;

	public NokiaSwing ()  { 
		super();
		initContent();
	}

	public void addQuestions(QuestionsType pQuestions) {		
		JPanel questionArea = generateQuestionArea();
		
		JPanel questionPanel = null;
		
		for (int i=0; i < pQuestions.getQuestionArray().length; i++) {
			questionPanel = addQuestion(pQuestions.getQuestionArray()[i]);
			questionArea.add(questionPanel);
		}
		
		getContentPane().add(questionArea, BorderLayout.WEST);
		getContentPane().setBackground(Color.lightGray);
		
		pack();
		repaint();
	}

	private void initContent() {
		setTitle("Nokia Test") ;		
	}
		
	private JPanel addQuestion(QuestionType pQuestion) {
		JPanel questionContainer = new JPanel();
		questionContainer.setLayout(new GridLayout(pQuestion.getAnswers().getAnswerArray().length+1, 1));

		Label questionText = new Label(pQuestion.getLabel());
		questionContainer.add(questionText);
		
		addAnswers(pQuestion.getAnswers(), questionContainer);

		return questionContainer;
	}

	private void addAnswers(AnswersType pAnswers, JPanel questionContainer) {
		for (int i = 0; i< pAnswers.getAnswerArray().length; i++){
			String answer =  pAnswers.getAnswerArray()[i].getLabel();
			Label answerText = new Label(answer);
			questionContainer.add(answerText);
		}
	}

	private JPanel generateQuestionArea() {
		JPanel questionArea = new JPanel();
		// Preferred height is irrelevant, since using WEST region
		
		questionArea.setPreferredSize(new Dimension(globalHeight,globalWidth));
		questionArea.setBorder(BorderFactory.createLineBorder (Color.blue, 2));
		questionArea.setBackground(Color.white);
		return questionArea;
	}
}
