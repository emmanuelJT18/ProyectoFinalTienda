package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
	private MemoriaRam ram;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DGVerMemoriaRam dialog = new DGVerMemoriaRam(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DGVerMemoriaRam(MemoriaRam ram) {
		this.ram = ram;
		setBounds(100, 100, 598, 433);
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
				lblCantMemoria.setBounds(15, 233, 109, 16);
				pParentPanel.add(lblCantMemoria);
			}
			{
				txtCantMemoria = new JTextField();
				txtCantMemoria.setColumns(10);
				txtCantMemoria.setBounds(139, 228, 201, 22);
				pParentPanel.add(txtCantMemoria);
			}
			{
				JLabel lblVelocidad_Prose = new JLabel("Velocidad de Procesamiento");
				lblVelocidad_Prose.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblVelocidad_Prose.setBounds(15, 266, 221, 16);
				pParentPanel.add(lblVelocidad_Prose);
			}
			{
				txtVelocidadProcesamiento = new JTextField();
				txtVelocidadProcesamiento.setColumns(10);
				txtVelocidadProcesamiento.setBounds(251, 261, 89, 22);
				pParentPanel.add(txtVelocidadProcesamiento);
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
						
						
					}
				});
				btnEdit.setActionCommand("OK");
				buttonPane.add(btnEdit);
				getRootPane().setDefaultButton(btnEdit);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		loadData();
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
	}
}

