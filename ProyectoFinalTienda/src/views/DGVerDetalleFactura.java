package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logic.DetalleFactura;
import connection.DetalleFacturaDAO;
import connection.FacturaDAO;
import logic.Factura;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;

public class DGVerDetalleFactura extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigoFactura;
	private JTextField txtClienteNombre;
	private JTextField txtTotal;
	private JTextField txtClienteContacto;
	private JTextField txtFecha;
	private JTable tblDetalleFactura;
	private ArrayList<DetalleFactura> detalles;
	private Factura factura;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DGVerDetalleFactura dialog = new DGVerDetalleFactura();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the dialog.
	 */
	public DGVerDetalleFactura() {
		setBounds(100, 100, 951, 630);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel pData = new JPanel();
		pData.setLayout(null);
		pData.setBounds(28, 33, 639, 152);
		contentPanel.add(pData);
		
		JLabel lblFacturaId = new JLabel("Cod. Factura");
		lblFacturaId.setBounds(12, 34, 111, 16);
		pData.add(lblFacturaId);
		
		txtCodigoFactura = new JTextField();
		txtCodigoFactura.setEditable(false);
		txtCodigoFactura.setColumns(10);
		txtCodigoFactura.setBounds(113, 31, 116, 22);
		pData.add(txtCodigoFactura);
		
		JLabel label_1 = new JLabel("Nombre");
		label_1.setBounds(12, 72, 111, 16);
		pData.add(label_1);
		
		txtClienteNombre = new JTextField();
		txtClienteNombre.setEditable(false);
		txtClienteNombre.setColumns(10);
		txtClienteNombre.setBounds(69, 69, 239, 22);
		pData.add(txtClienteNombre);
		
		txtFecha = new JTextField();
		txtFecha.setBounds(431, 28, 196, 22);
		pData.add(txtFecha);
		txtFecha.setEditable(false);
		txtFecha.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(343, 34, 111, 16);
		pData.add(lblFecha);
		
		txtClienteContacto = new JTextField();
		txtClienteContacto.setBounds(423, 66, 204, 22);
		pData.add(txtClienteContacto);
		txtClienteContacto.setEnabled(true);
		txtClienteContacto.setEditable(false);
		txtClienteContacto.setColumns(10);
		
		JLabel lblContacto = new JLabel("Contacto");
		lblContacto.setBounds(332, 72, 101, 16);
		pData.add(lblContacto);
		
		tblDetalleFactura = new JTable(getTableModel());
		JScrollPane scrollPane = new JScrollPane(tblDetalleFactura);
		scrollPane.setBounds(28, 198, 874, 259);
		
		contentPanel.add(scrollPane);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(28, 495, 111, 16);
		contentPanel.add(lblTotal);
		
		txtTotal = new JTextField();
		txtTotal.setBounds(84, 492, 160, 22);
		contentPanel.add(txtTotal);
		txtTotal.setEnabled(true);
		txtTotal.setEditable(false);
		txtTotal.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cerrar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		fillFields();
	}
	
	public ArrayList<DetalleFactura> getDetalles() {
		return detalles;
	}

	public void setDetalles(ArrayList<DetalleFactura> detalles) {
		this.detalles = detalles;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}
	
	private void fillFields() {
		txtCodigoFactura.setText(factura.getCodigo());    
		txtClienteNombre.setText(factura.getCliente().getNombre());    
		txtTotal.setText(String.valueOf(factura.getTotalPagar()));             
		txtClienteContacto.setText(factura.getCliente().getTelefono()); 
		txtFecha.setText(String.valueOf(factura.getFecha()));            
	}
	
	private DefaultTableModel getTableModel() {
		factura = FacturaDAO.searchFacturaById(7);
		String[] columns = {"Cod.", "Marca", "Precio", "Desc.", "Cant.","Total Por Comp."};
		DefaultTableModel model = new DefaultTableModel(columns, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};		
		for(DetalleFactura d : factura.getDetalles()) {
			Object[] row = {
					d.getComponente().getCodigo(),
					d.getComponente().getMarca(),
					d.getComponente().getPrecio(),
					d.getDescuento(),
					d.getCantidadVendida(),
					d.getTotal()
			};
			model.addRow(row);
		}
		
		return model;
	}
}
