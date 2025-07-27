package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginWindow extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LoginWindow dialog = new LoginWindow();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public LoginWindow() {
		setTitle("iniciar seccion");
		setResizable(false);
		setBounds(100, 100, 475, 448);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.BLUE);
		contentPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, Color.CYAN));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.BLUE, null, null, null));
			panel.setBounds(12, 13, 445, 343);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("Nombre de usuario");
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblNewLabel.setBounds(12, 62, 201, 16);
				panel.add(lblNewLabel);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("contrase\u00F1a");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblNewLabel_1.setBounds(12, 144, 201, 16);
				panel.add(lblNewLabel_1);
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(Color.WHITE);
				panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
				panel_1.setBounds(225, 62, 194, 25);
				panel.add(panel_1);
			}
			{
				passwordField = new JPasswordField();
				passwordField.setToolTipText("");
				passwordField.setBackground(new Color(255, 255, 255));
				passwordField.setBounds(225, 144, 194, 22);
				panel.add(passwordField);
			}
			
			JLabel lblNewLabel_2 = new JLabel("login");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 19));
			lblNewLabel_2.setBounds(192, 13, 56, 25);
			panel.add(lblNewLabel_2);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("iniciar seccion");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//@ TODO: Incertar en la base de datos una tabla para cuentas de usuario
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
