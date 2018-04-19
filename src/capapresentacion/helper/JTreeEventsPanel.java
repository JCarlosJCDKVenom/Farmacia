package capapresentacion.helper;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.ScrollPaneConstants;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import capapresentacion.Entradas;
import capapresentacion.MainWindow;
import capapresentacion.Salidas;
import capapresentacion.Ventas;

public class JTreeEventsPanel extends JPanel {
	  JTree tree;

	  JTextField JTexto;

	  public JTreeEventsPanel() {
	    setLayout(new BorderLayout());
	    DefaultMutableTreeNode top = new DefaultMutableTreeNode("Menu Principal");

	    DefaultMutableTreeNode a = new DefaultMutableTreeNode("Medicamentos");
	    top.add(a);
	    
	    a.add(new DefaultMutableTreeNode("Registrar Venta"));
	    a.add(new DefaultMutableTreeNode("Ingreso de Medicamentos"));
	    a.add(new DefaultMutableTreeNode("Salida de Medicamentos"));

	    DefaultMutableTreeNode b = new DefaultMutableTreeNode("Reportes");
	    top.add(b);
	    
	    b.add(new DefaultMutableTreeNode("Productos x Vencer"));
	    b.add(new DefaultMutableTreeNode("Productos x Terminarse"));
	    
	    ImageIcon iconoNodo = createImageIcon("/ok.png");
	    ImageIcon iconoPadre = createImageIcon("/medical-pills-pot-icon.png");
	    
	    tree = new JTree(top);
	    
	    tree.setCellRenderer(new MyArbolRenderer(iconoPadre, iconoNodo));
	    expandAllNodes(tree, 0, tree.getRowCount());
	    int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
	    int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
	    
		JLabel label = new JLabel("");
		Image imgMain = new ImageIcon(this.getClass().getResource("/paisaje.png")).getImage();
		label.setIcon(new ImageIcon(imgMain));
		
	    JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	    JScrollPane jspI = new JScrollPane(tree, v, h);

	    JPanel PanelMarca = new JPanel();
	    PanelMarca.add(label);
	    
	    splitPane.setLeftComponent(jspI);
	    splitPane.setRightComponent(PanelMarca);
	    splitPane.setDividerLocation(230);
	    splitPane.setDividerSize(5);
	    splitPane.setBackground(Color.BLACK);
	    add(splitPane);
	    
	    JTexto = new JTextField("", 20);
	    
	    //add(jsp, BorderLayout.CENTER);
	    add(JTexto, BorderLayout.SOUTH);

	    tree.addMouseListener(new MouseAdapter() {
	      public void mouseClicked(MouseEvent me) {

	        doMouseClicked(me);
	      }
	    });
	  }

	  void doMouseClicked(MouseEvent me) {
		 
		//VentTree.main(null);

	    TreePath tp = tree.getPathForLocation(me.getX(), me.getY());
	    Object path[] = tp.getPath();
	    if (tp != null) {
	    	JTexto.setText(tp.toString());

	    	if(path.length==3) {
	    		String ss = path[2].toString();
	    		if(ss.equals("Ingreso de Medicamentos")) {
	    			Entradas ent = new Entradas();
	    			ent.main(null);
	    		}
	    		if(ss.equals("Salida de Medicamentos")) {
	    			Salidas ent = new Salidas();
	    			ent.main(null);
	    		}
	    		if(ss.equals("Registrar Venta")) {
	    			Ventas ent = new Ventas();
	    			ent.main(null);
	    		}
	    	}
	    }
	    else
	    	JTexto.setText("");
	    
	  }
	  
	  protected static ImageIcon createImageIcon(String path) {
		    java.net.URL imgURL = MainWindow.class.getResource(path);
		    if (imgURL != null) {
		      return new ImageIcon(imgURL);
		    } else {
		      System.err.println("Couldn't find file: " + path);
		      return null;
		    }
		  }
	  
	  private void expandAllNodes(JTree tree, int startingIndex, int rowCount){
		    for(int i=startingIndex;i<rowCount;++i){
		        tree.expandRow(i);
		    }

		    if(tree.getRowCount()!=rowCount){
		        expandAllNodes(tree, rowCount, tree.getRowCount());
		    }
		}
	}