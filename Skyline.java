

package omssrjgd;

//import java.util.*;

public class Skyline
{
	int x;
	int y;
	//Skyline[] result;
	
	public Skyline(int xcord, int ycord)
	{
		this.x=xcord;
		this.y=ycord;
	}
	
	public class Building
	{
	    public int left;
	    public int height;
	    public int right;
	    
	   public Building(int left, int height, int right)
	    {
	    	this.left=left;
	    	this.height=height;
	    	this.right=right;
	    }
		
	}
	
	Skyline[] Compute_Skyline (Building[] GivenBuilding)
	{
		Skyline[] input, result;
		input=convert_to_xy(GivenBuilding);
		result = new Skyline[input.length];
		Compute_Skyline_usingMergeSort(input, result, 0, input.length-1);
		int i=0, k=0;
		
		for(int z=0; z<input.length; z++)
		{
			System.out.print(input[z].x + "," + input[z].y + "        ");
		}
		
		System.out.println("  ");
		
		for(int j=1; j<input.length; j++)   //to remove co ordinates with the same height
		{
			if (input[i].y != input[j].y)
			{
			  result[k].x=input[i].x;
			  result[k].y=input[i].y;
			  k++; i=j;
			}
			
		}
		return result;
	}
	
	void Compute_Skyline_usingMergeSort(Skyline[] input, Skyline[] result, int low, int high)
	{
	    int mid = low+(high-low)/2;
	    //int h1, h2;
	    
	    if (low >= high)
	    	return ;
	    
	    Compute_Skyline_usingMergeSort(input, result, low, mid);  //is this the correct way to write recursive code?
	    Compute_Skyline_usingMergeSort(input, result, mid+1, high);
	    Merge_the_two_halves(input, result, low, mid, high);
	    
	    
	}
	
	void Merge_the_two_halves(Skyline[] array, Skyline[] result, int low, int mid, int high)
	{
		/*if(low>=high)
			return array;*/
		
		int iteratefirsthalf=low;
		int iteratesecondhalf=mid+1;
		int h1=0, h2=0, i=0;
		//Skyline temp;
		
		while(iteratefirsthalf <= mid && iteratesecondhalf <= high)
		{
			if (array[iteratesecondhalf].x < array[iteratefirsthalf].x)
			{
				
				h2=array[iteratesecondhalf].y;
				result[i]=new Skyline(0,0);
				result[i].x = array[iteratesecondhalf].x;
				result[i].y=Math.max(h1, h2);
				
				//temp=array[iteratefirsthalf];
				//array[iteratefirsthalf]=array[iteratesecondhalf];
				//array[iteratesecondhalf]=temp;
				
				iteratesecondhalf++;
				i++;
				
			}
			else
			{
				h1=array[iteratefirsthalf].y;
				
				result[i]=new Skyline(0,0);
				result[i].x=array[iteratefirsthalf].x;
				result[i].y=Math.max(h1, h2);
				
				iteratefirsthalf++;
				i++;
			}
				
				
		}
		
		while(iteratefirsthalf<=mid)
		{
			result[i]=new Skyline(0,0);
			result[i].x=array[iteratefirsthalf].x;
			result[i].y=array[iteratefirsthalf].y;
			i++;
			iteratefirsthalf++;
		}
		
		while(iteratesecondhalf<=high)
		{
				result[i]=new Skyline(0,0);
				result[i].x=array[iteratesecondhalf].x;
				result[i].y=array[iteratesecondhalf].y;
			
			i++;
			iteratesecondhalf++;
		}
		
		i=0;
		for(int j=low; j<=high; j++)
		{
			array[j]=result[i++];
		}
		
		//	return array;
	}
	
	Skyline[] convert_to_xy(Building[] GivenBuilding)
	{
		Skyline[] givenSkyline = new Skyline[GivenBuilding.length*2];
		
		for(int i=0; i<GivenBuilding.length; i++)
		{
			System.out.println(i);
			givenSkyline[i*2] = new Skyline(GivenBuilding[i].left, GivenBuilding[i].height);
			givenSkyline[i*2+1] = new Skyline(GivenBuilding[i].right, 0);	
		}
		
		for(int i=0; i<givenSkyline.length; i++)
		{
			System.out.println(givenSkyline[i].x + " , " + givenSkyline[i].y);
		}
		
		return givenSkyline;
	}
	
	
	
	public static void main(String[] args)
	{
		Skyline skyline_given = new Skyline(0,0);
		Skyline[] result;
		Building[] input= new Building[8];  //isnt the static key word applicable in main?  if i put size 8 here and then initialize only the 0th position then I get a null pointer exeption
	 	input[0] = skyline_given.new Building (1, 11, 5);  // explain this syntax... 
	 	input[1] = skyline_given.new Building (2, 6, 7);
	 	input[2] = skyline_given.new Building (3, 13, 9);
	 	input[3] = skyline_given.new Building (12, 7, 16);
	 	input[4] = skyline_given.new Building (14, 3, 25);
	 	input[5] = skyline_given.new Building (19, 18, 22);
	 	input[6] = skyline_given.new Building (23, 13, 29);
	 	input[7] = skyline_given.new Building (24, 4, 28);
		
	 	result=skyline_given.Compute_Skyline(input);
	 	
	 	for (int i=0; i<result.length; i++)
	 	{
	 		System.out.print(result[i].x + "," + result[i].y + "         ");
	 	}
	 	
	}
}