/**
 * 
 */
package capapresentacion;


import java.awt.EventQueue;

import javax.swing.JFrame;

/**
 * @author "JuanCarlos"
 *
 */

import java.awt.Image;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import capapresentacion.helper.*;

public class MainWindow extends javax.swing.JFrame{

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
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
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
	
	

	private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
	      int op =  finalizar();
	      if(op == JOptionPane.OK_OPTION)
	        {
	            System.exit(0);
	        }
	        
	    }
	
	public int finalizar()
    {
        return JOptionPane.showConfirmDialog(this.frmSsss, "Si existe algun dato sin guardar "
                + "se perderán.\n ¿Desea salir del programa?");
    }
	

}