package view;

import javax.swing.*;

public class Alert {
    private JPanel panel;
    private JTextArea textArea1;
    JFrame frame;
    Alert alert;

    public Alert() {
        if (frame==null) frame=new JFrame("Alert");
    }

    public void build(String s) {
        if (alert == null) {
            alert = new Alert();
            panel.updateUI();
            textArea1.append(s);
            frame.setContentPane(alert.panel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.setBounds(200,200,200,150);
            frame.pack();
            frame.setVisible(true);
        }

    }
}
