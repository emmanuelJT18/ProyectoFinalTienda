package views.compVisuales;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class ActionButton extends JButton{
	public ActionButton(String actionName) {
		super(actionName);
		
		//setContentAreaFilled(false);
		//setBorder(new EmptyBorder(3,3,3,3));
		setFocusPainted(false);
		//setBorderPainted(false);
	}

}
