/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class Dataconnection {
    public Connection getConnection() {
     try {
            String user = "sa";
            String pass = "123";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=FU_DB";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    
            return DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Dataconnection.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return null;
    }
}
