
package Logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Conexion {
    String bd = "runt";
    String url = "jdbc:mysql://localhost:3306/";
    String user = "ramiro";
    String pass = "admin";
    String driver = "com.mysql.cj.jdbc.Driver";
    Connection cx;

    public Conexion() {
    }
    
    public Connection conectar(){
        try {
            Class.forName(driver);
            cx = DriverManager.getConnection(url+bd, user, pass);
            
            
        } catch (ClassNotFoundException |SQLException ex) {
            System.out.println("NO SE CONECTO A LA BASE DE DATOS");
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cx;
    }
}