package example.Programs;

public class VowelOrConsonant 
{	
	public static void main(String[] args) 
	{
		int vowelCount=0, consonantCount=0;
		String text = "I am inside the main program";
		text = text.toLowerCase();
		
		for(int i=0;i<=text.length();i++)
		{
			if(text.charAt(i)=='a'||text.charAt(i)=='e'|| text.charAt(i)=='i'|| 
					text.charAt(i)=='o')
			{
				vowelCount++;
			}
			else if(text.charAt(i)>='a' && text.charAt(i)<='z')
			{
				consonantCount++;
			}
		}
		System.out.println(vowelCount);
		System.out.println(consonantCount);
	}

}