package org.agile.grenoble.gui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.agile.grenoble.Configuration;
import org.agile.grenoble.Messages;

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

		JLabel logoAgilent = Utils.getImage(Configuration.getString("NokiaTest.agilentLogo"));
		JLabel logoKelkoo = Utils.getImage(Configuration.getString("NokiaTest.kelkooLogo"));
		JLabel logoFT = Utils.getImage(Configuration.getString("NokiaTest.FTLogo"));
		  
		hp.add( logoAgilent ) ;
		hp.add(logoKelkoo);
		hp.add(logoFT);
		return hp; 
	}

}
