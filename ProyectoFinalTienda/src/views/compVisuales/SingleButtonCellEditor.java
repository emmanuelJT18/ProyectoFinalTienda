package views.compVisuales;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.IntConsumer;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class SingleButtonCellEditor extends DefaultCellEditor {
	private JButton button;
	private IntConsumer onClick;
	private int row;

	public SingleButtonCellEditor(String text, IntConsumer onClick) {
		super(new JCheckBox());
		 this.onClick = onClick;
		 
		 button = new JButton(text);
		 button.addActionListener(new ActionListener() {
			 @Override
			 public void actionPerformed(ActionEvent e) {
				 fireEditingStopped();
			 }
		 });
	}
	
	@Override
	public Component getTableCellEditorComponent(
			JTable table, Object value, boolean isSelected, int row, int column) {
		this.row = row;
		return button;
	}
	
	@Override
	public Object getCellEditorValue() {
		if(onClick != null) {
			onClick.accept(row);
		}
		return null;
	}
	
}
