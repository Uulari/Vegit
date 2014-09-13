package main;


import sqldb.SQLDb;
import main.BasicSwing;
import java.io.IOException;
import javax.swing.JFrame;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author FunkyO
 */
public class Main {
        public static void main (String []args) throws IOException{
        
            SQLDb sqldb = new SQLDb();
            BasicSwing bs = new BasicSwing(sqldb);
            bs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            bs.setSize(600, 800);
            bs.setVisible(true);
            
//            bobby.startInterface();
            
        }
}
