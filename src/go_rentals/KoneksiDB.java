/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package go_rentals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author USER-ACER-PC
 */
public class KoneksiDB {

    static int con(String SQL) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     static class con {

        static Statement createStatement() {
            throw new UnsupportedOperationException("Not yet implemented");
        }

        public con() {
        }
    }
    public Connection connection;

    public KoneksiDB() {
        try{
            Object newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection=DriverManager.getConnection("jdbc:mysql://localhost/go","root","");


        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Gagal Koneksi - " + e.getMessage());

        }
    }

     public static Connection setKoneksi() {
String konString = "jdbc:mysql://localhost:3306/go";
Connection koneksi = null;
try {
Class.forName("com.mysql.jdbc.Driver");
koneksi = (Connection) DriverManager.getConnection(konString,"root","");
System.out.println("Koneksi Berhasil");
} catch (ClassNotFoundException ex) {
Logger.getLogger(KoneksiDB.class.getName()).log(Level.SEVERE, null, ex);
System.out.println("Koneksi Gagal");
} catch (SQLException ex) {
Logger.getLogger(KoneksiDB.class.getName()).log(Level.SEVERE, null, ex);
System.out.println("Koneksi Gagal");
}
return koneksi;
}
public static int execute(String SQL) {
int status = 0;
Connection koneksi = setKoneksi();
try {
Statement st = koneksi.createStatement();
status = st.executeUpdate(SQL);
} catch (SQLException ex) {
Logger.getLogger(KoneksiDB.class.getName()).log(Level.SEVERE, null, ex);
}
return status;
}
    
    
    
}
