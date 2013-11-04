import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;

import javax.swing.JTextArea;
import javax.swing.JTextField;


public class SubmitButtonActionListener implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String txt = Screen.inputText.getText();
		try {
			Screen.setURL(txt);
		} catch (MalformedURLException e) {
			
		}
	}
}
