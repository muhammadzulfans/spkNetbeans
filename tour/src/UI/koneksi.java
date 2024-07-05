package UI;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bass26
 */
public class koneksi {
public static Connection conn;

public static Connection getConnection(){
    if (conn==null) {
        try {
            String url ="jdbc:mysql://localhost/Travel";
            String user="root";
            String pass="";
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            conn = (Connection) DriverManager.getConnection(url,user,pass);
            System.out.println("berhasil connect");
        } catch (Exception e) {
            Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE,null, e);
        }
    }
    return conn;
}

}
