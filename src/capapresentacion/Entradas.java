package capapresentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JScrollBar;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;

import capaaccesodatos.CrudMedicina;
import capaaccesodatos.CrudPresentacion;
import capaaccesodatos.CrudItem;
import capaaccesodatos.CrudLab;
import capanegocios.Item;
import capanegocios.Laboratorio;
import capanegocios.Medicina;
import capanegocios.Mercancia;
import capanegocios.Presentacion;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import java.awt.Color;

public class Entradas {

	private JFrame frmIngresoDeMercancias;
	private JTextField textField;
	private JList listMed;
	private JList listLab;
	private JTextField txtLote;
	private JTextField txtCantidad;
	private JTextField txtCompra;
	private JTextField txtVenta;
	private JLabel lblSave;
	private JDateChooser dateChooser;
	private JTextField txtProvedor;
	private JTextField txtPresentacion;
	private JLabel lblPresentacion;
	private JLabel lblList2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Entradas window = new Entradas();
					window.frmIngresoDeMercancias.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Entradas() {
		initialize();
	}

	/**
	 * https://www.iconfinder.com/icons/559653/ambulance_cross_hospital_medical_pharmacy_plus_icon#size=16
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		frmIngresoDeMercancias = new JFrame();
		frmIngresoDeMercancias.getContentPane().setBackground(new Color(0, 191, 255));
		Image imgEntradas = new ImageIcon(this.getClass().getResource("/pills_medium-16.png")).getImage();
		frmIngresoDeMercancias.setIconImage(imgEntradas);
		frmIngresoDeMercancias.setTitle("Ingreso de Medicamentos y/o Productos");
		frmIngresoDeMercancias.setBounds(100, 100, 1000, 542);
		frmIngresoDeMercancias.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmIngresoDeMercancias.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
		frmIngresoDeMercancias.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 30));
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String valor = textField.getText();
				if(valor.equals("")) {

				}
				else {
					cargarLista(valor);
				}
			}
		});
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		textField.setBounds(30, 29, 920, 50);
		frmIngresoDeMercancias.getContentPane().add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 90, 920, 120);
		frmIngresoDeMercancias.getContentPane().add(scrollPane);
		
		lblSave = new JLabel("........");
		lblSave.setForeground(Color.WHITE);
		lblSave.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblSave.setBounds(183, 397, 390, 61);
		frmIngresoDeMercancias.getContentPane().add(lblSave);
		
		listMed = new JList();
		listMed.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				lblSave.setText("........");
				if (!arg0.getValueIsAdjusting()) {
					textField.setText(listMed.getSelectedValue().toString());
	            }
			}
		});
		scrollPane.setViewportView(listMed);
		
		listLab = new JList();
		listLab.setFont(new Font("Tahoma", Font.BOLD, 12));
		listLab.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int index = listLab.getSelectedIndex();
	              String selection = (String) listLab.getSelectedValue();
	              if(lblList2.getText().equals("Presentaciones:")) {
	            	  txtPresentacion.setText(selection);
	              }
	              if(lblList2.getText().equals("Laboratorios:")) {
	            	  txtProvedor.setText(selection);  
	              }
	              
			}
		});
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(800, 240, 150, 160);
		frmIngresoDeMercancias.getContentPane().add(scrollPane2);
		scrollPane2.setViewportView(listLab);
		
		
		txtLote = new JTextField();
		txtLote.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtLote.setBounds(364, 238, 126, 20);
		frmIngresoDeMercancias.getContentPane().add(txtLote);
		txtLote.setColumns(10);
		
		txtCantidad = new JTextField();
		txtCantidad.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtCantidad.setBounds(364, 281, 46, 20);
		frmIngresoDeMercancias.getContentPane().add(txtCantidad);
		txtCantidad.setColumns(10);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(363, 322, 127, 20);
		frmIngresoDeMercancias.getContentPane().add(dateChooser);
		
		txtCompra = new JTextField();
		txtCompra.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtCompra.setBounds(705, 308, 86, 20);
		frmIngresoDeMercancias.getContentPane().add(txtCompra);
		txtCompra.setColumns(10);
		
		txtVenta = new JTextField();
		txtVenta.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtVenta.setBounds(705, 342, 86, 20);
		frmIngresoDeMercancias.getContentPane().add(txtVenta);
		txtVenta.setColumns(10);
		
		JLabel lblCantidad = new JLabel("Lote:");
		lblCantidad.setFont(new Font("Dialog", Font.BOLD, 17));
		lblCantidad.setForeground(new Color(0, 0, 0));
		lblCantidad.setBounds(238, 234, 60, 20);
		frmIngresoDeMercancias.getContentPane().add(lblCantidad);
		
		JLabel lblNewLabel = new JLabel("Cantidad:");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(238, 275, 116, 25);
		frmIngresoDeMercancias.getContentPane().add(lblNewLabel);
		
		JLabel lblPc = new JLabel("Precio Compra:");
		lblPc.setFont(new Font("Dialog", Font.BOLD, 17));
		lblPc.setForeground(new Color(0, 0, 0));
		lblPc.setBounds(574, 311, 127, 14);
		frmIngresoDeMercancias.getContentPane().add(lblPc);
		
		JLabel lblPv = new JLabel("Precio Venta:");
		lblPv.setFont(new Font("Dialog", Font.BOLD, 17));
		lblPv.setForeground(new Color(0, 0, 0));
		lblPv.setBounds(574, 345, 127, 14);
		frmIngresoDeMercancias.getContentPane().add(lblPv);
		
		JLabel lblVenci = new JLabel("Vence el:");
		lblVenci.setFont(new Font("Dialog", Font.BOLD, 17));
		lblVenci.setForeground(new Color(0, 0, 0));
		lblVenci.setBounds(238, 320, 115, 31);
		frmIngresoDeMercancias.getContentPane().add(lblVenci);
		
		JButton btnGuardar = new JButton("Ingresar");
		btnGuardar.setForeground(new Color(0, 0, 0));
		btnGuardar.setFont(new Font("Dialog", Font.BOLD, 17));
		Image imgMain = new ImageIcon(this.getClass().getResource("/Ok-icon.png")).getImage();
		btnGuardar.setIcon(new ImageIcon(imgMain));
		
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guardarMercancia();
			}
		});
		btnGuardar.setBounds(30, 234, 198, 91);
		frmIngresoDeMercancias.getContentPane().add(btnGuardar);
		
		txtProvedor = new JTextField();
		txtProvedor.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtProvedor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				lblList2.setText("Laboratorios:");
				String valor = txtProvedor.getText();
				cargarListaProvedor(valor);
			}
		});
		txtProvedor.setBounds(705, 240, 86, 20);
		frmIngresoDeMercancias.getContentPane().add(txtProvedor);
		txtProvedor.setColumns(10);
		
		JLabel lblProovedor = new JLabel("Proovedor:");
		lblProovedor.setFont(new Font("Dialog", Font.BOLD, 17));
		lblProovedor.setForeground(new Color(0, 0, 0));
		lblProovedor.setBounds(574, 236, 121, 20);
		frmIngresoDeMercancias.getContentPane().add(lblProovedor);
		
		txtPresentacion = new JTextField();
		txtPresentacion.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtPresentacion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				lblList2.setText("Presentaciones:");
				String valor=txtPresentacion.getText();
				cargarPresentacion(valor);
			}
		});
		txtPresentacion.setBounds(704, 275, 86, 20);
		frmIngresoDeMercancias.getContentPane().add(txtPresentacion);
		txtPresentacion.setColumns(10);
		
		lblPresentacion = new JLabel("Presentacion");
		lblPresentacion.setFont(new Font("Dialog", Font.BOLD, 17));
		lblPresentacion.setForeground(new Color(0, 0, 0));
		lblPresentacion.setBounds(574, 275, 108, 14);
		frmIngresoDeMercancias.getContentPane().add(lblPresentacion);
		
		lblList2 = new JLabel("....");
		lblList2.setBounds(540, 32, 97, 14);
		frmIngresoDeMercancias.getContentPane().add(lblList2);
		
	}
	
	public void cargarLista(String valor){
		DefaultListModel dlm = new DefaultListModel();
		
		CrudMedicina cm = new CrudMedicina();
		List<Medicina> lm = cm.findAllLike(valor);
		
		for (int i = 0; i < lm.size(); i++) {
		    dlm.addElement(lm.get(i).getNomMed());
		}
		
		listMed.setModel(dlm);
	}

	public void cargarListaProvedor(String valor){
		DefaultListModel dlm2 = new DefaultListModel();
		
		CrudLab cm = new CrudLab();
		List<Laboratorio> lm = cm.findAllLike(valor);
		
		for (int i = 0; i < lm.size(); i++) {
		    dlm2.addElement(lm.get(i).getLaboratorio());
		}
		
		listLab.setModel(dlm2);
	}
	
	public void cargarPresentacion(String valor){
		DefaultListModel dlm2 = new DefaultListModel();
		
		CrudPresentacion cm = new CrudPresentacion();
		List<Presentacion> lm = cm.findAllLike(valor);
		
		int n = lm.size();
		for (int i = 0; i < lm.size(); i++) {
		    dlm2.addElement(lm.get(i).getPresentacion());
		}
		
		listLab.setModel(dlm2);
	}
	
	public void guardarMercancia(){
		CrudItem cri = new CrudItem();
		
		Mercancia itmercancia1 = new Mercancia();
		itmercancia1.setNombre(textField.getText());
		itmercancia1.setPresentacion(txtPresentacion.getText());
		itmercancia1.setProveedor(txtProvedor.getText());
		itmercancia1.setCantidad(Integer.parseInt(txtCantidad.getText()));
		itmercancia1.setDisponible(Integer.parseInt(txtCantidad.getText() ));
		itmercancia1.setCosto(Double.parseDouble(txtCompra.getText()));
		itmercancia1.setPrecio(Double.parseDouble(txtVenta.getText()));
		itmercancia1.setLote(txtLote.getText());
		
		//java.util.Date date = new java.util.Date();
		java.util.Date date = dateChooser.getDate();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());

		itmercancia1.setVencimiento(sqlDate);
		try {
			if(cri.create(itmercancia1)) lblSave.setText("Mercancia Guardada!!!");
			else lblSave.setText("Hubo un Error!!!");
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null,e);
		}
		
	}
}