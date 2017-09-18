
package omssrjgd;

import java.util.*;

public class MatrixDistancefromZero {
     private   int[][] matrix_class;
	
	public MatrixDistancefromZero(int[][] matrix)
	{
		this.matrix_class=matrix;
		for (int i=0; i<matrix.length; i++)
			for (int j=0; j<matrix[i].length; j++)
			{
				if(matrix_class[i][j]==1)
					matrix_class[i][j]= 32;
				
			}
	}
	
	public class Coordinate
	{
		public int x;
		public int y;
		
		public Coordinate(int x, int y)
		{
			this.x=x;
			this.y=y;
		}
	}
	
	
	public static void main(String[] args)
	{
		int[][] input_matrix = {
								{1,1,1},
								{1,1,1},
								{1,1,0}
								};
		MatrixDistancefromZero input = new MatrixDistancefromZero(input_matrix);
		
		input_matrix = input.CalculateZeroDistance(input_matrix);
		
		for (int i=0; i<3; i++)
			for (int j=0; j<3; j++)
			{
				System.out.println(input_matrix[i][j]);
			}
		
	}
    public int[][] CalculateZeroDistance ( int[][] matrix){
    	int[] x_co={-1, 1, 0, 0};
    	int[] y_co={0, 0, -1, 1};
    	Queue<Coordinate> BFSq = new LinkedList<Coordinate>();
    	int m=matrix.length;
    	int n, x=0, y=0;
    	for(int i=0; i<matrix.length;i++)
    	{
    		for(int j=0; j<matrix[i].length; j++)
    		{
    			n=matrix[i].length;
    		    if (matrix[i][j]==0)
    		    {
    		    	
    		    	for (int k=0; k<4;k++)
    		    	{
    		    	  x = i+ x_co[k];
    		    	  y = j+ y_co[k];
    		    		
       		    	
    		    	if (x<0 || x>=m || y<0 || y>=n)
    		    		continue;
    		    	else
    		    	{
    		    		if (matrix[x][y]==32)
    		    		{
    		    			matrix[x][y]=1;
    		    			Coordinate p= new Coordinate(x,y);
    		    			BFSq.add(p);
    		    		}
    		    	}
    		       }
    		    }
    		}
    	}
    	
    	Coordinate temp;
    	while (!BFSq.isEmpty())
    	{
    		temp=BFSq.remove();
    		int value = matrix[temp.x][temp.y];
    		int i=temp.x;
    		int j=temp.y;
    	//	int m=matrix.length;
    	//	int n=m;
    		n=m;
    		
    		for (int k=0; k<4;k++)
	    	{
	    	  x = i+ x_co[k];
	    	  y = j+ y_co[k];
	    		
		    	
	    	if (x<0 || x>=m || y<0 || y>=n)
	    		continue;
	    	else
	    	{
	    		if (matrix[x][y]==32)
	    		{
	    			matrix[x][y]=value+1;
	    			Coordinate p= new Coordinate(x,y);
	    			BFSq.add(p);
	    		}
	    	}
	    	}		
    	}
    	
    	return matrix;
    	
    
    } 
}











