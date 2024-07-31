package example.Programs;

public class AddNumbers 
{
	public int sum(int a,int b)
	{
		return a+b;
	}
	public static void main(String[] args) 
	{
		AddNumbers obj = new AddNumbers();
		int res = obj.sum(3, 4);
		System.out.println("result is:"+res);
	}
}