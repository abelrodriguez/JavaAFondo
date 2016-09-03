/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libro.cap03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 *
 * @author Abel Rodríguez
 */
public class UConnection {
    
    private static Connection con = null;
    
    public static Connection getConnection() {
        try {
            if (con == null) {
                // con esto determinamos cuando finalize el programa
                Runtime.getRuntime().addShutdownHook(new MiShDwnHook());
                
                ResourceBundle rb = ResourceBundle.getBundle("jdbc");
                String driver = rb.getString("driver");
                String url = rb.getString("url");
                String usr = rb.getString("usr");
                String pwd = rb.getString("pwd");
             
                Class.forName(driver);
                con = DriverManager.getConnection(url, usr, pwd);
            }
            
            return con;
        }
        catch (MissingResourceException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Recurso no encontrado", ex);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("Error al crear la conexión", ex);
        }
    }
    
    static class MiShDwnHook extends Thread {
        // justo antes de finalizar el programa la JVM invocara
        // a este metodo donde podemos cerrar la conexion
        
        public void run() {
            try {
                Connection con = UConnection.getConnection();
                con.close();
            }
            catch (Exception ex) {
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }
        }
    }
    
}
