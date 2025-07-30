/*
 * Nombre: DGVerMicroProcesadores
 * 
 * Autor: Josue Ariel Arias Veras
 * 
 * Proposito: Mostrar todos los datos de la clase hija MicroProcesador
 */

package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connection.ComponenteDAO;
import logic.MicroProcesador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DGVerMicroProcesadores extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtID;
	private JTextField txtNumSerie;
	private JTextField txtPrecio;
	private JTextField txtCantidadDisponible;
	private JTextField txtModelo;
	private JTextField txtMarca;
	private JTextField txtTipoConexion;
	private JTextField txtVelocidadProcesamiento;
	private boolean editarLosValores;
	private MicroProcesador mp;
	private PComponenteView componenteView;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DGVerMicroProcesadores dialog = new DGVerMicroProcesadores(null, null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DGVerMicroProcesadores(MicroProcesador mp, PComponenteView componenteView) {
		this.mp = mp;
		this.editarLosValores = false;
		this.componenteView = componenteView;
		setTitle("Micro Procesador");
		setBounds(100, 100, 450, 484);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("ID del componente");
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblNewLabel.setBounds(12, 37, 135, 16);
				panel.add(lblNewLabel);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Numero de serie");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblNewLabel_1.setBounds(12, 80, 135, 16);
				panel.add(lblNewLabel_1);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Precio");
				lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblNewLabel_2.setBounds(12, 117, 135, 16);
				panel.add(lblNewLabel_2);
			}
			{
				JLabel lblNewLabel_3 = new JLabel("Cantidad Disponible");
				lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblNewLabel_3.setBounds(12, 162, 147, 16);
				panel.add(lblNewLabel_3);
			}
			{
				JLabel lblNewLabel_4 = new JLabel("Modelo");
				lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblNewLabel_4.setBounds(12, 209, 56, 16);
				panel.add(lblNewLabel_4);
			}
			{
				JLabel lblNewLabel_5 = new JLabel("Marca");
				lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblNewLabel_5.setBounds(12, 251, 56, 16);
				panel.add(lblNewLabel_5);
			}
			{
				JLabel lblNewLabel_6 = new JLabel("tipo conexion");
				lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblNewLabel_6.setBounds(12, 297, 135, 16);
				panel.add(lblNewLabel_6);
			}
			{
				JLabel lblNewLabel_7 = new JLabel("Velocidad de procesamiento");
				lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblNewLabel_7.setBounds(12, 342, 198, 16);
				panel.add(lblNewLabel_7);
			}
			{
				txtID = new JTextField();
				txtID.setEditable(false);
				txtID.setBounds(271, 35, 116, 22);
				panel.add(txtID);
				txtID.setColumns(10);
			}
			{
				txtNumSerie = new JTextField();
				txtNumSerie.setEditable(false);
				txtNumSerie.setBounds(271, 78, 116, 22);
				panel.add(txtNumSerie);
				txtNumSerie.setColumns(10);
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
				txtPrecio.setEditable(false);
				txtPrecio.setBounds(271, 115, 116, 22);
				panel.add(txtPrecio);
				txtPrecio.setColumns(10);
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
				txtCantidadDisponible.setEditable(false);
				txtCantidadDisponible.setBounds(271, 160, 116, 22);
				panel.add(txtCantidadDisponible);
				txtCantidadDisponible.setColumns(10);
			}
			{
				txtModelo = new JTextField();
				txtModelo.setEditable(false);
				txtModelo.setBounds(271, 207, 116, 22);
				panel.add(txtModelo);
				txtModelo.setColumns(10);
			}
			{
				txtMarca = new JTextField();
				txtMarca.setEditable(false);
				txtMarca.setBounds(271, 251, 116, 22);
				panel.add(txtMarca);
				txtMarca.setColumns(10);
			}
			{
				txtTipoConexion = new JTextField();
				txtTipoConexion.setEditable(false);
				txtTipoConexion.setBounds(271, 295, 116, 22);
				panel.add(txtTipoConexion);
				txtTipoConexion.setColumns(10);
			}
			{
				txtVelocidadProcesamiento = new JTextField();
				txtVelocidadProcesamiento.setEditable(false);
				txtVelocidadProcesamiento.setBounds(271, 340, 116, 22);
				panel.add(txtVelocidadProcesamiento);
				txtVelocidadProcesamiento.setColumns(10);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton editarValores = new JButton("editar valores");
				editarValores.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						switchModos();
						txtModelo.setEditable(editarLosValores);
						txtMarca.setEditable(editarLosValores);
						txtNumSerie.setEditable(editarLosValores);
						txtPrecio.setEditable(editarLosValores);
						txtCantidadDisponible.setEditable(editarLosValores);
						txtTipoConexion.setEditable(editarLosValores);
						txtVelocidadProcesamiento.setEditable(editarLosValores);
						
						if(editarLosValores == false) {
							editarValores.setText("editar valores");
							updateInfo();
						}
						else {
							if(editarLosValores == true) {
								editarValores.setText("guardar cambios");
							}
						}
					}
				});
				editarValores.setActionCommand("OK");
				buttonPane.add(editarValores);
				getRootPane().setDefaultButton(editarValores);
			}
			{
				JButton cancelar = new JButton("cancelar");
				cancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelar.setActionCommand("Cancel");
				buttonPane.add(cancelar);
			}
		}
		loadData();
	}
	private void loadData() {
		txtID.setText(mp.getCodigo());                   
		txtNumSerie.setText(mp.getNumeroSerie());            
		txtPrecio.setText(String.valueOf(mp.getPrecio()));                
		txtCantidadDisponible.setText(String.valueOf(mp.getCantDisponible()));   
		txtModelo.setText(mp.getModelo());               
		txtMarca.setText(mp.getMarca());                 
		txtTipoConexion.setText(mp.getTipoConexion());         
		txtVelocidadProcesamiento.setText(mp.getVelocidadProcesamiento());
	}
	
	public void updateInfo() {
		try {
			String numeroSerie = txtNumSerie.getText();
			Double precio = Double.parseDouble(txtPrecio.getText());
			int cantDisponible = Integer.parseInt(txtCantidadDisponible.getText());
			String modelo = txtModelo.getText();
			String marca = txtMarca.getText();                      
			String tipoConexion = txtTipoConexion.getText();               
			String velocidadProcesamiento = txtVelocidadProcesamiento.getText();    
			
			mp.setNumeroSerie(numeroSerie);
			mp.setPrecio(precio);
			mp.setCantDisponible(cantDisponible);
			mp.setModelo(modelo);
			mp.setMarca(marca);
			mp.setTipoConexion(tipoConexion);
			mp.setVelocidadProcesamiento(velocidadProcesamiento);
			
			ComponenteDAO.updateMicroProcesador(mp);
			componenteView.updateTable();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private void switchModos() {
		if(this.editarLosValores == false) {
			this.editarLosValores = true;
		}
		else {
			if(this.editarLosValores == true) {
				this.editarLosValores = false;
			}
		}
	}
	
	public void setID(String id) {
		txtID.setText(id);
	}
	
	public void setNumSerie(String numS) {
		txtNumSerie.setText(numS);
	}
	
	public void setPrecio(String precio) {
		txtPrecio.setText(precio);
	}
	
	public void setCantidadDisponible(String cantidad) {
		txtCantidadDisponible.setText(cantidad);
	}
	
	public void setModelo(String modelo) {
		txtModelo.setText(modelo);
	}
	
	public void setMarca(String marca) {
		txtMarca.setText(marca);
	}
	
	public void setTipoConexion(String conexion) {
		txtTipoConexion.setText(conexion);
	}
	
	public void setVelocidadP(String velocidadP) {
		txtVelocidadProcesamiento.setText(velocidadP);
	}
}
