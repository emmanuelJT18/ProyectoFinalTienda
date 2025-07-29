package views.compVisuales;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.IntConsumer;

public class SingleBtnCellEditor extends DefaultCellEditor {
    private JButton button;
    private IntConsumer onClick; // Función que acepta el número de fila

    public SingleBtnCellEditor(String text, IntConsumer onClick) {
        super(new JCheckBox()); // Necesario por DefaultCellEditor
        this.onClick = onClick;

        button = new JButton(text);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // El row se pasa más abajo
                fireEditingStopped();
            }
        });
    }

    private int row;

    @Override
    public Component getTableCellEditorComponent( 
    		JTable table, Object value, boolean isSelected, int row, int column
    ) {
        this.row = row;
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        if (onClick != null) {
            onClick.accept(row);
        }
        return null;
    }
}
