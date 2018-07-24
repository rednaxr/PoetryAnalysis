//Main Class of Poetry Analyzer
//GUI and Central Control
//by: Alexander Dyall, Alex Gitteau, & Sydney Von Arx
//23 July 2018

package com.poetryanalyzer.lit;

import java.awt.GridLayout;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Main implements ActionListener {

	
	//Global Variables
	ArrayList<String> poemLines;				//Stores poem line by line
	ArrayList<String> analysis;			//stores analysis of poem section by section
	long time;							//stores time taken by system to complete analysis
	
	//Graphical Components
	JFrame window = new JFrame("Poetry Analyzer");
	JLabel inputLbl = new JLabel("Input:");
	JLabel outputLbl = new JLabel("Output:");
	JLabel statusLbl = new JLabel("Status: Ready");
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
		if(ae.getSource().equals(runBtn)) {											//If run button is pushed
			statusLbl.setText("Working...");										//report Working, start recording times
			time = System.currentTimeMillis();
			poemLines = readFile(inputTF.getText());
			StructuralAnalysis structure = new StructuralAnalysis(poemLines);		//initiate structural analysis of poem
			time = System.currentTimeMillis() - time;								//record time taken
			writeFile(outputTF.getText(), poemLines.get(0));
			statusLbl.setText("Status: Ready");										//report ready for new inputs
		}
	}
	
	//reads in text from a file
	public ArrayList<String> readFile (String filePath) {
		ArrayList<String> input = new ArrayList<String>();
		Scanner fileReader = null;
		File file = new File(filePath);
		if(file.exists() && !file.isDirectory()) {
			try {
				fileReader = new Scanner(new File(filePath));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			while (fileReader.hasNextLine()) {
				input.add(fileReader.nextLine());
			}
			fileReader.close();
		}
		else {
			statusLbl.setText("Status: Error - Invalid Input File");
		}
		return input;
	}
	
	//writes output to a string
	public void writeFile(String filePath, String output) {
		PrintWriter printer = null;
		try {
			printer = new PrintWriter(new FileWriter(new File(filePath)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		printer.write(output);
		printer.close();
	}
	
}
