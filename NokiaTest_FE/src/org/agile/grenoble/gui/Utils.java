package org.agile.grenoble.gui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Utils {

	static protected JLabel getImage(String filename) {
		BufferedImage myPicture = null;
		try {
			//myPicture = ImageIO.read(new File(filename));
			System.out.println("get ressource ("+filename+")=>" + Utils.class.getResource(filename));
			myPicture= ImageIO.read(new File(Utils.class.getResource(filename).getFile() ));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JLabel picLabel = new JLabel(new ImageIcon( myPicture ));
		return picLabel;
	}
	
}
