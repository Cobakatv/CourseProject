package buildings;

import java.util.*;

public class HealthCare 
{
	private Map<String, Building> HealthCare;
	
	public HealthCare() 
	{
		this.HealthCare = new HashMap<String, Building>();
	}
	
	public ArrayList<Building> getArrayVal() 
	{
		ArrayList<Building> array = new ArrayList<Building>();
		for(Building build: HealthCare.values())
		{
			array.add(build);
		}
		return array;
	}
	
	public void add(String name, Building build)
	{
		HealthCare.put(name, build);
	}
	
	public void delete(String name)
	{
		HealthCare.remove(name);
	}
	
	public Building get(String name) 
	{
		return HealthCare.get(name);
	}
	
	public boolean containsName(String name) 
	{
		return HealthCare.containsKey(name);
	}
}


