package capapresentacion.helper;

import java.awt.Component;

import javax.swing.Icon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

public class MyArbolRenderer extends DefaultTreeCellRenderer {
  Icon icono1;
  Icon icono2;

  public MyArbolRenderer(Icon icon1,Icon icon2) {
	  icono1 = icon1;
	  icono2 = icon2;
  }

  public Component getTreeCellRendererComponent(JTree tree, Object value,
      boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {

    super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row,hasFocus);
    
    if (leaf) {
      setIcon(icono2);
      setToolTipText("This book is in the Tutorial series.");
    } else {
    	setIcon(icono1);
      setToolTipText(null); // no tool tip
    }

    return this;
  }

  protected boolean isTutorialBook(Object value) {
/*    DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
    BookInfo nodeInfo = (BookInfo) (node.getUserObject());
    String title = nodeInfo.bookName;
    if (title.indexOf("Tutorial") >= 0) {
      return true;
    }

    return false;*/
	  
	  return true;
  }
}