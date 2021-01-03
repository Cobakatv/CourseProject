package parametrizeClases;

public abstract class Person 
{
	private String FirstName, LastName;
	private int age;
	
	public Person(String FirstName, String LastName, int age) 
	{
		this.age = age;
		this.FirstName = FirstName;
		this.LastName = LastName;
	}
	
	public String getName() 
	{
		return FirstName;
	}
	
	public String getLastName()
	{
		return LastName;
	}
	
	public int getAge() 
	{
		return age;
	}
}
