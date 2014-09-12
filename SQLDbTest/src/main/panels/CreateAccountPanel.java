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

    private JPanel panel;
    private JButton createButton;

    public CreateAccountPanel() {
        this.panel = new JPanel();
    }

    @Override
    public void initComponents() {
        
        ImageIcon sideimage = new ImageIcon("C:\\Users\\FunkyO\\testirepo\\SQLDbTest\\src\\main\\images\\vehepalsta.png");  
        ImageIcon logoimage = new ImageIcon("C:\\Users\\FunkyO\\testirepo\\SQLDbTest\\src\\main\\images\\Vegit_Logo.png");
        
        //initialize components for panel3
        
        JLabel sidepic = new JLabel(sideimage, JLabel.CENTER);    
        JLabel mainlogo = new JLabel(logoimage, JLabel.CENTER);
        JLabel loginunp3 = new JLabel("Desired username");
        JLabel loginpwp3 = new JLabel("Desired password");
        JTextField newUsername = new JTextField();
        JTextField newPassword = new JTextField();
        createButton = new JButton("Create account");

        //set sizes for components in panel 3
        mainlogo.setBounds(235, 40, 200, 50);
        sidepic.setBounds(0, 0, 45, 768);
        loginunp3.setBounds(150, 150, 150, 20);
        loginpwp3.setBounds(150, 200, 150, 20);
        newUsername.setBounds(300, 150, 150, 20);
        newPassword.setBounds(300, 200, 150, 20);
        createButton.setBounds(225, 250, 150, 30);
        
         //set borders for for components in panel3
        sidepic.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        //add components to panel3
        panel.add(mainlogo);
        panel.add(sidepic);
        panel.add(loginunp3);
        panel.add(loginpwp3);
        panel.add(newUsername);
        panel.add(newPassword);
        panel.add(createButton);
        panel.setBackground(Color.blue);

        panel.setLayout(null);
    }

    @Override
    public JPanel getPanel() {
        return this.panel;
    }
    
    public JButton getCreateButton() {
        return this.createButton;
    }

}
