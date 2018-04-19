package capapresentacion;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import capapresentacion.helper.*;

public class MainWindow {

	private JFrame frmSsss;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
			
					MainWindow window = new MainWindow();
					window.frmSsss.setVisible(true);
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
		frmSsss = new JFrame();
		frmSsss.setTitle("Farma Innova");
		frmSsss.setBounds(100, 100, 800, 600);
		frmSsss.setResizable(true);
		frmSsss.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		frmSsss.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Image imgPrincipal = new ImageIcon(this.getClass().getResource("/main_icon.png")).getImage();
		frmSsss.setIconImage(imgPrincipal);
		
	    JTreeEventsPanel Arbol = new JTreeEventsPanel();
	    frmSsss.getContentPane().add(Arbol);
	}

}
