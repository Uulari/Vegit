package main;


import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author FunkyO
 */
public class BasicSwing extends JFrame {

    SQLDb db;
    private JButton send, exit;
    private JPanel panel1 = new JPanel(), panel2 = new JPanel(), contentPanel = new JPanel();
    private CardLayout cardLayout = new CardLayout();
    private JLabel header, maxtime, ingreds, name, preptime, ingredients, instructions, leftpicp2, leftpicp1;
    private JTextField jtime;
    private JTextPane jt, outputinstructs, outputingreds;

    public BasicSwing(SQLDb sqldb) throws IOException {

        //initalize sqldb object        
        super("Reseptigeneraattori");
        db = sqldb;
        ImageIcon image = new ImageIcon("C:\\Users\\FunkyO\\testirepo\\SQLDbTest\\src\\main\\images\\vehepalsta.png");  

        //initalize components for panel1            
             
        leftpicp1 = new JLabel(image, JLabel.CENTER);        
        header = new JLabel("Vegit - The Amazing Generator");
        maxtime = new JLabel("Maxtime");
        ingreds = new JLabel("Ainekset");
        send = new JButton("Hae!");
        jt = new JTextPane();
        jtime = new JTextField();

        //initialize components for panel2
        leftpicp2 = new JLabel(image, JLabel.CENTER);
        name = new JLabel("Nimi", SwingConstants.CENTER);
        preptime = new JLabel("Valmistusaika");
        ingredients = new JLabel("Ainekset:");
        instructions = new JLabel("Valmistusohjeet: ");
        outputinstructs = new JTextPane();
        outputingreds = new JTextPane();
        
        exit = new JButton("Exit");

        //set sizes for components in panel1
        leftpicp1.setBounds(0, 0, 45, 768);  
        header.setBounds(300, 30, 200, 20);
        maxtime.setBounds(200, 100, 80, 20);
        jt.setBounds(350, 150, 100, 100);
        ingreds.setBounds(200, 150, 80, 20);
        jtime.setBounds(350, 100, 80, 20);
        send.setBounds(360, 270, 80, 50);

        //set sizes for components in panel2
        leftpicp2.setBounds(0, 0, 45, 768);  
        name.setBounds(225, 50, 120, 40);
        preptime.setBounds(150, 100, 150, 30);
        ingredients.setBounds(150, 150, 100, 10);        
        instructions.setBounds(150, 430, 100, 20);
        outputinstructs.setBounds(150, 450, 300, 250);
        outputinstructs.setBackground(Color.YELLOW);
        outputingreds.setBounds(150, 200, 200, 100);
        outputingreds.setBackground(Color.YELLOW);

        //set background colors and images
        panel1.setBackground(Color.red);
        panel2.setBackground(Color.yellow);
        
        
        
        


        //add components to panel1
        panel1.add(leftpicp1);
        panel1.add(header);
        panel1.add(jt);
        panel1.add(jtime);
        panel1.add(maxtime);
        panel1.add(ingreds);
        panel1.add(send);
        panel1.setLayout(null);

        //add components to panel2
        panel2.add(leftpicp2);
        panel2.add(name);
        panel2.add(preptime);
        panel2.add(ingredients);
        panel2.add(instructions);
        panel2.add(outputinstructs);
        panel2.add(outputingreds);
        panel2.setLayout(null);

        panel2.add(exit);

        contentPanel.setLayout(cardLayout);
        
        contentPanel.add(panel1, "panel1");
        contentPanel.add(panel2, "panel2");

        this.setContentPane(contentPanel);

        cardLayout.show(contentPanel, "panel1");

        actionListener al = new actionListener();

        exit.addActionListener(al);
        send.addActionListener(al);

    }

    public class actionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JButton src = (JButton) e.getSource();
            if (src.equals(send)) {
                cardLayout.show(contentPanel, "panel2");
                runQuery();
            } else if (src.equals(exit)) {
                System.exit(0);

            }

        }
    }

    public void runQuery() {

        ArrayList<String> ingred = new ArrayList();
        String str = jt.getText();
        String[] ingreds = str.split(" ");
        for (int i = 0; i < ingreds.length; i++) {
            ingred.add(ingreds[i]);
        }
        int strtime = Integer.parseInt(jtime.getText());
        jt.setText("");
        jtime.setText("");
        System.out.println("Resepti:");

        db.timeInMins(strtime);
        db.haeAinekset(ingred);

        try {
            db.run();
            ArrayList<String> tiedot = db.haeTiedot();
            if (tiedot.size() >= 0) {
                name.setText("" + tiedot.get(1) + "");
                System.out.println("Nimi: " + tiedot.get(1));
                
                preptime.setText("Valmistusaika: " + tiedot.get(0) + "");
                System.out.println("Valmistusaika: " + tiedot.get(0) + " min");
                
                
                System.out.println("Ainekset: " + tiedot.get(2));
                String[] ingredientarray = parseOutputIngredients(tiedot.get(2));
                String ainekset = "";
                for (String item : ingredientarray){
                    ainekset += (item + "\n");
                }
                outputingreds.setText(ainekset);
                
                System.out.println(tiedot.get(3));
                String[] instructionarray = parseOutputInstructions(tiedot.get(3));                
                String ohje = "";                
                for (String ins : instructionarray){
                    ohje += (ins + "\n");
                }
                outputinstructs.setText(ohje);
                
            }

        } catch (InstantiationException ex) {
            Logger.getLogger(BasicSwing.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(BasicSwing.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BasicSwing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String[] parseOutputInstructions(String instructions) {
        String[] osaset = instructions.split("[0-9]");
        return osaset;
    }
    
    public String[] parseOutputIngredients(String ingreds) {
        String[] osaset = ingreds.split("[,]");
        return osaset;
    
    }
}
