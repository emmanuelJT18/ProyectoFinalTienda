package views;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Color;

public class MainWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 977, 673);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar() {
			@Override
		    public Dimension getPreferredSize() {
		        return new Dimension(super.getPreferredSize().width, 70); // Set your desired height
		    }

		};
		menuBar.setBackground(Color.GREEN);
		frame.setJMenuBar(menuBar);
		
		JMenu mnInicio = new JMenu("Menu 1");
		menuBar.add(mnInicio);
		
		JMenu mnComponentes = new JMenu("Menu 2");
		menuBar.add(mnComponentes);
		
		menuBar.add(Box.createHorizontalGlue());
		
		JMenu mnLogOut = new JMenu("Log Out");
		menuBar.add(mnLogOut);
		
		
		
		JMenuItem mntmCrearComponente = new JMenuItem("Nuevo Componente");
		mnComponentes.add(mntmCrearComponente);
		
		JMenuItem mntmVerComponentes = new JMenuItem("Ver Componentes");
		mnComponentes.add(mntmVerComponentes);
		frame.getContentPane().setLayout(null);
	}
}
