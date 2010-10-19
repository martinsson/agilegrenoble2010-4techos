package org.agile.grenoble.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

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
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Failed to wait some time ") ;
		} 
		dispose();
	}
	
	private JPanel createHomePage() {
		JPanel hp = new JPanel();
		
		hp.setLayout(new GridBagLayout());
		JLabel title = new JLabel("Nokia Tests, Agile for techos");
		Font font = new Font("sansserif", Font.BOLD, 32);
		title.setFont(font);
		JLabel logoAgilent = Utils.getImage(Configuration.getString("NokiaTest.agilentLogo"));
		JLabel logoKelkoo = Utils.getImage(Configuration.getString("NokiaTest.kelkooLogo"));
		JLabel logoFT = Utils.getImage(Configuration.getString("NokiaTest.FTLogo"));
		JLabel logoThales = Utils.getImage(Configuration.getString("NokiaTest.thalesLogo"));
		  
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;

		hp.add(title, c);

		//hp.add(title);
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		
		hp.add( logoAgilent,c ) ;
		c.gridx = 1;
		hp.add(logoKelkoo,c);
		c.gridx = 0;
		c.gridy = 2;
		hp.add(logoFT,c);
		c.gridx = 1;
		hp.add(logoThales,c);
		return hp; 
	}

}
