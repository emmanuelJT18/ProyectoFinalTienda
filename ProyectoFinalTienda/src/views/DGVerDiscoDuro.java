package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.DiscoDuro;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class DGVerDiscoDuro extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtIDComponente;
	private JTextField txtNumeroSerie;
	private JTextField txtPrecio;
	private JTextField txtCantDisponible;
	private JTextField txtModelo;
	private JTextField txtMarca;
	private JTextField txtTipoConexion;
	private JTextField txtCantMemoria;
	private DiscoDuro dd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DGVerDiscoDuro dialog = new DGVerDiscoDuro(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DGVerDiscoDuro(DiscoDuro dd) {
		this.dd = dd;
		setTitle("Carateristica");
		setBounds(100, 100, 616, 480);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.NORTH);
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JLabel txtTitle = new JLabel("Disco Duro");
				txtTitle.setFont(new Font("Tahoma", Font.BOLD, 17));
				panel.add(txtTitle);
			}
		}
		{
			JPanel pParentConteiner = new JPanel();
			contentPanel.add(pParentConteiner, BorderLayout.CENTER);
			pParentConteiner.setLayout(null);
			
			JLabel lblIDComponente = new JLabel("ID del Componente");
			lblIDComponente.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblIDComponente.setBounds(15, 28, 147, 16);
			pParentConteiner.add(lblIDComponente);
			
			txtIDComponente = new JTextField();
			txtIDComponente.setColumns(10);
			txtIDComponente.setBounds(177, 16, 163, 29);
			pParentConteiner.add(txtIDComponente);
			
			JLabel lblNumeroSerie = new JLabel("Numero de Serie");
			lblNumeroSerie.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNumeroSerie.setBounds(15, 60, 135, 16);
			pParentConteiner.add(lblNumeroSerie);
			
			txtNumeroSerie = new JTextField();
			txtNumeroSerie.setBounds(177, 55, 163, 26);
			pParentConteiner.add(txtNumeroSerie);
			txtNumeroSerie.setColumns(10);
			
			JLabel lblPrecio = new JLabel("Precio");
			lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblPrecio.setBounds(15, 100, 109, 16);
			pParentConteiner.add(lblPrecio);
			
			txtPrecio = new JTextField();
			txtPrecio.setBounds(93, 95, 247, 26);
			pParentConteiner.add(txtPrecio);
			txtPrecio.setColumns(10);
			
			JLabel lblCantidadDisponible = new JLabel("Cant. Disponible");
			lblCantidadDisponible.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblCantidadDisponible.setBounds(15, 142, 135, 16);
			pParentConteiner.add(lblCantidadDisponible);
			
			txtCantDisponible = new JTextField();
			txtCantDisponible.setBounds(177, 137, 163, 26);
			pParentConteiner.add(txtCantDisponible);
			txtCantDisponible.setColumns(10);
			
			JLabel lblModelo = new JLabel("Modelo");
			lblModelo.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblModelo.setBounds(15, 182, 109, 16);
			pParentConteiner.add(lblModelo);
			
			txtModelo = new JTextField();
			txtModelo.setBounds(93, 179, 247, 26);
			pParentConteiner.add(txtModelo);
			txtModelo.setColumns(10);
			
			JLabel lblMarca = new JLabel("Marca");
			lblMarca.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblMarca.setBounds(15, 226, 109, 16);
			pParentConteiner.add(lblMarca);
			
			JLabel lblTipoConexion = new JLabel("Tipo Conexion");
			lblTipoConexion.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblTipoConexion.setBounds(15, 258, 109, 16);
			pParentConteiner.add(lblTipoConexion);
			
			JLabel lblCantMemoria = new JLabel("Cant. Memoria");
			lblCantMemoria.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblCantMemoria.setBounds(15, 300, 221, 16);
			pParentConteiner.add(lblCantMemoria);
			
			txtMarca = new JTextField();
			txtMarca.setBounds(93, 221, 247, 26);
			pParentConteiner.add(txtMarca);
			txtMarca.setColumns(10);
			
			txtTipoConexion = new JTextField();
			txtTipoConexion.setBounds(177, 253, 163, 29);
			pParentConteiner.add(txtTipoConexion);
			txtTipoConexion.setColumns(10);
			
			txtCantMemoria = new JTextField();
			txtCantMemoria.setBounds(177, 295, 163, 26);
			pParentConteiner.add(txtCantMemoria);
			txtCantMemoria.setColumns(10);
			
			JLabel lblNewLabel = new JLabel("New label");
			lblNewLabel.setBounds(412, 84, 69, 20);
			pParentConteiner.add(lblNewLabel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnEdit = new JButton("Editar");
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
		this.txtCantDisponible.setText(String.valueOf(dd.getCantDisponible()));
		this.txtCantMemoria.setText(dd.getCantMemoria());
		this.txtIDComponente.setText(dd.getCodigo());
		this.txtMarca.setText(dd.getMarca());
		this.txtModelo.setText(dd.getModelo());
		this.txtNumeroSerie.setText(dd.getNumeroSerie());
		this.txtPrecio.setText(String.valueOf(dd.getPrecio()));
		this.txtTipoConexion.setText(dd.getTipoConexion());
	}
}
