/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.panels;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 *
 * @author User
 */
public class CreateAccountPanel extends Panel {

    private JPanel panel, topPanel, bottomPanel2;
    private JButton createButton;
    private JTextField newPassword, newUsername;
    

    public CreateAccountPanel() {
        this.panel = new JPanel();        
    }

    @Override
    public void initComponents() {
        
        ImageIcon sideimage = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Vegit\\Vegit\\SQLDbTest\\src\\main\\images\\vehepalsta.png");
        ImageIcon logoimage = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Vegit\\Vegit\\SQLDbTest\\src\\main\\images\\Vegit_Logo.png");
        
        ImageIcon createaccountbtn = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Vegit\\Vegit\\SQLDbTest\\src\\main\\images\\buttons\\Createaccountbtn.jpg");
        
        //initialize components for panel3
        
        JLabel sidepic = new JLabel(sideimage, JLabel.CENTER);    
        JLabel mainlogo = new JLabel(logoimage, JLabel.CENTER);
        JLabel loginunp3 = new JLabel("Desired username");
        JLabel loginpwp3 = new JLabel("Desired password");
        topPanel = new JPanel();
        bottomPanel2 = new JPanel();
        newUsername = new JTextField();
        newPassword = new JTextField();
        createButton = new JButton("");
        createButton.setIcon(createaccountbtn);

        //set sizes for components in panel 3
        mainlogo.setBounds(225, 40, 200, 50);
        sidepic.setBounds(0, 0, 45, 768);
        loginunp3.setBounds(160, 150, 150, 20);
        loginpwp3.setBounds(160, 200, 150, 20);
        topPanel.setBounds(160, 110, 310, 15);
        bottomPanel2.setBounds(160, 250, 310, 15);
        newUsername.setBounds(320, 150, 150, 20);
        newPassword.setBounds(320, 200, 150, 20);
        createButton.setBounds(182, 300, 280, 40);
        
         //set borders for for components in panel3
        sidepic.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        //add components to panel3
        panel.add(mainlogo);
        panel.add(sidepic);
        panel.add(loginunp3);
        panel.add(loginpwp3);
        panel.add(topPanel);
        panel.add(bottomPanel2);
        topPanel.setBackground(Color.LIGHT_GRAY);
        bottomPanel2.setBackground(Color.LIGHT_GRAY);
        panel.add(newUsername);
        panel.add(newPassword);
        panel.add(createButton);
        panel.setBackground(Color.white);

        panel.setLayout(null);
    }

    @Override
    public JPanel getPanel() {
        return this.panel;
    }
    
    public JButton getCreateButton() {
        return this.createButton;
    }
    
    public boolean isValidPassword(String text) {
        if (this.newPassword.getText().length() >= 6 && this.newPassword.getText().length() <= 25) {
            return true;        
        }
        return false;
    }
    
    public boolean isValidUsername(String text) {
        if (this.newUsername.getText().length() >= 3 && this.newUsername.getText().length() <= 25) {
            return true;        
        }
        return false;
    }

}
