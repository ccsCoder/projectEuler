/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package problem5;

/**
 *
 * @author NISHANTG
 */
public class Problem5 {

    /**
     * @param args the command line arguments
     */
    private static long gcd(long a, long b) {
        long t;
        while (b != 0) {
            t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
    
    private static long lcm(long a, long b) {
        return (a*b)/gcd(a,b);
    }
    
    private static long lcmN(long tempLCM,long a) {
        if (a==20)
            return tempLCM;
        else {
            tempLCM = lcm(tempLCM,a);
            return lcmN(tempLCM,a+1);
        }
        
       
    }
    
    public static void main(String[] args) {
        long t = System.currentTimeMillis();
        //System.out.println(t);
        long lcmmmm = lcmN(2l,3l);
        long tt = System.currentTimeMillis();
        //System.out.println(tt);
        System.out.println("In "+(tt-t)+" ms, number="+lcmmmm);
        
        
    }
}
