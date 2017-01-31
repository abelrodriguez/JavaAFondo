/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libro.cap06.prodcons;

/**
 *
 * @author Abel Rodríguez
 */
public class Monitor {
    
    private char[] buff = null;
    private int tope = 0;
    private boolean lleno = false;
    private boolean vacio = true;
    
    public Monitor(int capacidad) {
        buff = new char[capacidad];
    }
    
    public synchronized void poner (char c) throws Exception {
        // mientras el buffer este lleno, me bloque para dalr la 
        // posibilidad al consumidor de consumir algun caracter
        while (lleno) {
            wait();
        }
        
        // seccion critica
        buff[++tope] = c;
        
        vacio = false;
        lleno = tope >= buff.length;
        
        notifyAll();
        
    }
    
    public synchronized char sacar () throws Exception {
        // mientras el buffer este lleno, me bloque para dalr la 
        // posibilidad al consumidor de consumir algun caracter
        while (vacio) {
            wait();
        }
        
        // seccion critica
        char c = buff[--tope];
        
        lleno = false;
        vacio = tope<=0;
        
        notifyAll();
        
        return c;
    }
    
}
