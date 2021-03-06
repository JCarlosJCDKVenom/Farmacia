package capapresentacion;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import com.mysql.jdbc.ResultSetMetaData;

import capanegocios.Item;
import capanegocios.Mercancia;
import capaaccesodatos.CrudItem;
import capaaccesodatos.conexion.ConectarDB;

import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Component;
import java.awt.SystemColor;

public class Ventas extends JFrame{
	
    int rowCount, numfac;
    ConectarDB con = null,query;
	
	private JPanel contentPane;
	private JFrame frmVentas;
	private JTextField txtNombreProducto;
	private JTable Tproductos;
	private JTextField txtCantidad;
	private int selectedId;
	private CrudItem CI;
	private JTextField txtPrecioUnitario;
	String valorTexto;
	private JTextField txtTotal;
	private JPanel JPanel_3;
	private JTable Tlista;
	int j=0;
	
	// private JScrollPane scrollPane_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventas window = new Ventas();
					window.frmVentas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ventas() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		frmVentas = new JFrame();
		frmVentas.setBackground(new Color(0, 191, 255));
		
		frmVentas.getContentPane().setBackground(new Color(0, 191, 255));
		//frmVentas.getContentPane().setBackground(Color.#00C0EF);
		frmVentas.setTitle("Realizar Venta");
		Image imgSalidas = new ImageIcon(this.getClass().getResource("/pills-16.png")).getImage();
		frmVentas.setIconImage(imgSalidas);
		frmVentas.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		frmVentas.setBounds(100, 100, 1080, 750);
		frmVentas.getContentPane().setBounds(0, 0, 1500, 700);
		frmVentas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmVentas.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);

		txtNombreProducto = new JTextField();
		txtNombreProducto.setBounds(40, 29, 1190, 50);
		txtNombreProducto.setFont(new Font("Tahoma", Font.BOLD, 30));
		txtNombreProducto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				valorTexto = txtNombreProducto.getText();
				if (valorTexto.equals("")) {

				} else {
					cargarLista(valorTexto);
				}
				
				
			}
				

		    @Override
			
			public void keyPressed(KeyEvent arg0) {
				
				
				
				
				
				
				
				
				
				
		        
		    
				
				
				
			}
		});
		frmVentas.getContentPane().setLayout(null);
		frmVentas.getContentPane().add(txtNombreProducto);
		txtNombreProducto.setColumns(10);

		JLabel lblLtValor = new JLabel("...");
		lblLtValor.setBounds(553, 283, 81, 14);
		lblLtValor.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLtValor.setForeground(Color.BLACK);
		frmVentas.getContentPane().add(lblLtValor);

		JLabel lblDisp = new JLabel("...");
		lblDisp.setBounds(553, 308, 81, 14);
		lblDisp.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDisp.setForeground(Color.BLACK);
		frmVentas.getContentPane().add(lblDisp);
		

		JLabel lblNuevoDisp = new JLabel("...");
		lblNuevoDisp.setBounds(553, 356, 46, 14);
		lblNuevoDisp.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNuevoDisp.setForeground(Color.BLACK);
		frmVentas.getContentPane().add(lblNuevoDisp);
		
		JScrollPane Sproductos = new JScrollPane();
		Sproductos.setBounds(40, 90, 1190, 159);
		frmVentas.getContentPane().add(Sproductos);

		Tproductos = new JTable();
		Tproductos.setBackground(new Color(0, 153, 255));
		Tproductos.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				
				int row = Tproductos.getSelectedRow();

				selectedId = Integer.parseInt(Tproductos.getModel().getValueAt(row, 0).toString());

				int columnProd = 2;

				String value = Tproductos.getModel().getValueAt(row, columnProd).toString();
				txtNombreProducto.setText(value);
				lblLtValor.setText(Tproductos.getModel().getValueAt(row, 1).toString());
				lblDisp.setText(Tproductos.getModel().getValueAt(row, 5).toString());
				txtPrecioUnitario.setText(Tproductos.getModel().getValueAt(row, 3).toString());
				lblNuevoDisp.setText("...");
			}
		});
		Sproductos.setViewportView(Tproductos);

		JLabel lblSalen = new JLabel("Cantidad:");
		lblSalen.setBounds(30, 280, 108, 28);
		lblSalen.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSalen.setForeground(Color.BLACK);
		frmVentas.getContentPane().add(lblSalen);

		txtCantidad = new JTextField();
		txtCantidad.setBounds(171, 277, 51, 28);
		txtCantidad.setBackground(new Color(176, 224, 230));
		txtCantidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frmVentas.getContentPane().add(txtCantidad);
		txtCantidad.setColumns(10);

		JLabel lblLote = new JLabel("Lote:");
		lblLote.setBounds(431, 280, 46, 14);
		lblLote.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLote.setForeground(Color.BLACK);
		frmVentas.getContentPane().add(lblLote);


		JLabel lblDisponible = new JLabel("Disponible:");
		lblDisponible.setBounds(431, 308, 95, 14);
		lblDisponible.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDisponible.setForeground(Color.BLACK);
		frmVentas.getContentPane().add(lblDisponible);

		JLabel lblExito = new JLabel("...");
		lblExito.setBounds(652, 283, 367, 61);
		lblExito.setForeground(Color.BLACK);
		lblExito.setBackground(Color.BLACK);
		lblExito.setFont(new Font("Tahoma", Font.PLAIN, 24));
		frmVentas.getContentPane().add(lblExito);
		

		JLabel lblNuevo = new JLabel("Nuevo");
		lblNuevo.setBounds(431, 335, 59, 20);
		lblNuevo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNuevo.setForeground(Color.BLACK);
		frmVentas.getContentPane().add(lblNuevo);

		JLabel lblDisponible_1 = new JLabel("Disponible:");
		lblDisponible_1.setBounds(431, 347, 95, 28);
		lblDisponible_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDisponible_1.setForeground(Color.BLACK);
		frmVentas.getContentPane().add(lblDisponible_1);
		
		
		
		
		txtPrecioUnitario = new JTextField();
		txtPrecioUnitario.setBounds(171, 319, 51, 28);
		txtPrecioUnitario.setBackground(new Color(176, 224, 230));
		txtPrecioUnitario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frmVentas.getContentPane().add(txtPrecioUnitario);
		txtPrecioUnitario.setColumns(10);

		JLabel lblPrecioVenta = new JLabel("Precio Venta:");
		lblPrecioVenta.setBounds(30, 319, 154, 28);
		lblPrecioVenta.setForeground(Color.BLACK);
		lblPrecioVenta.setFont(new Font("Tahoma", Font.BOLD, 20));
		frmVentas.getContentPane().add(lblPrecioVenta);

		
	//	String [] cabezera = {"Lote","Nombre_Producto","Cantidad","Precio","Importe"};
		
		
		
	//	JScrollPane sc = new JScrollPane(Tlista);
		
		
		txtTotal = new JTextField();
		txtTotal.setBounds(375, 647, 209, 34);
		txtTotal.setFont(new Font("Times New Roman", Font.BOLD, 28));
		frmVentas.getContentPane().add(txtTotal);
		txtTotal.setColumns(10);
		txtTotal.setHorizontalAlignment(SwingConstants.RIGHT); 
		/*
		JPanel panel = new JPanel();
		panel.setBounds(30, 441, 496, 204);
		frmVentas.getContentPane().add(panel);
		
		*/
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(40, 386, 1190, 240);
		frmVentas.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		
		Tlista  = new JTable (0,4);
		Tlista.setBackground(new Color(0, 153, 255));
		JScrollPane sc = new JScrollPane(Tlista);
		sc.setBounds(0, 0, 1200, 240);
		sc.setPreferredSize(new Dimension(1200,150));
		panel_3.add(sc);
		
		
		
		
		
		JButton btnSalen = new JButton("A\u00F1adir");
		btnSalen.setBounds(232, 276, 154, 71);
		btnSalen.setBackground(new Color(0, 128, 128));
		Image img2Salen = new ImageIcon(this.getClass().getResource("/Ok.png")).getImage();
		Image imgSalen = new ImageIcon(this.getClass().getResource("/Ok-icon.png")).getImage();
		
		btnSalen.setIcon(new ImageIcon(imgSalen));

		btnSalen.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		
		btnSalen.setSelectedIcon(new ImageIcon(img2Salen));
	    btnSalen.setToolTipText("A�adir a la lista de Ventas");
        numfac=1;
        btnSalen.addMouseListener(new MouseAdapter() {

            // agregamos el evento MouseEntered
            // cuando el puntero pase por encima del boton
            // ejecutar� el c�digo que este adentro de �l
            public void mouseEntered(MouseEvent evt) {

            	btnSalen.setIcon(new ImageIcon(img2Salen));
                
            }

          public void mouseExited(MouseEvent evt) {

        	  btnSalen.setIcon(new ImageIcon(imgSalen));
        	  }
          });
		btnSalen.addActionListener(new ActionListener() {
			 public void mouseEntered(ActionEvent evt) {

	                System.out.println("entro el mouse");
	                btnSalen.setEnabled(false);
	            }
			  public void mouseExited(ActionEvent evt) {

	                System.out.println("salio el mause");
				  btnSalen.setEnabled(true);
	            }
			public void actionPerformed(ActionEvent arg0) {
				CI = new CrudItem();
				Mercancia im = CI.findItem(selectedId);
				int actualDisp = im.getDisponible();try {
					int nuevoDisp = actualDisp - Integer.parseInt(txtCantidad.getText());
					im.setDisponible(nuevoDisp);
					boolean bol = CI.editDisponible(im);
					if (bol) {
						numfac++;
						lblNuevoDisp.setText(String.valueOf(im.getDisponible()));
						lblExito.setText("Salida y/o Venta Exitosa!!");
						cargarLista(valorTexto);
					}
					String nomb = "";
					float cant = 0;
					float precioUnitario = 0;
					float precioVenta = 0;
					
					
					nomb=txtNombreProducto.getText();
					cant=Float.parseFloat(txtCantidad.getText());
					precioUnitario = Float.parseFloat(txtPrecioUnitario.getText());///Corregir por el precio unitario   Float.parseFloat(txtPrecioUnitario.getText())*Float.parseFloat(txtCantidad.getText())
					precioVenta=precioUnitario*cant;
					
					CargarDatos(nomb,cant,precioUnitario,precioVenta);
					
					
					
			        
					
				} catch (Exception e) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Error "+e);
				}
				
				
				
				
				
			/*	
				
				DefaultTableModel modelo = new DefaultTableModel(){
					@Override
					public boolean isCellEditable(int rowIndex, int vColIndex) {
						return false;
						}};
					
						int aux = Tproductos.getSelectedRow();
						if (aux==1)
						{
						
							JOptionPane.showMessageDialog(null, "No se a seleccionado nada de la tabla.");
						
						}
						else
						{   

        
        String nombre = Tproductos.getValueAt(aux, 1).toString();
        String precio = Tproductos.getValueAt(aux, 2).toString();
        float total = 0;
		int j=0,w=0,jj=0; 
    String aux2 = precio;
    float tot = Float.parseFloat(aux2);
    String cant = JOptionPane.showInputDialog("Cantidad: ");
    //float cantidad = Float.parseFloat(cant);
    float cantidad = Float.parseFloat(cant);
    //float cantidad = (float)txtSalida.getText();
    tot=tot*cantidad;
    total=tot+total;
    String aux3 = String.valueOf(total);
    jTtotal.setText(aux3);
    DefaultTableModel temp = (DefaultTableModel) 
            Tlista.getModel();
    Object nuevo[]= {temp.getRowCount()+1,"",""};
    temp.addRow(nuevo);
    
       Tlista.setValueAt(nombre, j, 0);
       Tlista.setValueAt(precio, j, 1);
       Tlista.setValueAt(cant, j, 2);
       j++;//Aumenta el contador

}
				
		*/		
				j++;
				
				
			}
		});
		frmVentas.getContentPane().add(btnSalen);

		JButton btnFactura = new JButton("REALIZAR BOLETA");
		btnFactura.setBounds(618, 642, 271, 91);
		Image imgFactura = new ImageIcon(this.getClass().getResource("/BOLET.png")).getImage();
		Image img2Factura = new ImageIcon(this.getClass().getResource("/BOLET2.png")).getImage();

		btnFactura.setIcon(new ImageIcon(imgFactura));
		btnFactura.setForeground(new Color(0, 153, 0));
		btnFactura.setBackground(new Color(0, 0, 128));
		btnFactura.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnFactura.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent evt) {

            	btnFactura.setIcon(new ImageIcon(img2Factura));
            	
            }

          public void mouseExited(MouseEvent evt) {

        	  btnFactura.setIcon(new ImageIcon(imgFactura));
        	  
            }});
		btnFactura.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent arg0) {
				
				
				
		    ////////////////////////////////////////////////////////

			    
			    if (j==0)
			        {

			            JOptionPane.showMessageDialog(null, "No hay ningun elemento  en la Tabla de Venta");

			        }

			        else
			    {
			            try {
			            	
			                Factura Fac = new Factura();
			                rowCount = Tlista.getRowCount();
			                numfac=1;
			                PreparedStatement ps = ConectarDB.getConnection().prepareStatement("select * from detallefactura");
			            	ResultSet rs = ps.executeQuery();
			                while (rs.next()){
			                
			                    numfac++;
			                
			                }
			                Fac.setNum(numfac);
			                
			                //int aux = Tlista.
			                JTable t;
			                t=Fac.getTabla();
			                for(int k=0;k<rowCount;k++)
			                {
			                	DefaultTableModel modelo = (DefaultTableModel)t.getModel();
			                	modelo.addRow(new Object[]{"","","",""});

			                    t.setValueAt(Tlista.getValueAt(k, 0), k, 0);
			                    t.setValueAt(Tlista.getValueAt(k, 1), k, 1);
			                    t.setValueAt(Tlista.getValueAt(k, 2), k, 2);
			                    t.setValueAt(Tlista.getValueAt(k, 3), k, 3);
			                    
			                }
			                Fac.setTabla(t);
			                Fac.setTotal(txtTotal.getText());
			                Fac.setVisible(true);
			                eliminar();
			            } catch (Exception ex) {
			                Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
			            }
			    
			    
			    }
			    
				////////////////////////////////////////////////
			}
		});
		
		frmVentas.getContentPane().add(btnFactura);
		
		JLabel label = new JLabel("$");
		label.setBounds(342, 640, 29, 41);
		label.setForeground(new Color(0, 51, 0));
		label.setFont(new Font("Tahoma", Font.BOLD, 45));
		frmVentas.getContentPane().add(label);
		
		
		Tlista.getColumn("A").setHeaderValue("Nombre_Producto");
		Tlista.getColumn("B").setHeaderValue("Cantidad");
		Tlista.getColumn("C").setHeaderValue("Precio_Unidad");
		Tlista.getColumn("D").setHeaderValue("PrecioVenta");
		

		

	}
	

	public void cargarLista(String valor) {
		DefaultTableModel DTM = new DefaultTableModel();

		CrudItem cm = new CrudItem();
		List<Item> lm = cm.findAllLikeByDate(valor);
		Object[][] objectFila = new Object[lm.size()][6];

		for (int i = 0; i < lm.size(); i++) {
			objectFila[i][0] = lm.get(i).getId();
			objectFila[i][1] = lm.get(i).getLote();
			objectFila[i][2] = lm.get(i).getNombre();
			objectFila[i][3] = lm.get(i).getPrecio();
			objectFila[i][4] = lm.get(i).getVencimiento();
			objectFila[i][5] = lm.get(i).getDisponible();
		}
		DTM.setDataVector(objectFila, new Object[] { "", "Lote", "Producto", "$ Venta", "Vencimiento", "Quedan" });

		Tproductos.setModel(DTM);
		Tproductos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		Tproductos.getColumnModel().getColumn(0).setPreferredWidth(-1);
		Tproductos.getColumnModel().getColumn(1).setPreferredWidth(60);
		Tproductos.getColumnModel().getColumn(2).setPreferredWidth(939);
		Tproductos.getColumnModel().getColumn(3).setPreferredWidth(50);
		Tproductos.getColumnModel().getColumn(4).setPreferredWidth(90);
		Tproductos.getColumnModel().getColumn(5).setPreferredWidth(50);
		
		Tlista.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		//Tlista.getColumnModel().getColumn(0).setPreferredWidth(-1);
		Tlista.getColumnModel().getColumn(0).setPreferredWidth(939);
		Tlista.getColumnModel().getColumn(1).setPreferredWidth(71);
		Tlista.getColumnModel().getColumn(2).setPreferredWidth(90);
		Tlista.getColumnModel().getColumn(3).setPreferredWidth(90);
		//Tlista.getColumnModel().getColumn(3).setPreferredWidth(50);

	}
	float total=0;
	public void CargarDatos(String nombre , float cantidad, float precioU, float precioV) {
		DefaultTableModel modelo = (DefaultTableModel)Tlista.getModel();
		modelo.addRow(new Object[] {nombre,cantidad,precioU,precioV});
		
		float Vtotal=Float.parseFloat(txtPrecioUnitario.getText())*Float.parseFloat(txtCantidad.getText());
		
        total=total+Vtotal;
        
        String aux3 = String.valueOf(total);
        txtTotal.setText(aux3);
	}
	public JTable getTabla(){
	    return this.Tlista;
	}
	 public void eliminar(){
		 txtTotal.setText("0");
		 total = 0;
	        DefaultTableModel tb = (DefaultTableModel)Tlista.getModel();
	        int a = Tlista.getRowCount()-1;
	        for (int i = a; i >= 0; i--) {           
	        tb.removeRow(tb.getRowCount()-1);
	        } 
	        //cargaTicket();
	    }

	public int getFactura() {
		// TODO Auto-generated method stub
		return rowCount;
	}
}
