/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqldb;

/**
 *
 * @author User
 */
public class DBConnection {

    private String url;
    private String dbName;
    private String driver;
    private String userName;
    private String password;

    public DBConnection() {

        url = "jdbc:mysql://localhost:3306/";
        dbName = "vegitdatabase";
        driver = "com.mysql.jdbc.Driver";
        userName = "Morpheus";
        password = "Bambiino16";

    }
    
    public String getUrl() {
        return this.url;
    }
    
    public String getDbName() {
        return this.dbName;
    }
    
    public String getDriver() {
        return this.driver;
    }
    
    public String getUserName() {
        return this.userName;
    }
    
    public String getPassword() {
        return this.password;
    }
}
