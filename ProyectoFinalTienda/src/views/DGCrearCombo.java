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
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class DGCrearCombo extends JDialog {

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DGCrearCombo dialog = new DGCrearCombo(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DGCrearCombo(PComboView comboView) {
		this.comboView = comboView;
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
		
		JLabel lblNewLabel_1 = new JLabel("Crear Combo");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(203, 24, 141, 16);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblDescuento = new JLabel("Descuento");
		lblDescuento.setBounds(67, 124, 84, 16);
		contentPanel.add(lblDescuento);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 100, 1));
        if (spinner.getEditor() instanceof JSpinner.DefaultEditor) {
            ((JSpinner.DefaultEditor) spinner.getEditor()).getTextField().setEditable(false);
        }
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
		txtNombre.setBounds(236, 76, 153, 22);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(10);
		
		lblCodigo = new JLabel(controller.genCodigoCombo());
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCodigo.setBounds(425, 79, 73, 16);
		contentPanel.add(lblCodigo);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnCreateCombo = new JButton("Crear ");
				btnCreateCombo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						createCombo();
					}
				});
				btnCreateCombo.setActionCommand("OK");
				buttonPane.add(btnCreateCombo);
				getRootPane().setDefaultButton(btnCreateCombo);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		loadDataToCbx();
	}
	
	private void createCombo() {
		if(!hayAlMenosDosSeleccionados()) {
			JOptionPane.showConfirmDialog(null, "Selecciona al menos dos componentes.");
			return;
		}
		
		if(txtNombre.getText() == null || txtNombre.getText().length() < 4) {
			JOptionPane.showConfirmDialog(null, "Escribe un nombre adecuado para el combo.\nMayor a 4 caracteres");
			return;
		}
	    if (cbxDiscoDuro.getSelectedIndex() > 0) componentes.add((DiscoDuro) cbxDiscoDuro.getSelectedItem());
	    if (cbxMemoriaRam.getSelectedIndex() > 0) componentes.add((MemoriaRam) cbxMemoriaRam.getSelectedItem());
	    if (cbxMicroProcesador.getSelectedIndex() > 0) componentes.add((MicroProcesador) cbxMicroProcesador.getSelectedItem());
	    if (cbxTarjetasMadre.getSelectedIndex() > 0)  componentes.add((TarjetaMadre) cbxTarjetasMadre.getSelectedItem());
	    
		int value = (int) spinner.getValue();
		Double descuento = (double) (value/100.0);
		String nombre = (String) txtNombre.getText();
		Combo cb = new Combo(lblCodigo.getText(), nombre, descuento);
		cb.setComponentes(componentes);
		ComboDAO.insertCombo(cb);
		resetFields();
		comboView.updateTable();
		JOptionPane.showConfirmDialog(null, "Componente Creado!.");

	}
	
	private void resetFields() {
		cbxDiscoDuro.setSelectedIndex(0);
		cbxMemoriaRam.setSelectedIndex(0);
		cbxMicroProcesador.setSelectedIndex(0);
		cbxTarjetasMadre.setSelectedIndex(0);
		txtNombre.setText("");
		spinner.setValue(1);
		lblCodigo.setText(controller.genCodigoCombo());
	}
	
	private boolean hayAlMenosDosSeleccionados() {
	    int contador = 0;

	    if (cbxDiscoDuro.getSelectedIndex() > 0) contador++;
	    if (cbxMemoriaRam.getSelectedIndex() > 0) contador++;
	    if (cbxMicroProcesador.getSelectedIndex() > 0) contador++;
	    if (cbxTarjetasMadre.getSelectedIndex() > 0) contador++;

	    return contador >= 2;
	}
	
	private void loadDataToCbx() {
		cbxTarjetasMadre.addItem(new TarjetaMadre() {
		    @Override
		    public String toString() {
		        return "-- Seleccione una opción --";
		    }
		});
		
		cbxDiscoDuro.addItem(new DiscoDuro() {
		    @Override
		    public String toString() {
		        return "-- Seleccione una opción --";
		    }
		});
		
		cbxMicroProcesador.addItem(new MicroProcesador() {
		    @Override
		    public String toString() {
		        return "-- Seleccione una opción --";
		    }
		});
		
		cbxMemoriaRam.addItem(new MemoriaRam() {
		    @Override
		    public String toString() {
		        return "-- Seleccione una opción --";
		    }
		});

		for (Componente c : controller.getComponentes()) {
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
