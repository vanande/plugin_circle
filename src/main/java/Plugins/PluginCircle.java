package Plugins;

import org.odm.Circle;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

public class PluginCircle implements Circle {public String getName() {
    return "redcircle";
}public void drawCircle(final int radius) {
    JPanel pnlCircle = new JPanel() {
        public void paintComponent(Graphics g) {
            int X = 250-radius;
            int Y = 250-radius;
            g.setColor(Color.red);
            g.fillOval(X, Y, radius * 2, radius * 2);
            g.drawOval(X, Y, radius * 2, radius * 2);
        }
    };
    JFrame frame = new JFrame();
    frame.add(pnlCircle);
    frame.setSize(500, 500);
    frame.setVisible(true);
}

}
