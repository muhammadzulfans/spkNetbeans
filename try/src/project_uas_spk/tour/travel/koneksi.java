package project_uas_spk.tour.travel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class koneksi {
    public static Connection koneksi;

    static int execute(String SQL) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public Statement st;
    
    public static Connection getConnetion(){
        if(koneksi==null){
            try{
                String server="jdbc:mysql://localhost:3306/SAW_Java";
                String user="root";
                String password="";
//                Class.forName("com.mysql.jdbc.Driver");
                koneksi=DriverManager.getConnection(server,user,password);
            }catch(SQLException x){
                JOptionPane.showMessageDialog(null,"Koneksi Gagal, Pesan error \n"+x);
            }
        }
        return koneksi;
    }
    
    public void koneksi(){
        try{
            getConnetion();
            st=koneksi.createStatement();
        }catch(SQLException x){
            JOptionPane.showMessageDialog(null,"Koneksi ambil Gagal, Pesan error \n"+x);
        }
    }
    
    public void closeConnection(ResultSet rs){
        try{
            if(rs!=null){
                rs.close();
            }
            st.close();
            koneksi.close();
        }catch(SQLException x){
            JOptionPane.showMessageDialog(null,"Tutup Koneksi Gagal, Pesan error \n"+x);
        }
    } 
    
    public ResultSet getData(String sql){
         ResultSet rs=null;
         try{
            koneksi();
            rs=st.executeQuery(sql);
         }catch(SQLException x){
             JOptionPane.showMessageDialog(null,"Ambil Data Gagal, Pesan error : \n"+x);
         }
         return rs;
    }
    
    public void saveData(String sql){
        try{
            koneksi();
            st.executeUpdate(sql);
        }catch(SQLException x){
            System.out.print(x);
        }
    }
    
}
    
//        public static void main(String[] args) {
//        getConnetion();
//    }




//import com.mysql.cj.jdbc.MysqlDataSource;
//import java.sql.Connection;
//import java.sql.SQLException;
//
//public class koneksi {
//    public static Connection konekKeDB() {
//        try {
//            MysqlDataSource mds = new MysqlDataSource();
//            mds.setUser("root");
//            mds.setPassword("");
//            mds.setDatabaseName("SAW_Java");
//            mds.setServerName("localhost");
//            mds.setPortNumber(3306);
//            mds.setServerTimezone("Asia/Jakarta");
//            Connection koneksi = mds.getConnection();
//            System.out.println("TERHUBUNG");
//            return koneksi;
//        } catch (SQLException e) {
//            System.err.println("Can't connect: "+e.getMessage());
//            //JOptionPane.showMessageDialog(null, e.getMessage());
//        }
//        return null;
//    }
//    public static void main(String[] args) {
//        konekKeDB();
//    }




//}



//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//
//public class koneksi {
//
//    public static Connection getConnection(String localhost, String SAW_Java, String root, String password) {
//        Connection connection = null;
//        try {
//            String url = "jdbc:mysql://" + localhost + "/" + SAW_Java;
//            connection = DriverManager.getConnection(url, root, "");
//            System.out.println("Connection to MySQL DB successful");
//        } catch (SQLException e) {
//            System.out.println("The error '" + e.getMessage() + "' occurred");
//        }
//        return connection;
//    }
//
//    public static int execute(String SQL) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    static Connection getConnection() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    static PreparedStatement prepareStatement(String updateQuery) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//}



//package project_uas_spk.tour.travel;
//
//import com.mysql.cj.jdbc.MysqlDataSource;
//import java.sql.Connection;
//import java.sql.SQLException;
//
///**
// *
// * @author muhammadzulfans
// */
//
//public class koneksi {
//    public static Connection Go(){
//        Connection k = null;        
//        try {
//            MysqlDataSource m = new MysqlDataSource();
//            m.setServerName("localhost");
//            m.setDatabaseName("catering");
//            m.setUser("root"); 
//            m.setPassword(""); 
//            m.setPortNumber(3306); 
//            m.setServerTimezone("Asia/Jakarta"); 
//            k = m.getConnection();
//            //System.out.println("OK");
//        } catch (SQLException e) {
//            //System.err.println(e.getMessage());
//        }
//        
//        return k;
//    }
//}
//



//import com.mysql.cj.jdbc.MysqlDataSource;
//import java.sql.Connection;
//import java.sql.SQLException;
//
//public class koneksi {
//    
//    public static Connection MySQl(){
//    
//        try {
//            MysqlDataSource ds = new MysqlDataSource();
//            ds.setUser("root");        
//            ds.setPassword("");
//            ds.setServerName("localhost");
//            ds.setDatabaseName("saw_netbeans");
//            ds.setPortNumber(3306);
//            Connection c = ds.getConnection();
//            System.out.println("database connected!");
//            return c;
//            
//        } catch (SQLException e) {
//            
//            System.err.println("database tidak ada " + e.getMessage());
//            return null;
//        }
//        
//    }
//    
//    public static void main(String[] args) {
//        
//        
//        try {
//            Connection conn = koneksi.MySQl();
//            System.out.println(conn.getCatalog());
//        } catch (SQLException e) {
//            
//        }
//    }
//
//    static int execute(String SQL) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }

//    static int execute(String SQL) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//}