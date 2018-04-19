package capapresentacion;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import capanegocios.Item;
import capaaccesodatos.CrudItem;

import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Vencidos {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vencidos window = new Vencidos();
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
	public Vencidos() {
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
		
		frame = new JFrame();
		frame.setBounds(100, 100, 968, 442);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 87, 1220, 159);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		cargarTabla();
	}
	
	public void cargarTabla(){
		DefaultTableModel DTM = new DefaultTableModel();
		
		CrudItem cm = new CrudItem();
		List<Item> lm = cm.listarMercanciaVencida();
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
}
