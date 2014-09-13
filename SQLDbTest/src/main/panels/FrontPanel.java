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
public class FrontPanel extends Panel {

    private JPanel panel;
    private JButton login;
    private JButton createAccount;

    public FrontPanel() {
        this.panel = new JPanel();
    }

    @Override
    public void initComponents() {

        ImageIcon sideimage = new ImageIcon("C:\\Users\\FunkyO\\testirepo\\SQLDbTest\\src\\main\\images\\vehepalsta.png");  
        ImageIcon logoimage = new ImageIcon("C:\\Users\\FunkyO\\testirepo\\SQLDbTest\\src\\main\\images\\Vegit_Logo.png");
        ImageIcon twiit = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Vegit\\Vegit\\SQLDbTest\\src\\main\\images\\icon-social-small-twitter_1.png");

        JLabel sidepic = new JLabel(sideimage, JLabel.CENTER);
        JLabel mainlogo = new JLabel(logoimage, JLabel.CENTER);

//      set borders for for components in panel4
        sidepic.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        //initialize components for FrontPanel
        JLabel loginun = new JLabel("Username");
        JLabel loginpw = new JLabel("Password");
        JTextField loginUsername = new JTextField();
        JTextField loginPassword = new JTextField();
        login = new JButton("");
        createAccount = new JButton("Create account");
        login.setIcon(twiit);
        login.setBackground(Color.red);
        login.setFont(null);

        //set sizes for components in panel 4
        mainlogo.setBounds(235, 40, 200, 50);
        sidepic.setBounds(0, 0, 45, 768);
        loginun.setBounds(180, 150, 100, 20);
        loginpw.setBounds(180, 200, 100, 20);
        loginUsername.setBounds(300, 150, 150, 20);
        loginPassword.setBounds(300, 200, 150, 20);
        login.setBounds(180, 250, 120, 30);
        createAccount.setBounds(300, 250, 150, 30);

        //add components to panel4
        panel.add(mainlogo);
        panel.add(sidepic);
        panel.add(loginun);
        panel.add(loginpw);
        panel.add(loginUsername);
        panel.add(loginPassword);
        panel.add(login);
        panel.add(createAccount);
        panel.setBackground(Color.CYAN);
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
