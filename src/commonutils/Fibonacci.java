/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commonutils;

import java.util.Iterator;

/**
 *
 * @author NISHANTG
 */
public class Fibonacci implements Iterable<Long> {
    private long term1,term2,term3,temp;
    private long limit;
    
    public Fibonacci (long limit) {
        this.term1 = 0;
        this.term2= 1;
        this.term3=1;
        this.limit=limit;
    }
    
    @Override
    public Iterator<Long> iterator() {
        Iterator iter = new Iterator() {

            @Override
            public boolean hasNext() {
                return Fibonacci.this.term1 <Fibonacci.this.limit;
            }

            @Override
            public Object next() {
                temp=term1;
                term1 = term2;
                term2 = term3;
                term3= Math.abs(term1+term2);
                return Math.abs(temp);
            }

            @Override
            public void remove() {
                return;
            }
        };
        
        return iter;
    }
    
}
