package omssrjgd;

//Given   two   numbers   (a   and   b),   return   true   if   a   is   divisible   by   b,  otherwise   return   false. 

class Divisible
{
	void isDivisible(int a, int b)
	{
		int remainder = getRemainder(a, b);
		
		if(remainder==0)		
		   System.out.println(a + " is divisible by " + b);
		else
		   System.out.println(a + " is not divisible by " + b);

	}

	int getRemainder(int a, int b)
	{
		int quotient=0, remainder=0;
		quotient = (a/b);	
		remainder = a-(b*quotient);
		
		return remainder;
	}

	public static void main(String[] args)
	{
		Divisible var = new Divisible();
		int a=-200, b=200;
		
				
		if(b==0)		
			System.out.println(" division by zero is not allowed ");		
		else
			var.isDivisible(a, b);
	}
		
}