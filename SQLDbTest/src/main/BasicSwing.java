package main;


import java.awt.CardLayout;
import java.awt.Color;
import static java.awt.Color.red;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
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
import main.panels.CreateAccountPanel;
import main.panels.FrontPanel;
import main.panels.ResultsPanel;
import main.panels.SearchPanel;
import sqldb.SQLDb;
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
    private Font font;
    private JButton send, exit, back, login, createAccount, createButton;
    private JPanel contentPanel;
    private FrontPanel frontpanel;
    private CreateAccountPanel creationpanel;    
    private SearchPanel searchpanel;
    private ResultsPanel resultspanel; 
    private CardLayout cardLayout;
    private JLabel loginun, loginpw, loginunp3, loginpwp3, maxtime, ingreds, people, name, preptime, ingredients, instructions, leftpicp1, leftpicp2, leftpicp3, leftpicp4, mainlogo, mainlogop2, mainlogop3, mainlogop4, vege, p3;
    
    private JTextPane jt, outputinstructs, outputingreds;
    
    
    public BasicSwing(SQLDb sqldb) throws IOException {

        //initalize sqldb object        
        super("Reseptigeneraattori");
        
        db = sqldb;
        cardLayout  = new CardLayout();
        contentPanel  = new JPanel();                 
        contentPanel.setLayout(cardLayout);
        
        //button color and font
        //00ff62
        //Levenim MT
        
        
        
        frontpanel = new FrontPanel();        
        frontpanel.initComponents();
        creationpanel = new CreateAccountPanel();
        creationpanel.initComponents();
        searchpanel = new SearchPanel();
        searchpanel.initComponents();
        resultspanel = new ResultsPanel();
        resultspanel.initComponents();
        
        
       
        contentPanel.add(frontpanel.getPanel(), "frontpanel");
        contentPanel.add(creationpanel.getPanel(), "creationpanel");
        contentPanel.add(searchpanel.getPanel(), "searchpanel");
        contentPanel.add(resultspanel.getPanel(), "resultspanel");
        
        

        this.setContentPane(contentPanel);

        cardLayout.show(contentPanel, "frontpanel");

        actionListener al = new actionListener();
        
        
        this.login = frontpanel.getLogin();
        this.createAccount = frontpanel.getCreateAccount();
        this.createButton = creationpanel.getCreateButton();
        this.send = searchpanel.getSend();
        this.back = resultspanel.getBack();
        
        
        
        send.addActionListener(al);        
        back.addActionListener(al);
        login.addActionListener(al);
        createAccount.addActionListener(al);
        createButton.addActionListener(al);
       

    }

    

    public class actionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JButton src = (JButton) e.getSource();
            if (src.equals(send)) {
                cardLayout.show(contentPanel, "resultspanel");
                runQuery();
            } else if (src.equals(login)) {               
                cardLayout.show(contentPanel, "searchpanel");
            } else if (src.equals(createAccount)) {
                cardLayout.show(contentPanel, "creationpanel");                
            } else if (src.equals(createButton)) {               
                cardLayout.first(contentPanel);                
            } else if (src.equals(back)) {                
                cardLayout.first(contentPanel);
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
        
        int strtime = Integer.parseInt(searchpanel.getTime().getText());
        int peopleamount = Integer.parseInt(searchpanel.getAmountOfPeople().getText());
        String isvege = searchpanel.getVege().getText();
        
        searchpanel.getVege().setText("");
        jt.setText("");
        searchpanel.getTime().setText("");
        searchpanel.getAmountOfPeople().setText("");
        
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
