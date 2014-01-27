/*
 * The following iterative sequence is defined for the set of positive integers:

n  n/2 (n is even)
n  3n + 1 (n is odd)

Using the rule above and starting with 13, we generate the following sequence:

13  40  20  10  5  16  8  4  2  1
It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

Which starting number, under one million, produces the longest chain?

NOTE: Once the chain starts the terms are allowed to go above one million.
 */
package problem14;

/**
 *
 * @author NISHANTG
 */
public class Problem14 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long length=0,maxLength=0;
        long temp;
        long maxNumber=0;
        long start = System.currentTimeMillis();
        for(long n=999999;n>=500001;n-=2) {
            temp=n;
            length=0;
            while(temp>1) {
                if ((temp&1) ==0) {            //try n&1
                    temp = temp>>1;
                }
                else {
                    temp=temp*3+1;
                }
                length++;
            }
            if (length>maxLength) {
                maxLength=length;
                maxNumber=n;
            }
                
        }
        long end = System.currentTimeMillis();
        System.out.println(maxNumber+" in "+(end-start)+" MS");
    }
}
