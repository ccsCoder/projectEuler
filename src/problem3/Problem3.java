/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package problem3;

import commonutils.MillerRabinPrimality;
import java.util.Random;

/**
 *
 * @author NISHANTG
 */
public class Problem3 {
    
    private long composite;
    
    public Problem3(long composite) {
        this.composite = composite;
    }
    
    //actually, we'll be finding the smallest prime factor and dividing the composite by that
    
    public void getLargestPrimeFactor() {
        long i=2;
        //long limit= (long)Math.round(Math.sqrt((double)composite));
        long limit= composite;// (long)Math.round(Math.sqrt((double)composite));
        
        
        while(i<limit) {
            //System.out.println("Limit:"+limit+" i="+i);
            if (limit%i==0) {
                limit= limit/i;
                //break;
            }
            i++;
        }
        System.out.println(limit);
        
    }
    
    public static void main(String[] args) {
        Problem3 p3 = new Problem3(600851475143L);
        //Problem3 p3 = new Problem3(13195L);
        p3.getLargestPrimeFactor();
        //Random r = new Random();
        //System.out.println(Math.abs(r.nextLong()));
    }
    
    
    
}
