package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connection.ClienteDAO;
import logic.Cliente;
import logic.Tienda;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DGVerCliente extends JDialog {
	private int fontSize = 15;
	private PClienteView clienteView; 
	private final JPanel contentPanel = new JPanel();
	private JTextField txtId;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private Tienda controller;
	private Cliente cliente;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		try {
			DGVerCliente dialog = new DGVerCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public DGVerCliente(PClienteView clienteView, Cliente cliente) {
		this.clienteView = clienteView;
		this.cliente = cliente;
		controller = Tienda.getInstance();
		setBounds(100, 100, 718, 417);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel pCenterPanel = new JPanel();
			contentPanel.add(pCenterPanel, BorderLayout.CENTER);
			pCenterPanel.setLayout(null);
			
			JLabel lblNombre = new JLabel("Nombre");
			lblNombre.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNombre.setBounds(12, 118, 91, 16);
			pCenterPanel.add(lblNombre);
			{
				JLabel lblTelefono = new JLabel("Tel\u00E9fono");
				lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblTelefono.setBounds(12, 157, 91, 16);
				pCenterPanel.add(lblTelefono);
			}
			{
				JLabel lblDireccion = new JLabel("Direcci\u00F3n");
				lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblDireccion.setBounds(12, 196, 91, 16);
				pCenterPanel.add(lblDireccion);
			}
			{
				JLabel lblIdea = new JLabel("Id Cliente");
				lblIdea.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblIdea.setBounds(12, 76, 91, 16);
				pCenterPanel.add(lblIdea);
			}
			
			txtId = new JTextField();
			txtId.setBounds(91, 74, 116, 22);
			pCenterPanel.add(txtId);
			txtId.setColumns(10);
			
			txtNombre = new JTextField();
			txtNombre.setColumns(10);
			txtNombre.setBounds(79, 116, 245, 22);
			pCenterPanel.add(txtNombre);
			
			txtTelefono = new JTextField();
			txtTelefono.setColumns(10);
			txtTelefono.setBounds(89, 155, 235, 22);
			pCenterPanel.add(txtTelefono);
			
			txtDireccion = new JTextField();
			txtDireccion.setColumns(10);
			txtDireccion.setBounds(99, 194, 225, 22);
			pCenterPanel.add(txtDireccion);
			
			JLabel lblClienteIcon = new JLabel("Icon");
			lblClienteIcon.setBounds(364, 13, 314, 269);
			pCenterPanel.add(lblClienteIcon);
		}
		
		JPanel pNorthPanel = new JPanel();
		contentPanel.add(pNorthPanel, BorderLayout.NORTH);
		
		JLabel lblTitle = new JLabel("Crear Cliente");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitle.setHorizontalAlignment(SwingConstants.TRAILING);
		pNorthPanel.add(lblTitle);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnGuardar = new JButton("Guardar");
				btnGuardar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						updateCliente();
					}
				});
				btnGuardar.setActionCommand("OK");
				buttonPane.add(btnGuardar);
				getRootPane().setDefaultButton(btnGuardar);
			}
			{
				JButton btnCancel = new JButton("Cancelar");
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
		}
		loadData();
	}
	
	private void loadData() {
		txtId.setText(cliente.getCodigo());
		txtNombre.setText(cliente.getNombre());
		txtDireccion.setText(cliente.getDireccion());
		txtTelefono.setText(cliente.getTelefono());
	}
	
	private void updateCliente() {
		try {
			String nombre = txtNombre.getText();
			String telefono = txtTelefono.getText();
			String direccion = txtDireccion.getText();
			
			cliente.setNombre(nombre);
			cliente.setTelefono(telefono);
			cliente.setDireccion(direccion);
			
			//String test = controller.getClientes().get(controller.getClientes().size()-1).getId();
			ClienteDAO.updateCliente(cliente);
			clienteView.updateTable();
			JOptionPane.showConfirmDialog(null, "El cliente se ha editado correctamente.");
		}catch(Exception ex) {
			JOptionPane.showConfirmDialog(null, ex.getStackTrace());
		}
	}
}
