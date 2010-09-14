package org.agile.grenoble.gui;

import javax.swing.*;

import org.agile.grenoble.data.Answers;
import org.agile.grenoble.data.Question;

import java.awt.*;


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

	public void addQuestions(Question[] pQuestions) {		
		JPanel questionArea = generateQuestionArea();
		
		JPanel questionPanel = null;
		for (int i=0; i < pQuestions.length; i++) {
			questionPanel = addQuestion(pQuestions[i]);
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
		
	private JPanel addQuestion(Question pQuestion) {
		JPanel questionContainer = new JPanel();
		questionContainer.setLayout(new GridLayout(pQuestion.getAnswers().getTexts().length+1, 1));

		Label questionText = new Label(pQuestion.getQuestionText());
		questionContainer.add(questionText);
		
		addAnswers(pQuestion, questionContainer);

		return questionContainer;
	}

	private void addAnswers(Question pQuestion, JPanel questionContainer) {
		for (int i = 0; i< pQuestion.getAnswers().getTexts().length; i++){
			String answer =  pQuestion.getAnswers().getTexts()[i];
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
