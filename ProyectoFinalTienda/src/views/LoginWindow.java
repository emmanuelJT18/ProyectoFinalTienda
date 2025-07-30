package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.security.auth.login.LoginException;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class LoginWindow extends JDialog {

	/**
	 * 
	 */
	
	private final JPanel contentPanel = new JPanel();
	private String username;
    private String password;
    private JTextField txtUser;
    private JTextField txtpasswordField;

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
			
			JLabel lblNewLabel_2 = new JLabel("login");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 19));
			lblNewLabel_2.setBounds(192, 13, 56, 25);
			panel.add(lblNewLabel_2);
			
			txtUser = new JTextField();
			txtUser.setBounds(228, 59, 191, 26);
			panel.add(txtUser);
			txtUser.setColumns(10);
			{
				txtpasswordField = new JTextField();
				txtpasswordField.setBounds(228, 141, 191, 26);
				panel.add(txtpasswordField);
				txtpasswordField.setColumns(10);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnInicioSeccion = new JButton("iniciar seccion");
				btnInicioSeccion.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						login();
					}
				});
				btnInicioSeccion.setActionCommand("OK");
				buttonPane.add(btnInicioSeccion);
				getRootPane().setDefaultButton(btnInicioSeccion);
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
	private void login() {
        try {
            username = txtUser.getText().trim();
            password = txtpasswordField.getText().trim();

            if (username.isEmpty() && password.isEmpty()) {
                throw new LoginException("Usuario y contraseña son obligatorios");
            } else if (username.isEmpty()) {
                throw new LoginException("El usuario es obligatorio");
            } else if (password.isEmpty()) {
                throw new LoginException("La contraseña es obligatoria");
            }
            
            if (!validarCredenciales(username, password)) {
                throw new LoginException("Usuario o contraseña incorrectos");
            }
            
           
            JOptionPane.showMessageDialog(this, 
                "Login exitoso para: " + username, 
                "Éxito", 
                JOptionPane.INFORMATION_MESSAGE);
            
        } catch (LoginException e) {
            JOptionPane.showMessageDialog(this, 
                e.getMessage(), 
                "Error de Login", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

	private boolean validarCredenciales(String username2, String password2) {
		// TODO Auto-generated method stub
		return false;
	}

}
