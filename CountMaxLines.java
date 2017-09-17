
package omssrjgd;

import java.util.Arrays;

class CountMaxLines
{
	int[] input;
	
	
	CountMaxLines(int[] val)
	{
		this.input=val;
	}
	
	int countMaximumLines(int curr, int prev, int i, int count, int[] temp, int[] finalResult)
	{
		//temp[i]=count+1;
		
		if(curr > prev)
		{
			count++;
			
		//	if(temp[i]<count)
			    temp[i]=count;
			
			if(i+1==input.length)
			{
				
				
				for(int k=0; k<input.length; k++)
					finalResult[k] = temp[k];
				
				return count;
			}
			
			
			//count++;
			prev=curr;
			curr=input[i+1];
			return countMaximumLines(curr, prev, i+1, count, temp, finalResult);
		}
		else
		{
			
			
			if(i+1==input.length)
				if(count==1)
				{
					//finalResult=temp;
					
					for(int k=0; k<input.length; k++)
						finalResult[k] = temp[k];
					
					return count;
				}
				else
				{
					//for(int k=0; k<input.length; k++)
					//	temp[k]=0;
				
					return -1;
				}
			
			//if(temp[i+1]<count)
				temp[i+1]=count;
			
			return Math.max(countMaximumLines(curr+input[i+1], prev, i+1, count, temp, finalResult), countMaximumLines(input[i+1], prev+input[i], i+1, count, temp, finalResult));
			
		}
		//return count;
	}
	
	public static void main(String[] args)
	{
		//int[] input = {1,1,4,5};     
		//int[] input = {10, 2, 3, 6};
		int[] input = {1, 1, 4, 5, 6, 6, 14, 15};
		//int[] input = {10, 2, 3};
		
		int[] temp=new int[input.length];
		temp[0]=1;
		for(int m=1;m<temp.length; m++)
			temp[m]=0;
		
		int[] finalResult=new int[input.length];
		for(int m=0;m<temp.length; m++)
			finalResult[m]=0;
		
		CountMaxLines var= new CountMaxLines(input);
		
		int result=var.countMaximumLines(input[1], input[0], 1, 1, temp, finalResult);
		System.out.println(result);
		
		if(result!=-1)
			System.out.println(Arrays.toString(finalResult));
		
	}
	
}