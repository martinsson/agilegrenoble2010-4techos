package org.agile.grenoble.gui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomePage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JPanel welcome = null;
	public HomePage() {
		welcome = createHomePage(); 
		getContentPane().add(welcome);
		setVisible(true);
		getContentPane().setBackground(Color.lightGray);
		pack();
		repaint();		
	}
	
	public void display() {
		try {
			Thread.currentThread().sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Failed to wait some time ") ;
		} 
		dispose();
	}
	
	private JPanel createHomePage() {
		JPanel hp = new JPanel();
		//TODO make the logo read in a config file
		JLabel logoAgilent = Utils.getImage("E:\\build\\workspace\\NokiaTest_FE\\src\\resources\\images\\agilentlogo-home.gif");
		JLabel logoKelkoo = Utils.getImage("E:\\build\\workspace\\NokiaTest_FE\\src\\resources\\images\\kelkoo.jpg");
		JLabel logoFT = Utils.getImage("E:\\build\\workspace\\NokiaTest_FE\\src\\resources\\images\\orange-labs.jpg");
		  
		hp.add( logoAgilent ) ;
		hp.add(logoKelkoo);
		hp.add(logoFT);
		return hp; 
	}

}
