/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libro.cap04;

import java.util.HashMap;
import java.util.ResourceBundle;

/**
 *
 * @author Abel Rodríguez
 */
public class UFactory {
    
    private static HashMap<String,Object> instancias;
    
    
    public static Object getInstancia(String objName) {
        try {
            
            if (instancias == null) {
                instancias = new HashMap<String,Object>();
            }
            
            // verifico si exite un objeto relacionad a objName
            // en el HashMap
            Object obj = instancias.get(objName);
            
            if (obj == null) {
                ResourceBundle rb = ResourceBundle.getBundle("factory");
                String sClassname = rb.getString(objName);
                obj = Class.forName(sClassname).newInstance();
                
                instancias.put(objName, obj);
            }
            
            return obj;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }
}
