/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main.panels;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

/**
 *
 * @author User
 */
public class SearchPanel extends Panel {
    
    private JPanel panel;
    private JButton send;
    
    public SearchPanel() {
        this.panel = new JPanel();
    }

    @Override
    public void initComponents() {
       
         //initialize components for panel1
//        leftpicp1 = new JLabel(image, JLabel.CENTER);    
//        mainlogo = new JLabel(imagemain, JLabel.CENTER);
        send = new JButton("Hae!");
        JLabel people = new JLabel("Henkilömäärä");
        JLabel  vege = new JLabel("Kasvisresepti?");        
        JLabel maxtime = new JLabel("Valmistusaika (min)");
        JLabel ingreds = new JLabel("Ainekset (0-5)");
        
        JTextPane jt = new JTextPane();
        JTextField jtime = new JTextField();
        JTextField vegebole = new JTextField();
        JTextField amountofppl = new JTextField();  
        
        //set sizes for components in panel1
//        mainlogo.setBounds(235, 40, 200, 50); 
//        leftpicp1.setBounds(0, 0, 45, 768);       
        maxtime.setBounds(140, 120, 125, 20);
        jt.setBounds(290, 170, 100, 100);
        ingreds.setBounds(140, 170, 80, 20);
        people.setBounds(140, 300, 125, 20);
        jtime.setBounds(290, 120, 100, 20);
        amountofppl.setBounds(290, 300, 100, 20);
        vege.setBounds(140, 350, 100, 20);
        vegebole.setBounds(290, 350, 100, 20);
        this.send.setBounds(300, 420, 80, 50);
        
        //set borders
        jtime.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        jt.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        vegebole.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        amountofppl.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        this.send.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        
        //add components to panel1
//        panel.add(leftpicp1);
//        panel.add(mainlogo);
        
        
        panel.add(vege);
        panel.add(vegebole);
        panel.add(amountofppl);
        panel.add(jt);
        panel.add(jtime);
        panel.add(maxtime);
        panel.add(people);
        panel.add(ingreds);
        panel.add(send);
        panel.setLayout(null);
        panel.setBackground(Color.red);
    }

    @Override
    public JPanel getPanel() {
        return this.panel;
    }
    
    public JButton getSend() {
        return this.send;
    }
    
}
