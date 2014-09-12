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
    
    private JPanel panel;
    private JButton exit, back;
    
    public ResultsPanel() {
        panel = new JPanel();
        
    }
    
    @Override
    public void initComponents() {
        
        ImageIcon sideimage = new ImageIcon("C:\\Users\\FunkyO\\testirepo\\SQLDbTest\\src\\main\\images\\vehepalsta.png");  
        ImageIcon logoimage = new ImageIcon("C:\\Users\\FunkyO\\testirepo\\SQLDbTest\\src\\main\\images\\Vegit_Logo.png");
         
        //initialize components for panel2
        
        JLabel sidepic = new JLabel(sideimage, JLabel.CENTER);
        JLabel mainlogo = new JLabel(logoimage, JLabel.CENTER); 
        
        JLabel preptime = new JLabel("Valmistusaika");
        JLabel ingredients = new JLabel("Ainekset:");
        JLabel instructions = new JLabel("Valmistusohjeet: ");
        JTextPane outputinstructs = new JTextPane();
        JTextPane outputingreds = new JTextPane();
               
        exit = new JButton("Exit");
        back = new JButton("back to search");
        
        //set sizes for components in panel 2
        
        mainlogo.setBounds(235, 40, 200, 50); 
        sidepic.setBounds(0, 0, 45, 768);      
        preptime.setBounds(150, 135, 150, 30);
        ingredients.setBounds(150, 175, 100, 10);        
        instructions.setBounds(150, 355, 100, 20);
        outputingreds.setBounds(150, 205, 200, 140);
        outputingreds.setBackground(Color.white);
        outputinstructs.setBounds(150, 395, 300, 250);
        outputinstructs.setBackground(Color.white);
        exit.setBounds(200, 670, 60, 40);
        back.setBounds(290, 670, 120, 40);
        
         //set borders for components in panel2          
        sidepic.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        outputingreds.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        outputinstructs.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        
        //add components to panel2
        
        panel.add(mainlogo);        
        panel.add(sidepic);   
        
        panel.add(preptime);
        panel.add(ingredients);
        panel.add(instructions);
        panel.add(outputinstructs);
        panel.add(outputingreds);
        panel.setLayout(null);

        panel.add(exit);
        panel.add(back);
        
    }

    @Override
    public JPanel getPanel() {
        return this.panel;
    }
    
    public JButton getExit() {
        return this.exit;
    }
    
    public JButton getBack() {
        return this.back;
    }
    
}
