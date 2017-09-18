
package omssrjgd;

import java.util.Scanner;

public class towersofhanoinspare
{
	//public static int int_max = 1000;
	
	public void solve (int d, int n, int source, int dest, String[] towers)
	{
		
		/*if (d<=n)
		{
			int valueoftemp=0;
			for(int i=0; i<n; i++)
			{
			   valueoftemp = (dest+i)%(n+2);
			   
			   if (valueoftemp!=source && valueoftemp!=dest) //&&value on the top of each stack should be more or each of the stack should be empty
			
				System.out.println(towers[source] + " -> " + towers[valueoftemp]);		
			}
			
			for(int i=1; i<=n; i++)
			{
				int valueoftempforrestacking;
				if(valueoftemp == 0)
				{
					valueoftemp=n;
				}
				valueoftempforrestacking = (valueoftemp-1)%(n+2);
				if (valueoftempforrestacking!=source && valueoftempforrestacking!=dest) //&&value on the top of each stack should be more or each of the stack should be empty
					
					System.out.println(towers[valueoftempforrestacking] + " -> " + towers[valueoftemp]);		
			}
		}*/
		
		if(d<n)
		{
			for(int i=d-1; i>=1; i--)
			{
				int value= (dest+i)%(n+2);
				if(value==source)
				{
					value = dest - i;
					if(value<0)
					{
						value = (dest - i+ n+2);
					}
					//else
					//{
					//	value=dest-i;
					//}
					
					//value=(source+1)%(n+2);
					//value=(dest-i)%(n+2);
				}
				System.out.println(towers[source] + "-->" + towers[value]);
			}
			
			System.out.println(towers[source] + "-->" + towers[dest]);
			
			for(int j=1; j<=d-1; j++)
			{
				int value=(dest+j)%(n+2);
				
				if(value==source)
				{
					
					value = dest - j;
					if(value<0)
					{
						value = (dest - j+ n+2);
					}
					/*if(dest==0)
					{
						value = (n+2 -j);
					}
					else
					{
						value=dest-j;
					}*/
					//value=(source+1)%(n+2);
					//value=(dest-j)%(n+2);  //this step is questionable for modulus since negative values cant be an input for modulus.
				}
				
				
				System.out.println(towers[value] + "-->" + towers[dest]);
			}
		}
		else
		if(d==n)
		{
			for(int i=n-1; i>=1; i--)
			{
				int value= (dest+i)%(n+2);
				if(value==source)
				{
					
					value = dest - i;
					if(value<0)
					{
						value = (dest - i+ n+2);
					}
					/*if(dest==0)
					{
						value = (n+2 -i);
					}
					else
					{
						value=dest-i;
					}*/
					//value=(source+1)%(n+2);
					//value=(dest-i)%(n+2);
				}
				System.out.println(towers[source]+ "-->" + towers[value]);
			}
			
			
			System.out.println(towers[source] + "-->" + towers[dest]);
			
			for(int j=1; j<=n-1; j++)
			{
				int value=(dest+j)%(n+2);
				
				if(value==source)
				{
					value = dest - j;
					if(value<0)
					{
						value = (dest - j+ n+2);
					}
					/*if(dest==0)
					{
						value = (n+2 -j);
					}
					else
					{
						value=dest-j;
					}*/
					//value=(source+1)%(n+2);
					//value=(dest-j)%(n+2);  //this step is questionable for modulus since negative values cant be an input for modulus.
				}
				
				System.out.println(towers[value]+ "-->" + towers[dest]);
			}
			
		}
		
		else
		{
			//while(dest<=n)
			//{ 
			    int temp;
				//int nextdest = (temp+1)%n;
			    if((dest+1)%(n+2)==source)
			    {
			    	temp=(source+1)%(n+2);
			    }
			    else
			    {
			    	temp = (dest+1)%(n+2);
			    }
			
				solve(d-n, n,  source, temp, towers);
				for(int i=n-1; i>=1; i--)
				{
					int value= (temp+i)%(n+2);
					
					if(value==source)
					{
						value=(source+1)%(n+2);
					}
					
					System.out.println(towers[source]+ "-->" + towers[value]);
				}
				
				
				System.out.println(towers[source] + "-->" + towers[dest]);
				
				for(int j=1; j<=n-1; j++)
				{
					int value=(temp+j)%(n+2);
					System.out.println(towers[value]+ "-->" + towers[dest]);
				}
			//	int nextdest = (temp+1)%(n+2);
				solve(d-n, n, temp, dest, towers );
			//	dest=dest+1;
			//}
		}
	}
	
	public static void main(String[] args)
	{
		towersofhanoinspare test = new towersofhanoinspare();
		System.out.println("Enter the number of disks: ");
		Scanner scanner = new Scanner(System.in);
		int d = scanner.nextInt();
		System.out.println("enter the number of spare towers: ");
		int n = scanner.nextInt();
		String[] towers = new String[n+2];
		towers[0] ="S";
		towers[1]="D";
		
		for(int i=1; i<=n; i++)
		{
		  towers[i+1]="T"+i;
		}
		
	//	towers[2]="T1";
	//	towers[3]="T2";
	//	towers[4]="T3";
	//	towers[5]="T4";
	//	towers[6]="T5";
		//towers
		
		//test.solve(6, 3, 0, 1, towers);
		//test.solve(discs, sparetowers, 0, 1, int_max, towers);
		
		//test.solve(6, 3, 0, 1, towers);
		test.solve(d, n, 0, 1, towers);
	}
}