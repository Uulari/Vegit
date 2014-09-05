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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author FunkyO
 */
public class SQLDb {

    String hakusyote;
    int amountofppl;
    int time;
    ArrayList<String> tiedot;
    ArrayList<String> ingredients;
    private boolean vege;

    public SQLDb() {
        this.hakusyote = "";
        this.time = 0;
        this.amountofppl = 0;
        this.tiedot = new ArrayList();
        this.ingredients = new ArrayList();
        this.vege = false;
    }

    public void run() throws InstantiationException, IllegalAccessException, SQLException {
        String players;

        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "vegitdatabase";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "Morpheus";
        String password = "Bambiino16";
        try {
            //Initalize connection to db
            Class.forName(driver).newInstance();
            Connection conn = DriverManager.getConnection(url + dbName, userName, password);

            // make a query, request & display results   
            parseIngredients();

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
                tiedot.add(calculateIngredAmounts(tarvikkeet));
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

    public void timeInMins(int minutes) {
        if (minutes == 0 || minutes < 0) {
            this.time = 1000;
        } else {
            this.time = minutes;
        }

    }

    public void setAmountOfPeople(int amount) {
        if (amount > 0) {
            this.amountofppl = amount;
        }
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
            } else if (ingredients.size() >= 1) {

                hakusyote += ("ingredients LIKE '%" + this.ingredients.get(i) + "%' AND ");
            }
        }

    }

    public String calculateIngredAmounts(String tarvikkeet) {
        String returnString = "";
        String[] ainekset = tarvikkeet.split(",");
        for (String aines : ainekset) {

            String s = aines;
            if (s.contains("g)")) {
                s = s.substring(0, s.length() - 2);
            }

            String nums = "";
            String ingredname = "";
            nums = s.replaceAll("[^0-9]", "");
            ingredname = s.replaceAll("[^a-zA-Z]", "");
            int amount = Integer.parseInt(nums);
            int result = amount * this.amountofppl;
            String piece = "";
            piece = (ingredname + " (" + result + " g),");
            returnString += piece;
        }
        return returnString;
    }

}
