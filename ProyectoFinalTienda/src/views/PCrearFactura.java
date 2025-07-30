package views;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import logic.Cliente;
import logic.Combo;
import logic.Componente;
import logic.DetalleFactura;
import logic.DiscoDuro;
import logic.Factura;
import logic.Tienda;
import logic.Utilidad;
import views.compVisuales.LblMenuTab;
import views.compVisuales.SingleButtonCellRenderer;
import views.compVisuales.SingleButtonCellEditor;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;

import connection.DetalleFacturaDAO;
import connection.FacturaDAO;

import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class PCrearFactura extends JPanel {
	private JTextField txtIdComponente;
	private JTextField txtNombre;
	private JTextField txtPrecio;
	private JTextField txtCantidadDisponible;
	private JTextField txtCantidadVender;
	private JTextField txtNombreCliente;
	private JTextField txtClienteDireccion;
	private JTextField txtIdCliente;
	private JTable tblDetalleFactura;
	private ArrayList<Componente> detalleFactura;
	private ArrayList<DetalleFactura> detalles;
	private Tienda controller = Tienda.getInstance();
	private Componente componenteBuscado = null;
	//private Factura factura;
	private Cliente clienteBuscado = null;
	private Map<String, Integer> codigoAndIndex; //This will store the component's codigo and its rowIndex
	private double totalFactura;
	private JLabel lblTotalValue;
	private JComboBox<Combo> cbxCombos;

	/**
	 * Create the panel.
	 */

	public PCrearFactura() {
		
		totalFactura = 0.0;
		detalleFactura = new ArrayList<Componente>();
		detalles = new ArrayList<DetalleFactura>();
		codigoAndIndex = new HashMap<String, Integer>();

		setBounds(
				Utilidad.xlocationForChildPanelView, 
				Utilidad.ylocationForChildPanelView, 
				Utilidad.witdhForChildPanelView, 
				Utilidad.heightForChildPanelView
				);
		setLayout(null);		
		JPanel pComponente = new JPanel();
		pComponente.setBounds(34, 13, 639, 191);
		add(pComponente);
		pComponente.setLayout(null);

		JLabel lblComponenteId = new JLabel("Componente ID");
		lblComponenteId.setBounds(2, 10, 111, 16);
		pComponente.add(lblComponenteId);

		txtIdComponente = new JTextField();
		txtIdComponente.setBounds(103, 7, 116, 22);
		pComponente.add(txtIdComponente);
		txtIdComponente.setColumns(10);

		JButton btnSearchComponente = new JButton("Buscar Componente");
		btnSearchComponente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					componenteBuscado = controller.searchComponente(txtIdComponente.getText());
					if(componenteBuscado.getCantDisponible() < 1) {
						JOptionPane.showConfirmDialog(null, "Se ha agotado este componente.");
						return;
					}

					txtIdComponente.setText(componenteBuscado.getCodigo());      
					txtNombre.setText(componenteBuscado.getMarca());            
					txtPrecio.setText(String.valueOf(componenteBuscado.getPrecio()));            
					txtCantidadDisponible.setText(String.valueOf(componenteBuscado.getCantDisponible()));
					txtCantidadVender.setText("1");
				}catch(Exception e) {
					JOptionPane.showConfirmDialog(null, "Introduce un codigo válido.");
				}

			}
		});
		btnSearchComponente.setBounds(243, 9, 206, 33);
		pComponente.add(btnSearchComponente);

		JLabel lblNombreComponente = new JLabel("Nombre");
		lblNombreComponente.setBounds(2, 48, 111, 16);
		pComponente.add(lblNombreComponente);

		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setColumns(10);
		txtNombre.setBounds(59, 45, 160, 22);
		pComponente.add(txtNombre);

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(3, 90, 111, 16);
		pComponente.add(lblPrecio);

		txtPrecio = new JTextField();
		txtPrecio.setEnabled(true);
		txtPrecio.setEditable(false);
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(59, 87, 160, 22);
		pComponente.add(txtPrecio);

		JButton btnAddComponente = new JButton("Agregar");
		btnAddComponente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cantVender = 1;
				try {
					cantVender = Integer.parseInt(txtCantidadVender.getText());
					if(cantVender < 1) {
						JOptionPane.showConfirmDialog(null, "Ingresa un numero mayor a cero.");
						txtCantidadVender.setText("1");
						return;
					}

				}catch(Exception ex) {
					cantVender = 0;
					JOptionPane.showConfirmDialog(null, "Ingresa un digito");

				}

				if(componenteBuscado == null) {
					return;
				} else if(codigoAndIndex.containsKey(componenteBuscado.getCodigo())) {
					if(cantVender > componenteBuscado.getCantDisponible()) {
						JOptionPane.showConfirmDialog(null, "La cantidad a vender es mayor a la disponible.");
						return;
					}
					modifyCantOnTable(
							codigoAndIndex.get(componenteBuscado.getCodigo()),
							cantVender
							);

				}else if(cantVender > componenteBuscado.getCantDisponible()) {
					JOptionPane.showConfirmDialog(null, "La cantidad a vender es mayor a la disponible.");
					return;
				}else{

					codigoAndIndex.put(componenteBuscado.getCodigo(), tblDetalleFactura.getRowCount());
					detalleFactura.add(componenteBuscado);
					updateTable();
				}


				updateTotalFactura();
				txtNombre.setText(null);
				txtPrecio.setText(null);
				txtCantidadDisponible.setText(null);
				txtCantidadVender.setText(null);
				componenteBuscado = null;

			}
		});
		btnAddComponente.setBounds(12, 139, 97, 25);
		pComponente.add(btnAddComponente);

		JButton btnDeleteComponente = new JButton("borrar");
		btnDeleteComponente.setBounds(134, 139, 97, 25);
		pComponente.add(btnDeleteComponente);

		JLabel lblCantidadDisponible = new JLabel("Cant. Disponible");
		lblCantidadDisponible.setBounds(239, 51, 111, 16);
		pComponente.add(lblCantidadDisponible);

		txtCantidadDisponible = new JTextField();
		txtCantidadDisponible.setEditable(false);
		txtCantidadDisponible.setColumns(10);
		txtCantidadDisponible.setBounds(338, 48, 111, 22);
		pComponente.add(txtCantidadDisponible);

		JLabel lblCantidadVender = new JLabel("Cant. a Vender");
		lblCantidadVender.setBounds(239, 93, 111, 16);
		pComponente.add(lblCantidadVender);

		txtCantidadVender = new JTextField();
		txtCantidadVender.setEditable(true);
		txtCantidadVender.setColumns(10);
		txtCantidadVender.setBounds(338, 90, 111, 22);
		pComponente.add(txtCantidadVender);

		cbxCombos = new JComboBox();
		cbxCombos.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        Combo comboSeleccionado = (cbxCombos.getSelectedIndex() > 0) ? (Combo) cbxCombos.getSelectedItem() : null;
		        if (comboSeleccionado != null) {
		        	updateTable(comboSeleccionado);

		        }
		    }
		});
		cbxCombos.setBounds(338, 140, 185, 22);
		pComponente.add(cbxCombos);

		JLabel lblCombo = new JLabel("Combos");
		lblCombo.setBounds(252, 143, 111, 16);
		pComponente.add(lblCombo);

		JLabel lblDate = new JLabel("dd/mm/aaaa");
		lblDate.setText(String.valueOf(LocalDate.now()));
		lblDate.setBounds(514, 10, 82, 16);
		pComponente.add(lblDate);

		JPanel pCliente = new JPanel();
		pCliente.setBounds(696, 13, 372, 191);
		add(pCliente);
		pCliente.setLayout(null);

		JLabel lblNombreCliente = new JLabel("Nombre");
		lblNombreCliente.setBounds(12, 53, 111, 16);
		pCliente.add(lblNombreCliente);

		txtNombreCliente = new JTextField();
		txtNombreCliente.setEditable(false);
		txtNombreCliente.setColumns(10);
		txtNombreCliente.setBounds(82, 50, 251, 22);
		pCliente.add(txtNombreCliente);

		JLabel lblClienteDireccion = new JLabel("Direccion");
		lblClienteDireccion.setBounds(13, 95, 111, 16);
		pCliente.add(lblClienteDireccion);

		txtClienteDireccion = new JTextField();
		txtClienteDireccion.setEnabled(true);
		txtClienteDireccion.setEditable(false);
		txtClienteDireccion.setColumns(10);
		txtClienteDireccion.setBounds(82, 92, 251, 22);
		pCliente.add(txtClienteDireccion);

		JLabel lblClienteId = new JLabel("Cliente");
		lblClienteId.setBounds(12, 16, 111, 16);
		pCliente.add(lblClienteId);

		txtIdCliente = new JTextField();
		txtIdCliente.setColumns(10);
		txtIdCliente.setBounds(82, 13, 126, 22);
		pCliente.add(txtIdCliente);

		JButton btnSearchCliente = new JButton("buscar");
		btnSearchCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clienteBuscado = controller.searchCliente(txtIdCliente.getText());
				if(clienteBuscado == null) {
					JOptionPane.showConfirmDialog(null, "Introduce un codigo del cliente valido.");
					return;
				}
				txtNombreCliente.setText(clienteBuscado.getNombre());
				txtClienteDireccion.setText(clienteBuscado.getDireccion());
			}
		});
		btnSearchCliente.setBounds(222, 8, 111, 33);
		pCliente.add(btnSearchCliente);

		tblDetalleFactura = new JTable(getTableModel());
		JScrollPane scrollPane = new JScrollPane(tblDetalleFactura);
		scrollPane.setBounds(34,217,1034, 330);
		add(scrollPane);

		JLabel lblTotalName = new JLabel("Total");
		lblTotalName.setBounds(755, 592, 56, 16);
		add(lblTotalName);

		lblTotalValue = new JLabel("$0.00");
		lblTotalValue.setBounds(850, 592, 133, 16);
		add(lblTotalValue);

		JButton btnFacturar = new JButton("Facturar");
		btnFacturar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				createFactura();
			}
		});
		btnFacturar.setBackground(Color.GREEN);
		btnFacturar.setBounds(755, 633, 313, 54);
		add(btnFacturar);

		JButton btnCancel = new JButton("Cancelar");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cleanFields();
			}
		});
		btnCancel.setBackground(Color.RED);
		btnCancel.setBounds(430, 633, 313, 54);
		add(btnCancel);
		fillCbxCombos();

	}

	private void modifyCantOnTable(int rowIndex, int newCant) {

		double precio = 0.0; double newTotal = 0.0; 
		int precioColIndex = 0; int cantidadVenderColIndex = 0; int totalColIndex = 0; int oldCant = 0;
		precioColIndex = tblDetalleFactura.getColumnModel().getColumnIndex("Precio");
		cantidadVenderColIndex = tblDetalleFactura.getColumnModel().getColumnIndex("Cant.");
		totalColIndex = tblDetalleFactura.getColumnModel().getColumnIndex("Total Por Comp.");

		oldCant = (int) tblDetalleFactura.getValueAt(rowIndex, cantidadVenderColIndex);
		precio = (double) tblDetalleFactura.getValueAt(rowIndex, precioColIndex);

		newCant += oldCant;
		newTotal = newCant * precio;

		tblDetalleFactura.setValueAt(newCant, rowIndex, cantidadVenderColIndex);
		tblDetalleFactura.setValueAt(newTotal, rowIndex, totalColIndex);

	}

	private void updateTotalFactura() {
		double total = 0.0;
		int colIndex = tblDetalleFactura.getColumnModel().getColumnIndex("Total Por Comp.");
		for(int rowIndex = 0; rowIndex < tblDetalleFactura.getRowCount(); rowIndex++) {
			total += (double) tblDetalleFactura.getValueAt(rowIndex, colIndex);
		}
		totalFactura = total;
		lblTotalValue.setText(String.valueOf(total));
	}


	private DefaultTableModel getTableModel() {
		String[] columns = {"Cod.", "Marca", "Precio", "Desc.", "Cant.","Total Por Comp.", "Quitar Comp."};
		DefaultTableModel model = new DefaultTableModel(columns, 0);

		return model;
	}

	private void createFactura() {
		if(tblDetalleFactura.getRowCount() < 1 || clienteBuscado == null) {
			JOptionPane.showConfirmDialog(null, "Inserta los datos requeridos para facturar");
			return;
		}
		Factura factura = new Factura(controller.genCodigoFactura(), clienteBuscado, totalFactura);
		controller.createFactura(factura);
		fillDetalleFacturas(factura);
		cleanFields();
	}

	public void cleanFields() {
		txtIdComponente.setText("");     
		txtNombreCliente.setText("");      
		txtClienteDireccion.setText("");
		txtCantidadVender.setText("0");
		txtIdCliente.setText("");
		detalleFactura = new ArrayList<Componente>();
		codigoAndIndex = new HashMap<String, Integer>();
		clienteBuscado = null;
		totalFactura = 0.0;
		lblTotalValue.setText("$0.00");
		cbxCombos.setSelectedIndex(0);
		tblDetalleFactura.setModel(getTableModel());
	}

	private void updateTable() {
		DefaultTableModel updatedModel = (DefaultTableModel) tblDetalleFactura.getModel();
		int btnCol = tblDetalleFactura.getColumnCount()-1;
		int cantidadVender = Integer.parseInt(txtCantidadVender.getText());
		double totalPorComponente = (double) cantidadVender * componenteBuscado.getPrecio();
		
		Object[] rowData = {
				componenteBuscado.getCodigo(),
				componenteBuscado.getMarca(),
				componenteBuscado.getPrecio(),
				"0%",
				cantidadVender,
				totalPorComponente,
		};
		tblDetalleFactura.getColumnModel().getColumn(btnCol).setCellRenderer(new SingleButtonCellRenderer("eliminar"));
		tblDetalleFactura.getColumnModel().getColumn(btnCol).setCellEditor(
				new SingleButtonCellEditor("Eliminar", row -> {
					eliminateRow(row);
					deleteCombosOnCascade();
			    })
		);
		updatedModel.addRow(rowData);
		tblDetalleFactura.setModel(updatedModel);
	}
	
	private void eliminateRow(int row) {
		DefaultTableModel model = (DefaultTableModel) tblDetalleFactura.getModel();
        if (row >= 0 && row < model.getRowCount()) {
			String codigoComponente = (String) tblDetalleFactura.getValueAt(row, 0);
			codigoAndIndex.remove(codigoComponente);
            model.removeRow(row);
        }
	}
	
	private void fillDetalleFacturas(Factura factura) {
		//String[] columns = {"Cod.", "Marca", "Precio", "Desc.", "Cant.","Total Por Comp.", "Quitar Comp."};
		for(int row = 0; row < tblDetalleFactura.getRowCount(); row++) {
			String codigo = (String) tblDetalleFactura.getValueAt(row, 0);
			Componente componente = controller.searchComponente(codigo);
			String descuentoStr = (String) tblDetalleFactura.getValueAt(row, 3);
			double descuento = Double.parseDouble(descuentoStr.replace("%", ""));
			Object valor = tblDetalleFactura.getValueAt(row, 4);
			int cantidadVender = (int) tblDetalleFactura.getValueAt(row, 4);
	
			double totalPorComponente = (double) tblDetalleFactura.getValueAt(row, 5);
			
			DetalleFactura detalle = new DetalleFactura(factura.getId(), componente, descuento, cantidadVender, totalPorComponente);
			DetalleFacturaDAO.insertDetalleFactura(detalle);
			detalles.add(detalle);	
		}
	}
	
	private void fillCbxCombos() {
		cbxCombos.addItem(new Combo() {
			@Override
			public String toString() {
				return "Seleccione un combo";
			}
		});
		for(Combo c : controller.getCombos()) {
			cbxCombos.addItem(c);
		}
	}
	private void updateTable(Combo combo) {
		DefaultTableModel updatedModel = (DefaultTableModel) tblDetalleFactura.getModel();
		int btnCol = tblDetalleFactura.getColumnCount()-1;
		int cantidadVender = 1;
		
		for(Componente c : combo.getComponentes()) {
			Object[] rowData = {
					c.getCodigo(),
					c.getMarca(),
					c.getPrecio(),
					(combo.getDescuento()*100)+"%",
					cantidadVender,
					controller.componenteTotalNeto(c.getPrecio(), combo.getDescuento()),
			};
			updatedModel.addRow(rowData);
		}
		tblDetalleFactura.getColumnModel().getColumn(btnCol).setCellRenderer(new SingleButtonCellRenderer("eliminar"));
		tblDetalleFactura.getColumnModel().getColumn(btnCol).setCellEditor(
				new SingleButtonCellEditor("Eliminar", row -> {
					eliminateRow(row);
					deleteCombosOnCascade();
			    })
		);
		updateTotalFactura();
	}

	private void deleteCombosOnCascade() {
		DefaultTableModel model = (DefaultTableModel) tblDetalleFactura.getModel();
		String identifier = "0%"; 

		for (int i = model.getRowCount() - 1; i >= 0; i--) {
		    Object valor = model.getValueAt(i, 3); 
		    if (valor != null && valor.toString() != identifier) {
		        model.removeRow(i);
		    }
		}
		updateTotalFactura();
	}
}
