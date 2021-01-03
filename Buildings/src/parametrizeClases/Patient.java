package parametrizeClases;

public class Patient extends Person
{
	private String disease;
	
	public Patient(String FirstName, String LastName, int age, String disease)
	{
		super(FirstName, LastName, age);
		this.disease = disease;
	}
	
	public String getDisease()
	{
		return disease;
	}
	
}
