package views;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class PInicioView extends JPanel {

	/**
	 * Create the panel.
	 */
	public PInicioView() {
		this.setPreferredSize(new Dimension(1100,800));
		setLayout(null);
		
		JLabel lblInicio = new JLabel("INICIO");
		lblInicio.setBounds(449, 253, 55, 16);
		add(lblInicio);

	}

}
