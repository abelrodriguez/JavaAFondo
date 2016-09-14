/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libro.cap05.mvc;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author Abel Rodríguez
 */
public class MatrizModel implements TableModel {
    
    private Object[][] datos;
    
    public MatrizModel(Object [][] datos) {
        this.datos = datos;
    }
    
    public int getColumnCount() {
        return datos[0].length;
    }
    
    public String getColumnName(int columnIndex) {
        return datos[0][columnIndex].toString();
    }
    
    public int getRowCount() {
        return datos.length - 1;
    }
    
    public Object getValueAt(int rowIndex, int columnIndex) {
        return datos[rowIndex+1][columnIndex];
    }
    
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        
    }
    
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }
    
    public void addTableModelListener(TableModelListener lst) {}
    public void removeTableModelListener(TableModelListener lst) {}
}
