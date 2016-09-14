/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libro.cap05.mvc;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Abel Rodríguez
 */
public class DemoJTable extends JFrame {
    
    public DemoJTable() {
        super("Demo JList");
        
        Container content = getContentPane();
        content.setLayout(new BorderLayout());
        
        Object[][] datos = _obtenerMatrizDatos();
        JTable tabla = new JTable(new MatrizModel(datos));
        
        JScrollPane scrollLista = new JScrollPane(tabla);
        content.add(scrollLista, BorderLayout.CENTER);
        
        setSize(300,300);
        setVisible(true);
    }
    
    private Object[][] _obtenerMatrizDatos() {
        Object [][] mat = {
                { "Columna 0", "Columna 1", "Columna 2" },
                { "Rojo", "Verde", "Azul" },
                { "Amarillo", "Naranja", "Blanco" },
                { "Negro", "Turquesa", "Sepia" }
            };
    
        return mat;
    }
    
    public static void main(String[] args) {
        new DemoJTable();
    }
}
