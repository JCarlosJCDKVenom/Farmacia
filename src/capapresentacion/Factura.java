package capapresentacion;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;


//import com.blogspot.rolandopalermo.bean.Producto;

import capaaccesodatos.conexion.ConectarDB;


import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


import java.io.FileOutputStream;
import java.util.List;

import javax.swing.JTable;
import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import capapresentacion.Ventas;
public class Factura extends JFrame {
	String FormaPago = "CONTADO";
	private Font fuenteTitulo = new Font("Agency FB", Font.BOLD, 18);
	private JPanel contentPane;
	private JTextField txtNumFac;
	private JTextField txtOrden;
	private JTextField txtNombre;
	private JTextField txtIdentidad;
	private JTextField txtDireccion;
	private JTextField txtEmpleado;
	private JTextField txtApellido;
	private JTextField txtFecha;
	private JTextField txtCodigo;
	private JTable table;
	private JTable Tproductos;
	private JTextField txtTotal;
	private String ticket;
	java.util.Date fecha = new Date();
	List<Factura> productos = new ArrayList<Factura>();
	private JTextField txtPagoInicial;
	private JTextField txtVuelto;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					
					Factura frame = new Factura();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Factura() {
		Ventas limpiar = new Ventas();
		limpiar.limpiar(limpiar.Tlista);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1080, 760);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setUndecorated(true);
		contentPane = new JPanel();
		
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new MatteBorder(5, 5, 5, 5, (Color) Color.DARK_GRAY));

		//contentPane.setBorder(BorderFactory.createMatteBorder(20, 20, 20, 20, new ImageIcon("img/imgCruz.PNG")));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 128, 128), new Color(0, 128, 128), new Color(0, 128, 128), new Color(0, 128, 128)));
		panel.setForeground(new Color(230, 230, 250));
		panel.setBackground(new Color(230, 230, 250));
		panel.setBounds(27, 24, 293, 70);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblFarmaciaPeruSoft = new JLabel("PERU SOFT");
		lblFarmaciaPeruSoft.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFarmaciaPeruSoft.setBounds(10, 0, 280, 40);
		panel.add(lblFarmaciaPeruSoft);
		
		JLabel lblLaMejorAtencion = new JLabel("La mejor atencion al cliente");
		lblLaMejorAtencion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLaMejorAtencion.setBounds(20, 39, 170, 14);
		panel.add(lblLaMejorAtencion);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(230, 230, 250));
		panel_1.setBackground(new Color(230, 230, 250));
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 128, 128), new Color(0, 128, 128), new Color(0, 128, 128), new Color(0, 128, 128)));
		panel_1.setBounds(630, 24, 423, 70);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblRuc = new JLabel("R.U.C. 10718876637");
		lblRuc.setFont(new Font("Sitka Text", Font.BOLD, 16));
		lblRuc.setBounds(10, 10, 200, 15);
		panel_1.add(lblRuc);
		
		JLabel lblNroBoleta = new JLabel("NRO BOLETA");
		lblNroBoleta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNroBoleta.setBounds(210, 25, 89, 15);
		panel_1.add(lblNroBoleta);
		
		txtNumFac = new JTextField();
		txtNumFac.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtNumFac.setForeground(new Color(0, 0, 0));
		txtNumFac.setBackground(new Color(224, 255, 255));
		txtNumFac.setBounds(179, 39, 150, 20);
		txtNumFac.setEnabled(false);
		panel_1.add(txtNumFac);
		txtNumFac.setColumns(10);
		txtNumFac.setBorder(new MatteBorder(1, 1, 2, 1, (Color) new Color(47, 79, 79)));
		txtNumFac.setHorizontalAlignment(SwingConstants.RIGHT); 
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 191, 255), new Color(0, 191, 255), new Color(0, 191, 255), new Color(0, 191, 255)));
		panel_2.setBounds(26, 102, 1027, 220);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNroDeOrden = new JLabel("Nro de Orden");
		lblNroDeOrden.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNroDeOrden.setBounds(26, 21, 100, 14);
		panel_2.add(lblNroDeOrden);
		lblNroDeOrden.setVisible(false);
		JLabel lblNewLabel = new JLabel("Nombre Cliente");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(26, 46, 100, 14);
		panel_2.add(lblNewLabel);
		
		JLabel lblPerson = new JLabel("DNI");
		lblPerson.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPerson.setBounds(26, 71, 100, 14);
		panel_2.add(lblPerson);
		
		JLabel lblDireccion = new JLabel("DIRECCION");
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDireccion.setBounds(26, 97, 100, 14);
		panel_2.add(lblDireccion);
		
		JLabel lblEmpleado = new JLabel("EMPLEADO");
		lblEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmpleado.setBounds(26, 122, 100, 14);
		panel_2.add(lblEmpleado);
		lblEmpleado.setVisible(false);
		
		txtOrden = new JTextField();
		txtOrden.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtOrden.setBackground(new Color(224, 255, 255));
		txtOrden.setBorder(new MatteBorder(1, 1, 2, 1, (Color) new Color(47, 79, 79)));
		txtOrden.setBounds(123, 20, 241, 20);
		panel_2.add(txtOrden);
		txtOrden.setColumns(10);
		txtOrden.setVisible(false);
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtNombre.setBackground(new Color(224, 255, 255));
		txtNombre.setBorder(new MatteBorder(1, 1, 2, 1, (Color) new Color(47, 79, 79)));
		txtNombre.setColumns(10);
		txtNombre.setBounds(123, 45, 241, 20);
		panel_2.add(txtNombre);
		
		txtIdentidad = new JTextField();
		txtIdentidad.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtIdentidad.setBackground(new Color(224, 255, 255));
		txtIdentidad.setBorder(new MatteBorder(1, 1, 2, 1, (Color) new Color(47, 79, 79)));
		txtIdentidad.setColumns(10);
		txtIdentidad.setBounds(123, 70, 241, 20);
		panel_2.add(txtIdentidad);
		
		txtDireccion = new JTextField();
		txtDireccion.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtDireccion.setBackground(new Color(224, 255, 255));
		txtDireccion.setBorder(new MatteBorder(1, 1, 2, 1, (Color) new Color(47, 79, 79)));
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(123, 96, 847, 20);
		panel_2.add(txtDireccion);
		
		txtEmpleado = new JTextField();
		txtEmpleado.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtEmpleado.setBackground(new Color(224, 255, 255));
		txtEmpleado.setBorder(new MatteBorder(1, 1, 2, 1, (Color) new Color(47, 79, 79)));
		txtEmpleado.setColumns(10);
		txtEmpleado.setBounds(123, 121, 241, 20);
		panel_2.add(txtEmpleado);
		txtEmpleado.setVisible(false);
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.setBounds(383, 19, 89, 23);
		panel_2.add(btnBuscar);
		btnBuscar.setVisible(false);
		JLabel lblApellido = new JLabel("APELLIDOS");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellido.setBounds(393, 48, 79, 14);
		panel_2.add(lblApellido);
		
		JLabel lblFecha = new JLabel("FECHA");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFecha.setBounds(393, 73, 79, 14);
		panel_2.add(lblFecha);
		
		JLabel lblCodigo_1 = new JLabel("CODIGO");
		lblCodigo_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodigo_1.setBounds(393, 124, 79, 14);
		panel_2.add(lblCodigo_1);
		lblCodigo_1.setVisible(false);
		
		txtApellido = new JTextField();
		txtApellido.setBackground(new Color(224, 255, 255));
		txtApellido.setBorder(new MatteBorder(1, 1, 2, 1, (Color) new Color(47, 79, 79)));
		txtApellido.setBounds(482, 45, 488, 20);
		panel_2.add(txtApellido);
		txtApellido.setColumns(10);
		Date fech = fecha;
		txtFecha = new JTextField(fechaActual());
		txtFecha.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtFecha.setBackground(new Color(224, 255, 255));
		txtFecha.setBorder(new MatteBorder(1, 1, 2, 1, (Color) new Color(47, 79, 79)));
		txtFecha.setColumns(10);
		txtFecha.setBounds(482, 70, 150, 20);
		txtFecha.setEnabled(false);
		panel_2.add(txtFecha);
		
		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtCodigo.setBackground(new Color(224, 255, 255));
		txtCodigo.setBorder(new MatteBorder(1, 1, 2, 1, (Color) new Color(47, 79, 79)));
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(482, 121, 150, 20);
		panel_2.add(txtCodigo);
		txtCodigo.setVisible(false);
		try {
			PreparedStatement ps;
			ps = ConectarDB.getConnection().prepareStatement("SELECT COUNT(*) FROM facturas;");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String res = rs.toString();
				res = rs.getString(1);
				
				System.out.println(res);
				int num = Integer.parseInt(res)+1;
				String res2 = String.valueOf(num);
						setNum(res2);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String labels[] = { "Persona Natural", "Persona Juridica" };
	    final DefaultComboBoxModel model = new DefaultComboBoxModel(labels);

		JComboBox box = new JComboBox(model);
		
		box.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String box1=(String)box.getSelectedItem();
				 

		        box1=(String)box.getSelectedItem();
		        if (box1=="Persona Natural") {
		            lblPerson.setText("DNI");
		            
		            
		            
		        }else if(box1=="Persona Juridica")
		        {
		            lblPerson.setText("RUC");
		           
		            
		            
		        }    
				    
				
			}
		});
		box.setFont(new Font("Tahoma", Font.PLAIN, 14));
		box.setBounds(482, 20, 150, 20);
		panel_2.add(box);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"CONTADO", "TARJETA"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(645, 20, 150, 20);
		panel_2.add(comboBox);
		
		comboBox.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						String box1=(String)comboBox.getSelectedItem();
						 
		
				        box1=(String)comboBox.getSelectedItem();
				        if (box1=="CONTADO") {
				            FormaPago="CONTADO";
				            
				            
				            
				        }else if(box1=="TARJETA")
				        {
				        	FormaPago="TARJETA";
				           
				            
				            
				        }    
						    
						
					}
				});
		
		
		
		
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(27, 333, 1027, 261);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		
		Tproductos  = new JTable (0,4);
		Tproductos.setEnabled(false);
		JScrollPane sc = new JScrollPane(Tproductos);
		sc.setBounds(0, 0, 1027, 260);
		 sc.setPreferredSize(new Dimension(400,150));
		panel_3.add(sc);

		Tproductos.getColumn("A").setHeaderValue("Nombre_Producto");
		Tproductos.getColumn("B").setHeaderValue("Cantidad");
		Tproductos.getColumn("C").setHeaderValue("Precio_Unidad");
		Tproductos.getColumn("D").setHeaderValue("PrecioVenta");
		Ventas cargar = new Ventas();
		cargar.CargarTablaAncho(Tproductos, 700, 100, 100, 100);

		
		txtTotal = new JTextField();
		txtTotal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
			      if ( ((c < '0') || (c >= '0')) || (c != KeyEvent.VK_BACK_SPACE) || (c!= KeyEvent.VK_DELETE)) {
			         e.consume();  // ignore event
			      }
			}
		});
		txtTotal.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtTotal.setText("0.00");
		txtTotal.setBounds(838, 605, 215, 29);
		contentPane.add(txtTotal);
		txtTotal.setColumns(10);
		txtTotal.setHorizontalAlignment(SwingConstants.RIGHT); 
		
			
		JButton btnImprimir = new JButton("IMPRIMIR");
		btnImprimir.setEnabled(false);
		btnImprimir.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent arg0) {
				
				devolver2();
				
				
			}
		});
		btnImprimir.setBounds(961, 714, 89, 23);
		contentPane.add(btnImprimir);
		
		JButton btnGuardar = new JButton("BGuardar");
		btnGuardar.setBounds(40, 647, 89, 23);
		JButton bEliminar = new JButton();
		bEliminar.setToolTipText("Eliminar registro de Cliente");
		bEliminar.setSize(new Dimension(145, 40));
		bEliminar.setLocation(new Point(27, 697));
		bEliminar.setFont(new Font("Dialog", Font.BOLD, 14));
		bEliminar.setText("Cancelar");
		bEliminar.setMnemonic(KeyEvent.VK_E);
		bEliminar.setIcon(new ImageIcon("img/imgCancelar.PNG"));
		bEliminar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				int respuesta=JOptionPane.showConfirmDialog(null, "Desea cancelar la compra del cliente "+txtNombre.getText().trim()+" "+txtApellido.getText()+"?", "Eliminar compra",0, 3);
				if (respuesta==0){
					/*eliminar();*/
					Factura.this.dispose();
				}
			}
		});
		contentPane.add(bEliminar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(140, 653, 120, 40);
		
		
		btnLimpiar = new JButton();
		btnLimpiar.setToolTipText("Cancelar informaciï¿½n");
		btnLimpiar.setSize(new Dimension(112, 41));
		btnLimpiar.setLocation(new Point(175, 697));
		btnLimpiar.setEnabled(false);
		btnLimpiar.setText("Cancelar");
		btnLimpiar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnLimpiar.setMnemonic(KeyEvent.VK_C);
		btnLimpiar.setIcon(new ImageIcon("img/imgCancelar.JPG"));
		contentPane.add(btnLimpiar);
		
		JLabel lblPagini = new JLabel("PAG_INI");
		lblPagini.setFont(new Font("Dialog", Font.BOLD, 15));
		lblPagini.setBounds(775, 639, 63, 29);
		contentPane.add(lblPagini);
		
		txtPagoInicial = new JTextField("0.0");
		txtPagoInicial.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtPagoInicial.selectAll();
			}
		});
		txtPagoInicial.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtPagoInicial.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				Double rpt = 0.0;
				try {
				 rpt = Double.parseDouble(txtPagoInicial.getText())-Double.parseDouble(txtTotal.getText());
				txtVuelto.setText(String.valueOf(rpt));
				if(rpt>=0) {
					txtVuelto.setForeground(Color.green);
					btnImprimir.setEnabled(true);
				}else {
					txtVuelto.setForeground(Color.red);
					btnImprimir.setEnabled(false);
				}
				}catch(Exception ex) {
					rpt=0.0;
				}
			}
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if ( ((c < '0') || (c >= '9')) ) {
			         e.consume();  // ignore event
			      }
				
			}
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(txtPagoInicial.getText()==""||txtPagoInicial.getText()==null){
					txtVuelto.setForeground(Color.red);
					btnImprimir.setEnabled(false);
				}
			}
		});
		txtPagoInicial.setBounds(838, 639, 215, 29);
		contentPane.add(txtPagoInicial);
		txtPagoInicial.setColumns(10);
		txtPagoInicial.setHorizontalAlignment(SwingConstants.RIGHT); 
		
		JLabel lblVuelto = new JLabel("VUELTO");
		lblVuelto.setFont(new Font("Dialog", Font.BOLD, 15));
		lblVuelto.setBounds(775, 676, 63, 26);
		contentPane.add(lblVuelto);
		
		txtVuelto = new JTextField("0.0");
		txtVuelto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
			      if ( ((c < '0') || (c >= '0')) || (c != KeyEvent.VK_BACK_SPACE) || (c!= KeyEvent.VK_DELETE)) {
			         e.consume();  // ignore event
			      }
			}
		});
		
		txtVuelto.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtVuelto.setColumns(10);
		txtVuelto.setBounds(838, 673, 215, 29);
		contentPane.add(txtVuelto);
		txtVuelto.setHorizontalAlignment(SwingConstants.RIGHT); 
		btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
			  try{
				 int respuesta=JOptionPane.showConfirmDialog(null, "ï¿Desea descartar los datos ingresados?", "Cancelar ingresos",0, 3);
			  	 
			     }
			  catch(Exception s){}
			}
		});
		  
		
	}
	
	public static String fechaActual() {
		Date fecha = new Date();
		SimpleDateFormat  formatofecha = new SimpleDateFormat ("dd/MM/YY");
		return formatofecha.format(fecha);
	}
	
	public void setNum(String num){
		try {
		    txtNumFac.setText(num);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	    

	}
	public JTable getTabla(){
	    return this.Tproductos;
	}
	public void setTabla(JTable datos){
	    this.Tproductos=datos;

	}

	public void setTotal(String total){
	    txtTotal.setText(total);
	}
	public String objectToString(Object o) {
        String st;
        st = (String) o;
        return st;
    }
	
	public void devolver2() {
		
		
		int j;
        ConectarDB con;
        ResultSet rs;
        String PagoInicial = txtPagoInicial.getText();
        String vuelto = txtVuelto.getText();
        String ss;
        String nomfac = txtNombre.getText();
        String rucfac = txtIdentidad.getText();
        String direccionfac = txtDireccion.getText();
        String total = txtTotal.getText();
        Date date = new Date();
	       DateFormat fechaa = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss ");
	       System.out.println("fecha"+fechaa.format(date));
        Object producto;
        Object canti;
        String cadenita = "";
        String pro ="";
	    String existe = null;
	    int e;
        String ID = null;
       
        String cadena;
        try {
                //se crea la conexion y las consultas
                con = new ConectarDB();
                Double cantidad = Double.parseDouble(total);
                PreparedStatement ps = ConectarDB.getConnection().prepareStatement("INSERT INTO facturas (NUM_FAC, FECHA, ID_CLI, ID_VEN, FOR_PAG, DESCU, PREC_FINAL,TOT_DES, VUELTO, OBSERVAC, PAGO_INI) VALUES ('"+txtNumFac.getText()+"','"+fechaa.format(date)+"','CL0001','VE0001','"+FormaPago+"','0','"+total+"','0.0','"+vuelto+"','ninguno','"+PagoInicial+"');");
    			
    			ps.executeUpdate();
               
                Object ex = null,precio=null;
                Object pros=null;
                
                 
                Ventas row = new Ventas();
                int rowCount = Tproductos.getRowCount();
                System.out.println("cantidad de columnas "+rowCount);
               // vendedor vende = new vendedor();
                int rc = 0;//vende.getFactura();
                
                Date fecha = new Date();
               cadena="Farmacia 'FARMA VEA'\n----------------------\n RUC: TOSO850220GN9 \nBaltazar N. 4  \nSan Antonio Coaxomulco, Tlaxcala\nFecha: "+fecha+"\n";
                String cade="----------------------\n\n\t>>Datos del Comprador<<\n\nNumero de Factura: "+txtNumFac.getText()+"\nNombre: "+nomfac+"\nRUC: "+rucfac+"\nDireccion: "+direccionfac;
              //  System.out.println("Numero de Filas: "+rowCount);
                String enca="\n----------------------\nProducto\t     Cant.\t     Precio\n";
                
                for(int x=0;x<rowCount;x++){
                
                   producto = Tproductos.getValueAt(x,0);
                    pro = objectToString(producto);
                    
                    precio = Tproductos.getValueAt(x,1);
                    canti = Tproductos.getValueAt(x,2);
                    cadenita = cadenita+"\n"+pro+"\t  "+canti+"\t  "+precio+" $";
                   
                }
                for(int x=0;x<rc;x++){
                
                   producto = Tproductos.getValueAt(x,0);
                    pro = objectToString(producto);
                    
                    precio = Tproductos.getValueAt(x,1);
                   
                    canti = Tproductos.getValueAt(x,2);
                   
                    
                    if(pro.length()<=8)
                        pro=pro+"     ";
                    if(pro.length()>15)
                        pro = pro.substring(0, 15);
                                
                    cadenita = cadenita+"\n"+pro+"\t"+canti+"\t"+precio+" ";
                   
                }
                 ticket = cadena+cade+enca+cadenita+"\n\nTotal: \t\t$"+txtTotal.getText()+"\n\n----------------------\n  PERU SOFTWARE A SU SERVICIO\n    GRACIAS POR SU COMPRA.\n\n\n\n";
               
                 PrintStream ps1;
                
                 FileOutputStream os;
 				try {
 					os = new FileOutputStream("Archivo.txt");
 					generarArchivoPDF();
 					//ps1.println(cadena);
 					System.out.println("se supone que se genero el pdf");
 					ps1 = new PrintStream(os); 
 					ps1.println(ticket);
 				} catch (FileNotFoundException e1) {
 					// TODO Auto-generated catch block
 					e1.printStackTrace();
 					System.out.println("no se puede imprimir");
 				} 
               String t=txtTotal.getText();
               ticket = "";
               // JOptionPane.showMessageDialog(null, "   Imprimiendo con boton imprimir txt");
               System.out.println("imprimiendo");
               Factura.this.dispose();

            }   catch (SQLException ex) {
                Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
            }

	}
	private void agregarTextoNormal(Document document, String string, Font font, int align) {
        try {
            Chunk espacio = new Chunk(string);
            Paragraph p = new Paragraph(espacio);
            p.setAlignment(align);
            document.add(p);
        } catch (DocumentException ex) {
            ex.printStackTrace();
        }
    }
	 public void generarArchivoPDF() {
		 
	        try {
	            Rectangle pagesize = new Rectangle(600f, 150f + (1000f ));
	            Document document = new Document(pagesize, 5, 5, 0, 0);
	            PdfWriter.getInstance(document, new FileOutputStream(
	                    "factura_orden_template.pdf"));
	            document.open();
	            agregarSeparacion(document);
	            agregarSeparacion(document);
	            agregarTextoNormal(document, "FARMA VEA", fuenteTitulo, Element.ALIGN_CENTER);
	            agregarSeparacion(document);
	            agregarTextoNormal(document, "PERU SOFTWARE", fuenteTitulo, Element.ALIGN_CENTER);
	            
				//agregarTextoNormal(document, ticket , fuenteTitulo, Element.ALIGN_CENTER);
	           //
	            agregarSeparacion(document);
	            agregarSeparacion(document);
	            document.add(crearMaestroFactura());
	           agregarSeparacion(document);
	           agregarSeparacion(document);
				document.add(crearDetalleFactura());
				agregarSeparacion(document);
				agregarSeparacion(document);
				agregarSeparacion(document);
				agregarSeparacion(document);
				agregarSeparacion(document);
				agregarTextoNormal(document, "GRACIAS POR SU COMPRA", fuenteTitulo, Element.ALIGN_CENTER);
				agregarTextoNormal(document, "ESPERAMOS SU REGRESO", fuenteTitulo, Element.ALIGN_CENTER);
				document.close();
	            Runtime.getRuntime().exec("cmd.exe /c start factura_orden_template.pdf");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
}
	 private PdfPTable crearMaestroFactura() throws DocumentException {
	        PdfPTable table = new PdfPTable(4);
	        table.setWidthPercentage(100f);
	        agregarEtiqueta(table, "NOMBRE:", Element.ALIGN_LEFT, false, 0);
	        agregarEtiqueta(table, txtNombre.getText(), Element.ALIGN_LEFT, false, 0);
	        agregarEtiqueta(table, "APELLIDO:", Element.ALIGN_LEFT, false, 1);
	        agregarEtiqueta(table, txtApellido.getText(), Element.ALIGN_LEFT, false, 1);
	        agregarEtiqueta(table, "DIRECCION:", Element.ALIGN_LEFT, false, 1);
	        agregarEtiqueta(table, txtDireccion.getText(), Element.ALIGN_LEFT, false, 1);
	        
	        agregarEtiqueta(table, "R.U.C.:", Element.ALIGN_LEFT, false, 1);
	        agregarEtiqueta(table, "PersonalizadoAgregar", Element.ALIGN_LEFT, false, 1);
	        agregarEtiqueta(table, "Nro BOLETA", Element.ALIGN_LEFT, false, 1);
	        agregarEtiqueta(table, "00000"+txtNumFac.getText(), Element.ALIGN_LEFT, false, 1);
	        agregarEtiqueta(table, "FECHA :", Element.ALIGN_LEFT, false, 1);
	        agregarEtiqueta(table, txtFecha.getText(), Element.ALIGN_LEFT, false, 1);
	        return table;
	    }
	 private void agregarEtiqueta(PdfPTable table, String string, int align,boolean isBorder, int colspan) {
	        // Font fuente = new Font(Font.FontFamily.TIMES_ROMAN, 9, Font.BOLD);
	        Chunk c = new Chunk(string);
	        PdfPCell cell = new PdfPCell(new Phrase(c));
	        if (!isBorder) {
	            cell.setBorder(Rectangle.NO_BORDER);
	        }
	        cell.setColspan(colspan);
	        cell.setVerticalAlignment(align);
	        cell.setHorizontalAlignment(align);
	        table.addCell(cell);
	    }
	 private void agregarTexto(PdfPTable table, String string, int align, boolean isBorder, int colspan) {
		 
		 
		 Chunk c = new Chunk(string);
	        PdfPCell cell = new PdfPCell(new Phrase(c));
	        float[] medidaCeldas = {10.55f, 2.1f, 2.1f, 2.55f};

	     // ASIGNAS LAS MEDIDAS A LA TABLA (ANCHO)
	     try {
			table.setWidths(medidaCeldas);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("No se pudo cambiar el ancho de la columna");
		}
	        if (!isBorder) {
	            cell.setBorder(Rectangle.NO_BORDER);
	        }
	        cell.setColspan(colspan);
	        cell.setHorizontalAlignment(align);
	        table.addCell(cell);
	    }
	 private PdfPTable crearDetalleFactura() throws DocumentException {
	        PdfPTable table = new PdfPTable(4);
	        table.setWidthPercentage(100f);
	        //List<Producto> productos = factura.getProductos();
	        agregarEtiqueta(table, "Nombre", Element.ALIGN_CENTER, true, 1);
	        agregarEtiqueta(table, "Cantidad ", Element.ALIGN_CENTER, true, 1);
	        agregarEtiqueta(table, "PREC. UNIT.", Element.ALIGN_CENTER, true, 1);
	        agregarEtiqueta(table, "PREC. PARCIAL", Element.ALIGN_CENTER, true, 1);
	        double parcial = 0d;
	        for (int i=0; i<Tproductos.getRowCount();i++) {
	            agregarTexto(table, "" + Tproductos.getValueAt(i, 0), Element.ALIGN_CENTER, true, 1);
	            agregarTexto(table, ""+ Tproductos.getValueAt(i, 1), Element.ALIGN_CENTER, true, 1);
	            agregarTexto(table, "" +  Tproductos.getValueAt(i, 2), Element.ALIGN_RIGHT, true, 1);
	            agregarTexto(table, "" +  Tproductos.getValueAt(i, 3), Element.ALIGN_RIGHT, true, 1);
	           
	        }/*
	        agregarEtiqueta(table, "", Element.ALIGN_RIGHT, false, 1);
	        agregarEtiqueta(table, "", Element.ALIGN_RIGHT, false, 1);
	        /*agregarEtiqueta(table, "SUBTOTAL:", Element.ALIGN_RIGHT, true, 1);
	        agregarTexto(table, "" +txtTotal.getText(), Element.ALIGN_RIGHT, true, 1);*/
	        /*agregarEtiqueta(table, "", Element.ALIGN_RIGHT, false, 1);
	        agregarEtiqueta(table, "", Element.ALIGN_RIGHT, false, 1);/*
	        agregarEtiqueta(table, "I.G.V.:", Element.ALIGN_RIGHT, true, 1);
	        agregarTexto(table, "0.18", Element.ALIGN_RIGHT, true, 1);*/
	        agregarEtiqueta(table, "", Element.ALIGN_RIGHT, false, 1);
	        agregarEtiqueta(table, "", Element.ALIGN_RIGHT, false, 1);
	        agregarEtiqueta(table, "TOTAL", Element.ALIGN_RIGHT, true, 1);
	        agregarTexto(table, "" + Math.round(Double.parseDouble(txtTotal.getText()) * 100) / 100.0d, Element.ALIGN_RIGHT, true, 1);
	        agregarEtiqueta(table, "", Element.ALIGN_RIGHT, false, 1);
	        agregarEtiqueta(table, "", Element.ALIGN_RIGHT, false, 1);
	        agregarEtiqueta(table, "", Element.ALIGN_RIGHT, false, 1);
	        agregarEtiqueta(table, "", Element.ALIGN_RIGHT, false, 1);
	        agregarEtiqueta(table, "", Element.ALIGN_RIGHT, false, 1);
	        agregarEtiqueta(table, "", Element.ALIGN_RIGHT, false, 1);
	        agregarEtiqueta(table, "PAGO:", Element.ALIGN_RIGHT, true, 1);
	        agregarTexto(table, "" +txtPagoInicial.getText(), Element.ALIGN_RIGHT, true, 1);
	        agregarEtiqueta(table, "", Element.ALIGN_RIGHT, false, 1);
	        agregarEtiqueta(table, "", Element.ALIGN_RIGHT, false, 1);
	        agregarEtiqueta(table, "VUELTO:", Element.ALIGN_RIGHT, true, 1);
	        agregarTexto(table, "" +txtVuelto.getText(), Element.ALIGN_RIGHT, true, 1);
	        return table;
	    }
	    private void agregarSeparacion(Document document) {
	        try {
	            //Font fuente = new Font(Font.FontFamily.TIMES_ROMAN, 4, Font.NORMAL);
	        	Font fuente = new Font("Dialog", Font.PLAIN, 10);
	            Chunk espacio = new Chunk("\n");
	            
	            document.add(new Paragraph(espacio));
	        } catch (DocumentException ex) {
	            ex.printStackTrace();
	        }
	    }
}