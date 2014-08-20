package main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author FunkyO
 */
public class SQLDb {

    String hakusyote;
    int time;
    ArrayList<String> tiedot;
    ArrayList<String> ingredients;

    public SQLDb() {
        this.hakusyote = "";
        this.time = 0;
        tiedot = new ArrayList();
        ingredients = new ArrayList();
    }

    public void run() throws InstantiationException, IllegalAccessException, SQLException {
        String players;

        int medals;
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "reseptit";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "Mozartinkuula99";
        try {
            //Initalize connection to db
            Class.forName(driver).newInstance();
            Connection conn = DriverManager.getConnection(url + dbName, userName, password);

            // make a query, request & display results   
            parseIngredients();
            parseTime();
            
            Statement st = conn.createStatement();
            String sql = ("SELECT ID FROM recipes WHERE " + this.hakusyote + " time <= " + this.time);

            //gets IDS that fill           
            ResultSet rs1 = st.executeQuery(sql);
            List<Integer> ids = new ArrayList();
            while (rs1.next()) {

                ids.add(rs1.getInt("ID"));

            }
            // shuffle IDs
            Collections.shuffle(ids);

            //create new query which recovers parameters for randomized ID
            String sql2 = ("SELECT * FROM recipes WHERE ID = " + ids.get(0));

            //executes query2 to fetch information
            ResultSet rs2 = st.executeQuery(sql2);
            while (rs2.next()) {
                String name = rs2.getString("name");
                int time = rs2.getInt("time");
                String tarvikkeet = rs2.getString("ingredients");
                String valmistusohjeet = rs2.getString("instructions");

                tiedot.add(Integer.toString(time));
                tiedot.add(name);
                tiedot.add(tarvikkeet);
                tiedot.add(valmistusohjeet);

//               System.out.println("Nimi: " + name);
//               System.out.println("Valmistusaika: " + time);
//               System.out.println("Ainekset: " + tarvikkeet);
//               System.out.println("Valmistusohjeet: " + valmistusohjeet);
            }

            conn.close();

        } catch (ClassNotFoundException x) {
            x.printStackTrace();
        } catch (InstantiationException a) {
            a.printStackTrace();
        } catch (IllegalAccessException b) {
            b.printStackTrace();
        }

    }

//    public void keyword(String keyword) {
//        this.keyword = keyword;
//
//    }

    public void timeInMins(int minutes) {
        this.time = minutes;

    }

    public ArrayList<String> haeTiedot() {
        return this.tiedot;
    }

    public void haeAinekset(ArrayList aineet) {
        this.ingredients = aineet;

    }

    public void parseIngredients() {
        this.hakusyote = "";
        for (int i = 0; i < this.ingredients.size(); i++) {
            if (ingredients.size() == 0) {
                hakusyote = "";
            }
            else if (ingredients.size() >= 1){
            
            hakusyote += ("ingredients LIKE '%" + this.ingredients.get(i) + "%' AND ");
            }
        }

    }
    
    public void parseTime() {
        if (this.time == 0 || this.time < 0) {
            this.time = 1000;
        } else {
            this.time = this.time;
        }
       
    }

}
