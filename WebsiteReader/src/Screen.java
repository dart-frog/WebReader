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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Screen implements ItemListener {

	public static int MAXCHAR = 10;
	private static String URLstring = "";
	JPanel myCards;
	final static String READER = "Card where words are displayed";
	final static String TYPER = "Where you type in you URL";
	private JTextField inputTextField;
	private JTextArea wordFrequencyTextArea;
	private static JFrame frame;

	public void createCards() throws IOException {
		JPanel inputPanel = new JPanel();
		inputTextField = new JTextField();
		inputTextField.setFont(new Font("Serif", Font.ITALIC, 16));
		inputTextField.setColumns(20);
		inputPanel.add(inputTextField);

		JButton enter = new JButton("enter");
		SubmitButtonActionListener v = new SubmitButtonActionListener(this.inputTextField);
		enter.addActionListener(v);
		inputPanel.add(enter);

		// create my cards
		//JPanel blankCard = new JPanel();

		//JPanel populatedCard = new JPanel();
		// get a website
		URL z = null;
		try {
			z = new URL(URLstring);
		} catch (MalformedURLException e) {
			return;
		}
		BufferedReader in = new BufferedReader(new InputStreamReader(
				z.openStream()));

		StringBuilder massive = new StringBuilder();

		String htmlLine;

		while ((htmlLine = in.readLine()) != null) {
			massive.append(htmlLine);
		}
		in.close();

		String massiveString = massive.toString();
		MyHashMap t = new MyHashMap(MAXCHAR);

		ArrayList<String> fixedText = new ArrayList<String>();
		fixedText = (ArrayList<String>) Splitter.split(massiveString);
		t = WordCounter.reader(fixedText, t);

		StringBuilder resort = new StringBuilder();

		ArrayList<String> allList = (ArrayList<String>) t.getKeys();
		int far = 0;
		for (int i = 0; i < t.size(); i++) {
			for (int j = 0; j < t.bucketSize(i); j++) {
				String myWord;
				String myValue;
				myWord = format(allList.get(far));
				myValue = t.get(myWord);
				resort.append(myWord + " " + myValue + "\n");
				far++;
			}
		}
		String finalSort = resort.toString();

		wordFrequencyTextArea = new JTextArea(finalSort);
		wordFrequencyTextArea.setFont(new Font("Serif", Font.ITALIC, 16));
		wordFrequencyTextArea.setLineWrap(true);
		wordFrequencyTextArea.setWrapStyleWord(true);
		JScrollPane textAreaScrollPane = new JScrollPane(wordFrequencyTextArea);
		textAreaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		textAreaScrollPane.setPreferredSize(new Dimension(400, 600));
		//populatedCard.add(textAreaScrollPane);

		// create main pane
		myCards = new JPanel(new CardLayout());
		//myCards.add(blankCard, TYPER);
		//myCards.add(populatedCard, READER);
		
		JPanel contentPane = new JPanel();
		contentPane.setLayout(new GridLayout(0, 1));
		contentPane.add(inputPanel);
		//contentPane.add(myCards);
		frame.setContentPane(contentPane);
	}

	public void itemStateChanged(ItemEvent evt) {
		CardLayout clo = (CardLayout) (myCards.getLayout());
		clo.show(myCards, (String) evt.getItem());
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

	public static void setUp() throws IOException {
		frame = new JFrame("LeaderBoard");
		// frame.setBounds(50, 50, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Screen scr = new Screen();
		scr.createCards();
		frame.pack();
		frame.setVisible(true);
	}

	public static String format(String rough) {
		rough = rough.replace(" ", "");
		rough = rough.replace("\"", "");
		rough = rough.replace("(", "");
		rough = rough.replace(")", "");
		return rough;
	}

	public static void setURL(String url) throws IOException {
		URLstring = url;

	}
}
