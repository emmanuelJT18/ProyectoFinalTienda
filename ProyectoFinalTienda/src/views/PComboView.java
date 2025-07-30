package views;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import logic.Cliente;
import logic.Combo;
import logic.Tienda;
import logic.Utilidad;
import views.compVisuales.TableActionCellEditor;
import views.compVisuales.TableActionCellRender;
import views.compVisuales.TableActionEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import connection.ClienteDAO;
import connection.ComboDAO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PComboView extends JPanel {
	private JTable tblCombo;
	private Tienda controller = Tienda.getInstance();
	private TableActionEvent tableActionEvent;

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
		
		tableActionEvent = new TableActionEvent() {

			@Override
			public void onDelete(int row) {
				DefaultTableModel model = (DefaultTableModel) getTableModel();
				if (row != -1) { // -1 = there's no selected row 
				    model.removeRow(row);
				} else {
				    JOptionPane.showMessageDialog(null, "Por favor seleciona correctamente la fila que deseas eliminar.");
				}
				String codigo = (String) tblCombo.getValueAt(row, 0);
				ComboDAO.deleteCombo(codigo);
				updateTable();
				System.out.println("Delete Combo on row "+row);
			}

			@Override
			public void onView(int row) {
				String codigo = (String) tblCombo.getValueAt(row, 0);
				Combo combo = ComboDAO.searchCombo(codigo);
				DGVerCombo cbView = new DGVerCombo(combo);
				cbView.setLocationRelativeTo(null);
				cbView.setModal(true);
				cbView.setVisible(true);
				System.out.println("View Combo on row "+row);
				
			}
			
		};


		tblCombo = new JTable(getTableModel());
		tblCombo.setRowHeight(33);
		tblCombo.getColumnModel().getColumn(3).setCellRenderer(new TableActionCellRender());
		tblCombo.getColumnModel().getColumn(3).setCellEditor(new TableActionCellEditor(tableActionEvent));
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
		tblCombo.getColumnModel().getColumn(3).setCellRenderer(new TableActionCellRender());
		tblCombo.getColumnModel().getColumn(3).setCellEditor(new TableActionCellEditor(tableActionEvent));
		
	}
}
