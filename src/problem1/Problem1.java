/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package problem1;

/**
 *
 * @author NISHANTG
 */
public class Problem1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int sum=0;
        long start=System.currentTimeMillis();
        for(int i=0;i<1000;i++)
            if (i%3==0 || i%5==0)
                sum+=i;
        long end=System.currentTimeMillis();
        System.out.println(sum+" in"+(end-start)+" ms");
    }
}
