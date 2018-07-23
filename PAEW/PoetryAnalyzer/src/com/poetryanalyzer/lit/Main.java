//Main Class of Poetry Analyzer
//GUI and Central Control
//by: Alexander Dyall, Alex Gitteau, & Sidney Von Arx


package com.poetryanalyzer.lit;

import javax.swing.JFrame;

public class Main {

	JFrame window = new JFrame("Poetry Analyzer");
	
	public Main() {
		window.setLocation(50, 50);
		window.setSize(500, 500);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Main();
	}

}
