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
public class Screen implements ItemListener {
	
	public static int MAXCHAR = 10;
	private static String URLstring = "";
	JPanel myCards;
	final static String READER = "Card where words are displayed";
	final static String TYPER = "Where you type in you URL";
	public static JTextField inputText;
	public static JTextArea textArea;
	public static JFrame frame;
	
	public void createCards(Container pane) throws IOException{
		JPanel deck = new JPanel();
		inputText = new JTextField();
		inputText.setFont(new Font("Serif", Font.ITALIC, 16));
		inputText.setColumns(20);
		deck.add(inputText);
        
        JButton enter = new JButton("enter");
        SubmitButtonActionListener v = new SubmitButtonActionListener(); 
        enter.addActionListener(v);
        deck.add(enter);
		
		
		//create my cards
		JPanel cardType = new JPanel();
		
        
        JPanel cardRead = new JPanel();
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
      		//textArea.setBounds(0, 50, 600, 300);
      		cardRead.add(areaScrollPane);
      		//cardRead.setBounds(0, 50, 600, 300);
      		
      		//create main pane
      		myCards = new JPanel(new CardLayout());
      		myCards.add(cardType, TYPER);
      		myCards.add(cardRead, READER);
      		
      		pane.add(deck, BorderLayout.PAGE_START);
      		pane.add(myCards, BorderLayout.CENTER);
      	}
	public void itemStateChanged(ItemEvent evt){
		CardLayout clo = (CardLayout)(myCards.getLayout());
		clo.show(myCards, (String)evt.getItem());
	}
		
	
	public static void main(String[] args) throws Exception {
		try{
		UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		}
		catch(UnsupportedLookAndFeelException e){
			e.printStackTrace();
		}
		catch (IllegalAccessException ex) {            
			ex.printStackTrace();       
	 	} 
		catch (InstantiationException ex) {           
	 		ex.printStackTrace();      
	 	} 
		catch (ClassNotFoundException ex) {           
	 		ex.printStackTrace();      
		}
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() { public void run(){ try {
			setUp();
		} catch (IOException e) {
			
			e.printStackTrace();
		} } });
		 
    }
	public static void setUp() throws IOException{
		frame = new JFrame("LeaderBoard");
		//frame.setBounds(50, 50, 600, 400);       
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Screen scr = new Screen();
		scr.createCards(frame.getContentPane());
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
	public static void setURL(String url)throws IOException{
		URLstring = url;
		
	}
}
