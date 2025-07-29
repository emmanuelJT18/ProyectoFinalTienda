package views.compVisuales;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class SingleButtonCellRenderer extends JButton implements TableCellRenderer{
	public SingleButtonCellRenderer(String text) {
		super(text);
	}

	@Override
	public Component getTableCellRendererComponent(
			JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) 
	{
		return this;
	}
}
