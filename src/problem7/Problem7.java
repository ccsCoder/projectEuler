/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package problem7;

import commonutils.DeterministicPrimalityChecker;
import commonutils.MillerRabinPrimality;
import commonutils.TimeOperation;

/**
 *
 * @author NISHANTG
 */
public class Problem7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NoSuchMethodException {
        
        TimeOperation.init(Problem7.class.getDeclaredMethod("computeNthPrime", null), null);
        TimeOperation.executeWithTimer();
        System.out.println("Operation took:"+TimeOperation.timeTaken +" ms");
    }

    public static void computeNthPrime() {
        // TODO code application logic here
        int primeCount=2,i;
        for(i=3;primeCount<=10001;i+=2) {
            
           if (DeterministicPrimalityChecker.isPrime(i)) {
           //if (MillerRabinPrimality.millerRabinPrime(i, 4)) {
               primeCount++;
               //System.out.println("Found:"+primeCount+"th Prime="+i);
           }
        }
        System.out.println(i-2);
        
        
    }
}
