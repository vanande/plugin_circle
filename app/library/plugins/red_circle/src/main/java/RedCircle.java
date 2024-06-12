package org.odm;
import java.awt.Graphics;import javax.swing.JFrame;
import javax.swing.JPanel;

public class BasicCircle implements Circle { public String getName() {
    return "basic";
} public void drawCircle(final int radius) {
    JPanel pnlCircle = new JPanel() {
        public void paintComponent(Graphics g) {
            int X = 250-radius;
            int Y = 250-radius;
            g.drawOval(X, Y, radius * 2, radius * 2);
        }
    };
    JFrame frame = new JFrame();
    frame.add(pnlCircle);
    frame.setSize(500, 500);
    frame.setVisible(true);
}
}
