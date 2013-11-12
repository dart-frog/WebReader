import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Screen {

	public static int MAXCHAR = 10;
	public static URL z = null; 
	private static String URLstring = "";
	JPanel contentPane;
	final static String READER = "Card where words are displayed";
	final static String TYPER = "Where you type in you URL";
	private JTextField inputTextField;
	private JTextArea wordFrequencyTextArea;
	private static JFrame frame;
	/**
	 * creates a input box and a enter button
	 * @throws IOException
	 */
	public void createCards() throws IOException {
		JPanel inputPanel = new JPanel();
		inputTextField = new JTextField();
		inputTextField.setFont(new Font("Serif", Font.ITALIC, 16));
		inputTextField.setColumns(20);
		inputPanel.add(inputTextField);

		JButton enter = new JButton("enter");
		SubmitButtonActionListener v = new SubmitButtonActionListener(this.inputTextField, this);
		enter.addActionListener(v);
		inputPanel.add(enter);

		
		contentPane = new JPanel();
		contentPane.setLayout(new GridLayout(0, 1));
		contentPane.add(inputPanel);
		//contentPane.add(myCards);
		
		
		try{
		}
		catch(Exception e){
			createErrorLabel(e.getMessage());
		}

		// create main pane
		
		
		frame.setContentPane(contentPane);
	}

	public static void main(String[] args) throws Exception {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		} catch (IllegalAccessException ex) {
			ex.printStackTrace();
		} catch (InstantiationException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					setUp();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		});

	}
	/**
	 * creates the frame and the components
	 * @throws IOException
	 */
	public static void setUp() throws IOException {
		frame = new JFrame("LeaderBoard");
		// frame.setBounds(50, 50, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Screen scr = new Screen();
		scr.createCards();
		frame.pack();
		frame.setVisible(true);
	}

	
	/**
	 * takes a string and updates the global url
	 * @param url the url in string form
	 * @throws MalformedURLException
	 */
	public static void setURL(String url) throws MalformedURLException {	
		URLstring = url;
		z = new URL(URLstring);
			
	}
	/**
	 * creates a new buffer reader 
	 * @return buffer reafer
	 * @throws IOException
	 */
	public static BufferedReader buff() throws IOException{
		BufferedReader in;
		in = new BufferedReader(new InputStreamReader(z.openStream()));
		return in;
	}
	/**
	 * turns a url 
	 * @param b
	 * @return
	 * @throws IOException
	 */
	public static String parse(BufferedReader b) throws IOException{
		String htmlLine;
		StringBuilder massive = new StringBuilder();
		while ((htmlLine = b.readLine()) != null) {
			massive.append(htmlLine);
		}
		b.close();

		String massiveString = massive.toString();
		MyHashMap w = new MyHashMap(MAXCHAR);
		ArrayList<String> fixedText = new ArrayList<String>();
		fixedText = (ArrayList<String>) Splitter.split(massiveString);
		w = WordCounter.reader(fixedText, w);
		ArrayList<KeyValuePairs> x = new ArrayList() ;
		for(int i = 0; i < w.getKeys().size(); i++){
			String key = w.getKeys().get(i);
			String value = Integer.toString(key.length());
			KeyValuePairs kvp = new KeyValuePairs(key,value);
			x.add(kvp);
		}
		
		//known
		x= (ArrayList<KeyValuePairs>) BubbleSort.sort(x);
		
		
		StringBuilder resort = new StringBuilder();
		for (int i = 0; i < x.size(); i++){
			String myWord;
			String myValue;
			myWord = x.get(i).getKey();
			myValue = w.get(myWord);
			resort.append((myWord) + " " + myValue + "\n");
		}
		
		
		
		
		String finalSort = resort.toString();
		return finalSort;

	}
	/** 
	 * creates an error label
	 * @param the error message you would like to display
	 */
	public void createErrorLabel(String e){
		JLabel x = new JLabel(e);
		contentPane.add(x);
	}
	/**
	 * Displays the text box with the counted words
	 */
	public void action() {
		String finalSort = null;
		try {
			finalSort = parse(buff());
		} catch (IOException e) {
			String q = e.getMessage();
			createErrorLabel(q);
			
		}
		contentPane = new JPanel();
		wordFrequencyTextArea = new JTextArea(finalSort);
		wordFrequencyTextArea.setFont(new Font("Serif", Font.ITALIC, 16));
		wordFrequencyTextArea.setLineWrap(true);
		wordFrequencyTextArea.setWrapStyleWord(true);
		JScrollPane textAreaScrollPane = new JScrollPane(wordFrequencyTextArea);
		textAreaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		textAreaScrollPane.setPreferredSize(new Dimension(400, 600));
		
		try {
			createCards();
		} catch (IOException e) {
			e.printStackTrace();
		}
		contentPane.add(textAreaScrollPane);
		frame.setContentPane(contentPane);
		frame.pack();
	}
}
