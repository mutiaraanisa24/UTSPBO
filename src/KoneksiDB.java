
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PUGUH
 */
public class KoneksiDB {

    static int execute(String SQL) throws SQLException {
       int status = 0;
        Connection koneksi = setKoneksi();
        try {
            Statement st = koneksi.createStatement();
            status = st.executeUpdate(SQL);
        } catch (SQLException ex) {
            Logger.getLogger(KoneksiDB.class.getName()).log(Level.SEVERE,null, ex);
        } return status;
    }

    static ResultSet executeQuery(String SQL) throws SQLException {
         ResultSet rs = null;
        Connection koneksi = setKoneksi();
        try {
            Statement st = koneksi.createStatement();
            rs = st.executeQuery(SQL);
        } catch (SQLException ex) {
            Logger.getLogger(KoneksiDB.class.getName()).log(Level.SEVERE,null, ex);
        }
            return rs;
    }

    private static Connection setKoneksi() throws SQLException {
        String konString = "jdbc:mysql://localhost:3306/db_resto";
        Connection koneksi = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = (Connection) DriverManager.getConnection(konString,"root","");
            System.out.println("Koneksi Berhasil");
        } catch (ClassNotFoundException ex){
            Logger.getLogger(KoneksiDB.class.getName()).log(Level.SEVERE,null,ex);
            System.out.println("Koneksi Gagal");
        } return koneksi;
    }
    
}
