package Kalkulator_skomplikowany.GUI;

import Kalkulator_skomplikowany.GUI.CustomOkno.customjframe.CustomJFrame;
import Kalkulator_skomplikowany.GUI.CustomOkno.theme.DarkTheme;

import javax.swing.*;
import java.awt.*;


public class Ramka {
    public static void main(String[] args) {
        CustomJFrame ramkaG = new CustomJFrame(new DarkTheme(), "Kalkulator_skomplikowany");

        JPanel ramka = new JPanel();
        ramka.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        ramka.setOpaque(false);


        JPanel panel1 = new JPanel();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        ramka.add(panel1, c);


        JPanel panel2 = new JPanel();
        c.fill = GridBagConstraints.VERTICAL;
        c.gridx = 1;
        c.gridy = 0;
        ramka.add(panel2, c);


        JPanel panel3 = new JPanel();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 2;
        c.weightx = 4;
        c.weighty = 2.25;
        ramka.add(panel3, c);

        JPanel panel4 = new JPanel();
        c.fill = GridBagConstraints.VERTICAL;
        c.gridx = 0;
        c.gridy = 1;
        c.weighty = 0.1;
        c.anchor = GridBagConstraints.LINE_START;
        ramka.add(panel4, c);

        panel3.setLayout(new GridLayout(6,4));
        panel4.setLayout(new GridLayout(1,5));

        JButton przycisk1 = new JButton("%");
        przycisk1.setOpaque(false);
        JButton przycisk2 = new JButton("CE");
        JButton przycisk3 = new JButton("C");
        JButton przycisk4 = new JButton("del");
        JButton przycisk5 = new JButton("1/x");
        JButton przycisk6 = new JButton("x^2");
        JButton przycisk7 = new JButton("sqrt(x)");
        JButton przycisk8 = new JButton("/");
        JButton przycisk9 = new JButton("7");
        JButton przycisk10 = new JButton("8");
        JButton przycisk11 = new JButton("9");
        JButton przycisk12 = new JButton("x");
        JButton przycisk13 = new JButton("4");
        JButton przycisk14 = new JButton("5");
        JButton przycisk15 = new JButton("6");
        JButton przycisk16 = new JButton("-");
        JButton przycisk17 = new JButton("1");
        JButton przycisk18 = new JButton("2");
        JButton przycisk19 = new JButton("3");
        JButton przycisk20 = new JButton("+");
        JButton przycisk21 = new JButton("+/-");
        JButton przycisk22 = new JButton("0");
        JButton przycisk23 = new JButton(",");
        JButton przycisk24 = new JButton("=");
        JButton przycisk25 = new JButton("MC");
        JButton przycisk26 = new JButton("MR");
        JButton przycisk27 = new JButton("M+");
        JButton przycisk28 = new JButton("M-");
        JButton przycisk29 = new JButton("MS");

        panel3.add(przycisk1);
        panel3.add(przycisk2);
        panel3.add(przycisk3);
        panel3.add(przycisk4);
        panel3.add(przycisk5);
        panel3.add(przycisk6);
        panel3.add(przycisk7);
        panel3.add(przycisk8);
        panel3.add(przycisk9);
        panel3.add(przycisk10);
        panel3.add(przycisk11);
        panel3.add(przycisk12);
        panel3.add(przycisk13);
        panel3.add(przycisk14);
        panel3.add(przycisk15);
        panel3.add(przycisk16);
        panel3.add(przycisk17);
        panel3.add(przycisk18);
        panel3.add(przycisk19);
        panel3.add(przycisk20);
        panel3.add(przycisk21);
        panel3.add(przycisk22);
        panel3.add(przycisk23);
        panel3.add(przycisk24);

        panel4.add(przycisk25);
        panel4.add(przycisk26);
        panel4.add(przycisk27);
        panel4.add(przycisk28);
        panel4.add(przycisk29);

        panel1.setOpaque(false);
        panel2.setOpaque(false);
        panel3.setOpaque(false);
        panel4.setOpaque(false);

        ramkaG.add(ramka);
        ramkaG.pack();
        ramkaG.setVisible(true);

    }
}
