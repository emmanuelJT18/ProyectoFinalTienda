package views.compVisuales;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.Componente;
import logic.MicroProcesador;
import logic.Tienda;
import logic.Utilidad;
import views.PComponenteView;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;

public class DGCrearComp extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtId;
	private JTextField txtNumeroSerie;
	private JTextField txtMarca;
	private JTextField txtModelo;
	private JTextField txtPrecio;
	private JTextField txtCantidadDisponible;
	private JLabel lblCompPicture;
	private Tienda controller;
	private PComponenteView componenteView;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DGCrearComp dialog = new DGCrearComp(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DGCrearComp(PComponenteView componenteView) {
		this.componenteView = componenteView;
		setBounds(100, 100, 758, 441);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel pCenterPanel = new JPanel();
			pCenterPanel.setLayout(null);
			contentPanel.add(pCenterPanel);
			{
				JLabel label = new JLabel("ID del Componente");
				label.setBounds(12, 16, 109, 16);
				pCenterPanel.add(label);
			}
			{
				txtId = new JTextField();
				txtId.setColumns(10);
				txtId.setBounds(130, 13, 138, 22);
				pCenterPanel.add(txtId);
			}
			{
				txtNumeroSerie = new JTextField();
				txtNumeroSerie.setColumns(10);
				txtNumeroSerie.setBounds(121, 53, 147, 22);
				pCenterPanel.add(txtNumeroSerie);
			}
			{
				JLabel label = new JLabel("Numero de Serie");
				label.setBounds(12, 56, 109, 16);
				pCenterPanel.add(label);
			}
			{
				txtMarca = new JTextField();
				txtMarca.setColumns(10);
				txtMarca.setBounds(68, 160, 200, 22);
				pCenterPanel.add(txtMarca);
			}
			{
				JLabel label = new JLabel("Marca");
				label.setBounds(12, 163, 109, 16);
				pCenterPanel.add(label);
			}
			{
				JLabel label = new JLabel("Modelo");
				label.setBounds(12, 123, 109, 16);
				pCenterPanel.add(label);
			}
			{
				txtModelo = new JTextField();
				txtModelo.setColumns(10);
				txtModelo.setBounds(68, 120, 200, 22);
				pCenterPanel.add(txtModelo);
			}
			{
				JLabel label = new JLabel("Precio");
				label.setBounds(12, 91, 109, 16);
				pCenterPanel.add(label);
			}
			{
				txtPrecio = new JTextField();
				txtPrecio.setColumns(10);
				txtPrecio.setBounds(83, 88, 185, 22);
				pCenterPanel.add(txtPrecio);
			}
			{
				JLabel label = new JLabel("Cant. Disponible");
				label.setBounds(12, 198, 109, 16);
				pCenterPanel.add(label);
			}
			{
				txtCantidadDisponible = new JTextField();
				txtCantidadDisponible.setColumns(10);
				txtCantidadDisponible.setBounds(127, 195, 141, 22);
				pCenterPanel.add(txtCantidadDisponible);
			}
			{
				lblCompPicture = new JLabel("");
				lblCompPicture.setBounds(362, 16, 356, 299);
				Utilidad.fitImageInsideLabel("img/compImage.jpg", lblCompPicture);
				pCenterPanel.add(lblCompPicture);
			}
		}
		
		JPanel pNorthPanel = new JPanel();
		contentPanel.add(pNorthPanel, BorderLayout.NORTH);
		
		JLabel label = new JLabel("Crear Componente");
		label.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		pNorthPanel.add(label);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnSave = new JButton("Guardar Componente");
				btnSave.setActionCommand("OK");
				buttonPane.add(btnSave);
				getRootPane().setDefaultButton(btnSave);
			}
			{
				JButton btnCancel = new JButton("Cancelar");
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
		}
	}
	
	private void newMicroProcesador() {
		try {
			
			String id = txtId.getText();                      
			String numeroSerie = txtNumeroSerie.getText();                 
			String marca = txtMarca.getText();                       
			String modelo = txtModelo.getText();                      
			Double precio = Double.parseDouble(txtPrecio.getText());                      
			int cantDisponible = Integer.parseInt(txtCantidadDisponible.getText());          
			
			//Componente nuevoComponente = new Componente(id, numeroSerie, marca, modelo, precio, cantDisponible);
			controller.addComponente(null);
			
			String test = controller.getComponentes().get(0).getCodigo();
			JOptionPane.showConfirmDialog(null, "Se guardo bien: " + test);
			componenteView.updateTable();//Refreshes the table
		}catch(Exception ex) {
			JOptionPane.showConfirmDialog(null, "Description: " + ex);
		}
	}

}
