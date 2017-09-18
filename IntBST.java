package omssrjgd;

import java.util.Scanner;

class IntTreeNode
{
	public int data;
	public IntTreeNode left;
	public IntTreeNode right;
	
	
	public IntTreeNode(int data)
	{
		this(data, null, null);
	}
	
	 public IntTreeNode(int data, IntTreeNode left, IntTreeNode right)
	 {
		 this.data=data;
		 this.left=left;
		 this.right=right;
	 }
}


class IntBST {
	IntTreeNode root;
	
	IntBST()
	{
		this.root=null;
	}
	
	void addBST(IntTreeNode node)
	{
	   if (this.root==null)	   
		  this.root = node;   	   
	   else
	   {
		   IntTreeNode temp = root;
		   IntTreeNode prev=null;
		  		   
		   while (temp!=null)
		   {
			   prev=temp;
		   
			   if(node.data < temp.data)
				   temp=temp.left;			   
			   else			   				
				   temp=temp.right;			   
		   }
		   
		   if(node.data < prev.data)
			   prev.left=node;
		   else
			   prev.right=node;
	   }
	   
	}
	
	void displayBSTInorder(IntTreeNode temp)
	{
		if(temp!=null)
		{
			displayBSTInorder(temp.left);
			System.out.println(temp.data);
			displayBSTInorder(temp.right);
		}
			
	}
	
	int calulateNearestToXInBST(int x)
	{
		int value=0, result=0, diff=0, closest=65535;
		
		IntTreeNode temp=this.root;
		
		while (temp!=null)
		{
			value=temp.data;
			
			if(x < value)
			{
				diff = value-x;	
				temp=temp.left;
			}
			else
			{
				diff = x-value;
				temp=temp.right;
			}
			
			if (diff < closest)
			{
				closest=diff;
				result=value;
			}
		}
		return result;
	}
	
	
	public static void main(String[] args)
	{
		IntBST test = new IntBST();		
		int value;
		IntTreeNode node;
		int[] arrInt = {-1, -8, -7, -9, 100};
		
		Scanner s = new Scanner(System.in);
		
		for(int i: arrInt)
		{
			node=new IntTreeNode(i);
			test.addBST(node);
		}
		
		test.displayBSTInorder(test.root);			
		System.out.println("enter the number to which the closest is required  : ");
		value=s.nextInt();
		System.out.print(test.calulateNearestToXInBST(value));		
		s.close();
		
	}

}
