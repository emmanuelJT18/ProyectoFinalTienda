package views;

import java.awt.Dimension;

import javax.swing.JPanel;

import logic.Utilidad;

public class PComboView extends JPanel {

	/**
	 * Create the panel.
	 */
	public PComboView() {
		setPreferredSize(
				new Dimension(
						Utilidad.witdhForParentPanelView,
						Utilidad.heightForParentPanelView
				)
		);
	}

}
