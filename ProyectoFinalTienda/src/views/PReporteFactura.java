package views;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import logic.Factura;
import logic.Tienda;
import logic.Utilidad;

public class PReporteFactura extends JPanel {
	private Tienda controller = Tienda.getInstance();
	private JTable tblFacturas;
	/**
	 * Create the panel.
	 */
	public PReporteFactura() {
		setBounds(
				Utilidad.xlocationForChildPanelView, 
				Utilidad.ylocationForChildPanelView, 
				Utilidad.witdhForChildPanelView, 
				Utilidad.heightForChildPanelView
		);
		setLayout(null);
		
		JLabel lblTitulo = new JLabel("Reportes");
		lblTitulo.setBounds(452, 13, 148, 16);
		add(lblTitulo);
		
		JPanel pDataTable = new JPanel();
		pDataTable.setBounds(0, 235, 1100, 358);
		add(pDataTable);
		
		JPanel pActions = new JPanel();
		pActions.setBounds(0, 83, 1100, 144);
		add(pActions);
		pDataTable.setLayout(null);
		
		tblFacturas = new JTable(getTableModel());
		JScrollPane scrollPane = new JScrollPane(tblFacturas);
		scrollPane.setBounds(85, 10, 927, 335);
		pDataTable.add(scrollPane);	
		
	}
	
	private DefaultTableModel getTableModel() {
		String[] columns = {"Cod. Factura", "Cliente", "Total Factura", "Fecha", "Acciones"};
		DefaultTableModel model = new DefaultTableModel(columns, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return column == 4;
			}
		};
		
		for(Factura f : controller.getFacturas()) {
			Object[] row = {
					f.getCodigo(),
					f.getCliente().getNombre(),
					f.getTotalPagar(),
					f.getFecha(),
			};
			model.addRow(row);
		}
		
		return model;
	}
	
	public void updateTable() {
		tblFacturas.setModel(getTableModel());
	}
}
