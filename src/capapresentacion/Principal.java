package capapresentacion;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Window;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.Font;

public class Principal {

	private JFrame frmFarmaciaInnova;
	//private Entradas frameEntradas;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frmFarmaciaInnova.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		
		frmFarmaciaInnova = new JFrame();
		JFrame.setDefaultLookAndFeelDecorated(true);
		frmFarmaciaInnova.setFont(new Font("Dialog", Font.BOLD, 14));
		frmFarmaciaInnova.setForeground(Color.BLACK);
		frmFarmaciaInnova.setTitle("Farmacia Innova");
		Image imgPrincipal = new ImageIcon(this.getClass().getResource("/main_icon.png")).getImage();
		frmFarmaciaInnova.setIconImage(imgPrincipal);
		
		frmFarmaciaInnova.setBounds(100, 100, 900, 600);
		frmFarmaciaInnova.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmFarmaciaInnova.setJMenuBar(menuBar);
		
		JMenu mnEntradas = new JMenu("Entradas");
		menuBar.add(mnEntradas);
		
		JMenuItem mntmNuevaMercancia = new JMenuItem("Nueva Mercancia");
		mntmNuevaMercancia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Entradas frameEntradas = new Entradas();
				frameEntradas.main(null);
			}
		});
		mnEntradas.add(mntmNuevaMercancia);
		
		JSeparator separator = new JSeparator();
		mnEntradas.add(separator);
		
		JMenuItem mntmCerrar = new JMenuItem("Cerrar");
		mntmCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		mnEntradas.add(mntmCerrar);
		
		JMenu mnSalidas = new JMenu("Salidas");
		menuBar.add(mnSalidas);
		
		JMenuItem mntmSalidas = new JMenuItem("Salidas");
		mntmSalidas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Salidas frameSalidas = new Salidas();
				frameSalidas.main(null);
			}
		});
		mnSalidas.add(mntmSalidas);
		
		JMenu mnSuministros = new JMenu("Suministros");
		menuBar.add(mnSuministros);
		
		JMenu mnReportes = new JMenu("Reportes");
		menuBar.add(mnReportes);
		
		JMenuItem mntmProductosXVencer = new JMenuItem("Productos x Vencer");
		mntmProductosXVencer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		mnReportes.add(mntmProductosXVencer);
		
		JMenuItem mntmProductosXAcabarse = new JMenuItem("Productos x acabarse");
		mnReportes.add(mntmProductosXAcabarse);
		
		JLabel label = new JLabel("");
		Image imgMain = new ImageIcon(this.getClass().getResource("/paisaje.png")).getImage();
		label.setIcon(new ImageIcon(imgMain));
		
		frmFarmaciaInnova.getContentPane().add(label, BorderLayout.CENTER);
	}

}
