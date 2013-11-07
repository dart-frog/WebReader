import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.swing.JTextArea;
import javax.swing.JTextField;


public class SubmitButtonActionListener implements ActionListener{
	
	private JTextField inputText;
	private Screen scr;
	
	public SubmitButtonActionListener(JTextField inputText, Screen scr)
	{
		this.inputText = inputText;
		this.scr = scr;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String txt = inputText.getText();
		
		try {
			Screen.setURL(txt);
			scr.action();
		} catch (MalformedURLException e) {
			String x = e.getMessage();
			scr.createErrorLabel(x);
			System.out.println(txt);
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
