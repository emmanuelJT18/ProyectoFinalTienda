package views;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import logic.Cliente;
import logic.Componente;
import logic.Tienda;
import logic.Utilidad;
import views.compVisuales.TableActionCellEditor;
import views.compVisuales.TableActionCellRender;
import views.compVisuales.TableActionEvent;

import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import connection.ClienteDAO;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class PClienteView extends JPanel {
	private Tienda controller;
	private JTextField txtParameter;
	private JTable tblClientes;
	TableActionEvent tableActionEvent;

	/**
	 * Create the panel.
	 */
	public PClienteView() {
		controller = Tienda.getInstance();
		setPreferredSize(
				new Dimension(
						Utilidad.witdhForParentPanelView,
						Utilidad.heightForParentPanelView
				)
		);
		setLayout(null);
		
		JPanel pActions = new JPanel();
		pActions.setBounds(0, 0, 1100, 178);
		add(pActions);
		pActions.setLayout(null);
		
		txtParameter = new JTextField();
		txtParameter.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				DefaultTableModel tableModel = (DefaultTableModel) tblClientes.getModel();
				TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<>(tableModel);
				tblClientes.setRowSorter(rowSorter);
				rowSorter.setRowFilter(RowFilter.regexFilter(txtParameter.getText()));
			}
		});
		txtParameter.setBounds(215, 80, 234, 22);
		pActions.add(txtParameter);
		txtParameter.setColumns(10);
		
		JButton btnNewCliente = new JButton("Nuevo");
		btnNewCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DGCrearCliente newClienteForm = new DGCrearCliente(PClienteView.this);
				newClienteForm.setLocationRelativeTo(null);
				newClienteForm.setModal(true);
				newClienteForm.setVisible(true);
			}
		});
		btnNewCliente.setBounds(702, 79, 129, 25);
		pActions.add(btnNewCliente);
		
		JLabel lblNewLabel = new JLabel("Buscar Cliente");
		lblNewLabel.setBounds(66, 83, 104, 16);
		pActions.add(lblNewLabel);
		
		JLabel lblCrearCliente = new JLabel("Crear Cliente");
		lblCrearCliente.setBounds(585, 83, 104, 16);
		pActions.add(lblCrearCliente);
		
		JPanel pParentContainer = new JPanel();
		pParentContainer.setBounds(0, 179, 1100, 621);
		add(pParentContainer);
		pParentContainer.setLayout(null);
		tableActionEvent = new TableActionEvent() {

			@Override
			public void onDelete(int row) {
				DefaultTableModel model = (DefaultTableModel) getTableModel();
				if (row != -1) { // -1 = there's no selected row 
				    model.removeRow(row);
				} else {
				    JOptionPane.showMessageDialog(null, "Please select a row to delete.");
				}
				String codigo = (String) tblClientes.getValueAt(row, 0);
				ClienteDAO.deleteCliente(codigo);
				updateTable();
				System.out.println("Delete Cliente on row "+row);
			}

			@Override
			public void onView(int row) {
				Cliente cliente = controller.getClientes().get(row);
				DGVerCliente verCliente = new DGVerCliente(PClienteView.this, cliente);
				verCliente.setLocationRelativeTo(null);
				verCliente.setModal(true);
				verCliente.setVisible(true);
				System.out.println("View Cliente on row "+row);
				
			}
			
		};
		tblClientes = new JTable(getTableModel());
		tblClientes.setRowHeight(33);
		tblClientes.getColumnModel().getColumn(4).setCellRenderer(new TableActionCellRender());
		tblClientes.getColumnModel().getColumn(4).setCellEditor(new TableActionCellEditor(tableActionEvent));
		JScrollPane scrollPane = new JScrollPane(tblClientes);
		scrollPane.setBounds(85, 10, 927, 419);
		pParentContainer.add(scrollPane);
		
	}
	
	private DefaultTableModel getTableModel() {
		String[] columns = {"Cod.", "Nombre", "Telefono", "Direccion", "Acciones"};
		
		DefaultTableModel model = new DefaultTableModel(columns, 0) {
		    @Override
		    public boolean isCellEditable(int row, int column) {
		        return column == 4; 
		    }
		};
		
		for (Cliente c : controller.getClientes()) {
			Object[] row = {
				c.getCodigo(),
				c.getNombre(),
				c.getTelefono(),
				c.getDireccion(),
				
			};
			model.addRow(row);
		}
		return model;
	}
	
	public void updateTable() {
		DefaultTableModel updatedModel = getTableModel(); 
		tblClientes.setModel(updatedModel);
		tblClientes.getColumnModel().getColumn(4).setCellRenderer(new TableActionCellRender());
		tblClientes.getColumnModel().getColumn(4).setCellEditor(new TableActionCellEditor(tableActionEvent));
	}
}
