/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commonutils;

import java.util.Random;



/**
 *
 * @author NISHANTG
 */
public class MillerRabinPrimality {
    private static Random generator;
    /**
	 * Determines if a number is probably prime using the Miller-Rabin primality
	 * test.
	 * 
	 * @param number
	 * @param iterations
	 *            How accurate the test needs to be. Accuracy ~= 1 -
	 *            O(4^-iterations)
	 * @return false if definitely composite. true if probably prime.
	 */
	public static boolean millerRabinPrime(long number, int iterations)
	{
		if (number <= 1 || (number & 1) == 0)
		{
			if (number == 2)
			{
				return true;
			}
			// numbers less than or equal to 1 are not prime
			// even numbers are not prime
			return false;
		}
		else if (number == 3)
		{
			// 3 is prime
			return true;
		}
		// write number - 1 as 2^s * d, with d odd by factoring powers of 2 from
		// n-1
		long s = 1;
		while ((number - 1 & 1 << s) == 0)
		{
			++s;
		}
		long d = (number - 1) / (1 << s);
		// System.out.println("2^" + s + " * " + d);
		generator = new Random();
		// if (iterations > number - 4)
		// {
		// iterations = number - 3;
		// }
		for (int i = 1; i <= iterations; ++i)
		{
			// pick a random integer a in the range [2, n-2]
			//long a = generator.nextInt(number - 3) + 2;
			//long a = getNextRandomLong(number);
			// test alternative: use an even a distribution
			long a = (number - 3) * i / iterations;
			// compute x=a^d % number, check to see if x==1 or x==number-1
			long x = safe_pow(a, d, number);
			if (x == 1 || x == number - 1)
			{
				continue;
			}
			boolean gotoLoop = false;
			for (int r = 1; r < s && !gotoLoop; ++r)
			{
				// x = x^2 % n
				x = x * x % number;
				if (x == 1)
				{
					return false;
				}
				else if (x == number - 1)
				{
					gotoLoop = true;
					break;
				}
			}
			if (!gotoLoop)
			{
				// definately composite
				return false;
			}
		}
		// probably prime
		return true;
	}
        
        private static long getNextRandomLong(long n) {
            System.out.println("Inside");
            long num;
            do {
                num=Math.abs(generator.nextLong());
                System.out.println(num);
            }while(num<2 || num>(n-3));
            
            return num;
        }
 
	/**
	 * Computes base^power % mod. Protects against over-flow
	 * 
	 * @param base
	 * @param power
	 * @param mod
	 * @return
	 */
	public static long safe_pow(long base, long power, long mod)
	{
		if (power == 0)
		{
			return 1;
		}
		else if (power == 1)
		{
			return base;
		}
		else if ((power & 1) == 0)
		{
			// even power
			// base^power % mod = ((base * base % mod) ^ (power/2)) % mod
			return safe_pow((base * base % mod), power / 2, mod) % mod;
		}
		else
		{
			// odd
			// base^power % mod = ((base * base % mod) ^ (power/2) * base) % mod
			return safe_pow((base * base % mod), power / 2, mod) * base % mod;
		}
	}
        
        public static void main(String[] args) {
            System.out.println(MillerRabinPrimality.millerRabinPrime(303377, 1));
        
        }
    
}
