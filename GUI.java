import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    private JPanel mainPanel;
    private JPanel panel1;
    private JPanel panel2;
    private JTextPane tfield1;
    private JTextPane tfield2;
    private JButton button1;
    private JButton button2;
    private ButtonActionListener1 buttonActionListener1;
    private ButtonActionListener2 buttonActionListener2;

    public GUI(){
        this.mainPanel = new JPanel(new GridLayout(1,2));
        this.panel1 = new JPanel();
        this.panel2 = new JPanel();
        this.tfield1 = new JTextPane();
        this.tfield2 = new JTextPane();
        this.button1 = new JButton("Button1");
        this.button2 = new JButton("Button2");
        this.buttonActionListener1 = new ButtonActionListener1();
        this.buttonActionListener2 = new ButtonActionListener2();

        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        button1.addActionListener(buttonActionListener1);
        button2.addActionListener(buttonActionListener2);
        tfield1.setMaximumSize(new Dimension(400, 300));
        tfield2.setMaximumSize(new Dimension(400,300));
        tfield1.setEditable(false);
        tfield2.setEditable(false);

        panel1.add(tfield1);
        panel1.add(button1);

        panel2.add(tfield2);
        panel2.add(button2);

        mainPanel.add(panel1);
        mainPanel.add(panel2);

        this.add(mainPanel);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 400);
        this.setResizable(false);
        this.setVisible(true);
    }

    class ButtonActionListener1 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            int[][] tablica = Connector.mnożenie();
            tfield1.setText(Connector.drukujMacierz(tablica));
        }
    }

    class ButtonActionListener2 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            int[][] tablica = Connector.maxMin();
            tfield2.setText(Connector.drukujMacierz(tablica));
        }
    }
}
