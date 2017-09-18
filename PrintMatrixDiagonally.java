package omssrjgd;

/*
 * some comments on my initial code which i incorporated -- 
 * for function names use either camel case or underscore but not both
 * boolean values are used as if x and if !x and not by comparing if x==true
 * use a separate display function to print. Also use tabs to print. or use 
 * string.format(explore this) so you could use %d and other format specifiers with this.
 * class level variables should not change often. so i and j for iteration better be local variables
 * if you need to return multiple variables back then make them into a class and return the class object 
 */

import java.util.Scanner;

class PrintMatrixDiagonally
{
	int[][] result;
	int rows, columns;
	boolean direction = true;  //true is up into the right and false is down into the left
	
	 PrintMatrixDiagonally(int rows, int columns)
	 {
		 this.rows=rows;
		 this.columns=columns;
		 result = new int[rows][columns];	 
	 }
	
	void computeDiagonally()
	{
		int count=0, i=0, j=0;
		
		while (i<rows && j<columns)
		{	   			   	
			result[i][j]=count++; 
			
			//logic to calculate the next valid location
			if (direction)
			{												
				if((j+1) == columns)	//this if takes care of the condition where both i and j can go off i.e on the diagonal to the top right			
				{
					i++;
					j=columns-1;
					direction=false;
				}
				
				else if((i-1)<0)
				{
					i=0;				
					j++;	
					direction=false;
				}
				else
				{
					i--;
					j++;
				}
			}
			
			else
			{
				if((i+1 == rows))  // this if takes care of the condition where both can go off at the bottom diagonal
				{
					i=rows-1;
					j++;
					direction = true;
				}
				else if((j-1) < 0)
				{
					j=0;
					i++;			
				    direction = true;
				}
				else
				{
					i++;
					j--;
				}
			}   	    		   		   
		}
		
		display();
	}
	
	void display()
	{
		for(int i=0; i<rows; i++)
		{
			System.out.println();		
			for(int j=0; j<columns; j++)
			{
				System.out.print("\t" + result[i][j] + "\t");
			}		
			System.out.println();
		}		
	}
	
	
	
	public static void main(String[] args)
	{
		int rows, columns;
		
		Scanner in=new Scanner(System.in);		
		System.out.println("input rows and columns");
		
		rows = in.nextInt();
		columns = in.nextInt();
		
		PrintMatrixDiagonally var = new PrintMatrixDiagonally(rows, columns);
		var.computeDiagonally();
		in.close();
	}
	
}