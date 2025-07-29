package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class DGVerDetalleFactura extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigoFactura;
	private JTextField txtClienteNombre;
	private JTextField txtTotal;
	private JTextField txtClienteContacto;
	private JTextField txtFecha;

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
		setBounds(100, 100, 1069, 630);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel pData = new JPanel();
		pData.setLayout(null);
		pData.setBounds(12, 33, 639, 191);
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
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(13, 114, 111, 16);
		pData.add(lblTotal);
		
		txtTotal = new JTextField();
		txtTotal.setEnabled(true);
		txtTotal.setEditable(false);
		txtTotal.setColumns(10);
		txtTotal.setBounds(69, 111, 160, 22);
		pData.add(txtTotal);
		
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
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
