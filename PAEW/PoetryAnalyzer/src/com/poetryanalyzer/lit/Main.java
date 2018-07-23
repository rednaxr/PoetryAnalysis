//Main Class of Poetry Analyzer
//GUI and Central Control
//by: Alexander Dyall, Alex Gitteau, & Sidney Von Arx
//23 July 2018

package com.poetryanalyzer.lit;

import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Main implements ActionListener {

	JFrame window = new JFrame("Poetry Analyzer");

	JLabel inputLbl = new JLabel("Input: ");
	JLabel outputLbl = new JLabel("Output: ");
	JLabel statusLbl = new JLabel("Status: ");
	JTextField inputTF = new JTextField("");
	JTextField outputTF = new JTextField("");
	JButton runBtn = new JButton("Run");
	
	public Main() {
		//Set up window
		double screenWidth = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double screenHeight = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		window.setLocation((int)Math.round(screenWidth/4), (int)Math.round(screenHeight/4));
		window.setSize(400, 150);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.setLayout(new GridLayout(3, 2));
		
		//Set up graphical components
		window.add(inputLbl);
		inputLbl.setHorizontalAlignment(JLabel.CENTER);
		window.add(inputTF);
		window.add(outputLbl);
		outputLbl.setHorizontalAlignment(JLabel.CENTER);
		window.add(outputTF);
		window.add(statusLbl);
		statusLbl.setHorizontalAlignment(JLabel.CENTER);
		window.add(runBtn);
		runBtn.addActionListener(this);
		
	}
	
	public static void main(String[] args) {
		new Main();
	}

	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource().equals(runBtn)) {
			
		}
	}

	public String readInput(String fileName) {
		String poem = "";
		return poem;
	}
	
	public void writeOutput(String fileName) {
		
	}
	
}
