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
public class DemoThread3 {
    
    public static void main (String[] args) {
        MiThred t1 = new MiThred("Pedro");
        MiThred t2 = new MiThred("Pablo");
        
        t1.setPriority(Thread.MAX_PRIORITY);
        
        System.out.println(Thread.MAX_PRIORITY);
        System.out.println(Thread.MIN_PRIORITY);
        
        t1.start();
        t2.start();
        
       
    }
    
    static class MiThred extends Thread {
    
        private String nombre;

        public MiThred(String nombre) {
            this.nombre = nombre;
        }


        public void run() {
            for (int i=0; i<5; i++ ) {
                
                System.out.println(nombre + " - " + i);
                yield();
            }
        }
    }
    
    
}
