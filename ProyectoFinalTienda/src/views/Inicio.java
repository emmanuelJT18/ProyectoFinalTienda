package views;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import views.compVisuales.BtnForSideMenu;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;
import logic.Utilidad;


public class Inicio extends JFrame {

	private JPanel contentPane;
	private static JPanel pParentContainer = new JPanel();
	private JPanel pNorthContainer = new JPanel();
	private JPanel pWestContainer = new JPanel();
	private JButton btnGoToInicio;
	private JButton btnGoToFactura;
	private JButton btnGoToComponente;
	private final JLabel lblNombreSistema = new JLabel("EJM Electronica");
	private final JLabel lblCerrarSesion = new JLabel("Cerrar Sesion");
	private final JLabel lblLogo = new JLabel("");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					
					System.out.println(pParentContainer.getLocationOnScreen());
					System.out.println("Ancho: " + pParentContainer.getWidth());
					System.out.println("Alto: " + pParentContainer.getHeight());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Inicio() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1436, 936);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlLtHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		pNorthContainer.setBackground(new Color(0,2,61));
		pNorthContainer.setPreferredSize(new Dimension(700,70));
		contentPane.add(pNorthContainer, BorderLayout.NORTH);
		pNorthContainer.setLayout(new BorderLayout(0, 0));
		
		lblNombreSistema.setFont(new Font("Arial", Font.BOLD, 40));
		lblNombreSistema.setForeground(Color.WHITE);
		pNorthContainer.add(lblNombreSistema, BorderLayout.CENTER);
		
		lblCerrarSesion.setFont(new Font("Arial", Font.BOLD, 20));
		lblCerrarSesion.setForeground(Color.WHITE);
		pNorthContainer.add(lblCerrarSesion, BorderLayout.EAST);
		

		pWestContainer.setBackground(new Color(7, 12, 59));
		pWestContainer.setPreferredSize(new Dimension(300,700));
		contentPane.add(pWestContainer, BorderLayout.WEST);
		
		btnGoToInicio = new BtnForSideMenu("Inicio");
		btnGoToInicio.setBounds(0, 191, 300, 49);
		btnGoToInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PInicioView viewInicio = new PInicioView();
				Utilidad.showMyPanel(pParentContainer, viewInicio);
			}
		});
		
		btnGoToFactura = new BtnForSideMenu("Facturas");
		btnGoToFactura.setBounds(0, 253, 300, 49);
		btnGoToFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PFacturaView viewFactura = new PFacturaView();
				Utilidad.showMyPanel(pParentContainer, viewFactura);

			}
		});
		btnGoToFactura.setBounds(0, 253, 300, 49);

		
		btnGoToComponente = new BtnForSideMenu("Componentes");
		btnGoToComponente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PComponenteView componenteView = new PComponenteView();
				Utilidad.showMyPanel(pParentContainer, componenteView);
			}
		});
		btnGoToComponente.setBounds(0, 315, 300, 49);
		
		
		BtnForSideMenu btnGoToCliente = new BtnForSideMenu("Clientes");
		btnGoToCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PClienteView clienteView = new PClienteView();
				Utilidad.showMyPanel(pParentContainer, clienteView);
			}
		});
		btnGoToCliente.setBounds(0, 377, 300, 49);

		pWestContainer.setLayout(null);
		pWestContainer.add(btnGoToInicio);
		pWestContainer.add(btnGoToFactura);
		pWestContainer.add(btnGoToComponente);
		pWestContainer.add(btnGoToCliente);
		
		lblLogo.setBounds(0, 0, 300, 178);
		Utilidad.fitImageInsideLabel(
				"img/logo.jpg", 
				lblLogo
	    );
		lblLogo.setHorizontalAlignment(JLabel.CENTER);
		pWestContainer.add(lblLogo);
	
		pParentContainer.setBackground(Color.BLUE);
		pParentContainer.add(new PInicioView());
		contentPane.add(pParentContainer, BorderLayout.CENTER);
	}
}
