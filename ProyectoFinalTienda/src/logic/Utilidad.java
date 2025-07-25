package logic;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Utilidad {
	public static final int witdhForParentPanelView = 1100;
	public static final int heightForParentPanelView = 800;
	
	public static final int witdhForChildPanelView = 1100;
	public static final int heightForChildPanelView = 740;
	public static final int xlocationForChildPanelView = 0;
	public static final int ylocationForChildPanelView = 60;
	
	public static void fitImageInsideLabel(String route, JLabel label) {
		//Make sure to assign a width and hight to the label before using
		//this method otherwise the image wont be resized properly
		ImageIcon originalImg = new ImageIcon(route);
		Image resizedImg = originalImg.getImage().getScaledInstance(
				label.getWidth(), 
				label.getHeight(), 
				Image.SCALE_SMOOTH
		);
		label.setIcon(new ImageIcon(resizedImg));
	}
	public static void showMyPanel(JPanel parentPanel, JPanel childPanel) {	
		try {
			childPanel.setSize(parentPanel.getWidth(),parentPanel.getHeight());
			childPanel.setLocation(parentPanel.getLocationOnScreen());
			
			parentPanel.removeAll();
			parentPanel.add(childPanel);
			parentPanel.revalidate();
			parentPanel.repaint();
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, "Error description: "+e.getStackTrace());
		}
	}
}
