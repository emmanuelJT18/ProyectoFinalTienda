package views;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import connection.ComponenteDAO;
import logic.Componente;
import logic.DiscoDuro;
import logic.Factura;
import logic.MemoriaRam;
import logic.MicroProcesador;
import logic.TarjetaMadre;
import logic.Tienda;
import logic.Utilidad;
import views.compVisuales.SingleBtnCellEditor;
import views.compVisuales.SingleButtonCellEditor;
import views.compVisuales.SingleButtonCellRenderer;
import views.compVisuales.TableActionCellEditor;
import views.compVisuales.TableActionCellRender;
import views.compVisuales.TableActionEvent;

public class PReporteFactura extends JPanel {
	private Tienda controller = Tienda.getInstance();
	private JTable tblFacturas;
	private TableActionEvent tableActionEvent;
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
		
	    tableActionEvent = new TableActionEvent() {

			@Override
			public void onDelete(int row) {
				System.out.println("Delete Componente on row: "+row);
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onView(int row) {
				showDetalleFactura(row);
				System.out.println("View Componente on row: "+row);				
			}
		};		
		tblFacturas = new JTable(getTableModel());	
		tblFacturas.setRowHeight(20);
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
		tblFacturas.getColumnModel().getColumn(4).setCellRenderer(new SingleButtonCellRenderer("ver detalles"));
		tblFacturas.getColumnModel().getColumn(4).setCellEditor(new SingleButtonCellEditor("Ver Detalles", row -> {
	        System.out.println("Botón presionado en la fila: " + row);
	        showDetalleFactura(row);
		}));
		//tblFacturas.getColumnModel().getColumn(4).setCellRenderer(new TableActionCellRender());
		//tblFacturas.getColumnModel().getColumn(4).setCellEditor(new TableActionCellEditor(tableActionEvent));
	}
	
	private void showDetalleFactura(int row) {
		Factura factura = controller.getFacturas().get(row);
		DGVerDetalleFactura df = new DGVerDetalleFactura(factura);
		df.setModal(true);
		df.setLocationRelativeTo(null);
		df.setVisible(true);
	}
}
