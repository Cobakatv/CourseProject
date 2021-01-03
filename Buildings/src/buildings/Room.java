package buildings;

import java.util.*;
import parametrizeClases.*;

public class Room 
{
	private double area;
	private int people, allDrugs, patients, staff;
	private ArrayList<Staff> Staff;
	private ArrayList<Patient> Patients;
	private ArrayList<Drug> Drugs;
	
	public Room(double area, int people)
	{
	
		this.area = area;
		this.people = people;
		this.allDrugs = 0;
		this.staff = 0;
		this.patients = 0;
	}
	
	//достаем препарат из списка по индексу
	public Drug getDrug(int i) 
	{
		return Drugs.get(i);
	}
	
	//узнаем длину массива препаратов
	public int drugsLength() 
	{
		return Drugs.size();
	}
	
	//узнаем общее число препаратов
	public int getDrugsInt() 
	{
		return allDrugs;
	}
	
	public String getStaff(int i) 
	{
		String str = "";
		str += Staff.get(i).getLastName() + " " + Staff.get(i).getName() + " " + Staff.get(i).getAge();
		return  str;
	}
	
	public String getPatient(int i) 
	{
		String str = "";
		str += Patients.get(i).getLastName() + " " + Patients.get(i).getName() + " " + Patients.get(i).getAge() + " " + Patients.get(i).getDisease();
		return  str;
	}
	
	public int getStaffInt()
	{
		return staff;
	}
	
	public double getRoomArea()
	{
		return area;
	}
	
	public int getPatientsInt() 
	{
		return patients;
	}
	
	//добавляем персонал
	public int addStaff(String firstName, String lastName, int age) 
	{
		if(staff + 1 + patients > people) 
		{
			return 0;
		}
		if(staff == 0)
		{
			this.Staff = new ArrayList<Staff>();
		}
		Staff.add(new Staff(firstName, lastName, age));
		staff++;
		return 1;
	}
	
	//удаляем персонал
	public int subtractStaff(String firstName,String LastName) 
	{
		for(int k = 0;k < Staff.size();k++) 
		{
			if(Staff.get(k).getLastName().equals(LastName) && Staff.get(k).getName().equals(firstName)) 
			{
				Staff.remove(k);
				staff--;
				return 1;
			}
		}
		
		return -1;
	}
	
	//добавляем пациентов
	public int addPatient(String firstName, String lastName, int age, String disease)
	{	
		if(staff + 1 + patients > people) 
		{
			return 0;
		}
		if(patients == 0) 
			this.Patients = new ArrayList<Patient>();
		
		Patients.add(new Patient(firstName, lastName, age, disease));
		patients++;
		return 1;
	}
	
	//удаляем пациентов
	public int subtractPatient(String name,String lastName)
	{
		if(patients - 1 < 0) 
			return 0;
	
		for(int k = 0;k < Patients.size();k++) 
		{
			if(Patients.get(k).getLastName().equals(lastName) && Patients.get(k).getName().equals(name)) 
			{
				Patients.remove(k);
				patients--;
				return 1;
			}
		}
		
		return -1;
	}
	
	//добавление препаратов
	public void addDrug(String name, int amount)
	{ 
		if(allDrugs == 0) 
			this.Drugs = new ArrayList<Drug>();
	
		int i = 0;
		for(;i < Drugs.size();i++) 
		{
			if(Drugs.get(i).getName().equals(name))
			{
				Drugs.get(i).add(amount);
				allDrugs += amount;
				return;
			}
		}
		
		Drugs.add(new Drug(name, amount));
		allDrugs += amount;
	}
	
	//отнимание препаратов
	public void subtractDrug(String name, int amount) 
	{ 
		if(allDrugs == 0) 
			return;
		
		for(int i = 0;i < Drugs.size();i++)
		{
			if(Drugs.get(i).getName().equals(name))
			{
				if(Drugs.get(i).getAmount() - amount < 0) 
				{
					for(;amount > Drugs.get(i).getAmount();amount--) 
					{	
					}
					allDrugs -= amount;
					Drugs.remove(i);
					return;
				}
				Drugs.get(i).subtract(amount);
				allDrugs -= amount;
				
				if(allDrugs == 0) 
					Drugs.clear();
			}
		}
	}
}
