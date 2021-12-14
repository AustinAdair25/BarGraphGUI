package View;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class DrawGraph extends JPanel {

    public int DEFAULT_VAL = 1;

    private int redHeight = DEFAULT_VAL;
    private int greenHeight = DEFAULT_VAL;
    private int blueHeight = DEFAULT_VAL;

    public void setHeights(int[] heights){
        redHeight = heights[0];
        greenHeight = heights[1];
        blueHeight = heights[2];
    }

    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g2d);

        Rectangle2D.Double r = new Rectangle2D.Double(70, 400 - redHeight, 65, redHeight);
        g2d.setColor(Color.RED);
        g2d.fill(r);

        Rectangle2D.Double r2 = new Rectangle2D.Double(170, 400 - greenHeight, 65, greenHeight);
        g2d.setColor(Color.GREEN);
        g2d.fill(r2);

        Rectangle2D.Double r3 = new Rectangle2D.Double(270, 400 - blueHeight, 65, blueHeight);
        g2d.setColor(Color.BLUE);
        g2d.fill(r3);

        repaint();
    }
}