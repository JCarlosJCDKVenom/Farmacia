package capapresentacion;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.border.Border;
import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;


class RoundedBorder implements Border {

	/*/ Establecemos un UI específico
	  ShapedButtonUI roundUI = new ShapedButtonUI();
	  roundUI.setShape(ButtonShape.ROUND, roundButton);
	  roundButton.setUI(roundUI);
	  roundButton.setPreferredSize(new Dimension(100, 100));
	  ShapedButtonUI squareUI = new ShapedButtonUI();
	  squareUI.setShape(ButtonShape.SQUARE, squareButton);
	  squareButton.setUI(squareUI);
	  squareButton.setPreferredSize(new Dimension(100, 100));
	  ShapedButtonUI polygonUI = new ShapedButtonUI();
	  polygonUI.setShape(ButtonShape.POLYGON, polygonButton);
	  polygonButton.setUI(polygonUI);
	  polygonButton.setPreferredSize(new Dimension(100, 100));
	 
	
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    private int radius;

    RoundedBorder(int radius) {
        this.radius = radius;
    }

    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
    }

    public boolean isBorderOpaque() {
        return true;
    }

    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawRoundRect(x, y, width-1, height-1, radius, radius);
    }
}
