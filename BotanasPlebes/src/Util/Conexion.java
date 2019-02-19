package Util;

import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Sony
 */

public class Conexion {
    
    public Connection getConexion(){
        Connection cn=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost/botanasplebes", "root", "");
            System.out.println("Se conectó :-)");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("No se conectó :-("+e);
        }
        return cn;
    } 
    /*
    public static void main(String[] args){
        Conexion conexion = new Conexion();
        conexion.getConexion();
    }*/
}
