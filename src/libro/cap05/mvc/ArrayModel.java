/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libro.cap05.mvc;

import java.util.ArrayList;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

/**
 *
 * @author Abel Rodríguez
 */
public class ArrayModel implements ListModel {
    
    private ArrayList<Object> datos;
    
    public ArrayModel (ArrayList<Object> datos) {
        this.datos = datos;
    }
    
    @Override
    public Object getElementAt(int index) {
        return datos.get(index);
    }
    
    @Override
    public int getSize() {
        return datos.size();
    }
    
    @Override
    public void removeListDataListener (ListDataListener lst) {}
    @Override
    public void addListDataListener (ListDataListener lst) {}

    
    
}
