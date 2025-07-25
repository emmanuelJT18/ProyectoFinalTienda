package views;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
//import net.miginfocom.swing.MigLayout;
import views.compVisuales.LblMenuTab;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;

import logic.Utilidad;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PFacturaView extends JPanel {
	private JPanel pContainerForViews;
	/**
	 * Create the panel.
	 */
	public PFacturaView() {
		setPreferredSize(new Dimension(1100,800));
		setLayout(null);
		
		JPanel pMenuBar = new JPanel();
		pMenuBar.setLocation(0, 0);
		pMenuBar.setBackground(new Color(205, 206, 210));
		pMenuBar.setSize(1100,60);
		add(pMenuBar);
		
		pContainerForViews = new JPanel();
		pContainerForViews.setBounds(
				Utilidad.xlocationForChildPanelView, 
				Utilidad.ylocationForChildPanelView, 
				Utilidad.witdhForChildPanelView, 
				Utilidad.heightForChildPanelView
		);
		pContainerForViews.setLayout(new BorderLayout(0, 0));
		add(pContainerForViews);
		
		JPanel crearFacturaView = new PCrearFactura();
		LblMenuTab lblFacturar = new LblMenuTab("Facturar", pContainerForViews, crearFacturaView);
		lblFacturar.presentedAsPressed();
		lblFacturar.setBounds(12, 13, 119, 47);
		
		JPanel reporteFacturaView = new PReporteFactura();
		LblMenuTab lblReportes = new LblMenuTab("Reportes", pContainerForViews, reporteFacturaView);
		lblReportes.setBounds(130, 13, 119, 47);
		pMenuBar.setLayout(null);
		pMenuBar.add(lblFacturar);
		pMenuBar.add(lblReportes);
		
		JLabel lblFacturasContianer = new JLabel("FacturasContainer");
		pContainerForViews.add(lblFacturasContianer);
		
		showCreateFacturaPanel();
	}
	
	public void showCreateFacturaPanel() {
		pContainerForViews.add(new PCrearFactura());
	}
}
