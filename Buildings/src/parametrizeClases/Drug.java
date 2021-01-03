package parametrizeClases;

public class Drug 
{	
	private String name;
	private int amount;
	public Drug(String name, int amount) 
	{
		this.amount = amount;
		this.name = name;
	}
	public void add(int i) 
	{
		amount += i;
	}
	
	public void subtract(int i)
	{
		amount -= i;
	}
	
	public int getAmount() 
	{
		return amount;
	}
	
	public String getName()
	{
		return name;
	}
}
