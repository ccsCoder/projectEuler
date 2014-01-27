/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package problem10;

import commonutils.DeterministicPrimalityChecker;

/**
 *
 * @author NISHANTG
 */
public class Problem10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long sum=2;
        long start = System.currentTimeMillis();
        for(long i=3;i<2000000;i+=2) {
            sum += DeterministicPrimalityChecker.isPrime(i)?i:0;
            
        }
        long end = System.currentTimeMillis();
        
        System.out.println("In "+(end-start)+" MS, sum="+sum);
    }
}
