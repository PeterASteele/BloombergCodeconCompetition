import java.util.*;
public class BloombergCodecon {
		public static void main(String[] args){
			/*
			 * Editor
Submissions
Introduction

One of the great open questions of number theory is whether there exists infinitely many Twin Primes.

Twin Primes are a pair of prime numbers p such that given a prime number p[1], p[2]=p[1]+2 is also a prime.

Given a number K, can you find the largest twin primes p such that p[1],p[2] ≤ K?


Input Specifications

Your program will take a prime number, K ≥ 5.

Output Specifications

Based on the input, print out the closest pair of twin primes ≤ K comma-separated in ascending order.

Sample Input/Output

INPUT
5 
OUTPUT
3,5
EXPLANATION
3 and 5 are both prime numbers ≤ 5 and 3+2=5, making them twin primes.
			 */
			Scanner stdin = new Scanner(System.in);
			int input = 0;;
		       while(stdin.hasNextLine()) 
		       {
		           input = stdin.nextInt();
		           stdin.nextLine();
		       }
		       stdin.close();
		       int highestprime1 = 0;
		       int highestprime2 = 0;
		       
		       for(int a = 2; a <= input -2; a++){
		    	   if (primeCheck(a) && primeCheck(a + 2)){
		    		   highestprime1 = a;
		    		   highestprime2 = a + 2;
		    		   //System.out.println("test");
		    	   }
		       }
		       System.out.println(highestprime1 + ", " + highestprime2);
		}
		public static boolean primeCheck(int numberToTest){
			for(int a = 2; a <= Math.sqrt(numberToTest); a++){
				if (numberToTest % a == 0){
					return false;
				}
			}
			return true;
		}

		
}
