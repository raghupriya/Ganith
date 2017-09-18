package omssrjgd;

class WaveSort
{
	int[] sortIntWave(int[] input)
	{
		int i=0, temp;
		
		while(i+1 < input.length)
		{
			if(i%2==0)
			{
			   if(input[i] < input[i+1])
			   {
				   temp=input[i+1];
				   input[i+1]=input[i];
				   input[i]=temp;
			   }
			}
			else
			{
			   if(input[i]>input[i+1])
			   {
				   temp=input[i+1];
				   input[i+1]=input[i];
				   input[i]=temp;	  	   
			   }
			}	
			
			i++;
		}
		
		return input;
	}
	
	public static void main(String[] args)
	{
		WaveSort temp=new WaveSort();
		int[] input_string={2, 4, 6, 8, 10, 20};
		int[] output;
		output=temp.sortIntWave(input_string);
		
		for(int i=0; i<output.length; i++)
		{
			System.out.println(output[i]);
		}
		
	}
}