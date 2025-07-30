package views;

import java.awt.Dimension;

import javax.swing.JPanel;

import logic.Utilidad;

import javax.swing.JLabel;

public class PInicioView extends JPanel {

	/**
	 * Create the panel.
	 */
	public PInicioView() {
		this.setPreferredSize(new Dimension(1100,800));
		setLayout(null);
		
		JLabel lblInicio = new JLabel("INICIO");
		lblInicio.setBounds(169, 151, 728, 620);
		Utilidad.fitImageInsideLabel("img/bienvenido.jpg", lblInicio);
		add(lblInicio);
		
		JLabel lblBienvenidoTitle = new JLabel("New label");
		lblBienvenidoTitle.setBounds(169, 42, 728, 92);
		Utilidad.fitImageInsideLabel("img/bienvenidoText.png", lblBienvenidoTitle);
		add(lblBienvenidoTitle);

	}
}
