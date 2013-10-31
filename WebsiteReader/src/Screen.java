import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.text.ComponentView;
import javax.swing.text.JTextComponent;
public class Screen {
	
	public static int MAXCHAR = 10;
	
	public static void main(String[] args) throws Exception {

        setUp();
    }
	
	public static void setUp() {
		///get a website 
		
	        BufferedReader in = new BufferedReader(
	        new InputStreamReader(given.openStream()));

	        StringBuilder massive  = new StringBuilder();
	       
	        
	        String htmlLine;
	       
	        while ((htmlLine = in.readLine()) != null){
	            massive.append(htmlLine);
	        }
	        in.close();
	        
	        String massiveString = massive.toString();
	        MyHashMap t = new MyHashMap(MAXCHAR);
	        
	   
	        ArrayList<String> fixedText = new ArrayList<String>();
	        fixedText = (ArrayList<String>) Splitter.split(massiveString);
	        t = WordCounter.reader(fixedText,t);
	        
	        StringBuilder resort = new StringBuilder();
	        
	        ArrayList<String> allList = (ArrayList<String>) t.getKeys();
	        int far = 0;
	        for (int i = 0; i < t.size(); i++){
	        	for (int j = 0; j < t.bucketSize(i); j++){
	        		String myWord;
	        		String myValue;
	        		myWord = format(allList.get(far));
	        		myValue = t.get(myWord);
	        		resort.append(myWord + " " + myValue + "\n");
	        		far++;
	        	}
	        }
	        String finalSort = resort.toString();
	        
	        
	        
	        JTextArea textArea = new JTextArea(finalSort); 	
	        textArea.setFont(new Font("Serif", Font.ITALIC, 16));
	        textArea.setLineWrap(true);
	        textArea.setWrapStyleWord(true);
	        JScrollPane areaScrollPane = new JScrollPane(textArea);
	        areaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);   
	        areaScrollPane.setPreferredSize(new Dimension(400, 600));
	        
	        	
		
		
		
		
		
		JFrame frame = new JFrame("TopLevelDemo");       
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p = new JPanel();
		
		p.add(BorderLayout.NORTH, areaScrollPane);

		
		/*
		ArrayList<String> keys = (ArrayList<String>) t.getKeys();
		int formalSize = 0;
		Box hBox = Box.createHorizontalBox();
		for (int i = 0; i < t.size(); i++){
			JLabel menuLabel = new JLabel("bucket " + (i + 1));
			menuLabel.setBackground(new Color(255, 10, 159));        
			menuLabel.setPreferredSize(new Dimension(120, 60));
			
			Box vBox = Box.createVerticalBox();
			vBox.add(menuLabel);
			
			for (int j = 0; j < t.bucketSize(i); j++){
				String myKey = keys.get(formalSize);
				String myVal = t.get(myKey);
			
			
			
				JLabel yellowLabel = new JLabel(myKey + " " + myVal);       
				yellowLabel.setOpaque(true);       
				yellowLabel.setBackground(new Color(248, 213, 131));        
				yellowLabel.setPreferredSize(new Dimension(120, 60));
			
				formalSize++;
				vBox.add(yellowLabel);
			}
			p.add(BorderLayout.NORTH, vBox);
		}
		//p.add(BorderLayout.EAST,hBox);
		*/
		
		
		frame.add(p);
		frame.pack();       
		frame.setVisible(true);
		

	}
	public static String format(String rough){
		rough = rough.replace(" ","");
		rough = rough.replace("\"", "");
		rough = rough.replace("(", "");
		rough = rough.replace(")", "");
		return rough;
	}
	public static URL getURL(String url)throws MalformedURLException{
		
			URL given = new URL(url);
		
		return given;
	}
}
