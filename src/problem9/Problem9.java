/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package problem9;

/**
 *
 * @author Neo
 */
public class Problem9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int a=0,b=0,c=0,p = 0,q;

        boolean found=false;
        long start=System.currentTimeMillis();
        for(q=1;q<=20&&!found;q++) {
            for(p=q+1;p<=20;p++) {
                a = 2 * p * q;
                b = p*p - q*q;
                c = p*p + q*q;
                if ((a+b+c)==1000) {
                    found=true;
                    break;
                }
            }
            
        }
        long end = System.currentTimeMillis();
        System.out.println("For (p,q)=("+p+","+q+"):     a="+a+" , b="+b+" , c="+c+" SUM= "+(a+b+c)+" in "+(end-start)+" MS.");
        
    }
}
