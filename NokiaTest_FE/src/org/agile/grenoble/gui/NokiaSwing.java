package org.agile.grenoble.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.BorderFactory;
import javax.swing.JButton;
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

	private void initContent() {
		setTitle("Nokia Test") ;		
	}

	
	JPanel [] iPanel=  null;
	JPanel iNavBar = null ;
	JButton  nextOrTerminate = null ;
	JPanel welcome = null;
	
	//temporary 
	public void generateQuestionDisplay(QuestionsType pQuestions) {		
		//JPanel questionArea = new JPanel();
		iPanel=  generateQuestionsPanels(pQuestions);

		//TODO add logo and welcome message 
		welcome = HomePage(); 
		getContentPane().add(welcome);
		
		getContentPane().setBackground(Color.lightGray);
		iNavBar = generateNavigationBar();

		pack();
		repaint();
	}
	
	private JPanel HomePage() {
		JPanel hp = new JPanel();
		JButton logoAgilent = new JButton("Agilent") ;
		JButton logoKelkoo = new JButton("Kelkoo") ;
		JButton logoFT = new JButton("FT") ;
		hp.add(logoAgilent);
		hp.add(logoKelkoo);
		hp.add(logoFT);
		return hp; 
	}
	
	/* 
	 * Navigation Bar (may be a standalone class soon )
	 * */
	
	public JPanel generateNavigationBar() {
		JPanel navigationBar = new JPanel();
		nextOrTerminate = new JButton("NextorTerminate");
		navigationBar.add(nextOrTerminate,BorderLayout.EAST);
		return navigationBar ;
	}
	
	private JPanel[] generateQuestionsPanels(QuestionsType pQuestions) {		
	   JPanel[] questionsPanels = new JPanel[pQuestions.getQuestionArray().length];
		
		for (int i=0; i < pQuestions.getQuestionArray().length; i++) {
			questionsPanels[i] = generateQuestionPanel(pQuestions.getQuestionArray()[i]);

		}
		return questionsPanels;
	}
		
	
	/** 
	 * We return a panel per question, allowing us to display several panel in the same page
	 * or one panel per page ... 
	 * May be the change is the "Next " button inside the panel or outside it 
	 * */ 
	private JPanel generateQuestionPanel(QuestionType pQuestion) {
		JPanel questionContainer = generateQuestionArea();
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

	@SuppressWarnings("deprecation")
	public void DisplayFirstquestion() {
		getContentPane().setBackground(Color.lightGray);
		//TODO remove welcome message
		getContentPane().remove(welcome);
		getContentPane().add(iPanel[0], BorderLayout.NORTH);
		//TODO add i18n
		nextOrTerminate.setLabel("Next");
		getContentPane().add(iNavBar, BorderLayout.SOUTH );
		pack();
		repaint();
		
	}
}
