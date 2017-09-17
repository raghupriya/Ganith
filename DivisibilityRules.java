package omssrjgd;

class DivisibilityRules
{
	int num;
	
	DivisibilityRules(int input)
	{
		num=input;
	}
	
	boolean isDivisible(int a, int b)
	{
		int remainder = getRemainder(a, b);
		
		if(remainder==0)	
		{
		   System.out.println(num + " is divisible by " + b);
		   return true;
		}
		else
		{
		   System.out.println(num + " is not divisible by " + b);
		   return false;
		}

	}

	int getRemainder(int a, int b)
	{
		int quotient=0, remainder=0;
		quotient = (a/b);	
		remainder = a-(b*quotient);
		
		return remainder;
	}

	

    boolean isDivisibleby2()
    {
    	int remainder = getRemainder(num, 10);
    	boolean result;
    		
    	result = isDivisible(remainder, 2);
    	return result;
    }
    
    int sumOfDigits(int temp)
    {
    	int remainder=0;
    	while (temp>9)
		{
			remainder+=getRemainder(temp,10);
			temp=temp/10;  	
		}		
		remainder+=temp;
		
		return remainder;
    	
    }

	boolean isDivisibleby3()
	{
		int sum=0;
		boolean result;
		
		sum=sumOfDigits(num);
		result=isDivisible(sum,3);
		
		return result;
	}

	void isDivisibleby4()
	{
		int remainder=0;
		
		remainder=getRemainder(num, 100);
		isDivisible(remainder, 4);		
	}
	
	void isDivisibleby5()
	{
		int remainder=0;
		
		remainder=getRemainder(num, 10);
		isDivisible(remainder, 5);
	
	}
	
	void isDivisibleby6()
	{
		if(isDivisibleby2() && isDivisibleby3())
			System.out.println(num + " is Divisible by 6");			
		
	}
	
	void isDivisibleby7()
	{
		int quotient=0, remainder=0, temp=0;
		
		remainder=getRemainder(num,10);
		quotient=num/10;   //18*quotient+remainder = 10A+B;
		
		temp=quotient-2*remainder;		
		isDivisible(temp, 7);
	}
	
	void isDivisibleby8()
	{
		int remainder=0;
		
		remainder=getRemainder(num, 1000);
		isDivisible(remainder, 8);	
	}
	
	void isDivisibleby9()
	{
		int sum=0;
		
		sum=sumOfDigits(num);
		isDivisible(sum,9);		
	}
	
	void isDivisibleby11()
	{
		int temp=num, diffOfEvenOdd=0;
		boolean count=false;  //false is even position and true is odd position
		
		while(temp>9)
		{
			if(!count)
			{
				diffOfEvenOdd+=getRemainder(temp,10);
				count=true;
			}
			else
			{
				diffOfEvenOdd-=getRemainder(temp,10);
				count=false;
			}		
			temp=temp/10;
		}
		
		if(temp>0)
		{
			if(!count)
				diffOfEvenOdd+=temp;
			else
				diffOfEvenOdd-=temp;
		}
		
		isDivisible(diffOfEvenOdd, 11);
	}
	
	
	public static void main(String[] args)
	{
		DivisibilityRules var = new DivisibilityRules(13);
		
		var.isDivisibleby2();
		var.isDivisibleby3();
		var.isDivisibleby4();
		var.isDivisibleby5();
		var.isDivisibleby6();
		var.isDivisibleby7();
		var.isDivisibleby8();
		var.isDivisibleby9();
		var.isDivisibleby11();
		
	}
}
