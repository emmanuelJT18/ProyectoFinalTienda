package views.compVisuales;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class PanelAction extends JPanel {
	//private ActionButton btnEdit;
	private ActionButton btnView;
	private ActionButton btnDelete;

	/**
	 * Create the panel.
	 */
	
	public PanelAction() {
		setLayout(null);
		//btnEdit = new ActionButton("E");
		//btnEdit.setBounds(2, 5, 48, 25);
		//add(btnEdit);
		btnView = new ActionButton("V");
		btnView.setIcon(new ImageIcon("img/eye.png"));
		btnView.setText("");
		btnView.setBounds(12, 5, 55, 25);
		add(btnView);
		btnDelete = new ActionButton("D");
		btnDelete.setIcon(new ImageIcon("img/delete.png"));
		btnDelete.setText("");
		btnDelete.setBounds(83, 5, 55, 25);
		add(btnDelete);
	}

	public void initEvent(TableActionEvent event, int row) {
		/*btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				event.onEdit(row);
			}
		});*/
		
		btnView.addActionListener(new ActionListener() {
			@Override 
			public void actionPerformed(ActionEvent ae) {
				event.onView(row);
			}
		});
		
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				event.onDelete(row);
			}
		});
		
	}
	
	

}
