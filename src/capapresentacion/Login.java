package capapresentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import capaaccesodatos.CrudUsuario;

import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frmIngresoAlSistema;
	private JTextField txtUsuario;
	private JPasswordField txtClave;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmIngresoAlSistema.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		frmIngresoAlSistema = new JFrame();
		frmIngresoAlSistema.setTitle("Ingreso al Sistema");
		frmIngresoAlSistema.setBounds(100, 100, 370, 274);
		frmIngresoAlSistema.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIngresoAlSistema.getContentPane().setLayout(null);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frmIngresoAlSistema.setLocation(dim.width/2-frmIngresoAlSistema.getSize().width/2, dim.height/2-frmIngresoAlSistema.getSize().height/2);
		
		Image imgPrincipal = new ImageIcon(this.getClass().getResource("/LoginIcon.png")).getImage();
		frmIngresoAlSistema.setIconImage(imgPrincipal);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(58, 89, 46, 14);
		frmIngresoAlSistema.getContentPane().add(lblUsuario);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(57, 134, 63, 14);
		frmIngresoAlSistema.getContentPane().add(lblPassword);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(144, 86, 111, 20);
		frmIngresoAlSistema.getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(33, 162, 287, 14);
		frmIngresoAlSistema.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(33, 68, 287, 12);
		frmIngresoAlSistema.getContentPane().add(separator_1);
		
		JButton btnLogin = new JButton("Entrar");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CrudUsuario cu = new CrudUsuario();
				String usuario = txtUsuario.getText().trim();
				String password = txtClave.getText().trim();
				if(cu.usuarioExiste(usuario, password)) {
					MainWindow mw = new MainWindow();
					mw.main(null);
					frmIngresoAlSistema.dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "Error en el nombre de usuario o password", "InfoBox: " + "Error", JOptionPane.INFORMATION_MESSAGE);
					txtUsuario.setText("");
					txtClave.setText("");
				}
			}
		});
		
		frmIngresoAlSistema.getRootPane().setDefaultButton(btnLogin);
		
		btnLogin.setBounds(33, 179, 89, 23);
		frmIngresoAlSistema.getContentPane().add(btnLogin);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtUsuario.setText("");
				txtClave.setText("");
			}
		});
		btnLimpiar.setBounds(132, 179, 89, 23);
		frmIngresoAlSistema.getContentPane().add(btnLimpiar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(231, 179, 89, 23);
		frmIngresoAlSistema.getContentPane().add(btnSalir);
		
		JLabel lblInnovaFarma = new JLabel("INNOVA FARMA");
		lblInnovaFarma.setForeground(Color.DARK_GRAY);
		lblInnovaFarma.setFont(new Font("Segoe Script", Font.PLAIN, 18));
		lblInnovaFarma.setBounds(98, 28, 166, 14);
		frmIngresoAlSistema.getContentPane().add(lblInnovaFarma);
		
		txtClave = new JPasswordField();
		txtClave.setBounds(144, 131, 111, 20);
		frmIngresoAlSistema.getContentPane().add(txtClave);
	}
}
