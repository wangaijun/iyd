package view;

import applayer.WordsNote;
import model.AntiLayer;
import model.BasicBean;
import util.AudioPlayer;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static applayer.DictionaryKt.lookAndPlay;

public class DicForm {
    private JPanel panel;
    private JTextField textField1;
    private JTextArea textArea1;
    private JButton button1;
    private JButton button2;
    Alert alert = new Alert();
    private String q;
    private BasicBean basicBean;

    public DicForm() {
        setViewProperty();
        setViewListener();
    }

    private void setViewProperty() {
        textField1.setFont(new Font("宋体",Font.BOLD,20));
        textArea1.setFont(new Font("宋体",Font.BOLD,16));
    }

    private void setViewListener() {
        textField1.addActionListener(e -> {
            q = textField1.getText();
            basicBean = lookAndPlay(new String[]{q});
            textArea1.setText(basicBean.toString());
        });
        button1.addActionListener(e -> new AudioPlayer().play(q));
        button2.addActionListener(e -> {
            if (basicBean!=null) WordsNote.INSTANCE.save(AntiLayer.INSTANCE.toWord(q,basicBean));
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("DicForm");
        frame.setContentPane(new DicForm().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,200);
//        frame.pack();
        frame.setLocation(1000, 500);
        frame.setVisible(true);
    }
}
