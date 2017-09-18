//String getLongestPalindrome(String word): Write a program to print the longest palindrome in the given string?

package StringQotd;

class LongestPalindromeRecursion
{
	String input;
	int inputLength;
	int[][] matrix;
	
	LongestPalindromeRecursion(String s)
	{
		input=s;
		inputLength=input.length();
		matrix=new int[inputLength][inputLength];
	}

	
	

	int getLongestPalindromeLength(String word, int i, int j)
	{
			if(i>j)
				return 0;
			
			 
				
			
		     if(matrix[i][j]==0)
			 {
		    	 if(i==j)  //it is best to take this statement outside the recursive call. 
		    	 {
					//return 1;
		    		 matrix[i][j]=1;
		    		 return 1;
		    	 }
		    	 
				if(word.charAt(i)==word.charAt(j))
					matrix[i][j]=2 + getLongestPalindromeLength(word, i+1, j-1);				
				else
					matrix[i][j]= Math.max(getLongestPalindromeLength(word, i, j-1), getLongestPalindromeLength(word, i+1, j)) ;
			 }
			
			return matrix[i][j]; 
			
	 }
			
	void printMatrix()
	{
		for(int i=0; i<inputLength; i++)
		{
			for(int j=0; j<inputLength; j++)
				System.out.print("\t" + matrix[i][j]);
			
			System.out.println("\n");
		}
				
	}
		
			
						
			public static void main(String[] args)
			{
				LongestPalindromeRecursion test=new LongestPalindromeRecursion("abamadama");
				int value=test.getLongestPalindromeLength("abamadama", 0, 8);	
				
				test.printMatrix();
				
				
			}
}

