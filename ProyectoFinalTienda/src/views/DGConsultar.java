package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.Utilidad;

public class DGConsultar extends JDialog {

	private final JPanel parentPanel = new JPanel();

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public DGConsultar(JPanel childPanel) {
		setBounds(100, 100, 1358, 889);
		getContentPane().setLayout(new BorderLayout());
		parentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(parentPanel, BorderLayout.CENTER);
		parentPanel.setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		//parentPanel.add(childPanel);
	}
	public JPanel getParentPanel() {
		return this.parentPanel;
	}

}
