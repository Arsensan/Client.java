package GUI;

import java.awt.*;
import javax.swing.*;

public class GUI extends JFrame {
    JFrame f1;


    public GUI() {
        f1 = new JFrame("Storage 1.0");
        JTextArea clientWindow = new JTextArea();
        JTextArea serverWindow = new JTextArea();
        JTextField t1 = new JTextField();
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        JButton uploadButton = new JButton();
        JButton downloadButton = new JButton();
        JButton upButton = new JButton();
        JButton downButton = new JButton();
        uploadButton.setText("->");
        downloadButton.setText("<-");
        upButton.setText("Up");
        downButton.setText("Down");
        uploadButton.setSize(10, 10);
        downloadButton.setSize(10, 10);
        upButton.setSize(10, 10);
        downButton.setSize(10, 10);
        p1.setLayout(new BorderLayout());
        p2.setLayout(new BorderLayout());
        p3.setLayout(new BorderLayout());
        p4.setLayout(null);
        f1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f1.setSize(600, 600);
        f1.setResizable(false);
        f1.setLayout(new BorderLayout());
        f1.add(p1, BorderLayout.WEST);
        f1.add(p2, BorderLayout.EAST);
        f1.add(p3, BorderLayout.NORTH);
        f1.add(p4, BorderLayout.CENTER);
        p1.setBorder(BorderFactory.createLineBorder(Color.black));
        p1.setPreferredSize(new Dimension(230, 0));
        p2.setBorder(BorderFactory.createLineBorder(Color.black));
        p2.setPreferredSize(new Dimension(230, 0));
        p3.setPreferredSize(new Dimension(0, 50));
        p1.getRootPane().setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
        p1.add(clientWindow);
        p2.add(serverWindow);
        t1.setEditable(false);
        p3.add(t1);
        p4.add(uploadButton);
        p4.add(downloadButton);
        p4.add(upButton);
        p4.add(downButton);
        uploadButton.setBounds(10, 50, 70, 50);
        downloadButton.setBounds(10, 150, 70, 50);
        upButton.setBounds(10, 280, 70, 50);
        downButton.setBounds(10, 400, 70, 50);
        f1.setVisible(true);
    }

    public static void main(String[] args) {
        new GUI();
    }
}
