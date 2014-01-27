/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * The palindrome can be written as
11(9091a + 910b + 100c) = mn;
a,b & c being 1 digit integers and m & n being 3 digit intergers.

Let 11 * 10 < m < 11 * 90;

for(int a=9; a>=1; a--)
  for(int b=9; b>=0; b--)
    for(int c=9; c>=0; c--){
      num = 9091 * a + 910 * b + 100 * c;
      for(int divider=90; divider>=10; divider--){
        //look for divider that can divide 
        //and also doesn't make n > 999
	if((num % divider) == 0){
	  if((num / divider) > 999)
	    break;
	  else
	    result = num * 11; //Found it!
	} else { break; }
      }
 * 
 * 
 */
package problem4;

/**
 *
 * @author Neo
 */
public class Problem4 {

    /**
     * @param args the command line arguments
     */
    private static boolean isPalindrome(int num) {
        int reverse=0;
        int tempNum = num;
        while(num>0) {
            reverse = reverse*10+ num%10;
            num/=10;
        }
        //System.out.println("Reverse"+reverse);
        
        return reverse==tempNum;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        //isPalindrome(1091);
        int temp=0,pdrome=0;
//        for(int i=999;i>=980;i--) {
//            temp = 1100 * i - 990 * (i/10) -99 * (i/100);
//            
//            System.out.println(i+"*"+(temp/i)+"="+temp);
//            
//        }
        long t=System.currentTimeMillis();
        for(int i=100;i<=999;i++) {
            for(int j=100;j<=999;j++) {
                temp = i*j;
                if(temp%11==0 && isPalindrome(temp)) {
                    pdrome = temp>pdrome?temp:pdrome;
                }
            }
        }
        long e = System.currentTimeMillis();
        
        System.out.println(pdrome);
        System.out.println(e-t);
    
    }
}
