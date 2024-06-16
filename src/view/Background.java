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

    // Cast to Graphics2D for better control over graphics settings
    Graphics2D g2d = (Graphics2D) g.create();

    // Set the rendering hint for better image quality (if needed)
    g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

    // Set the background color you want to paint, for example, light blue
    g2d.setColor(Color.decode("#AAD7CE"));  // You can change this to any color you like

    // Fill the entire panel with the background color
    g2d.fillRect(0, 0, getWidth(), getHeight());

    // Dispose the Graphics2D object to free up resources
    g2d.dispose();
  }
}
