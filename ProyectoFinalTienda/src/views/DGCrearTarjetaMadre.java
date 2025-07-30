package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import connection.ComponenteDAO;
import logic.MicroProcesador;
import logic.TarjetaMadre;
import logic.Tienda;
import logic.Utilidad;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DGCrearTarjetaMadre extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtId;
	private JTextField txtNumeroSerie;
	private JTextField txtMarca;
	private JTextField txtModelo;
	private JTextField txtPrecio;
	private JTextField txtCantidadDisponible;
	private JLabel lblCompPicture;
	private Tienda controller = Tienda.getInstance();
	private PComponenteView componenteView;
	private JTextField txtTipoConexion;
	private JTextField txtTipoMemoriaRAM;
	private int fontSize = 15;
	private JTextArea txtAconxionesDiscosDuros;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DGCrearTarjetaMadre dialog = new DGCrearTarjetaMadre(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DGCrearTarjetaMadre(PComponenteView componenteView) {
		this.componenteView = componenteView;

		setBounds(100, 100, 851, 516);
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
				label.setFont(new Font("Tahoma", Font.BOLD, fontSize));
				label.setBounds(12, 16, 151, 16);
				pCenterPanel.add(label);
			}
			{
				txtId = new JTextField();
				txtId.setEditable(false);
				txtId.setText(controller.genCodigoComponente(new TarjetaMadre()));
				txtId.setColumns(10);
				txtId.setBounds(160, 14, 218, 22);
				pCenterPanel.add(txtId);
			}
			{
				txtNumeroSerie = new JTextField();
				txtNumeroSerie.setColumns(10);
				txtNumeroSerie.setBounds(148, 54, 230, 22);
				pCenterPanel.add(txtNumeroSerie);
			}
			{
				JLabel label = new JLabel("Numero de Serie");
				label.setFont(new Font("Tahoma", Font.BOLD, fontSize));
				label.setBounds(12, 56, 138, 16);
				pCenterPanel.add(label);
			}
			{
				txtMarca = new JTextField();
				txtMarca.setColumns(10);
				txtMarca.setBounds(78, 161, 300, 22);
				pCenterPanel.add(txtMarca);
			}
			{
				JLabel label = new JLabel("Marca");
				label.setFont(new Font("Tahoma", Font.BOLD, fontSize));
				label.setBounds(12, 163, 109, 16);
				pCenterPanel.add(label);
			}
			{
				JLabel label = new JLabel("Modelo");
				label.setFont(new Font("Tahoma", Font.BOLD, fontSize));
				label.setBounds(12, 123, 109, 16);
				pCenterPanel.add(label);
			}
			{
				txtModelo = new JTextField();
				txtModelo.setColumns(10);
				txtModelo.setBounds(78, 120, 300, 22);
				pCenterPanel.add(txtModelo);
			}
			{
				JLabel label = new JLabel("Precio");
				label.setFont(new Font("Tahoma", Font.BOLD, fontSize));
				label.setBounds(12, 91, 109, 16);
				pCenterPanel.add(label);
			}
			{
				txtPrecio = new JTextField();
				txtPrecio.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						char c = e.getKeyChar();
						if(!Character.isDigit(c)) {
							e.consume();
						}
					}
				});
				txtPrecio.setColumns(10);
				txtPrecio.setBounds(83, 88, 295, 22);
				pCenterPanel.add(txtPrecio);
			}
			{
				JLabel label = new JLabel("Cant. Disponible");
				label.setFont(new Font("Tahoma", Font.BOLD, fontSize));
				label.setBounds(12, 198, 124, 16);
				pCenterPanel.add(label);
			}
			{
				txtCantidadDisponible = new JTextField();
				txtCantidadDisponible.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						char c = e.getKeyChar();
						if(!Character.isDigit(c)) {
							e.consume();
						}
					}
				});
				txtCantidadDisponible.setColumns(10);
				txtCantidadDisponible.setBounds(148, 196, 230, 22);
				pCenterPanel.add(txtCantidadDisponible);
			}
			{
				lblCompPicture = new JLabel("");
				lblCompPicture.setBounds(387, 16, 424, 357);
				Utilidad.fitImageInsideLabel("img/compImage.jpg", lblCompPicture);
				pCenterPanel.add(lblCompPicture);
			}
			{
				JLabel lblTipoDeConexion = new JLabel("Tipo de Conexion");
				lblTipoDeConexion.setFont(new Font("Tahoma", Font.BOLD, fontSize));
				lblTipoDeConexion.setBounds(12, 227, 138, 16);
				pCenterPanel.add(lblTipoDeConexion);
			}
			{
				txtTipoConexion = new JTextField();
				txtTipoConexion.setColumns(10);
				txtTipoConexion.setBounds(148, 225, 230, 22);
				pCenterPanel.add(txtTipoConexion);
			}
			{
				JLabel lblMemoriaRamAceptada = new JLabel("Tipo de RAM compatible");
				lblMemoriaRamAceptada.setFont(new Font("Tahoma", Font.BOLD, fontSize));
				lblMemoriaRamAceptada.setBounds(12, 256, 191, 16);
				pCenterPanel.add(lblMemoriaRamAceptada);
			}
			{
				txtTipoMemoriaRAM = new JTextField();
				txtTipoMemoriaRAM.setColumns(10);
				txtTipoMemoriaRAM.setBounds(199, 254, 179, 22);
				pCenterPanel.add(txtTipoMemoriaRAM);
			}
			{
				JLabel lblConexionesDeDiscos = new JLabel("Conexiones de Discos Duros:");
				lblConexionesDeDiscos.setFont(new Font("Tahoma", Font.BOLD, fontSize));
				lblConexionesDeDiscos.setBounds(12, 286, 223, 16);
				pCenterPanel.add(lblConexionesDeDiscos);
			}
			
			txtAconxionesDiscosDuros = new JTextArea();
			//textArea.setBounds(68, 331, 278, 90);
			txtAconxionesDiscosDuros.setLineWrap(true);
		    JScrollPane scroll = new JScrollPane (txtAconxionesDiscosDuros);
		    scroll.setBounds(12, 311, 366, 62);
		    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		    scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		    
			pCenterPanel.add(scroll);
		}
		
		JPanel pNorthPanel = new JPanel();
		contentPanel.add(pNorthPanel, BorderLayout.NORTH);
		
		JLabel lblNuevaTarjetaMadre = new JLabel("Nueva Tarjeta Madre");
		lblNuevaTarjetaMadre.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		pNorthPanel.add(lblNuevaTarjetaMadre);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnSave = new JButton("Guardar Componente");
				btnSave.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						newTarjetaMadre();
					}
				});
				btnSave.setActionCommand("OK");
				buttonPane.add(btnSave);
				getRootPane().setDefaultButton(btnSave);
			}
			{
				JButton btnCancel = new JButton("Cancelar");
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
		}
	}
	
	private void newTarjetaMadre() {
		try {
			
			String codigo = txtId.getText();                      
			String numeroSerie = txtNumeroSerie.getText();                 
			String marca = txtMarca.getText();                       
			String modelo = txtModelo.getText();                      
			Double precio = Double.parseDouble(txtPrecio.getText());                      
			int cantDisponible = Integer.parseInt(txtCantidadDisponible.getText()); 
			String tipoConexion = txtTipoConexion.getText();        
			String tipoMemoriaRAM = txtTipoMemoriaRAM.getText();    
			String conxionesDiscosDuros = txtAconxionesDiscosDuros.getText();
			System.out.println(codigo);
			System.out.println(numeroSerie);
			System.out.println(marca);
			System.out.println(modelo);
			System.out.println(precio);
			System.out.println(cantDisponible);
			System.out.println(tipoConexion);
			System.out.println(tipoMemoriaRAM);
			System.out.println(conxionesDiscosDuros);
			
			TarjetaMadre nuevoComponente = new TarjetaMadre(codigo, numeroSerie, marca, modelo, precio, cantDisponible, tipoConexion, tipoMemoriaRAM, conxionesDiscosDuros);
			controller.addComponente(nuevoComponente);
			ComponenteDAO.insertTarjetaMadre(nuevoComponente);
			String test = controller.getComponentes().get(controller.getComponentes().size()-1).getCodigo();
			JOptionPane.showConfirmDialog(null, "Se guardo bien: " + test);
			componenteView.updateTable();//Refreshes the table
		}catch(Exception ex) {
			JOptionPane.showConfirmDialog(null, "Description: " + ex.getStackTrace());
		}
	}
}
