/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textfileencryption;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author Emilson
 */
public class Customize extends JFrame{ 
    public JPanel contentPanel, headPanel;
    public JButton minBtn, closeBtn;
    public JLabel headLbl;
    public JFrame frame;
    
    public Customize(int width, JFrame frame){
    contentPanel = new JPanel();
        //frame.setContentPane(contentPanel);
        this.frame = frame;
        contentPanel.setLayout(null);
        contentPanel.setBorder(new LineBorder(SystemColor.control));

        headPanel = new JPanel();
        headPanel.setBounds(0, 0, width, 50);
        headPanel.setBackground(Color.decode("#ff4081"));
        headPanel.setLayout(null);
        contentPanel.add(headPanel);

        headLbl = new JLabel("Text to Image Encryption");
        headLbl.setFont(new Font("Open Sans", Font.BOLD, 16));
        headLbl.setBounds(20, 0, 200, 50);
        headLbl.setForeground(Color.decode("#fafafa"));
        headPanel.add(headLbl);
        

        minBtn = new JButton(new ImageIcon("Images/Min.png"));
        minBtn.setBounds(width-84, 14, 32, 35);
        minBtn.setRolloverIcon(new ImageIcon("Images/Min.png"));
        minBtn.setFocusPainted(false);
        minBtn.setBorder(null);
        minBtn.setContentAreaFilled(false);
        minBtn.setToolTipText("Minimize");
        minBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        minBtn.addActionListener((ActionEvent e) -> {
           minimize();
        });
        headPanel.add(minBtn);

        closeBtn = new JButton(new ImageIcon("Images/Close.png"));
        closeBtn.setBounds(width - 45, 8, 35, 35);
        closeBtn.setRolloverIcon(new ImageIcon("Images/Close.png"));
        closeBtn.setFocusPainted(false);
        closeBtn.setBorder(null);
        closeBtn.setContentAreaFilled(false);
        closeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        closeBtn.addActionListener((ActionEvent e) -> {
            close();
        });
        headPanel.add(closeBtn);
    }
    
    public void minimize(){
        frame.setExtendedState(JFrame.ICONIFIED);
    }
    public void close(){
        frame.dispose();
    }
   }
