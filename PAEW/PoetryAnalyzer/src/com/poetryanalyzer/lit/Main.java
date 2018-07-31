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
	ArrayList<String> poemLines;		//Stores lines of poem
	Poem poem;							//Stores poem being analyzed
	ArrayList<String> analysis;			//stores analysis of poem section by section
	long time;							//stores time taken by system to complete analysis
	private static Queries db; 			//the instance of the database
	
	//Graphical Components
	JFrame window = new JFrame("Poetry Analyzer");
	JLabel inputLbl = new JLabel("Input:");
	JLabel outputLbl = new JLabel("Output:");
	JLabel statusLbl = new JLabel("Status: Ready");
	JTextField inputTF = new JTextField("");
	JTextField outputTF = new JTextField("");
	JButton runBtn = new JButton("Run");
	
	public Main() {
		setDb(new Queries());
		//SQL says to add this 
		try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            // handle the error
        }
		
		
		
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
			statusLbl.setText("Status: Working...");									//report Working, start recording times
			time = System.currentTimeMillis();
			poemLines = readFile("Poems/A Brook in the City.txt");//TODO
			
			//poemLines = readFile(inputTF.getText());
			if(poemLines != null) {
				StructuralAnalysis structural = new StructuralAnalysis(poemLines);		//initiate structural analysis of poem
				poem = structural.getPoem();
				time = System.currentTimeMillis() - time;								//record time taken
				
				//TODO: Debug Code - reports rhyme scheme as string[] and prints to a txt file
				String[] output = new String[poem.getLines().length + 1];
				for(int i = 0; i < poem.getLines().length; i++) {
					output[i] = poem.getLines()[i].getText();
					if(poem.getRhymeScheme()[i] > 0) {
						output[i] += "\t" + poem.getRhymeScheme()[i];
					}
				}
				output[output.length - 1] = "Time:  " + time + "ms";
				outputTF.setText("out.txt");
				
				writeFile(outputTF.getText(), output);
				statusLbl.setText("Status: Ready");										//report ready for new inputs
			}
		}
	}
	
	//reads in text from a file
	public ArrayList<String> readFile (String filePath) {
		ArrayList<String> input = new ArrayList<String>();
		Scanner fileReader = null;
		File file = new File(filePath);
		if(file.exists() && !file.isDirectory()) {
			try {
				fileReader = new Scanner(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			while (fileReader.hasNextLine()) {
				input.add(fileReader.nextLine());
			}
			fileReader.close();
		}
		else {
			statusLbl.setText("Error: Invalid Input File");
			input = null;
		}
		return input;
	}
	
	//writes output to a string
	public void writeFile(String filePath, String[] output) {
		PrintWriter printer = null;
		try {
			printer = new PrintWriter(new FileWriter(new File(filePath)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(int i = 0; i < output.length; i++) {
			printer.println(output[i]);
		}
		printer.close();
	}

	public static Queries getDb() {
		return db;
	}

	public static void setDb(Queries db) {
		Main.db = db;
	}
	
}
