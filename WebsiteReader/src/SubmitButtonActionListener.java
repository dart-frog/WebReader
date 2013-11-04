import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.swing.JTextArea;
import javax.swing.JTextField;


public class SubmitButtonActionListener implements ActionListener{
	
	private JTextField inputText;
	
	public SubmitButtonActionListener(JTextField inputText)
	{
		this.inputText = inputText;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String txt = inputText.getText();
		
		try {
			Screen.setURL(txt);
		} catch (MalformedURLException e) {
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
