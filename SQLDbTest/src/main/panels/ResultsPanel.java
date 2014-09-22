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
import javax.swing.JTextPane;

/**
 *
 * @author User
 */
public class ResultsPanel extends Panel {
    
    private JPanel panel, topPanel;    
    private JButton back;
    private JButton exit;
    private JButton minimize;
    
    public ResultsPanel() {
        panel = new JPanel();
        
    }
    
    @Override
    public void initComponents() {
        
       ImageIcon sideimage = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Vegit\\Vegit\\SQLDbTest\\src\\main\\images\\vehepalsta.png");
       ImageIcon logoimage = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Vegit\\Vegit\\SQLDbTest\\src\\main\\images\\Vegit_Logo.png");
       
       ImageIcon backtosearch = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Vegit\\Vegit\\SQLDbTest\\src\\main\\images\\buttons\\Backtosearchbtn.jpg");
       
       ImageIcon exitbtn = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Vegit\\Vegit\\SQLDbTest\\src\\main\\images\\buttons\\Exitbtn.jpg");
       ImageIcon minibtn = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Vegit\\Vegit\\SQLDbTest\\src\\main\\images\\buttons\\minibtn.jpg");
       
        //initialize components for panel2
        
        JLabel sidepic = new JLabel(sideimage, JLabel.CENTER);
        JLabel mainlogo = new JLabel(logoimage, JLabel.CENTER); 
        
        JLabel preptime = new JLabel("Valmistusaika");
        JLabel ingredients = new JLabel("Ainekset:");
        JLabel instructions = new JLabel("Valmistusohjeet: ");
        JTextPane outputinstructs = new JTextPane();
        JTextPane outputingreds = new JTextPane();
        
        topPanel = new JPanel();
        exit = new JButton("");
        exit.setIcon(exitbtn);
        minimize = new JButton("");
        minimize.setIcon(minibtn);
               
        
        back = new JButton("");
        back.setIcon(backtosearch);
        
        //set sizes for components in panel 2
        
        mainlogo.setBounds(225, 40, 200, 50); 
        sidepic.setBounds(5, 5, 45, 768);      
        preptime.setBounds(172, 135, 150, 30);
        ingredients.setBounds(172, 175, 100, 10);        
        instructions.setBounds(172, 355, 100, 20);
        topPanel.setBounds(160, 110, 310, 15);
        minimize.setBounds(490, 20, 35, 35);
        exit.setBounds(530, 20, 35, 35);
        outputingreds.setBounds(172, 205, 200, 140);
        outputingreds.setBackground(Color.white);
        outputinstructs.setBounds(172, 395, 300, 250);
        outputinstructs.setBackground(Color.white);
        
        back.setBounds(197, 670, 250, 40);
        
         //set borders for components in panel2          
        sidepic.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        outputingreds.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        outputinstructs.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        this.panel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 5));
        this.panel.setBackground(Color.white);
        topPanel.setBackground(Color.LIGHT_GRAY);
        
        //add components to panel2
        
        panel.add(mainlogo);        
        panel.add(sidepic); 
        panel.add(topPanel);
        panel.add(minimize);
        panel.add(exit);
        
        panel.add(preptime);
        panel.add(ingredients);
        panel.add(instructions);
        panel.add(outputinstructs);
        panel.add(outputingreds);
        panel.setLayout(null);

        
        panel.add(back);
        
    }

    @Override
    public JPanel getPanel() {
        return this.panel;
    }
    
       
    public JButton getBack() {
        return this.back;
    }
    
}
