package Kalkulator_skomplikowany.GUI;

import javax.swing.*;

public class MainFrame extends JFrame {

    private Panel1 panel;

    MainFrame(){

        panel = new Panel1();
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        this.setOpacity(0.7f);
        this.setVisible(true);
    }

    public static void main(String[] args) {

        MainFrame mf = new MainFrame();

    }
}
