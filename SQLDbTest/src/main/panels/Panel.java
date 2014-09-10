/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main.panels;

import javax.swing.JPanel;

/**
 *
 * @author User
 */
public abstract class Panel {
    
    private JPanel panel;
    
    public abstract void initComponents();    
    public abstract JPanel getPanel();
    
}
