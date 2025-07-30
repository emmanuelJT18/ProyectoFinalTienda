package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connection.ComponenteDAO;
import logic.MemoriaRam;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DGVerMemoriaRam extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtIDComponente;
	private JTextField txtNumeroSerie;
	private JTextField txtPrecio;
	private JTextField txtCantDisponible;
	private JTextField txtModelo;
	private JTextField txtMarca;
	private JTextField txtCantMemoria;
	private JTextField txtVelocidadProcesamiento;
	private JTextField txtTipoRam;
	private MemoriaRam ram;
	private PComponenteView componenteView;
	private boolean editable = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DGVerMemoriaRam dialog = new DGVerMemoriaRam(null, null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DGVerMemoriaRam(MemoriaRam ram, PComponenteView componenteView) {
		this.componenteView = componenteView;
		this.ram = ram;
		setBounds(100, 100, 676, 487);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel pTitlePane = new JPanel();
			contentPanel.add(pTitlePane, BorderLayout.NORTH);
			pTitlePane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JLabel lblTitle = new JLabel("Memoria Ram");
				lblTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
				pTitlePane.add(lblTitle);
			}
		}
		{
			JPanel pParentPanel = new JPanel();
			contentPanel.add(pParentPanel, BorderLayout.CENTER);
			pParentPanel.setLayout(null);
			
			JLabel lblIDComponente = new JLabel("ID del Componente");
			lblIDComponente.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblIDComponente.setBounds(15, 16, 147, 16);
			pParentPanel.add(lblIDComponente);
			
			txtIDComponente = new JTextField();
			txtIDComponente.setColumns(10);
			txtIDComponente.setBounds(177, 11, 163, 22);
			pParentPanel.add(txtIDComponente);
			
			JLabel lblNumeroSerie = new JLabel("Numero de Serie");
			lblNumeroSerie.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNumeroSerie.setBounds(15, 48, 135, 16);
			pParentPanel.add(lblNumeroSerie);
			
			txtNumeroSerie = new JTextField();
			txtNumeroSerie.setColumns(10);
			txtNumeroSerie.setBounds(177, 49, 163, 22);
			pParentPanel.add(txtNumeroSerie);
			
			JLabel lblPrecio = new JLabel("Precio");
			lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblPrecio.setBounds(15, 90, 109, 16);
			pParentPanel.add(lblPrecio);
			{
				txtPrecio = new JTextField();
				txtPrecio.setColumns(10);
				txtPrecio.setBounds(95, 87, 245, 22);
				pParentPanel.add(txtPrecio);
			}
			{
				JLabel lblCantDisponible = new JLabel("Cant. Disponible");
				lblCantDisponible.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblCantDisponible.setBounds(15, 125, 135, 16);
				pParentPanel.add(lblCantDisponible);
			}
			{
				txtCantDisponible = new JTextField();
				txtCantDisponible.setColumns(10);
				txtCantDisponible.setBounds(166, 125, 174, 22);
				pParentPanel.add(txtCantDisponible);
			}
			{
				JLabel lblModel = new JLabel("Modelo");
				lblModel.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblModel.setBounds(15, 166, 109, 16);
				pParentPanel.add(lblModel);
			}
			{
				txtModelo = new JTextField();
				txtModelo.setColumns(10);
				txtModelo.setBounds(112, 161, 228, 22);
				pParentPanel.add(txtModelo);
			}
			{
				JLabel lblMarca = new JLabel("Marca");
				lblMarca.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblMarca.setBounds(15, 195, 109, 16);
				pParentPanel.add(lblMarca);
			}
			{
				txtMarca = new JTextField();
				txtMarca.setColumns(10);
				txtMarca.setBounds(95, 195, 245, 22);
				pParentPanel.add(txtMarca);
			}
			{
				JLabel lblCantMemoria = new JLabel("Cant. Memoria");
				lblCantMemoria.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblCantMemoria.setBounds(12, 274, 109, 16);
				pParentPanel.add(lblCantMemoria);
			}
			{
				txtCantMemoria = new JTextField();
				txtCantMemoria.setColumns(10);
				txtCantMemoria.setBounds(136, 269, 201, 22);
				pParentPanel.add(txtCantMemoria);
			}
			{
				JLabel lblVelocidad_Prose = new JLabel("Velocidad de Procesamiento");
				lblVelocidad_Prose.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblVelocidad_Prose.setBounds(12, 307, 221, 16);
				pParentPanel.add(lblVelocidad_Prose);
			}
			{
				txtVelocidadProcesamiento = new JTextField();
				txtVelocidadProcesamiento.setColumns(10);
				txtVelocidadProcesamiento.setBounds(248, 302, 89, 22);
				pParentPanel.add(txtVelocidadProcesamiento);
			}
			{
				JLabel label = new JLabel("Tipo de RAM");
				label.setFont(new Font("Tahoma", Font.BOLD, 15));
				label.setBounds(15, 232, 101, 16);
				pParentPanel.add(label);
			}
			{
				txtTipoRam = new JTextField();
				txtTipoRam.setColumns(10);
				txtTipoRam.setBounds(136, 234, 77, 22);
				pParentPanel.add(txtTipoRam);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnEdit = new JButton("Editar ");
				btnEdit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						editable = !editable;
						if(editable) {
							btnEdit.setText("Guardar Cambios");
						} else {
							btnEdit.setText("Editar");
							updateInfo();
						}
						setCamposEditable(editable);
					}
				});
				btnEdit.setActionCommand("OK");
				buttonPane.add(btnEdit);
				getRootPane().setDefaultButton(btnEdit);
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
		setCamposEditable(false);
		loadData();
	}
	
	private void setCamposEditable(boolean editable) {
		txtIDComponente.setEditable(editable);
		txtNumeroSerie.setEditable(editable);           
		txtPrecio.setEditable(editable);                 
		txtCantDisponible.setEditable(editable);         
		txtModelo.setEditable(editable);                 
		txtMarca.setEditable(editable);                  
		txtCantMemoria.setEditable(editable);            
		txtVelocidadProcesamiento.setEditable(editable); 
		txtTipoRam.setEditable(editable);                
	}
	
	private void updateInfo() {
		try {
			String numeroSerie = txtNumeroSerie.getText();             
			Double precio = Double.parseDouble(txtPrecio.getText());                   
			int cantDisponible = Integer.parseInt(txtCantDisponible.getText());           
			String modelo = txtModelo.getText();                 
			String marca = txtMarca.getText();                   
			String cantMemoria = txtCantMemoria.getText();              
			String velocidadProcesamiento = txtVelocidadProcesamiento.getText(); 
			String tipoRam = txtTipoRam.getText();
			
			ram.setNumeroSerie(numeroSerie);
			ram.setPrecio(precio);
			ram.setCantDisponible(cantDisponible);
			ram.setModelo(modelo);
			ram.setMarca(marca);
			ram.setCantMemoria(cantMemoria);
			ram.setVelocidadProcesamiento(velocidadProcesamiento);
			ram.setTipoMemoriaRAM(tipoRam);
			
			ComponenteDAO.updateMemoriaRam(ram);
			componenteView.updateTable();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	private void loadData() {
		this.txtCantDisponible.setText(String.valueOf(ram.getCantDisponible()));
		this.txtCantMemoria.setText(ram.getCantMemoria());
		this.txtIDComponente.setText(ram.getCodigo());
		this.txtMarca.setText(ram.getMarca());
		this.txtModelo.setText(ram.getModelo());
		this.txtNumeroSerie.setText(ram.getNumeroSerie());
		this.txtPrecio.setText(String.valueOf(ram.getPrecio()));
		this.txtVelocidadProcesamiento.setText(ram.getVelocidadProcesamiento());
		this.txtTipoRam.setText(ram.getTipoMemoriaRAM());
	}
}

