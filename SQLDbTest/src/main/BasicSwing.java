package main;


import java.awt.CardLayout;
import java.awt.Color;
import static java.awt.Color.red;
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
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
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
    private JButton send, exit, back, login, createAccount, createButton;
    private JPanel panel1 = new JPanel(), panel2 = new JPanel(), panel3 = new JPanel(), panel4 = new JPanel(), contentPanel = new JPanel();
    private CardLayout cardLayout = new CardLayout();
    private JLabel loginun, loginpw, loginunp3, loginpwp3, header, maxtime, ingreds, people, name, preptime, ingredients, instructions, leftpicp1, leftpicp2, leftpicp3, leftpicp4, mainlogo, mainlogop2, mainlogop3, mainlogop4, vege, p3;
    private JTextField jtime, amountofppl, vegebole, loginUsername, loginPassword, newUsername, newPassword;
    private JTextPane jt, outputinstructs, outputingreds;
    private ImageIcon image, imagemain;
    
    public BasicSwing(SQLDb sqldb) throws IOException {

        //initalize sqldb object        
        super("Reseptigeneraattori");
        
        db = sqldb;
        image = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Vegit\\Vegit\\SQLDbTest\\src\\main\\images\\vehepalsta.png");  
        imagemain = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Vegit\\Vegit\\SQLDbTest\\src\\main\\images\\Vegit_Logo.png");
       
        //initalize components for panel1          
        initComponentsForPanel1();
//       
         

        //initialize components for panel2
        
        leftpicp2 = new JLabel(image, JLabel.CENTER);
        name = new JLabel("yo");
        preptime = new JLabel("Valmistusaika");
        ingredients = new JLabel("Ainekset:");
        instructions = new JLabel("Valmistusohjeet: ");
        outputinstructs = new JTextPane();
        outputingreds = new JTextPane();
        mainlogop2 = new JLabel(imagemain, JLabel.CENTER);        
        exit = new JButton("Exit");
        back = new JButton("back to search");
        
        //initialize components for panel3
        p3 = new JLabel("test3");
        leftpicp3 = new JLabel(image, JLabel.CENTER);    
        mainlogop3 = new JLabel(imagemain, JLabel.CENTER);
        loginunp3 = new JLabel("Desired username");
        loginpwp3 = new JLabel("Desired password");
        newUsername = new JTextField();
        newPassword = new JTextField();
        createButton = new JButton("Create account");

        
        //initialize components for panel4
        leftpicp4 = new JLabel(image, JLabel.CENTER);    
        mainlogop4 = new JLabel(imagemain, JLabel.CENTER);
        loginun = new JLabel("Username");
        loginpw = new JLabel("Password");
        loginUsername = new JTextField();
        loginPassword = new JTextField();
        login = new JButton("Login");
        createAccount = new JButton("Create account");

        
        
         //set borders for components in panel2          
        leftpicp1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        jtime.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        jt.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        vegebole.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        amountofppl.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        send.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        
        

        //set borders for components in panel2          
        leftpicp2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        outputingreds.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        outputinstructs.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        
        //set borders for for components in panel3
        leftpicp3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        
        //set borders for for components in panel4
        leftpicp4.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        
        
        
        //set sizes for components in panel 2
        mainlogop2.setBounds(235, 40, 200, 50); 
        leftpicp2.setBounds(0, 0, 45, 768);
        name.setBounds(150, 110, 150, 20);
        preptime.setBounds(150, 135, 150, 30);
        ingredients.setBounds(150, 175, 100, 10);        
        instructions.setBounds(150, 355, 100, 20);
        outputingreds.setBounds(150, 205, 200, 140);
        outputingreds.setBackground(Color.white);
        outputinstructs.setBounds(150, 395, 300, 250);
        outputinstructs.setBackground(Color.white);
        exit.setBounds(200, 670, 60, 40);
        back.setBounds(290, 670, 120, 40);
        

        //set background colors and images
        panel1.setBackground(Color.red);
        panel2.setBackground(Color.yellow);
        panel3.setBackground(Color.white);
        panel4.setBackground(Color.CYAN);
          
        //set sizes for components in panel 3
        p3.setBounds(200, 670, 60, 40);
        mainlogop3.setBounds(235, 40, 200, 50);
        leftpicp3.setBounds(0, 0, 45, 768);
        loginunp3.setBounds(150, 150, 150, 20);
        loginpwp3.setBounds(150, 200, 150, 20);
        newUsername.setBounds(300, 150, 150, 20);
        newPassword.setBounds(300, 200, 150, 20);
        createButton.setBounds(225, 250, 150, 30);

        
        //set sizes for components in panel 4
        mainlogop4.setBounds(235, 40, 200, 50);
        leftpicp4.setBounds(0, 0, 45, 768);
        loginun.setBounds(180, 150, 100, 20);
        loginpw.setBounds(180, 200, 100, 20);
        loginUsername.setBounds(300, 150, 150, 20);
        loginPassword.setBounds(300, 200, 150, 20);
        login.setBounds(180, 250, 120, 30);
        createAccount.setBounds(300, 250, 150, 30);

        //add components to panel1
        panel1.add(leftpicp1);
        panel1.add(mainlogo);
        
        //panel1.add(header);
        panel1.add(vege);
        panel1.add(vegebole);
        panel1.add(amountofppl);
        panel1.add(jt);
        panel1.add(jtime);
        panel1.add(maxtime);
        panel1.add(people);
        panel1.add(ingreds);
        panel1.add(send);
        panel1.setLayout(null);

        //add components to panel2
        panel2.add(mainlogop2);
        panel2.add(name);
        
        panel2.add(leftpicp2);        
        panel2.add(preptime);
        panel2.add(ingredients);
        panel2.add(instructions);
        panel2.add(outputinstructs);
        panel2.add(outputingreds);
        panel2.setLayout(null);

        panel2.add(exit);
        panel2.add(back);
        
        //add components to panel3
        panel3.add(p3);
        panel3.add(mainlogop3);
        panel3.add(leftpicp3);
        panel3.add(loginunp3);
        panel3.add(loginpwp3);
        panel3.add(newUsername);
        panel3.add(newPassword);
        panel3.add(createButton);
        
        panel3.setLayout(null);
        
        //add components to panel4
        panel4.add(mainlogop4);
        panel4.add(leftpicp4);
        panel4.add(loginun);
        panel4.add(loginpw);
        panel4.add(loginUsername);
        panel4.add(loginPassword);
        panel4.add(login);
        panel4.add(createAccount);
        panel4.setLayout(null);
       
        contentPanel.setLayout(cardLayout);
        
        contentPanel.add(panel1, "panel1");
        contentPanel.add(panel2, "panel2");
        contentPanel.add(panel3, "panel3");
        contentPanel.add(panel4, "panel4");
        

        this.setContentPane(contentPanel);

        cardLayout.show(contentPanel, "panel4");

        actionListener al = new actionListener();

        exit.addActionListener(al);
        send.addActionListener(al);        
        back.addActionListener(al);
        login.addActionListener(al);
        createAccount.addActionListener(al);
       

    }

    private void initComponentsForPanel1() {
        
        //initialize components for panel1
        leftpicp1 = new JLabel(image, JLabel.CENTER);    
        mainlogo = new JLabel(imagemain, JLabel.CENTER);
        people = new JLabel("Henkilömäärä");
        vege = new JLabel("Kasvisresepti?");
        header = new JLabel("Vegit - The Amazing Generator");
        maxtime = new JLabel("Valmistusaika (min)");
        ingreds = new JLabel("Ainekset (0-5)");
        send = new JButton("Hae!");
        jt = new JTextPane();
        jtime = new JTextField();
        vegebole = new JTextField();
        amountofppl = new JTextField();  
        
        //set sizes for components in panel1
        mainlogo.setBounds(235, 40, 200, 50); 
        leftpicp1.setBounds(0, 0, 45, 768);       
        maxtime.setBounds(140, 120, 125, 20);
        jt.setBounds(290, 170, 100, 100);
        ingreds.setBounds(140, 170, 80, 20);
        people.setBounds(140, 300, 125, 20);
        jtime.setBounds(290, 120, 100, 20);
        amountofppl.setBounds(290, 300, 100, 20);
        vege.setBounds(140, 350, 100, 20);
        vegebole.setBounds(290, 350, 100, 20);
        send.setBounds(300, 420, 80, 50);
    }

    public class actionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JButton src = (JButton) e.getSource();
            if (src.equals(send)) {
                cardLayout.show(contentPanel, "panel2");
                runQuery();
            } else if (src.equals(login)) {
                cardLayout.show(contentPanel, "panel1");
            } else if (src.equals(createAccount)) {
                cardLayout.show(contentPanel, "panel3");
            } else if (src.equals(back)) {                
                cardLayout.first(contentPanel);
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
        int peopleamount = Integer.parseInt(amountofppl.getText());
        String isvege = vegebole.getText();
        vegebole.setText("");
        jt.setText("");
        jtime.setText("");
        amountofppl.setText("");
        
        System.out.println("Resepti:");

        db.timeInMins(strtime);
        db.haeAinekset(ingred);
        db.setAmountOfPeople(peopleamount);

        try {
            db.run();
            ArrayList<String> tiedot = db.haeTiedot();
            System.out.println(db.haeTiedot());
            if (tiedot.size() >= 0) {
                name.setText("" + tiedot.get(1) + "");
//                System.out.println("Nimi: " + tiedot.get(1));
                
                preptime.setText("Valmistusaika: " + tiedot.get(0) + " min");
//                System.out.println("Valmistusaika: " + tiedot.get(0) + " min");
                
                
//                System.out.println("Ainekset: " + tiedot.get(2));
                String[] ingredientarray = parseOutputIngredients(tiedot.get(2));
                String ainekset = "";
                for (String item : ingredientarray){
                    ainekset += (item + "\n");
                }
                outputingreds.setText(ainekset);
                
//                System.out.println("Valmistusohjeet: \n" + tiedot.get(3));
                String[] instructionarray = parseOutputInstructions(tiedot.get(3));                 
                String ohje = "";                
                for (String ins : instructionarray){
                    if (ins.length() > 0) {
                        ohje += (ins + "\n");
                    }                    
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
