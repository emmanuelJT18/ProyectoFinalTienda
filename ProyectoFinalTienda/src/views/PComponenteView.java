package views;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import logic.Utilidad;
import views.compVisuales.TableActionCellEditor;
import views.compVisuales.TableActionCellRender;
import views.compVisuales.TableActionEvent;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import logic.Componente;
import logic.DiscoDuro;
import logic.MemoriaRam;
import logic.MicroProcesador;
import logic.TarjetaMadre;
import logic.Tienda;

import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;

public class PComponenteView extends JPanel {
	private Tienda controller = Tienda.getInstance();
	private JTable table;
	private JComboBox cbxTiposComponentes;
	private TableActionEvent tableActionEvent;

	/**
	 * Create the panel.
	 */
	public PComponenteView() {
		
		setPreferredSize(
				new Dimension(
						Utilidad.witdhForParentPanelView,
						Utilidad.heightForParentPanelView
				)
		);
		setLayout(new BorderLayout(0, 0));
		
		JPanel pActions = new JPanel();
		pActions.setPreferredSize(new Dimension(super.getWidth(), 200));
		add(pActions, BorderLayout.NORTH);
		
		JButton btnNuevoComponente = new JButton("Nuevo Componente");
		btnNuevoComponente.setBounds(392, 82, 143, 25);
		btnNuevoComponente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//DGCrearMicroProcesador crearMicroProcesadorView = new DGCrearMicroProcesador(PComponenteView.this);
				//crearMicroProcesadorView.setVisible(true);
				
				openViewForNewComponent();
			}
		});
		pActions.setLayout(null);
		pActions.add(btnNuevoComponente);
		
		cbxTiposComponentes = new JComboBox();
		cbxTiposComponentes.setModel(new DefaultComboBoxModel(new String[] {"seleccione", "Microprocesador", "Tarjeta Madre", "Memoria RAM", "Disco Duro"}));
		cbxTiposComponentes.setBounds(231, 83, 119, 22);
		pActions.add(cbxTiposComponentes);
		
		JLabel lblNewLabel = new JLabel("Tipo de Componente");
		lblNewLabel.setBounds(100, 86, 119, 16);
		pActions.add(lblNewLabel);
		 
		JPanel pShowData = new JPanel();
		add(pShowData, BorderLayout.CENTER);
		pShowData.setLayout(null);
		
	    tableActionEvent = new TableActionEvent() {
			/*@Override
			public void onEdit(int row) {
				System.out.println("Edit row: "+row);
			}*/

			@Override
			public void onDelete(int row) {
				System.out.println("Delete Componente on row: "+row);
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onView(int row) {
				Componente com = controller.getComponentes().get(row);
				JDialog dg = new JDialog();
				if(com instanceof DiscoDuro) {
					 dg = new DGVerDiscoDuro((DiscoDuro) com, PComponenteView.this);
				} else if (com instanceof MemoriaRam) {
					 dg = new DGVerMemoriaRam((MemoriaRam) com, PComponenteView.this);
				} else if (com instanceof MicroProcesador) {
					dg = new DGVerMicroProcesadores((MicroProcesador) com,PComponenteView.this);
				} else if (com instanceof TarjetaMadre) {
					dg = new DGVerTarjetaMadre((TarjetaMadre) com, PComponenteView.this);
				}
				dg.setLocationRelativeTo(null);
				dg.setModal(true);
				dg.setVisible(true);
				
				System.out.println("View Componente on row: "+row);

				// TODO Auto-generated method stub
				
			}
		};
		table = new JTable(getTableModel());
		table.setRowHeight(33);
		table.getColumnModel().getColumn(6).setCellRenderer(new TableActionCellRender());
		table.getColumnModel().getColumn(6).setCellEditor(new TableActionCellEditor(tableActionEvent));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(30, 0, 1047, 400);
		pShowData.add(scrollPane/*, BorderLayout.CENTER*/);
		
	}
	
	private DefaultTableModel getTableModel() {

		String[] columns = {"ID", "Num. Serie", "Marca", "Modelo", "Precio", "Stock", "Acciones"};
		DefaultTableModel model = new DefaultTableModel(columns, 0) {
		    @Override
		    public boolean isCellEditable(int row, int column) {
		        return column == 6; 
		    }

		};
		
		for(Componente c : controller.getComponentes()) {
			Object[] row = {
					c.getCodigo(),
					c.getNumeroSerie(),
					c.getMarca(),
					c.getModelo(),
					c.getPrecio(),
					c.getCantDisponible(),
			};
			model.addRow(row);
		}
		return model;
	}
	
	public void updateTable() {
		DefaultTableModel updatedModel = getTableModel();
		table.setModel(updatedModel);
		table.getColumnModel().getColumn(6).setCellRenderer(new TableActionCellRender());
		table.getColumnModel().getColumn(6).setCellEditor(new TableActionCellEditor(tableActionEvent));
	}
	
	private void openViewForNewComponent() {
		JDialog createComponentForm;
		DGCrearMicroProcesador microProcesadorForm = new DGCrearMicroProcesador(PComponenteView.this);
		DGCrearTarjetaMadre tarjetaMadreForm = new DGCrearTarjetaMadre(PComponenteView.this);
		DGCrearMemoriaRAM memoriaRAMForm = new DGCrearMemoriaRAM(PComponenteView.this);
		DGCrearDiscoDuro discoDuroForm = new DGCrearDiscoDuro(PComponenteView.this);
		
		JDialog[] forms = { microProcesadorForm, tarjetaMadreForm, memoriaRAMForm, discoDuroForm };
		
		if(cbxTiposComponentes.getSelectedIndex() != 0) {
			createComponentForm = forms[cbxTiposComponentes.getSelectedIndex()-1];
			createComponentForm.setLocationRelativeTo(null);
			createComponentForm.setModal(true);
			createComponentForm.setVisible(true);
		}
	}
}
