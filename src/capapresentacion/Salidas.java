package capapresentacion;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import capanegocios.Item;
import capanegocios.Medicina;
import capanegocios.Mercancia;
import capaaccesodatos.CrudItem;
import capaaccesodatos.CrudMedicina;

import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

public class Salidas {

	private JFrame frmSalidaDeProductos;
	private JTextField txtProducto;
	private JTable table;
	private JTextField txtSalida;
	private int selectedId;
	private CrudItem CI;
	private JTextField txtVenta;
	//String valorTexto;
	//private JScrollPane scrollPane_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Salidas window = new Salidas();
					window.frmSalidaDeProductos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	public Salidas() {
		initialize();
	}

	
	
	private void initialize() {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		frmSalidaDeProductos = new JFrame();
		frmSalidaDeProductos.getContentPane().setBackground(Color.BLACK);
		frmSalidaDeProductos.setTitle("Salida de Productos");
		Image imgSalidas = new ImageIcon(this.getClass().getResource("/pills-16.png")).getImage();
		frmSalidaDeProductos.setIconImage(imgSalidas);
		frmSalidaDeProductos.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		frmSalidaDeProductos.setBounds(100, 100, 820, 548);
		frmSalidaDeProductos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmSalidaDeProductos.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
		frmSalidaDeProductos.getContentPane().setLayout(null);
		
		txtProducto = new JTextField();
		txtProducto.setFont(new Font("Tahoma", Font.BOLD, 30));
		txtProducto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String valorTexto = txtProducto.getText();
				if(valorTexto.equals("")) {

				}
				else {
					cargarLista(valorTexto);
				}
				
			}
		});
		txtProducto.setBounds(30, 29, 1220, 50);
		frmSalidaDeProductos.getContentPane().add(txtProducto);
		txtProducto.setColumns(10);
		
		JLabel lblLtValor = new JLabel("...");
		lblLtValor.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLtValor.setForeground(Color.WHITE);
		lblLtValor.setBounds(553, 283, 81, 14);
		frmSalidaDeProductos.getContentPane().add(lblLtValor);
		
		JLabel lblDisp = new JLabel("...");
		lblDisp.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDisp.setForeground(Color.WHITE);
		lblDisp.setBounds(553, 308, 81, 14);
		frmSalidaDeProductos.getContentPane().add(lblDisp);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(30, 90, 1220, 159);
		frmSalidaDeProductos.getContentPane().add(scrollPane_1);
		
		table = new JTable();
		table.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
				System.out.println("***********");
				int row = table.getSelectedRow();
				
				selectedId = Integer.parseInt(table.getModel().getValueAt(row, 0).toString());

				int columnProd = 2;
				
				String value = table.getModel().getValueAt(row, columnProd).toString();
				txtProducto.setText(value);
				lblLtValor.setText(table.getModel().getValueAt(row, 1).toString());
				lblDisp.setText(table.getModel().getValueAt(row, 5).toString());
				txtVenta.setText(table.getModel().getValueAt(row, 3).toString());
		    }
		});
		scrollPane_1.setViewportView(table);
		
		JLabel lblSalen = new JLabel("Salen:");
		lblSalen.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSalen.setForeground(Color.WHITE);
		lblSalen.setBounds(30, 280, 87, 28);
		frmSalidaDeProductos.getContentPane().add(lblSalen);
		
		txtSalida = new JTextField();
		txtSalida.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtSalida.setBounds(171, 277, 51, 28);
		frmSalidaDeProductos.getContentPane().add(txtSalida);
		txtSalida.setColumns(10);
		
		JLabel lblLote = new JLabel("Lote:");
		lblLote.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLote.setForeground(Color.WHITE);
		lblLote.setBounds(431, 280, 46, 14);
		frmSalidaDeProductos.getContentPane().add(lblLote);
		
		JLabel lblNuevoDisp = new JLabel("...");
		lblNuevoDisp.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNuevoDisp.setForeground(Color.WHITE);
		lblNuevoDisp.setBounds(553, 356, 46, 14);
		frmSalidaDeProductos.getContentPane().add(lblNuevoDisp);
		
		JLabel lblDisponible = new JLabel("Disponible:");
		lblDisponible.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDisponible.setForeground(Color.WHITE);
		lblDisponible.setBounds(431, 308, 95, 14);
		frmSalidaDeProductos.getContentPane().add(lblDisponible);
		
		JLabel lblExito = new JLabel("...");
		lblExito.setForeground(Color.WHITE);
		lblExito.setBackground(Color.WHITE);
		lblExito.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblExito.setBounds(95, 420, 310, 61);
		frmSalidaDeProductos.getContentPane().add(lblExito);
		
		JButton btnSalen = new JButton("Salen");
		Image imgSalen = new ImageIcon(this.getClass().getResource("/Ok-icon.png")).getImage();
		btnSalen.setIcon(new ImageIcon(imgSalen));
		
		btnSalen.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSalen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CI = new CrudItem();
				Mercancia im = CI.findItem(selectedId);
				int actualDisp = im.getDisponible();
				int nuevoDisp = actualDisp - Integer.parseInt(txtSalida.getText());
				im.setDisponible(nuevoDisp);
				boolean bol = CI.editDisponible(im);
				if(bol) {
					lblNuevoDisp.setText(String.valueOf(im.getDisponible()));
					lblExito.setText("Salida y/o Venta Exitosa!!");
					//cargarLista(valorTexto);
				}
			}
		});
		btnSalen.setBounds(232, 276, 154, 71);
		frmSalidaDeProductos.getContentPane().add(btnSalen);
		
		JLabel lblNuevo = new JLabel("Nuevo");
		lblNuevo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNuevo.setForeground(Color.WHITE);
		lblNuevo.setBounds(431, 335, 59, 20);
		frmSalidaDeProductos.getContentPane().add(lblNuevo);
		
		JLabel lblDisponible_1 = new JLabel("Disponible:");
		lblDisponible_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDisponible_1.setForeground(Color.WHITE);
		lblDisponible_1.setBounds(431, 347, 95, 28);
		frmSalidaDeProductos.getContentPane().add(lblDisponible_1);
		
		txtVenta = new JTextField();
		txtVenta.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtVenta.setBounds(171, 319, 51, 28);
		frmSalidaDeProductos.getContentPane().add(txtVenta);
		txtVenta.setColumns(10);
		
		JLabel lblPrecioVenta = new JLabel("Precio Venta:");
		lblPrecioVenta.setForeground(Color.WHITE);
		lblPrecioVenta.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPrecioVenta.setBounds(30, 319, 154, 28);
		frmSalidaDeProductos.getContentPane().add(lblPrecioVenta);
		

	}
	public void cargarLista(String valor){
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
		
		table.setModel(DTM);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(-1);
		table.getColumnModel().getColumn(1).setPreferredWidth(60);
		table.getColumnModel().getColumn(2).setPreferredWidth(800);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
		table.getColumnModel().getColumn(4).setPreferredWidth(90);
		table.getColumnModel().getColumn(5).setPreferredWidth(50);
	}
	public void cargarLista1(String valor){
		DefaultListModel dlm = new DefaultListModel();
		
		CrudMedicina cm = new CrudMedicina();
		List<Medicina> lm = cm.findAllLike(valor);
		
		for (int i = 0; i < lm.size(); i++) {
		    dlm.addElement(lm.get(i).getNomMed());
		}
		
		//table.setModel( dlm);
	}

}
