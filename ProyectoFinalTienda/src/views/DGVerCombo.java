package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connection.ComboDAO;
import logic.Combo;
import logic.Componente;
import logic.DiscoDuro;
import logic.MemoriaRam;
import logic.MicroProcesador;
import logic.TarjetaMadre;
import logic.Tienda;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Color;
import java.awt.Component;

public class DGVerCombo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JComboBox<DiscoDuro> cbxDiscoDuro;
	private JComboBox<TarjetaMadre> cbxTarjetasMadre;
	private JComboBox<MicroProcesador> cbxMicroProcesador;
	private JComboBox<MemoriaRam> cbxMemoriaRam;
	private Tienda controller = Tienda.getInstance();
	private JSpinner spinner;
	private ArrayList<Componente> componentes;
	private JTextField txtNombre;
	private JLabel lblCodigo;
	private PComboView comboView;
	private Combo combo;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		try {
			Combo cb = ComboDAO.searchComboeById(1);
			DGVerCombo dialog = new DGVerCombo(cb);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public DGVerCombo(Combo combo) {
		this.combo = combo;
		componentes = new ArrayList<Componente>();
		setBounds(100, 100, 595, 502);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		cbxDiscoDuro = new JComboBox();
		cbxDiscoDuro.setBounds(236, 168, 287, 22);
		contentPanel.add(cbxDiscoDuro);
		
		cbxTarjetasMadre = new JComboBox();
		cbxTarjetasMadre.setBounds(236, 216, 287, 22);
		contentPanel.add(cbxTarjetasMadre);
		
		cbxMicroProcesador = new JComboBox();
		cbxMicroProcesador.setBounds(236, 261, 287, 22);
		contentPanel.add(cbxMicroProcesador);
		
		cbxMemoriaRam = new JComboBox();
		cbxMemoriaRam.setBounds(236, 312, 287, 22);
		contentPanel.add(cbxMemoriaRam);
		
		JLabel lblNewLabel = new JLabel("Discos Duros");
		lblNewLabel.setBounds(67, 171, 84, 16);
		contentPanel.add(lblNewLabel);
		
		JLabel lblTarjetasMadre = new JLabel("Tarjetas Madre");
		lblTarjetasMadre.setBounds(67, 219, 121, 16);
		contentPanel.add(lblTarjetasMadre);
		
		JLabel lblMicroProcesadores = new JLabel("Micro Procesadores");
		lblMicroProcesadores.setBounds(67, 264, 121, 16);
		contentPanel.add(lblMicroProcesadores);
		
		JLabel lblMemoriasRam = new JLabel("Memorias Ram");
		lblMemoriasRam.setBounds(67, 315, 94, 16);
		contentPanel.add(lblMemoriasRam);
		
		JLabel lblNewLabel_1 = new JLabel("Ver Combo");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(203, 24, 141, 16);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblDescuento = new JLabel("Descuento");
		lblDescuento.setBounds(67, 124, 84, 16);
		contentPanel.add(lblDescuento);
		
		spinner = new JSpinner();
		spinner.setFont(new Font("Tahoma", Font.BOLD, 14));
		spinner.setForeground(Color.BLACK);
		spinner.setModel(new SpinnerNumberModel(1, 1, 100, 1));
		spinner.setBounds(236, 121, 57, 22);
		contentPanel.add(spinner);
		
		JLabel label = new JLabel("%");
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		label.setBounds(305, 124, 84, 16);
		contentPanel.add(label);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre ");
		lblNewLabel_2.setBounds(67, 79, 56, 16);
		contentPanel.add(lblNewLabel_2);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtNombre.setBounds(236, 76, 153, 22);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(10);
		
		lblCodigo = new JLabel("New label");
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCodigo.setBounds(425, 79, 73, 16);
		contentPanel.add(lblCodigo);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		lblCodigo.setText(combo.getCodigo());
		loadDataToCbx();
		disbleFields();
	}
	

	
	private void disbleFields() {
		// Desactivar el campo de texto (no editable)
		JComponent editor = spinner.getEditor();
		if (editor instanceof JSpinner.DefaultEditor) {
		    JTextField textField = ((JSpinner.DefaultEditor) editor).getTextField();
		    textField.setEditable(false);
		    textField.setForeground(Color.BLACK); // Opcional: texto negro
		    textField.setFont(new Font("Arial", Font.BOLD, 12)); // Opcional: texto en negrita
		}

		// Desactivar los botones 
		for (Component comp : spinner.getComponents()) {
		    if (comp instanceof JButton) {
		        comp.setEnabled(false);
		    }
		}
	    txtNombre.setEditable(false);

	}

	
	
	private void loadDataToCbx() {
		txtNombre.setText(combo.getNombre());
		lblCodigo.setText(combo.getCodigo());
		spinner.setValue(combo.getDescuento()*100);
		for (Componente c : combo.getComponentes()) {
		    if (c instanceof TarjetaMadre) {
		        cbxTarjetasMadre.addItem((TarjetaMadre) c); 
		    } else if (c instanceof DiscoDuro) {
		        cbxDiscoDuro.addItem((DiscoDuro) c);
		    } else if (c instanceof MicroProcesador) {
		        cbxMicroProcesador.addItem((MicroProcesador) c);
		    } else if (c instanceof MemoriaRam) {
		        cbxMemoriaRam.addItem((MemoriaRam) c);
		    }
		}
	}
}
