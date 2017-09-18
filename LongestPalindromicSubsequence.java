//based on tushar roy's longest palindromic subsequence on youtube. 

package omssrjgd;

import java.util.Arrays;

class LongestPalindromicSubsequence
{
	
	
	void  calculate_LPS(String input)
	{
		int len=input.length();
		
		int[][] matrix = new int[len][];
		for(int i=0; i<len;i++)
		{
			matrix[i] = new int[len];
		}
		
		//initialize the diagonal elements to 1 as each element is a LPS of length 1
		
		for (int i=0; i<len; i++)
		{
		   matrix[i][i]=1;	
		}
		
		int j;
		
		for(int k=1; k<=len; k++) //for length of subsequences -- len 1, 2, 3 till input string length
		{
			for(int i=0; i<len;i++) //actual indices ex for len 2 -- 0, 1; 1, 2; 2,3; for len 3 -- 0-2; 1-3; 
			{
				j=i+k;
				if(j<len)
				{
					if(input.charAt(i) == input.charAt(j))
					{
						matrix[i][j]= matrix[i+1][j-1]+2;
					}
					else
					{
						matrix[i][j]= Math.max(matrix[i][j-1], matrix[i+1][j]);
					}
					
				}
					
			}
			
			
		}
		
		System.out.println(Arrays.deepToString(matrix));
		
		int[] output=new int[len];
		int i=0,k=0;
		j=len-1;
		//double halfthematrix = Math.floor(len/2);

		//while(i<len-1)
		//{
			while(j> 0 && matrix[i][j]!=0 )
			{
				System.out.println("original box  " + matrix[i][j]);
				System.out.println("diagonal down " + matrix[i+1][j-1]);
				
				System.out.println("value of i  " + i + "   value of j "+ j);
				
				if(matrix[i+1][j-1]+2 == matrix[i][j] && (input.charAt(i)==input.charAt(j)))
				{
					//output[k++]=input.charAt(j);
					output[i]=1;
					output[j]=1;
					i=i+1;
					j=j-1;
				}
				else
				{
					System.out.println("left" + matrix[i][j-1]);
					if(matrix[i][j]==matrix[i][j-1])
					{
						j=j-1;
					}
					else
					{
					    System.out.println("down" + matrix[i+1][j]);
						if (matrix[i][j]==matrix[i+1][j])
						{
							i=i+1;
						}
						else
						{
							output[i]=1;
							j=0;  // terminating condition
							
					 	}
					}
				}
			}
			
			
	// i traversed left for equal elements. in thsi while loop i will traverse down. Just to amke sure that i dont include several palindromes of the same lenght
				
		//}	
			j=len-1;
			i=0;
			
			while(j> 0 && matrix[i][j]!=0 )
			{
				System.out.println("original box  " + matrix[i][j]);
				System.out.println("diagonal down " + matrix[i+1][j-1]);
				
				System.out.println("value of i  " + i + "   value of j "+ j);
				
				if(matrix[i+1][j-1]+2 == matrix[i][j] && (input.charAt(i)==input.charAt(j)))
				{
					//output[k++]=input.charAt(j);
					output[i]=1;
					output[j]=1;
					i=i+1;
					j=j-1;
				}
				else
				{
					System.out.println("left" + matrix[i][j-1]);
					if(matrix[i][j]==matrix[i+1][j])
					{
						i=i+1;
					}
					else
					{
					    System.out.println("down" + matrix[i+1][j]);
						if (matrix[i][j]==matrix[i][j-1])
						{
							j=j-1;
						}
						else
						{
							output[i]=1;
							j=0;
							
					 	}
					}
				}
			}
		
		System.out.println("the letters other than the palindrome are");
		
		for(i=0; i<len; i++)
		{
			if(output[i]==0)
				System.out.println(input.charAt(i));
		}
	} 
	
	public static void main(String[] args)
	{
		String input="google";
		LongestPalindromicSubsequence LPS_obj= new LongestPalindromicSubsequence();
		LPS_obj.calculate_LPS(input);
	}
	
	
} 