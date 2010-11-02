package org.agile.grenoble.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.agile.grenoble.data.AnswersStorage;
import org.agile.grenoble.user.User;
import org.agile.grenoble.user.UserFactory;


class myOkButtonListener implements ActionListener {

	
	UserRegistration ur = null; 
	public myOkButtonListener(UserRegistration pUr) {
		ur = pUr ;
	}

//	@Override
	public void actionPerformed(ActionEvent arg0) {
		//select or not select ?
		System.out.println("Clicking on button") ;
			ur.updateData();
			ur.dispose();
	}
}

public class UserRegistration extends JFrame {

	AnswersStorage iStorage = null ;
	String username = null ;
	String usermail = null ; 
	
	public UserRegistration(AnswersStorage storage) {
		iStorage = storage ;
		createDisplay();
		
	}

	private void setEmail(String pMail) {
		usermail = pMail ; 
	}
	
	private void setMyName(String pName) {
		username= pName ;
	}
	
	public void updateData() {
		setMyName(yourname.getText());
		setEmail(youremail.getText());
	}
	
	private JTextField yourname = null ; 
	private JTextField youremail = null; 
	
	private void createDisplay() {
		JPanel jpanel = new JPanel() ;
		getContentPane().add(jpanel);
		jpanel.setLayout(new GridLayout(3,2));
		JLabel name =  new JLabel("NAME : " ); 
		yourname =  new JTextField(30);
		JLabel email = new JLabel("EMAIL:" );
		youremail = new JTextField(30);
		
		JButton okButton = new JButton("OK") ;
		okButton.addActionListener(new myOkButtonListener(this));
		
		jpanel.add(name);jpanel.add(yourname);
		jpanel.add(email);jpanel.add(youremail);
		jpanel.add(okButton);
		jpanel.setSize(300,200);
		
		pack();
		setVisible(true);
	}
	
	public User getUser() {
		User user = null ; 
		if ( username == null || usermail==null ) {
			//do nothing
			System.out.println("User data not yet collected");
		} else {
			user = UserFactory.getUser(username+"_"+System.currentTimeMillis(), usermail,iStorage) ;
		}
		
		return user;
	}
	
}
