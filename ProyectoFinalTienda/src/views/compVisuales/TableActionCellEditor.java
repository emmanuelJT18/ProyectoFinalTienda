package views.compVisuales;

import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class TableActionCellEditor extends DefaultCellEditor{
	
	private TableActionEvent event;
	
	public TableActionCellEditor(TableActionEvent event) {
		super(new JCheckBox());
		this.event = event;
	}

	@Override
	public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int i, int i1) {
		PanelAction pAction = new PanelAction();
		pAction.initEvent(event, i);
		return pAction;
	}
}
