package omssrjgd;

class FirstLastIndex
{
	void helperFunction(int[] input, int elem)
	{
		//int mid = (input.length-1)/2;
		Index x = new Index();
		
		searchIndex(input, 0, input.length-1,elem, x);
		if(x.left==12229 && x.right==-1)
			System.out.println("element not found");
		else if(x.left==x.right)
			System.out.println("element found at " + x.right );
		
		else
		{
			System.out.println("first index is " + x.left + "  last index = " + x.right);
		}
	}
	
	void searchIndex(int[] input, int low, int high, int elem, Index x)
	{
		int mid;
		
		
		if(low<=high)
		{
			mid=((high-low)/2)+ low;
			
			if(elem == input[mid])
			{
				if (mid < x.left)
				{
				   x.left = mid;
				  searchIndex(input, low, mid-1, elem, x);
				}
				 if(mid > x.right)
				 {
					 x.right=mid;
				 
					 searchIndex(input, mid+1, high, elem, x);
				 }
				
			}
			else if(elem < input[mid])
			{
				searchIndex(input, low, mid-1, elem, x);
			}
			else
			{
				searchIndex(input, mid+1, high, elem, x);
			}
		}
		/*else if(low == high)
		{
			if(elem == input[low])
			{
				
			
				if( c == 'L')
				{
					if(low < x.left) 
						x.left = low;
				}
				else
				{
					if (low>x.right)
		
					x.right=low;
				}
				
				
		   }
		  
		}*/			
		
		
	}
	
/*	int searchFirstLast(int[] input, int low, int high, int elem)
	{
		int mid, index;
		
		while(low<=high)
		{
			mid=((high-low)/2)+ low;
		
			if(elem == input[mid])
			{
				index = mid;
				high=mid-1
			}
			
		}
	}*/
	
	class Index
	{
		int left;
		int right;
		
		Index()
		{

			left=65535;
			right=-1;
		}
	}
	
	public static void main(String[] args)
	{
		FirstLastIndex temp= new FirstLastIndex();
		
		int[] input = {1, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 5};
		
		temp.helperFunction(input, 3);
		
		
	}
}
