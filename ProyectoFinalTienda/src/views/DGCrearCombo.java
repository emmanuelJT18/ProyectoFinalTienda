package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
import java.awt.event.ActionEvent;

public class DGCrearCombo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JComboBox<DiscoDuro> cbxDiscoDuro;
	private JComboBox<TarjetaMadre> cbxTarjetasMadre;
	private JComboBox<MicroProcesador> cbxMicroProcesador;
	private JComboBox<MemoriaRam> cbxMemoriaRam;
	private Tienda controller = Tienda.getInstance();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DGCrearCombo dialog = new DGCrearCombo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DGCrearCombo() {
		setBounds(100, 100, 595, 502);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		cbxDiscoDuro = new JComboBox();
		cbxDiscoDuro.setBounds(251, 93, 287, 22);
		contentPanel.add(cbxDiscoDuro);
		
		cbxTarjetasMadre = new JComboBox();
		cbxTarjetasMadre.setBounds(251, 141, 287, 22);
		contentPanel.add(cbxTarjetasMadre);
		
		cbxMicroProcesador = new JComboBox();
		cbxMicroProcesador.setBounds(251, 186, 287, 22);
		contentPanel.add(cbxMicroProcesador);
		
		cbxMemoriaRam = new JComboBox();
		cbxMemoriaRam.setBounds(251, 237, 287, 22);
		contentPanel.add(cbxMemoriaRam);
		
		JLabel lblNewLabel = new JLabel("Discos Duros");
		lblNewLabel.setBounds(82, 96, 84, 16);
		contentPanel.add(lblNewLabel);
		
		JLabel lblTarjetasMadre = new JLabel("Tarjetas Madre");
		lblTarjetasMadre.setBounds(82, 144, 121, 16);
		contentPanel.add(lblTarjetasMadre);
		
		JLabel lblMicroProcesadores = new JLabel("Micro Procesadores");
		lblMicroProcesadores.setBounds(82, 189, 121, 16);
		contentPanel.add(lblMicroProcesadores);
		
		JLabel lblMemoriasRam = new JLabel("Memorias Ram");
		lblMemoriasRam.setBounds(82, 240, 94, 16);
		contentPanel.add(lblMemoriasRam);
		
		JLabel lblNewLabel_1 = new JLabel("Crear Combo");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(203, 24, 141, 16);
		contentPanel.add(lblNewLabel_1);
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
		JOptionPane.showConfirmDialog(null, "Componente Creado!.");

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
