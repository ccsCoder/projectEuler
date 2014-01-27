/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commonutils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NISHANTG
 */
public class SieveOfEratosthenesPrimeGenerator {
    private long limit;
    private List<Number> primeList;
    private List<Boolean> isComposite;

    public SieveOfEratosthenesPrimeGenerator(long limit) {
        this.limit = limit;
        this.primeList = new ArrayList<Number>();
        this.isComposite = new ArrayList<Boolean>();
        
        //init the flag array.
        for(int i=0;i<=limit;i++) {
            this.isComposite.add(Boolean.FALSE);
        }
    }
    
    public List<Number> getPrimeList() {
        long upperBoundSqrt = (long)Math.sqrt(this.limit);
        
        for(int m=2;m<=upperBoundSqrt;m++) {
            if(!isComposite.get(m)) {
                //System.out.println(m);
                this.primeList.add(m);
                //mark all the multiples as composite.
                for(int k=m*m;k<=this.limit;k+=m)
                    this.isComposite.set(k, Boolean.TRUE);
            }
        }
        
        //also add the ones above the upperBoundSQRT
        for(int m=(int)upperBoundSqrt;m<=this.limit;m++)
            if(!this.isComposite.get(m))
                this.primeList.add(m);
        
        return this.primeList;
    }
}
