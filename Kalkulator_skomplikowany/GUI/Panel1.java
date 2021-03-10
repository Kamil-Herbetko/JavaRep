package Kalkulator_skomplikowany.GUI;

import javax.swing.*;
import java.awt.*;

public class Panel1 extends JPanel{
    Panel1(){
        this.setPreferredSize(new Dimension(500,500));
    }

    public void paint(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setStroke(new BasicStroke(50));
        graphics2D.setPaint(Color.blue);
        graphics2D.fillRect(0, 0, 500, 500);
    }
}
