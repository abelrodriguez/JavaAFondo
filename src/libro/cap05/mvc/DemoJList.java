/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libro.cap05.mvc;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Abel Rodríguez
 */
public class DemoJList extends JFrame {
    
    public DemoJList() {
        super("Demo JList");
        
        Container content = getContentPane();
        content.setLayout(new BorderLayout());
        
        // obtengo el vector con los datos que vamos a mostrar
        ArrayList<Object> datos = _obtenerVectorDatos();
        
        // el constructor de JList recibe una instancai de ListModel
        JList lista = new JList(new ArrayModel(datos));
        
        // el ScrollPane agrega barras de scroll si e necesario
        JScrollPane scrollLista = new JScrollPane(lista);
        
        content.add(scrollLista, BorderLayout.CENTER);
        
        setSize(300,300);
        setVisible(true);
    }
    
    private ArrayList<Object> _obtenerVectorDatos() {
        ArrayList<Object> v = new ArrayList<Object>();
        
        v.add("John Lennon");
        v.add("Paul McCartney");
        v.add("George Harrison");
        
        return v;
    }
    
    public static void main (String[] args) {
        new DemoJList();
    }
}
