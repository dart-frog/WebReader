import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;


public class SubmitButtonActionListener implements ActionListener{
	private JTextField jt;
	private Screen scr;
	
	public SubmitButtonActionListener(JTextField x, Screen y){
		jt =x;
		scr = y;
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}
}
