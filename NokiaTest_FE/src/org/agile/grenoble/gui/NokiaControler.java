package org.agile.grenoble.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.agile.grenoble.data.AnswersStorage;
import org.agile.grenoble.questions.QuestionsType;
import org.agile.grenoble.user.User;
/*
 * MVC model, the controler will control the gui, and send proper information 
 * to storage mechanism
 * It control also the logic.
 */
public class NokiaControler implements  ActionListener{

	/* constructor */
	public NokiaControler() {
		
	}
	
	//the storage engine 
	AnswersStorage storage = null ;
	
	//the list of questions
	QuestionsType iQuestions = null;

	//	the GUI
	NokiaSwing iNokiaSwing = null;
	
	User currentUser = null ; 
	//the current question (will allow future back button too)
	int currentQuestionIndex = -1 ;
	
	/* set the storage engine on the controler */
	public void setStorage(AnswersStorage pStorage) {
		storage = pStorage;
	}
	
	/* set the  questions list, on the controller*/
	public void setQuestions(QuestionsType qt) {
		iQuestions = qt ; 
	}
	
	/* Set the GUI to the Controller */
	public void setNokiaSwing(NokiaSwing ns ) {
		iNokiaSwing = ns ; 
	}
	
	/* start the survey */
	public void startQuestions(User pUser ) {
		currentQuestionIndex = 0 ;
		currentUser = pUser ;
		iNokiaSwing.displayFirstquestion();
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
//	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (currentQuestionIndex < iQuestions.sizeOfQuestionArray()  ) {
			currentQuestionIndex++;
			boolean isLast = ( currentQuestionIndex == iQuestions.sizeOfQuestionArray()-1); 
			iNokiaSwing.nextQuestion(currentQuestionIndex,isLast);
		} else {
			iNokiaSwing.terminateTest();
			try {
				storage.storeAnswers(iQuestions, currentUser.getId());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void startHomePage() {
		HomePage hp = new HomePage();
		hp.display();
	}

	public User startUserRegistration() {
		UserRegistration ur = new UserRegistration(storage);
		User user = ur.getUser();
		while (user == null ) {
			user = ur.getUser();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return user; 
	}
	

}
