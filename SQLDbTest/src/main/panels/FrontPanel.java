/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.panels;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIDefaults;
import javax.swing.UIManager;

/**
 *
 * @author User
 */
public class FrontPanel extends Panel {

    private JPanel panel, topPanel, bottomPanel;
    private JButton login;
    private JButton createAccount;
    private Font customFont;

    public FrontPanel() {
        this.panel = new JPanel();

    }

    @Override
    public void initComponents() {
        

        ImageIcon sideimage = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Vegit\\Vegit\\SQLDbTest\\src\\main\\images\\vehepalsta.png");
        ImageIcon logoimage = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Vegit\\Vegit\\SQLDbTest\\src\\main\\images\\Vegit_Logo.png");
        
        
        
        //button icons
        ImageIcon createbtn = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Vegit\\Vegit\\SQLDbTest\\src\\main\\images\\buttons\\Createbtn.jpg");
        ImageIcon loginbtn = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Vegit\\Vegit\\SQLDbTest\\src\\main\\images\\buttons\\Loginbtn.jpg");
        
        JLabel sidepic = new JLabel(sideimage, JLabel.CENTER);
        JLabel mainlogo = new JLabel(logoimage, JLabel.CENTER);

//      set borders for for components in panel4
        sidepic.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        
        
        //initialize components for FrontPanel
        JLabel loginun = new JLabel("Username");
        JLabel loginpw = new JLabel("Password");
        JTextField loginUsername = new JTextField();
        JPasswordField loginPassword = new JPasswordField();
        login = new JButton("");
        bottomPanel = new JPanel();
        topPanel = new JPanel();
        createAccount = new JButton("");
        createAccount.setIcon(createbtn);
        login.setIcon(loginbtn);
        login.setBackground(Color.red);
        login.setFont(null);

        //set sizes for components in panel 4
        mainlogo.setBounds(225, 40, 200, 50);
        sidepic.setBounds(0, 0, 45, 768);
        loginun.setBounds(180, 150, 100, 20);
        loginpw.setBounds(180, 200, 100, 20);
        topPanel.setBounds(160, 110, 310, 15);
        bottomPanel.setBounds(160, 250, 310, 15);
        loginUsername.setBounds(300, 150, 150, 20);
        loginPassword.setBounds(300, 200, 150, 20);
        login.setBounds(162, 300, 160, 40);
        createAccount.setBounds(322, 300, 160, 40);

        //set fonts for components
        
        topPanel.setBackground(Color.LIGHT_GRAY);
        bottomPanel.setBackground(Color.LIGHT_GRAY);
        
        //add components to panel4
        panel.add(mainlogo);
        panel.add(sidepic);
        panel.add(loginun);
        panel.add(loginpw);
        panel.add(loginUsername);
        panel.add(loginPassword);
        panel.add(topPanel);
        panel.add(bottomPanel);        
        panel.add(login);
        panel.add(createAccount);
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);

    }

    @Override
    public JPanel getPanel() {
        return this.panel;
    }

    public JButton getLogin() {
        return this.login;
    }

    public JButton getCreateAccount() {
        return this.createAccount;
    }


}
