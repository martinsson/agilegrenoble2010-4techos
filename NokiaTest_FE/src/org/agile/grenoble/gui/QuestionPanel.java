package org.agile.grenoble.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class QuestionPanel extends JPanel{

	private String scoreResult;
	
	public String getScoreResult() {
		return this.scoreResult;
	}
	public QuestionPanel() {
		this.scoreResult = "NokiaTest result is 10";
	
	}
	
//	public QuestionPanel() {
//		JPanel scorePanel = new JPanel();
//		scorePanel.setLayout(new GridLayout(1, 2));
//		
//		Font font = new Font("sansserif", Font.BOLD, 16);
//		
//		JPanel responsePanel = new JPanel();
//		responsePanel.setLayout(new GridLayout());
//		
//		responsePanel.setBackground(Color.blue);
//		responsePanel.setForeground(Color.yellow);
//		responsePanel.setBackground(Color.blue);
//		responsePanel.setFont(font);
//		responsePanel.add(new JTextField("HELLOOOOOOOOOOOO"));
//		
//		scorePanel.add(responsePanel);
//	}

}
