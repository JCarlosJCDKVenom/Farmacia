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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
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

public class Factura extends JFrame {
	
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
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1080, 720);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 128, 128), new Color(0, 128, 128), new Color(0, 128, 128), new Color(0, 128, 128)));
		panel.setForeground(new Color(230, 230, 250));
		panel.setBackground(new Color(230, 230, 250));
		panel.setBounds(10, 11, 300, 80);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblFarmaciaPeruSoft = new JLabel("PERU SOFT");
		lblFarmaciaPeruSoft.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFarmaciaPeruSoft.setBounds(10, 0, 280, 40);
		panel.add(lblFarmaciaPeruSoft);
		
		JLabel lblLaMejorAtencion = new JLabel("La mejor atencion al cliente");
		lblLaMejorAtencion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLaMejorAtencion.setBounds(20, 40, 170, 14);
		panel.add(lblLaMejorAtencion);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(230, 230, 250));
		panel_1.setBackground(new Color(230, 230, 250));
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 128, 128), new Color(0, 128, 128), new Color(0, 128, 128), new Color(0, 128, 128)));
		panel_1.setBounds(640, 11, 414, 80);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblRuc = new JLabel("R.U.C. 10718876637");
		lblRuc.setFont(new Font("Sitka Text", Font.BOLD, 16));
		lblRuc.setBounds(10, 10, 200, 15);
		panel_1.add(lblRuc);
		
		JLabel lblNroBoleta = new JLabel("NRO BOLETA");
		lblNroBoleta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNroBoleta.setBounds(160, 32, 89, 15);
		panel_1.add(lblNroBoleta);
		
		txtNumFac = new JTextField();
		txtNumFac.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtNumFac.setForeground(new Color(0, 0, 0));
		txtNumFac.setBackground(new Color(224, 255, 255));
		txtNumFac.setBounds(132, 52, 150, 20);
		txtNumFac.setEnabled(false);
		panel_1.add(txtNumFac);
		txtNumFac.setColumns(10);
		txtNumFac.setBorder(new MatteBorder(1, 1, 2, 1, (Color) new Color(47, 79, 79)));
		txtNumFac.setHorizontalAlignment(SwingConstants.RIGHT); 
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 191, 255), new Color(0, 191, 255), new Color(0, 191, 255), new Color(0, 191, 255)));
		panel_2.setBounds(10, 102, 1044, 220);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNroDeOrden = new JLabel("Nro de Orden");
		lblNroDeOrden.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNroDeOrden.setBounds(26, 21, 100, 14);
		panel_2.add(lblNroDeOrden);
		
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
		
		txtOrden = new JTextField();
		txtOrden.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtOrden.setBackground(new Color(224, 255, 255));
		txtOrden.setBorder(new MatteBorder(1, 1, 2, 1, (Color) new Color(47, 79, 79)));
		txtOrden.setBounds(123, 20, 241, 20);
		panel_2.add(txtOrden);
		txtOrden.setColumns(10);
		
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
		txtDireccion.setBounds(123, 96, 628, 20);
		panel_2.add(txtDireccion);
		
		txtEmpleado = new JTextField();
		txtEmpleado.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtEmpleado.setBackground(new Color(224, 255, 255));
		txtEmpleado.setBorder(new MatteBorder(1, 1, 2, 1, (Color) new Color(47, 79, 79)));
		txtEmpleado.setColumns(10);
		txtEmpleado.setBounds(123, 121, 241, 20);
		panel_2.add(txtEmpleado);
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.setBounds(383, 19, 89, 23);
		panel_2.add(btnBuscar);
		
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
		
		txtApellido = new JTextField();
		txtApellido.setBackground(new Color(224, 255, 255));
		txtApellido.setBorder(new MatteBorder(1, 1, 2, 1, (Color) new Color(47, 79, 79)));
		txtApellido.setBounds(482, 45, 150, 20);
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
		
		
		
		
		
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 333, 872, 261);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		
		Tproductos  = new JTable (0,4);
		Tproductos.setEnabled(false);
		JScrollPane sc = new JScrollPane(Tproductos);
		sc.setBounds(10, 11, 872, 261);
		 sc.setPreferredSize(new Dimension(400,150));
		panel_3.add(sc);

		Tproductos.getColumn("A").setHeaderValue("Nombre_Producto");
		Tproductos.getColumn("B").setHeaderValue("Cantidad");
		Tproductos.getColumn("C").setHeaderValue("Precio_Unidad");
		Tproductos.getColumn("D").setHeaderValue("PrecioVenta");
		

		
		txtTotal = new JTextField();
		txtTotal.setText("0.00");
		txtTotal.setBounds(650, 605, 215, 29);
		contentPane.add(txtTotal);
		txtTotal.setColumns(10);
		txtTotal.setHorizontalAlignment(SwingConstants.RIGHT); 
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			System.out.println("clickeo en el lugar equivcado xD");
			}
		});
		btnOk.setBounds(918, 560, 89, 23);
		contentPane.add(btnOk);
		
		JButton btnImprimir = new JButton("IMPRIMIR");
		btnImprimir.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent arg0) {
				devolver2();
				
				
			}
		});
		btnImprimir.setBounds(918, 608, 89, 23);
		contentPane.add(btnImprimir);
		
		
		
		  
		
	}
	
	public static String fechaActual() {
		Date fecha = new Date();
		SimpleDateFormat  formatofecha = new SimpleDateFormat ("dd/MM/YY");
		return formatofecha.format(fecha);
	}
	
	public void setNum(int num){
	    String x = String.valueOf(num);
	    txtNumFac.setText(x);
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
        
        String ss;
        String cadena;
        
        try {
                //se crea la conexion y las consultas
                con = new ConectarDB();
                PreparedStatement ps = ConectarDB.getConnection().prepareStatement("INSERT INTO facturas (cantidad, nombre, direccion, ruc,fecha) VALUES ('"+total+"', '"+nomfac+"', '"+direccionfac+"', '"+rucfac+"', '"+fechaa.format(date)+"');");
    			
    			ps.executeUpdate();
               
//                int to[] = new int[100];
//                float prec[] = new float[100];
                Object ex = null,precio=null;
                Object pros=null;
                
                // se crea la sentecia sql y se ejecuta para hacer la modificacion
               
//////                FileOutputStream os = null;
//////                try {
//////                    os = new FileOutputStream("ticket.txt");
//////                } catch (FileNotFoundException ex1) {
//////                    Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex1);
//////                }
//////                  PrintStream ps = new PrintStream(os);
                
                
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
                /*double subtotal = 0d;
                for (int i = 0; i < rowCount; i++) {
			        int cantidad = (Integer) Tproductos.getValueAt(i, 0);
			        String descripcion = (String) Tproductos.getValueAt(i, 1);
			        double precioUnitario = (Double) Tproductos.getValueAt(i, 2);
			        double precioParcial = precioUnitario * cantidad;
			        subtotal += precioParcial;
			        Tproductos.setValueAt(precioParcial, i, 3);
			        Producto producto1 = new Producto();
			        producto1.setCantidad(cantidad);
			        producto1.setDescripcion(descripcion);
			        producto1.setPrecioParcial(precioParcial);
			        producto1.setPrecioUnitario(precioUnitario);
			        productos.add(producto1);
			    }*/
                for(int x=0;x<rowCount;x++){
                
                   producto = Tproductos.getValueAt(x,0);
                    pro = objectToString(producto);
                    
                    precio = Tproductos.getValueAt(x,1);
        //            String pre = objectToString(prec);
                   
                    canti = Tproductos.getValueAt(x,2);
        //            String c = objectToString(canti);
                   
                    
                   // if(pro.length()<=8) {
                     //   pro=pro+"     ";}
                   // if(pro.length()>15) {
                     //   pro = pro.substring(0, 15);}
                                
                    cadenita = cadenita+"\n"+pro+"\t  "+canti+"\t  "+precio+" $";
                   
                }
                for(int x=0;x<rc;x++){
                
                   producto = Tproductos.getValueAt(x,0);
                    pro = objectToString(producto);
                    
                    precio = Tproductos.getValueAt(x,1);
        //            String pre = objectToString(prec);
                   
                    canti = Tproductos.getValueAt(x,2);
        //            String c = objectToString(canti);
                   
                    
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
 					os = new FileOutputStream("Archivo2.txt");
 					generarArchivoPDF();
 					//ps1.println(cadena);
 					System.out.println("se supone que se genero el pdf");
 					ps1 = new PrintStream(os); 
 					ps1.println(ticket);
 				} catch (FileNotFoundException e1) {
 					// TODO Auto-generated catch block
 					e1.printStackTrace();
 					System.out.println("no se puede imprimir con boton dos");
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
	/*/public void devolver() {
		int j;
        ConectarDB con;
        ResultSet rs;
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
        
        
if(!nomfac.equals("") || !rucfac.equals("") || !direccionfac.equals("")) {
if(JOptionPane.showConfirmDialog(rootPane, "Ya esta listo para imprimir la Factura?","Imprimir Factura",1)==0){
    String existe = null;
    int e;
        String ID = null;
        String ticket;
        String ss;
        String cadena;
        
        try {
                //se crea la conexion y las consultas
                con = new ConectarDB();
                PreparedStatement ps = ConectarDB.getConnection().prepareStatement("INSERT INTO facturas (cantidad, nombre, direccion, ruc,fecha) VALUES ('"+total+"', '"+nomfac+"', '"+direccionfac+"', '"+rucfac+"', '"+fechaa.format(date)+"');");
    			
    			ps.executeUpdate();
               
//                int to[] = new int[100];
//                float prec[] = new float[100];
                Object ex = null,precio=null;
                Object pros=null;
                
                // se crea la sentecia sql y se ejecuta para hacer la modificacion
               
//////                FileOutputStream os = null;
//////                try {
//////                    os = new FileOutputStream("ticket.txt");
//////                } catch (FileNotFoundException ex1) {
//////                    Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex1);
//////                }
//////                  PrintStream ps = new PrintStream(os);
                
                
                Ventas row = new Ventas();
                //int rowCount = row.getFactura();
               // System.out.println(rowCount);
               // vendedor vende = new vendedor();
                int rc = 0;//vende.getFactura();
                
                Date fecha = new Date();
               cadena="Farmacia 'FARMA VEA'\n----------------------\n RUC: TOSO850220GN9 \nBaltazar N. 4  \nSan Antonio Coaxomulco, Tlaxcala\nFecha: "+fecha+"\n";
                String cade="----------------------\n\n\t>>Datos del Comprador<<\n\nNumero de Factura: "+txtNumFac.getText()+"\nNombre: "+nomfac+"\nRFC: "+rucfac+"\nDireccion: "+direccionfac;
              //  System.out.println("Numero de Filas: "+rowCount);
                String enca="\n----------------------\nProducto\tCant.\tPrecio\n";
                for(int x=0;x<Tproductos.getRowCount();x++){
                
                   producto = Tproductos.getValueAt(x,0);
                    pro = objectToString(producto);
                    
                    precio = Tproductos.getValueAt(x,1);
        //            String pre = objectToString(prec);
                   
                    canti = Tproductos.getValueAt(x,2);
        //            String c = objectToString(canti);
                   
                    
                    if(pro.length()<=8)
                        pro=pro+"     ";
                    if(pro.length()>15)
                        pro = pro.substring(0, 15);
                                
                    cadenita = cadenita+"\n"+pro+"\t"+canti+"\t"+precio+"";
                   
                }
                for(int x=0;x<rc;x++){
                
                   producto = Tproductos.getValueAt(x,0);
                    pro = objectToString(producto);
                    
                    precio = Tproductos.getValueAt(x,1);
        //            String pre = objectToString(prec);
                   
                    canti = Tproductos.getValueAt(x,2);
        //            String c = objectToString(canti);
                   
                    
                    if(pro.length()<=8)
                        pro=pro+"     ";
                    if(pro.length()>15)
                        pro = pro.substring(0, 15);
                                
                    cadenita = cadenita+"\n"+pro+"\t"+canti+"\t"+precio+"";
                   
                }
                 ticket = cadena+cade+enca+cadenita+"\n\nTotal: \t\t$"+txtTotal.getText()+"\n\n----------------------\n    CON EL CORAZON EN LAS MANOS\n    GRACIAS POR SU COMPRA.\n\n\n\n";
               //Cogemos el servicio de impresión por defecto (impresora por defecto)
PrintService service = PrintServiceLookup.lookupDefaultPrintService();
//Le decimos el tipo de datos que vamos a enviar a la impresora
//Tipo: bytes Subtipo: autodetectado
DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
//Creamos un trabajo de impresión
DocPrintJob pj = service.createPrintJob();
 ss=new String(ticket);
byte[] bytes;
bytes=ss.getBytes();
Doc doc=new SimpleDoc(bytes,flavor,null);

  pj.print(doc, null);


                
                
               String t=txtTotal.getText();
               ticket = "";
                JOptionPane.showMessageDialog(null, "   Imprimiendo Factura");
               Factura.this.dispose();

            }   catch (PrintException ex1) {
                    Logger.getLogger(Factura.class.getName()).log(Level.SEVERE, null, ex1);
                }  catch (SQLException ex) {
                Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
            }

        
    
    
}
}
else 
    JOptionPane.showMessageDialog(rootPane, "Faltan Campos por Llenar");
	}
	*/
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
	        agregarEtiqueta(table, "ORDEN DE COMPRA:", Element.ALIGN_LEFT, false, 1);
	        agregarEtiqueta(table, txtOrden.getText(), Element.ALIGN_LEFT, false, 1);
	        agregarEtiqueta(table, "R.U.C.:", Element.ALIGN_LEFT, false, 1);
	        agregarEtiqueta(table, txtIdentidad.getText(), Element.ALIGN_LEFT, false, 1);
	        agregarEtiqueta(table, "Nro GUIA", Element.ALIGN_LEFT, false, 1);
	        agregarEtiqueta(table, txtNumFac.getText(), Element.ALIGN_LEFT, false, 1);
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
	           
	        }
	        agregarEtiqueta(table, "", Element.ALIGN_RIGHT, false, 1);
	        agregarEtiqueta(table, "", Element.ALIGN_RIGHT, false, 1);
	        agregarEtiqueta(table, "SUBTOTAL:", Element.ALIGN_RIGHT, true, 1);
	        agregarTexto(table, "" +txtTotal.getText(), Element.ALIGN_RIGHT, true, 1);
	        agregarEtiqueta(table, "", Element.ALIGN_RIGHT, false, 1);
	        agregarEtiqueta(table, "", Element.ALIGN_RIGHT, false, 1);
	        agregarEtiqueta(table, "I.G.V.:", Element.ALIGN_RIGHT, true, 1);
	        agregarTexto(table, "0.18", Element.ALIGN_RIGHT, true, 1);
	        agregarEtiqueta(table, "", Element.ALIGN_RIGHT, false, 1);
	        agregarEtiqueta(table, "", Element.ALIGN_RIGHT, false, 1);
	        agregarEtiqueta(table, "TOTAL", Element.ALIGN_RIGHT, true, 1);
	        agregarTexto(table, "" + Math.round(Double.parseDouble(txtTotal.getText()) * 1.18 * 100) / 100.0d, Element.ALIGN_RIGHT, true, 1);
	        
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
