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
	private static String URLstring = "";
	public static JPanel p, p2;
	public static JTextField inputText;
	public static JTextArea textArea;
	public static JFrame frame;
	public static void main(String[] args) throws Exception {
        setUp();
    }
	public static void setUp(){
		frame = new JFrame("TopLevelDemo");frame.setBounds(50, 50, 600, 400);       
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p = new JPanel();
		p.setBounds(0, 0, 600, 50);
		p2 = new JPanel();
		p2.setBounds(0, 50, 300, 300);
		setUpP();
		frame.add(p);
		frame.add(p2);     
		frame.setVisible(true);
	}
	public static void setUpP(){
		inputText = new JTextField();
		inputText.setFont(new Font("Serif", Font.ITALIC, 16));
		inputText.setColumns(20);//setBounds(0, 0, 200, 50);
		p.add(inputText);
        
        JButton enter = new JButton("enter");
        SubmitButtonActionListener v = new SubmitButtonActionListener(); 
        enter.addActionListener(v);
        p.add(enter);
	}
	public static void setUpP2() throws IOException {
		//get a website 
		URL z = null;
		try {
			z = new URL(URLstring);
		} catch (MalformedURLException e) {
			return;
		}
        BufferedReader in = new BufferedReader(
        new InputStreamReader(z.openStream()));

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
	    
	    textArea = new JTextArea(finalSort); 	
	    textArea.setFont(new Font("Serif", Font.ITALIC, 16));
	    textArea.setLineWrap(true);
	    textArea.setWrapStyleWord(true);
	    JScrollPane areaScrollPane = new JScrollPane(textArea);
	    areaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);   
	    areaScrollPane.setPreferredSize(new Dimension(400, 600));
		textArea.setBounds(0, 50, 600, 300);
		p2.add(BorderLayout.NORTH, areaScrollPane);
		p2.setBounds(0, 50, 600, 300);
	}
	public static String format(String rough){
		rough = rough.replace(" ","");
		rough = rough.replace("\"", "");
		rough = rough.replace("(", "");
		rough = rough.replace(")", "");
		return rough;
	}
	public static void setURL(String url)throws MalformedURLException{
		URLstring = url;
		try {
			setUpP2();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
