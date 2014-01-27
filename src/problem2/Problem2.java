/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package problem2;

import commonutils.Fibonacci;
import java.util.Iterator;


/**
 *
 * @author NISHANTG
 */
public class Problem2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Fibonacci fb = new Fibonacci(4000000);
        Iterator<Long> iter = fb.iterator();
        long sum=0,term;
        while(iter.hasNext() ) {
            term=iter.next();
            if (term%2==0)
                sum+=term;
        }
        
        System.out.println(sum);
        
    }
}
