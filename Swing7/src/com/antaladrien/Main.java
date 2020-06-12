package com.antaladrien;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main {
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;
    private JLabel msglabel;

    public Main(){
        prepareGUI();
    }
    public static void main(String[] args){
        Main swingContainerDemo = new Main();
        swingContainerDemo.showJWindowDemo();
    }
    private void prepareGUI(){
        mainFrame = new JFrame("Java Swing Examples");
        mainFrame.setSize(400,400);
        mainFrame.setLayout(new GridLayout(3, 1));

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });
        headerLabel = new JLabel("", JLabel.CENTER);
        statusLabel = new JLabel("",JLabel.CENTER);
        statusLabel.setSize(350,100);

        msglabel = new JLabel("Welcome", JLabel.CENTER);

        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }
    private void showJWindowDemo(){
        headerLabel.setText("Container in action: JWindow");
        final MessageWindow window = new MessageWindow(
                mainFrame, "Welcome");

        JButton okButton = new JButton("Open a Window");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                window.setVisible(true);
                statusLabel.setText("A Window shown to the user.");
            }
        });
        controlPanel.add(okButton);
        mainFrame.setVisible(true);
    }
    class MessageWindow extends JWindow{
        private String message;
        public MessageWindow(JFrame parent, String message) {
            super(parent);
            this.message = message;
            setSize(300, 300);
            setLocationRelativeTo(parent);
        }
        public void paint(Graphics g) {
            super.paint(g);
            g.drawRect(0,0,getSize().width - 1,getSize().height - 1);
            g.drawString(message,50,150);
        }
    }
}