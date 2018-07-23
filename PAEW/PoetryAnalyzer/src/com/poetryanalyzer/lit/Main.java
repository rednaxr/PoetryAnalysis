//Main Class of Poetry Analyzer
//GUI and Central Control
//by: Alexander Dyall, Alex Gitteau, & Sidney Von Arx


package com.poetryanalyzer.lit;

import java.awt.Toolkit;

import javax.swing.JFrame;

public class Main {

	JFrame window = new JFrame("Poetry Analyzer");

	public Main() {
		double screenWidth = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double screenHeight = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		window.setLocation((int)Math.round(screenWidth/4), (int)Math.round(screenHeight/4));
		window.setSize(500, 500);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.setLayout(new GridLayout(2, 2));
	}
	
	public static void main(String[] args) {
		new Main();
	}

}
