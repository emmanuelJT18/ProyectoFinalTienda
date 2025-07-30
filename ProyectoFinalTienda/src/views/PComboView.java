package views;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import logic.Combo;
import logic.Tienda;
import logic.Utilidad;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PComboView extends JPanel {
	private JTable tblCombo;
	private Tienda controller = Tienda.getInstance();

	/**
	 * Create the panel.
	 */
	public PComboView() {
		setPreferredSize(
				new Dimension(
						Utilidad.witdhForParentPanelView,
						Utilidad.heightForParentPanelView
				)
		);
		setLayout(null);
		
		JPanel pActions = new JPanel();
		pActions.setBounds(165, 52, 616, 101);
		add(pActions);
		pActions.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Crear Combo");
		lblNewLabel.setBounds(109, 48, 99, 16);
		pActions.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Nuevo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DGCrearCombo comboView = new DGCrearCombo(PComboView.this);
				comboView.setLocationRelativeTo(null);
				comboView.setModal(true);
				comboView.setVisible(true);
			}
		});
		btnNewButton.setBounds(204, 44, 118, 25);
		pActions.add(btnNewButton);
		
		JPanel pShowData = new JPanel();
		pShowData.setBounds(50, 178, 947, 344);
		add(pShowData);
		pShowData.setLayout(null);
		
		tblCombo = new JTable(getTableModel());
		JScrollPane scrollPane = new JScrollPane(tblCombo);
		scrollPane.setBounds(12, 28, 923, 268);
		pShowData.add(scrollPane);
	}
	
	private DefaultTableModel getTableModel() {
		String[] columns = {"Cod.", "Nombre", "Descuento", "Acciones"};
		DefaultTableModel model = new DefaultTableModel(columns, 0){
		    @Override
		    public boolean isCellEditable(int row, int column) {
		        return column == 3; 
		    }
		};
		for(Combo c : controller.getCombos()) {
			
			Object[] row = {
				c.getCodigo(),
				c.getNombre(),
				(c.getDescuento()*100)+"%",
			};
			model.addRow(row);
		}
		
		return model;
	}
	
	public void updateTable() {
		DefaultTableModel updatedModel = getTableModel();
		tblCombo.setModel(updatedModel);
	}
}
