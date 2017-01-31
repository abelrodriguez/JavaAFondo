/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libro.cap06;

/**
 *
 * @author Abel Rodríguez
 */
public class DemoThread extends Thread {
    
    private String nombre;
    
    public DemoThread(String nombre) {
        this.nombre = nombre;
    }
    
    public void run() {
        try{
            int x = (int)(Math.random()*5000);
            
            Thread.sleep(x);
            System.out.println("Soy: " + nombre + " (" + x + ")");
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static void main (String[] args) {
        DemoThread t1 = new DemoThread("Pedro");
        DemoThread t2 = new DemoThread("Pablo");
        DemoThread t3 = new DemoThread("Juan");
        
        t1.start();
        t2.start();
        t3.start();
        
        //esperamos la finalización de los tres hilos
        try {
            
            t1.join();
            t2.join();
            t3.join();
        } catch (Exception e) {
        }
        
        System.out.println("Final del programa!");
    }
    
}
