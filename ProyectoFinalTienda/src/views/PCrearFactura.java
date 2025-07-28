package views;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import logic.Cliente;
import logic.Componente;
import logic.DiscoDuro;
import logic.Factura;
import logic.Tienda;
import logic.Utilidad;
import views.compVisuales.LblMenuTab;

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
	private Tienda controller = Tienda.getInstance();
	private Componente componenteBuscado = null;
	private Cliente clienteBuscado = null;
	private Map<String, Integer> codigoAndIndex; //This will store the component's codigo and its rowIndex
	private double totalFactura;
	private JLabel lblTotalValue;

	/**
	 * Create the panel.
	 */
	

	
	public PCrearFactura() {
		totalFactura = 0.0;
		detalleFactura = new ArrayList<Componente>();
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
					JOptionPane.showConfirmDialog(null, "Introduce un codigo v�lido.");
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
				int cantVender = Integer.parseInt(txtCantidadVender.getText());
			
				if(componenteBuscado == null) {
					return;
				} else if(codigoAndIndex.containsKey(componenteBuscado.getCodigo())) {
					if(cantVender > componenteBuscado.getCantDisponible()) {
						JOptionPane.showConfirmDialog(null, "La cantidad a vender es mayor a la disponible.");
						return;
					}
					modifyCantOnTable(
							codigoAndIndex.get(componenteBuscado.getCodigo()), 
							Integer.parseInt(txtCantidadVender.getText())
					);
					
				}else if(cantVender > componenteBuscado.getCantDisponible()) {
					JOptionPane.showConfirmDialog(null, "La cantidad a vender es mayor a la disponible.");
					return;
				}else{
					if(cantVender < 1) {
						JOptionPane.showConfirmDialog(null, "Ingresa un numero mayor a cero.");
						txtCantidadVender.setText("1");
						return;
					}
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
		
		JComboBox cbxCombos = new JComboBox();
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
		lblTotalValue.setBounds(850, 592, 56, 16);
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
		btnCancel.setBackground(Color.RED);
		btnCancel.setBounds(430, 633, 313, 54);
		add(btnCancel);

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
	/*
	private int getRowIndexByCodigo(String codigoComponente) {
		for(int rowIndex = 0; rowIndex < tblDetalleFactura.getRowCount(); rowIndex++) {
			String codigoOnTable = String.valueOf(tblDetalleFactura.getValueAt(rowIndex, 0));
			if(codigoOnTable.equalsIgnoreCase(codigoComponente)) {
				return rowIndex;
			}
		}
		return -1;
	}*/
	
	private DefaultTableModel getTableModel() {
		String[] columns = {"Cod.", "Marca", "Precio", "Desc.", "Cant.","Total Por Comp.", "Quitar Comp."};
		DefaultTableModel model = new DefaultTableModel(columns, 0);
		
		/*for(Componente componente : detalleFactura) {
			int cantidadVender = Integer.parseInt(txtCantidadVender.getText());
			double totalPorComponente = (double) cantidadVender * componente.getPrecio();
			Object[] row = {
				componente.getCodigo(),
				componente.getMarca(),
				componente.getPrecio(),
				"0%",
				cantidadVender,
				totalPorComponente,
				"Eliminar"
			};
			model.addRow(row);
		}*/
		return model;
	}
	
	private void createFactura() {
		if(tblDetalleFactura.getRowCount() < 1 || clienteBuscado == null) {
			JOptionPane.showConfirmDialog(null, "Inserta los datos requeridos para facturar");
			return;
		}
		Factura factura = new Factura(controller.genCodigoFactura(), clienteBuscado, totalFactura);
		controller.createFactura(factura);
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
		tblDetalleFactura.setModel(getTableModel());
	}
	
	private void updateTable() {
		DefaultTableModel updatedModel = (DefaultTableModel) tblDetalleFactura.getModel();

		int cantidadVender = Integer.parseInt(txtCantidadVender.getText());
		double totalPorComponente = (double) cantidadVender * componenteBuscado.getPrecio();
		Object[] rowData = {
			componenteBuscado.getCodigo(),
			componenteBuscado.getMarca(),
			componenteBuscado.getPrecio(),
			"0%",
			cantidadVender,
			totalPorComponente,
			"Eliminar"
		};
		updatedModel.addRow(rowData);
		tblDetalleFactura.setModel(updatedModel);
	}
}
