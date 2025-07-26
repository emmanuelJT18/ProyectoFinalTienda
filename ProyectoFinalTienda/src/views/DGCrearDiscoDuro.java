package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connection.ComponenteDAO;
import logic.Componente;
import logic.DiscoDuro;
import logic.MicroProcesador;
import logic.Tienda;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DGCrearDiscoDuro extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtId;
	private JTextField txtNumeroSerie;
	private JTextField txtMarca;
	private JTextField txtModelo;
	private JTextField txtPrecio;
	private JTextField txtCantidadDisponible;
	private JTextField txtTipoConexion;
	private JTextField txtCantidadMemoria;
	private Tienda controller = Tienda.getInstance();
	private PComponenteView componenteView;
	private int fontSize = 15;
	
	public static void main(String[] args) {
		try {
			DGCrearDiscoDuro dialog = new DGCrearDiscoDuro(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the dialog.
	 */
	public DGCrearDiscoDuro(PComponenteView componenteView) {
		this.componenteView = componenteView;
		setBounds(100, 100, 655, 441);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel pTitlePanel = new JPanel();
		contentPanel.add(pTitlePanel, BorderLayout.NORTH);
		{
			JLabel lblTitle = new JLabel("Disco Duro");
			lblTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
			pTitlePanel.add(lblTitle);
		}
		{
			JPanel pParentContainer = new JPanel();
			contentPanel.add(pParentContainer, BorderLayout.CENTER);
			pParentContainer.setLayout(null);
			{
				JLabel lblIdComponente = new JLabel("ID del Componente");
				lblIdComponente.setFont(new Font("Tahoma", Font.BOLD, fontSize));
				lblIdComponente.setBounds(31, 27, 147, 16);
				pParentContainer.add(lblIdComponente);
			}
			
			txtId = new JTextField();
			txtId.setBounds(177, 25, 163, 22);
			pParentContainer.add(txtId);
			txtId.setColumns(10);
			
			txtNumeroSerie = new JTextField();
			txtNumeroSerie.setColumns(10);
			txtNumeroSerie.setBounds(177, 65, 163, 22);
			pParentContainer.add(txtNumeroSerie);
			
			JLabel lblNumeroSerie = new JLabel("Numero de Serie");
			lblNumeroSerie.setFont(new Font("Tahoma", Font.BOLD, fontSize));
			lblNumeroSerie.setBounds(31, 67, 135, 16);
			pParentContainer.add(lblNumeroSerie);
			
			txtMarca = new JTextField();
			txtMarca.setColumns(10);
			txtMarca.setBounds(97, 207, 281, 22);
			pParentContainer.add(txtMarca);
			
			JLabel lblMarca = new JLabel("Marca");
			lblMarca.setFont(new Font("Tahoma", Font.BOLD, fontSize));
			lblMarca.setBounds(31, 209, 109, 16);
			pParentContainer.add(lblMarca);
			
			JLabel lblModelo = new JLabel("Modelo");
			lblModelo.setFont(new Font("Tahoma", Font.BOLD, fontSize));
			lblModelo.setBounds(31, 169, 109, 16);
			pParentContainer.add(lblModelo);
			
			txtModelo = new JTextField();
			txtModelo.setColumns(10);
			txtModelo.setBounds(112, 167, 228, 22);
			pParentContainer.add(txtModelo);
			
			JLabel lblPrecio = new JLabel("Precio");
			lblPrecio.setFont(new Font("Tahoma", Font.BOLD, fontSize));
			lblPrecio.setBounds(31, 102, 109, 16);
			pParentContainer.add(lblPrecio);
			
			txtPrecio = new JTextField();
			txtPrecio.setColumns(10);
			txtPrecio.setBounds(112, 100, 140, 22);
			pParentContainer.add(txtPrecio);
			
			JLabel lblCantidadDisponible = new JLabel("Cant. Disponible");
			lblCantidadDisponible.setFont(new Font("Tahoma", Font.BOLD, fontSize));
			lblCantidadDisponible.setBounds(31, 137, 135, 16);
			pParentContainer.add(lblCantidadDisponible);
			
			txtCantidadDisponible = new JTextField();
			txtCantidadDisponible.setColumns(10);
			txtCantidadDisponible.setBounds(166, 135, 174, 22);
			pParentContainer.add(txtCantidadDisponible);
			
			JLabel lblTipoConexion = new JLabel("Tipo Conexion");
			lblTipoConexion.setFont(new Font("Tahoma", Font.BOLD, fontSize));
			lblTipoConexion.setBounds(31, 244, 109, 16);
			pParentContainer.add(lblTipoConexion);
			
			txtTipoConexion = new JTextField();
			txtTipoConexion.setColumns(10);
			txtTipoConexion.setBounds(252, 242, 77, 22);
			pParentContainer.add(txtTipoConexion);
			
			JLabel lblCantidadMemoria = new JLabel("Cant. Memoria");
			lblCantidadMemoria.setFont(new Font("Tahoma", Font.BOLD, fontSize));
			lblCantidadMemoria.setBounds(31, 279, 221, 16);
			pParentContainer.add(lblCantidadMemoria);
			
			txtCantidadMemoria = new JTextField();
			txtCantidadMemoria.setColumns(10);
			txtCantidadMemoria.setBounds(252, 277, 77, 22);
			pParentContainer.add(txtCantidadMemoria);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnCreate = new JButton("Crear Componente");
				btnCreate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						newDiscoDuro();
					}
				});
				btnCreate.setActionCommand("OK");
				buttonPane.add(btnCreate);
				getRootPane().setDefaultButton(btnCreate);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}
	
	private void newDiscoDuro() {
		try {
			
			String codigo = txtId.getText();                      
			String numeroSerie = txtNumeroSerie.getText();                 
			String marca = txtMarca.getText();                       
			String modelo = txtModelo.getText();                      
			Double precio = Double.parseDouble(txtPrecio.getText());                      
			int cantDisponible = Integer.parseInt(txtCantidadDisponible.getText());          
			String tipoConexion = txtTipoConexion.getText();                
			String cantMemoria = txtCantidadMemoria.getText();      
			
			DiscoDuro newComponente = new DiscoDuro(codigo, numeroSerie, marca, modelo, precio, cantDisponible, tipoConexion, cantMemoria);
			controller.addComponente(newComponente);
			ComponenteDAO.insertDiscoDuro(newComponente);
			//String test = controller.getComponentes().get(controller.getComponentes().size()-1).getCodigo();
			JOptionPane.showConfirmDialog(null, "Se guardo bien ");
			componenteView.updateTable();//Refreshes the table
		}catch(Exception ex) {
			JOptionPane.showConfirmDialog(null, "Description: " + ex);
		}
	}
}
