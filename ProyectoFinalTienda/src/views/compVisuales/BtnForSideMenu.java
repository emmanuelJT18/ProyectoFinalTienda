package views.compVisuales;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;


public class BtnForSideMenu extends JButton{
	
	private final Color backgroundColor = new Color(29, 58, 110);
	private final Color hoverColor = new Color(112, 146, 190);
	
	public BtnForSideMenu(String nameButton) {
		super(nameButton);
		setFont(new Font("Arial", Font.BOLD, 14));
		setForeground(Color.WHITE);//Esto le da color al texto que tiene el boton
		setBackground(backgroundColor);
		
		//Quita los bordes del boton y da un enfoque plano
		setFocusPainted(false);
		setBorderPainted(false);
		setOpaque(true);
		
		eventos();
	}
	
	private void eventos() {
		addMouseListener(new MouseAdapter() {
			@Override 
			public void mouseEntered(MouseEvent e) {
				setBackground(hoverColor);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				setBackground(backgroundColor);
			}
		});
	}
}	
