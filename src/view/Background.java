package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class Background extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);      
        Graphics2D g2d = (Graphics2D) g.create();        
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);        
        g2d.setColor(Color.decode("#AAD7CE"));  
        g2d.fillRect(0, 0, getWidth(), getHeight());
        g2d.dispose();
    }

}
