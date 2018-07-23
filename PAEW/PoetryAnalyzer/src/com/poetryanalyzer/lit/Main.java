//Main Class of Poetry Analyzer
//GUI and Central Control
//by: Alexander Dyall, Alex Gitteau, & Sidney Von Arx
//23 July 2018

package com.poetryanalyzer.lit;

import java.awt.GridLayout;
import java.awt.Toolkit;
<<<<<<< HEAD
<<<<<<< HEAD
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
=======
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
>>>>>>> 398521806fb6da06b6c58313d5c5588696868bbf
=======
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
>>>>>>> 398521806fb6da06b6c58313d5c5588696868bbf

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
	
	
	ArrayList<String> poetryLines;
	
	
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
		
	}
	
	public static void main(String[] args) {
		new Main();
	}
	
	public void readFile (String filePath) {
		File file = new File (filePath);
		Scanner fileReader = null;
		
		try {
			fileReader = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while (fileReader.hasNextLine()) {
			poetryLines.add(fileReader.nextLine());
		}
		
		fileReader.close();
	}

	public void actionPerformed(ActionEvent arg0) {
		
	}

	public void actionPerformed(ActionEvent arg0) {
		
	}

}
