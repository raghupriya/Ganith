//boolean isPalindrome(String word): Given a word, check if it is a palindrome or not.

package StringQotd;

class Palindrome
{
	boolean isPalindromeUsingStringBuffer(String input)
	{
		StringBuffer temp = new StringBuffer(input);
		StringBuffer rev = temp;
		
		
		System.out.println(temp.toString());
		System.out.println(rev);
		
      
		if(temp.toString().equals(rev.reverse().toString()))
			return true;
	
		return false;
	}

	boolean isPalindromeUsingString(String input)
	{
		int len=input.length();
		int mid=len/2;

		int EndIndex=len-1;
		for(int i=0; i<mid; i++)
		{
			if(input.charAt(i)==input.charAt(EndIndex))
				EndIndex--;
			else
				return false;
		}
		return true;
	}
	

	public static void main(String[] args)
	{
		String input = "testest";		
		Palindrome test = new Palindrome();
		
		boolean flag = test.isPalindromeUsingStringBuffer(input);
		
		if(flag)
			System.out.println("is a palindrome");
		else
			System.out.println("No");

		flag=test.isPalindromeUsingString(input);
		
		if(flag)
			System.out.println("ispalindrome");
		else
			System.out.println("Not");

	}
}