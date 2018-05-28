package view;

import javax.swing.*;

public class DicForm {
    private JPanel panel;
    private JTextField textField1;
    private JButton button1;
    Alert alert = new Alert();

    public DicForm() {
//        button1.addActionListener(e -> {
//            alert.build("hello,world!");
//        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("DicForm");
        frame.setContentPane(new DicForm().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
