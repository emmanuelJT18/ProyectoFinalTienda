/*
 * Nombre de codigo: DGVerTarjetaMadre
 * Autor: Josue Ariel Arias Veras
 * fecha: 23/07/2025
 * 
 * proposito: Mostrar datos completos de x componente, este en particular mostrara 
 * 			  los datos de la clase hija Tarjeta Madre.
 */

package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connection.ComponenteDAO;
import logic.TarjetaMadre;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DGVerTarjetaMadre extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtID;
	private JTextField txtNumSerie;
	private JTextField txtModelo;
	private JTextField txtMarca;
	private JTextField txtPrecio;
	private JTextField txtCantDisp;
	private JTextField txtConexionesDiscosDuros;
	private JTextField txtTipoRAM;
	private boolean editMode;
	private TarjetaMadre tm;
	private PComponenteView componenteView;
	private JTextField txtTipoConexion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DGVerTarjetaMadre dialog = new DGVerTarjetaMadre(null, null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DGVerTarjetaMadre(TarjetaMadre tm, PComponenteView componenteView) {
		this.componenteView = componenteView;
		this.tm = tm;
		setTitle("Tarjeta madre");
		this.editMode = false;
		setBounds(100, 100, 630, 512);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);

			JLabel lblNewLabel = new JLabel("ID");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel.setBounds(12, 65, 56, 16);
			panel.add(lblNewLabel);

			JLabel lblNewLabel_1 = new JLabel("Numero de serie");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel_1.setBounds(12, 102, 117, 16);
			panel.add(lblNewLabel_1);

			JLabel lblNewLabel_2 = new JLabel("Modelo");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel_2.setBounds(12, 145, 117, 16);
			panel.add(lblNewLabel_2);

			JLabel lblNewLabel_3 = new JLabel("Marca");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel_3.setBounds(12, 187, 49, 16);
			panel.add(lblNewLabel_3);

			JLabel lblNewLabel_4 = new JLabel("Precio");
			lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel_4.setBounds(12, 239, 49, 16);
			panel.add(lblNewLabel_4);

			JLabel lblNewLabel_5 = new JLabel("Cantidad disponible");
			lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel_5.setBounds(12, 284, 139, 16);
			panel.add(lblNewLabel_5);

			JLabel lblNewLabel_6 = new JLabel("Tipo de conexion de Disco");
			lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel_6.setBounds(12, 353, 187, 16);
			panel.add(lblNewLabel_6);

			JLabel lblNewLabel_7 = new JLabel("Tipo de RAM combatible");
			lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel_7.setBounds(12, 387, 187, 16);
			panel.add(lblNewLabel_7);

			txtID = new JTextField();
			txtID.setEditable(false);
			txtID.setBounds(307, 63, 116, 22);
			panel.add(txtID);
			txtID.setColumns(10);

			txtNumSerie = new JTextField();
			txtNumSerie.setEditable(false);
			txtNumSerie.setBounds(307, 100, 116, 22);
			panel.add(txtNumSerie);
			txtNumSerie.setColumns(10);

			txtModelo = new JTextField();
			txtModelo.setEditable(false);
			txtModelo.setBounds(307, 145, 116, 22);
			panel.add(txtModelo);
			txtModelo.setColumns(10);

			txtMarca = new JTextField();
			txtMarca.setEditable(false);
			txtMarca.setBounds(307, 185, 116, 22);
			panel.add(txtMarca);
			txtMarca.setColumns(10);

			txtPrecio = new JTextField();
			txtPrecio.setEditable(false);
			txtPrecio.setBounds(307, 237, 116, 22);
			panel.add(txtPrecio);
			txtPrecio.setColumns(10);

			txtCantDisp = new JTextField();
			txtCantDisp.setEditable(false);
			txtCantDisp.setBounds(307, 282, 116, 22);
			panel.add(txtCantDisp);
			txtCantDisp.setColumns(10);

			txtConexionesDiscosDuros = new JTextField();
			txtConexionesDiscosDuros.setEditable(false);
			txtConexionesDiscosDuros.setBounds(307, 351, 116, 22);
			panel.add(txtConexionesDiscosDuros);
			txtConexionesDiscosDuros.setColumns(10);

			txtTipoRAM = new JTextField();
			txtTipoRAM.setEditable(false);
			txtTipoRAM.setBounds(307, 385, 116, 22);
			panel.add(txtTipoRAM);
			txtTipoRAM.setColumns(10);

			JLabel lblTipoDeConexion = new JLabel("Tipo de Conexion");
			lblTipoDeConexion.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblTipoDeConexion.setBounds(14, 319, 139, 16);
			panel.add(lblTipoDeConexion);

			txtTipoConexion = new JTextField();
			txtTipoConexion.setText("0");
			txtTipoConexion.setEditable(false);
			txtTipoConexion.setColumns(10);
			txtTipoConexion.setBounds(309, 317, 116, 22);
			panel.add(txtTipoConexion);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Editar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						activarDesactivarEditMode();
						txtCantDisp.setEditable(editMode);
						txtID.setEditable(editMode);
						txtMarca.setEditable(editMode);
						txtModelo.setEditable(editMode);
						txtNumSerie.setEditable(editMode);
						txtPrecio.setEditable(editMode);
						txtConexionesDiscosDuros.setEditable(editMode);
						txtTipoRAM.setEditable(editMode);
						txtTipoConexion.setEditable(editMode);

						if(editMode == true) {
							okButton.setText("guardar valores");
						}
						else {
							if(editMode == false) {
								okButton.setText("editar valores");
								updateInfo();
							}
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		loadData();
	}

	private void updateInfo() { 
		try {
			String numeroSerie = txtNumSerie.getText();             
			String modelo = txtModelo.getText();              
			String marca = txtMarca.getText();                
			Double precio= Double.parseDouble(txtPrecio.getText());               
			int cantDisponible = Integer.parseInt(txtCantDisp.getText());             
			String conexionesDiscosDuros = txtConexionesDiscosDuros.getText();
			String tipoRam = txtTipoRAM.getText();
			String tipoConexion = txtTipoConexion.getText();

			tm.setNumeroSerie(numeroSerie);
			tm.setModelo(modelo);
			tm.setMarca(marca);
			tm.setPrecio(precio);
			tm.setCantDisponible(cantDisponible);
			tm.setConxionesDiscosDuros(conexionesDiscosDuros);
			tm.setTipoMemoriaRAM(tipoRam);
			tm.setTipoConexion(tipoConexion);
			
			ComponenteDAO.updateTarjetaMadre(tm);
			componenteView.updateTable();
		} catch (Exception ex) {
			ex.printStackTrace();		
		}
	}
	private void loadData() {
		txtID.setText(tm.getCodigo());                   
		txtNumSerie.setText(tm.getNumeroSerie());            
		txtModelo.setText(tm.getModelo());              
		txtMarca.setText(tm.getMarca());                
		txtPrecio.setText(String.valueOf(tm.getPrecio()));     
		txtCantDisp.setText(String.valueOf(tm.getCantDisponible()));             
		txtConexionesDiscosDuros.setText(tm.getConxionesDiscosDuros());
		txtTipoRAM.setText(tm.getTipoMemoriaRAM());
		txtTipoConexion.setText(tm.getTipoConexion());
	}

	/*
	 * Setters para colocar los valores de la base de datos
	 */
	public void setID(String s) {
		this.txtID.setText(s);
	}

	public void setNumSerie(String s) {
		this.txtNumSerie.setText(s);
	}
	public void setModelo(String s) {
		this.txtModelo.setText(s);
	}

	public void setMarca(String s) {
		this.txtMarca.setText(s);
	}
	public void setPrecio(String s) {
		this.txtPrecio.setText(s);
	}
	public void setCantDisp(String s) {
		this.txtCantDisp.setText(s);
	}
	public void setTipoDD(String s) {
		this.txtConexionesDiscosDuros.setText(s);
	}

	public void setTipoRAM(String s) {
		this.txtTipoRAM.setText(s);
	}
	/*
	 * activarDesactuvarEditMode actua como un interruptor, en que se apagara y enciende el editor de
	 * los valores.
	 */
	private void activarDesactivarEditMode() {
		if(this.editMode == false) {
			this.editMode = true;
		}
		else {
			if(this.editMode == true)
				this.editMode = false;
		}
	}
}
