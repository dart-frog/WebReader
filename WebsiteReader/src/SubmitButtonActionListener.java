import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;

import javax.swing.JTextArea;
import javax.swing.JTextField;


public class SubmitButtonActionListener implements ActionListener{
	private JTextField jt;
	private Screen scr;
	
	public SubmitButtonActionListener(JTextArea inputText, Screen y){
		jt =inputText;
		scr = y;
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		String x = jt.getText();
		try {
			scr.getURL(x);
		} catch (MalformedURLException e) {
			
		}
	}
}
