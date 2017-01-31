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
public class Productor  extends Thread {
    
    private Monitor buff;
    private int n;
    private int sleep;
    
    public Productor (Monitor b, int n, int s) {
        this.buff = b;
        this.n = n;
        this.sleep = s;
    }
    
    public void run() {
        try {
            char c;
            
            for (int i=0; i<n; i++) {
                c = (char) ('A' + i);
                
                buff.poner(c);
                System.out.println("Produce: " + c);
                
                sleep((int)(Math.random()*sleep));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }
    
}
