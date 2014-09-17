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
import javax.swing.JTextPane;

/**
 *
 * @author User
 */
public class SearchPanel extends Panel {

    private JPanel panel;
    private JButton send;
    private JTextField time, vegebole, amountofppl;

    public SearchPanel() {
        this.panel = new JPanel();
    }

    @Override
    public void initComponents() {

        ImageIcon sideimage = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Vegit\\Vegit\\SQLDbTest\\src\\main\\images\\vehepalsta.png");
        ImageIcon logoimage = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Vegit\\Vegit\\SQLDbTest\\src\\main\\images\\Vegit_Logo.png");
        
        ImageIcon search = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Vegit\\Vegit\\SQLDbTest\\src\\main\\images\\buttons\\Searchbtn.jpg");

        //initialize components for panel1
        JLabel leftpic = new JLabel(sideimage, JLabel.CENTER);
        JLabel mainlogo = new JLabel(logoimage, JLabel.CENTER);
        send = new JButton("");
        send.setIcon(search);
        JLabel people = new JLabel("Henkilömäärä");
        JLabel vege = new JLabel("Kasvisresepti?");
        JLabel maxtime = new JLabel("Valmistusaika (min)");
        JLabel ingreds = new JLabel("Ainekset (0-5)");

        JTextPane jt = new JTextPane();
        time = new JTextField();
        vegebole = new JTextField();
        amountofppl = new JTextField();

        //set sizes for components in panel1
        mainlogo.setBounds(225, 40, 200, 50);
        leftpic.setBounds(0, 0, 45, 768);
        maxtime.setBounds(117, 120, 125, 20);
        jt.setBounds(267, 170, 100, 100);
        ingreds.setBounds(117, 170, 80, 20);
        people.setBounds(117, 300, 125, 20);
        time.setBounds(267, 120, 100, 20);
        amountofppl.setBounds(267, 300, 100, 20);
        vege.setBounds(117, 350, 100, 20);
        vegebole.setBounds(267, 350, 100, 20);
        this.send.setBounds(242, 420, 160, 40);

        //set borders
        leftpic.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        time.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        jt.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        vegebole.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        amountofppl.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
//        this.send.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        //add components to panel1
        panel.add(leftpic);
        panel.add(mainlogo);

        panel.add(vege);
        panel.add(vegebole);
        panel.add(amountofppl);
        panel.add(jt);
        panel.add(time);
        panel.add(maxtime);
        panel.add(people);
        panel.add(ingreds);
        panel.add(send);
        panel.setLayout(null);
        panel.setBackground(Color.white);
    }

    @Override
    public JPanel getPanel() {
        return this.panel;
    }

    public JButton getSend() {
        return this.send;
    }

    public JTextField getVege() {
        return this.vegebole;
    }

    public JTextField getAmountOfPeople() {
        return this.amountofppl;
    }

    public JTextField getTime() {
        return this.time;
    }

}
