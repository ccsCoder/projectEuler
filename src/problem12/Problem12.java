/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package problem12;

import commonutils.SieveOfEratosthenesPrimeGenerator;
import java.util.List;

/**
 *
 * @author NISHANTG
 */
public class Problem12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        SieveOfEratosthenesPrimeGenerator gen = new SieveOfEratosthenesPrimeGenerator(75000);
        List<Number> primeList = gen.getPrimeList();
        long i,triangle;
        for(i=500;;i++) {
            triangle=(i*(i+1))/2;
            if (getNumberOfDivisors(primeList,triangle)>=500)
                break;
        }
        long end=System.currentTimeMillis();
        
        System.out.println("Triangle Number having more than 500 divisors="+triangle+" in ---"+(end-start)+" MS.");
        
        
    }    
    
    private static int getNumberOfDivisors(List<Number> primeList, long number) {
        //System.out.print("Number: "+number);
        int numberOfDivisors = 1;
        long remain = number;
        int exponent=1;
        Number temp;
        for(int i=0;i<primeList.size();i++) {
            temp = primeList.get(i);
            //if there is a remainder, this current number is a divisor... ( happens when cannot divide anymore )
            if (temp.longValue() * temp.longValue() > number ) {
                //System.out.print(" has Divisors="+(numberOfDivisors*2)+"\n");
                return numberOfDivisors * 2;
            }
            exponent=1;
            while(remain % temp.longValue()==0) {
                exponent++;
                remain/=temp.longValue();
            }
            
            numberOfDivisors *=exponent;
            
            //if no remainder, get count;
            if (remain==1) {
                //System.out.print(" has Divisors="+(numberOfDivisors)+"\n");
                return numberOfDivisors;
            }
        }
        //System.out.print(" has Divisors="+(numberOfDivisors)+"\n");
        return numberOfDivisors;
    }
    
    /**
     * 
     * @param num
     * @return long
     */
    private static long getNumberOfDivisors(long num) {
        long count=0;
        long tempNum = (long)Math.sqrt(num);
        
        for(long i=1;i<=tempNum;i++) {
           if (tempNum%i==0)
               count+=2;
           
        }
        //Correction for perfect square
        if (tempNum*tempNum==num)
            count--;
        
        
        System.out.println("number: "+tempNum+" has ->"+count);
        return count;
    }
}
