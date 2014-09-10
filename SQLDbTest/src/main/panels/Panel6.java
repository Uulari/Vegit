/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main.panels;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
public class Panel6 {
    
    
    private JPanel panel6;
    
    public Panel6() {
        panel6 = new JPanel();
    }
    
    public void initComponents() {
        
        JButton hellosir = new JButton("HEY!");
        hellosir.setBounds(200, 300, 30, 30);
        
        
        this.panel6.setBackground(Color.red);
        this.panel6.setLayout(null);
        this.panel6.add(hellosir);
    }
    
    public JPanel getPanel() {
        return this.panel6;
    }
    
}
