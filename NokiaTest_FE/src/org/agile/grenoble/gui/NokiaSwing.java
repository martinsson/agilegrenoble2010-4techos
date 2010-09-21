package org.agile.grenoble.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.agile.grenoble.questions.AnswersType;
import org.agile.grenoble.questions.ConfigurationType;
import org.agile.grenoble.questions.QuestionType;
import org.agile.grenoble.questions.QuestionsType;

class myCheckGroup implements ActionListener {
	
	int iMaxSelected = -1 ;
	int iNbCheckedItem = 0 ;
	Vector<JCheckBox> v = new Vector<JCheckBox>();  
	myCheckGroup(int maxSelected) {
		iMaxSelected = maxSelected ; 
	}
	
	
	public void add(JCheckBox aBox) {
	 // super.add(aBox);
	  //register to click event :)
	  aBox.addActionListener(this);
	  v.add(aBox);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//select or not select ? 
		JCheckBox cb = (JCheckBox) arg0.getSource();
		if (cb.isSelected()) {
			iNbCheckedItem++;
			if (iNbCheckedItem > iMaxSelected) {
				for ( Enumeration<JCheckBox> e = v.elements(); e.hasMoreElements(); ) {
					JCheckBox value = e.nextElement();
					if (value == cb) {
						iNbCheckedItem--;
						value.setSelected(false);
						//display each vegetable
						System.out.println( value );
					}
				 }
			} else if (iNbCheckedItem < iMaxSelected) {
				//nothing
			} else {
				//nothing
			}
		} else {
			//unselect 
			iNbCheckedItem--;
		}
		
	}
	
}


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
	public void generateQuestionDisplay(QuestionsType pQuestions) throws Exception {		
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
		//JButton logoAgilent = new JButton("Agilent") ;
		//JButton logoAgilent = new JButton("Agilent");
		JLabel picLabel = getImage();
		hp.add( picLabel ) ;
		  
		JButton logoKelkoo = new JButton("Kelkoo") ;
		JButton logoFT = new JButton("FT") ;
		//hp.add(logoAgilent);
		hp.add(logoKelkoo);
		hp.add(logoFT);
		return hp; 
	}

	private JLabel getImage() {
		BufferedImage myPicture=null;
		try {
			myPicture = ImageIO.read(new File("E:\\build\\workspace\\NokiaTest_FE\\src\\resources\\images\\agilentlogo-home.gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JLabel picLabel = new JLabel(new ImageIcon( myPicture ));
		return picLabel;
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
	
	private JPanel[] generateQuestionsPanels(QuestionsType pQuestions) throws Exception {		
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
	 * @throws Exception 
	 * */ 
	private JPanel generateQuestionPanel(QuestionType pQuestion) throws Exception {
		JPanel questionContainer = generateQuestionArea();
		questionContainer.setLayout(new GridLayout(pQuestion.getAnswers().getAnswerArray().length+1, 1));
		//TODO add question mark image 
		Label questionText = new Label(pQuestion.getLabel());
		questionContainer.add(questionText);
		
		addAnswers(pQuestion.getAnswers(), questionContainer);

		return questionContainer;
	}

	private void addAnswers(AnswersType pAnswers, JPanel questionContainer) throws Exception {
		ConfigurationType conf =pAnswers.getConfiguration() ; 
		if (conf.getType().equals("single")) {
			addRadioAnswers(pAnswers,questionContainer);	
		} else if (conf.getType().equals("multiple")) {
			addCheckAnswers(pAnswers,questionContainer);
		} else if  (conf.getType().equals("complex")) {
			addComplexAnswers(pAnswers,questionContainer);
		} else {
			//ERROR 
			throw new Exception("UNKNOWN question type :" + conf.getType());
		}
	}

	private void addComplexAnswers(AnswersType pAnswers,JPanel questionContainer) {
		// TODO Auto-generated method stub
	}

	
	private void addCheckAnswers(AnswersType pAnswers, JPanel questionContainer) {
		myCheckGroup buttonGroup = new myCheckGroup(pAnswers.getConfiguration().getNumber()) ;
		//ButtonGroup buttonGroup = new ButtonGroup() ;
		//buttonGroup.
		for (int i = 0; i< pAnswers.getAnswerArray().length; i++){
			String answer =  pAnswers.getAnswerArray()[i].getLabel();
			JCheckBox answerText = new JCheckBox(answer);
			questionContainer.add(answerText);
			buttonGroup.add(answerText);
		}
	}

	private void addRadioAnswers(AnswersType pAnswers, JPanel questionContainer) {
		ButtonGroup buttonGroup = new ButtonGroup() ;
		
		for (int i = 0; i< pAnswers.getAnswerArray().length; i++){
			String answer =  pAnswers.getAnswerArray()[i].getLabel();
			JRadioButton answerText = new JRadioButton(answer);
			questionContainer.add(answerText);
			buttonGroup.add(answerText);
		}
		//questionContainer.add(menuItem);
		
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

	public void registerOnClickNavBarEvent(NokiaControler nokiaControler) {
		nextOrTerminate.addActionListener(nokiaControler);
		
	}

	public void nextQuestion(int currentQuestionIndex,boolean isLast) {
		getContentPane().remove(iPanel[currentQuestionIndex-1]);
		getContentPane().add(iPanel[currentQuestionIndex], BorderLayout.NORTH);
		//TODO add i18n
		if (isLast) {
			nextOrTerminate.setLabel("Go Home !!! ");
		} else {
			nextOrTerminate.setLabel("Next");
		}
		//getContentPane().add(iNavBar, BorderLayout.SOUTH );
		pack();
		repaint();
		
	}

	public void TerminateTest() {
		dispose();
		
	}
}
