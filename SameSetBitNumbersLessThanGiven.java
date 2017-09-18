package omssrjgd;

import java.util.Scanner;

/*
 *  consider the number 18. its binary representation is 10010. The number of set bits
 *  i.e the number of ones are 2. This program finds all the numbers less than 18 which 
 *  have only 2 bits set in them optimally. 
 *   
 *  Brute force method would be to go through all the numbers less than the given
 *  number and compare the set bits from each number with the given number and check
 */

class SameSetBitNumbersLessThanGiven
{
	int count_Bruteforce(int n)
	{
		int n_SetBits = count_SetBits(n);
		int count=0;
		
		for(int i=1; i<n; i++)
		{
			if(count_SetBits(i)==n_SetBits)
			{
				System.out.println("number less than given : " + i);
				count++;
			}
		}
		
		return count;
	}
	
	int count_SetBits(int n)
	{
		int count =0;
		while (n>0)
		{
			count++;
			n=n&(n-1);
		}
		return count;
	}
	
	
	int count_SameSetBitNumbersLessThanGiven(int n)
	{
		int n_SetBits=0, n_TotalBits=0, rem=0, sum=0;
		
		
		/* 
		 * the following function will calculate the total number of bits and also
		 * all the numbers with the same total bits but less than the given number. 
		 * Ex. 17 has total 5 bits same as 18, has the same number of bits set i.e 2, but is less than 18
		 * 
		 * The same subproblem is repeating. Hence this could probably be done recursively as well. 
		 * consider 100. its binary represenation is 1100100. First you need to see in how many ways can the 1 at position
		 * 3 be fit in the 0's succeeding it i.e 2C1. Now the next one is at position 6. Until position 6 there are two 1's.
		 * In the while loop, the setbit count would increase to 2 and the total bit count would be 6. we are now checking 
		 * 6-1=5 and 5C2. i.e how may ways in which the two 1s could be placed in 5 locations. similarly the problem continues. 
		 */
		
		while(n>1)
		{
			n_TotalBits++;
			rem= n % 2;
			n=n/2;
			
			if(rem==1)
			{
				n_SetBits++;
				sum=sum + count_Combinations(n_SetBits, n_TotalBits-1);				
			}
			
		}
		
		n_TotalBits++;  //to account for the last 1
		n_SetBits++;    //fencepost
		 
		/*numbers with total bits less than the given number but with the same number of set bits */
		sum+= count_Combinations(n_SetBits, n_TotalBits-1); //fencepost
		
		return  sum;						
	}
	
	int count_Combinations(int n_SetBits, int n_TotalBits)
	{
		int  numerator=1, denominator=1;
		
		n_SetBits=((n_TotalBits-n_SetBits) < n_SetBits)? n_TotalBits-n_SetBits:n_SetBits;
		
		while(n_SetBits > 0)
		{
			//result = result * (n_TotalBits /n_SetBits);  will result in float values which may not yield the solution desired
			
			numerator = numerator * n_TotalBits;
			denominator = denominator * n_SetBits;
			
			n_TotalBits--;
			n_SetBits--;
		}		
		return numerator/denominator;
	}
	
	
	
	public static void main(String[] args)
	{
		int given;
		
		System.out.println("Provide input number :  ");
		Scanner input = new Scanner(System.in);
		given = input.nextInt();
		input.close();
		
		SameSetBitNumbersLessThanGiven s = new SameSetBitNumbersLessThanGiven();
		
		System.out.println("Answer by BruteForce  :  " + s.count_Bruteforce(given));		
		System.out.println("answer optimal :  " + s.count_SameSetBitNumbersLessThanGiven(given));        		
		
	}
}
