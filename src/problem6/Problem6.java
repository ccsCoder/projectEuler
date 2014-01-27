/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package problem6;

/**
 *
 * @author NISHANTG
 */
public class Problem6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        long squareOfSums = 50*101;
        squareOfSums = squareOfSums * squareOfSums;
        
        long sumOfSquares = 0;
        for(int i=1;i<=100;i++)
            sumOfSquares+=i*i;
        
        System.out.println(squareOfSums-sumOfSquares);
    }
}
