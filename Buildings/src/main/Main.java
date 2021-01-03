package main;

import javax.swing.*;
import java.awt.*;
import buildings.*;
import parametrizeClases.Drug;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.*;

public class Main 
{	
	public static void main(String[] args) throws Exception 
	{		
		Scanner cmd = new Scanner(System.in);
		System.out.print("Print the name of file: ");
		String file = cmd.nextLine();
		cmd.close();
		System.out.println();
		FileReader fr = new FileReader(file);
		PrintWriter pw = new PrintWriter("output.txt", "UTF-8");
		Scanner scan = new Scanner(fr);
		HealthCare HealthCare = new HealthCare();
		
		while(scan.hasNextLine()) 
		{
			String str = scan.nextLine();
			
			if(str.equals("addHospital")) {
				String name = scan.nextLine();
				try 
				{	
					int floors = Integer.parseInt(scan.nextLine());
					
					String[] propOfRooms = new String[floors];
					String[] roomsOnFloorStr = scan.nextLine().split(" ");
					
					for(int i = 0;i < floors;i++) 
					{
						propOfRooms[i] = scan.nextLine();
					}
					HealthCare.add(name, new Hospital(floors, name, roomsOnFloorStr, propOfRooms));
				}
				
				catch(NumberFormatException e) 
				{
					pw.println("You wrote incorrect properties of building "+name);
					pw.println();
					continue;
				}
				
				catch(StringIndexOutOfBoundsException e) 
				{
					pw.println("You wrote incorrect properties of room in "+name);
					pw.println();
					continue;
				}
			}
			
			if(str.equals("addPolyclinic")) 
			{
				String name = scan.nextLine();
				
				try 
				{
					int floors = Integer.parseInt(scan.nextLine());
				
					String[] propOfRooms = new String[floors];
					String[] roomsOnFloorStr = scan.nextLine().split(" ");
					
					for(int i = 0;i < floors;i++) 
					{
						propOfRooms[i] = scan.nextLine();
					}
					HealthCare.add(name, new Polyclinic(floors, name, roomsOnFloorStr, propOfRooms));
				} 
				
				catch(NumberFormatException e) 
				{
					pw.println("You wrote incorrect number of floors! And the building with name " + name + "wasn't done!");
					pw.println();
					continue;
				}
				
				catch(StringIndexOutOfBoundsException e)
				{
					pw.println("You wrote incorrect properties of room in "+name);
					pw.println();
					continue;
				}
			}
			if(str.equals("addPharmacy")) 
			{
				
				String name = scan.nextLine();
				try 
				{
					int floors = Integer.parseInt(scan.nextLine());
					
					String[] propOfRooms = new String[floors];
					String[] roomsOnFloorStr = scan.nextLine().split(" ");
					
					for(int i = 0;i < floors;i++) 
					{
						propOfRooms[i] = scan.nextLine();
					}
					HealthCare.add(name, new Pharmacy(floors, name, roomsOnFloorStr, propOfRooms));
				} 
				
				catch(NumberFormatException e) 
				{
						pw.println("You wrote incorrect number of floors! And the building with name " + name + "wasn't done!");
						pw.println();
						continue;
					}
				
				catch(StringIndexOutOfBoundsException e) 
				{
					pw.println("You wrote incorrect properties of room in "+name);
					pw.println();
					continue;
				}
			}
			if(str.equals("addStaff")) 
			{
				String name = scan.nextLine();
				
				//проверяем имеется ли данное здание
				if(!HealthCare.containsName(name))
				{
					pw.println("There is no building with name " + name);
					pw.println();
					continue;
				}
				
				//добавляем персонал
				try 
				{
					String numOfRoom = scan.nextLine();
					int numOfPeople = Integer.parseInt(scan.nextLine());
					
					for(int i = 1;i <= numOfPeople;i++) 
					{
						if(HealthCare.get(name).addStaff(numOfRoom, scan.nextLine()) == 0) 
						{
							pw.println("You can't add more people in " + numOfRoom+" room in "+name);
							pw.println();
							break;
						}
					}
				}
				catch(NumberFormatException e) 
				{
					pw.println("You wrote incorrect data when adding  staff to "+ name);
					pw.println();
					continue;
				}
				catch(ArrayIndexOutOfBoundsException e) 
				{
					pw.println("You wrote incorrect data when adding staff to  "+ name+", please, check that you didn't add extra line break!");
					pw.println();
					continue;
				}
			}
			if(str.equals("subStaff")) 
			{
				String name = scan.nextLine();
				
				//проверяем имеется ли данное здание
				if(!HealthCare.containsName(name)) 
				{
					pw.println("There is no building with name " + name);
					pw.println();
					continue;
				}
				
				//удаляем персонал
				try
				{
					int numOfPeople = Integer.parseInt(scan.nextLine());
				
					for(int i = 1;i <= numOfPeople; i++) 
					{
						String person = scan.nextLine();
						int bool = HealthCare.get(name).subtractStaff(person);
					
						if (bool == -1) 
						{
							pw.println("Noone has name " + person+" in "+ name);
							pw.println();
						}
					}
				} 
				catch(NumberFormatException e) 
				{
					pw.println("You wrote incorect data when subtracting staff in "+ name);
					pw.println();
					continue;
				}
				catch(ArrayIndexOutOfBoundsException e) 
				{
					pw.println("You wrote incorrect data when subtracting staff in  "+ name+", please, check that you didn't add extra line break!");
					pw.println();
					continue;
				}
			}	
			//добавляем пациентов
			if(str.equals("addPatient")) 
			{
				String name = scan.nextLine();
				
				//проверяем имеется ли данное здание
				if(!HealthCare.containsName(name)) 
				{
					pw.println("There is no building with name "+name);
					pw.println();
					continue;
				}
				try 
				{
					String numOfRoom = scan.nextLine();
					int numOfPeople = Integer.parseInt(scan.nextLine());
					
					for(int i = 1;i <= numOfPeople;i++)
					{
						int num = HealthCare.get(name).addPatient(numOfRoom, scan.nextLine());
						if(num == 0) 
						{
							pw.println(name + " can't store more patients in "+numOfRoom+" room!");
							break;
						} 
						if(num == -1)
						{
							pw.println(name + " can't store patients!");
							pw.println();
							break;
						}
					}
				}
				catch(NumberFormatException e) 
				{
					pw.println("You wrote incorrect data when adding patients to "+ name);
					pw.println();
					continue;
				}
				catch(ArrayIndexOutOfBoundsException e) 
				{
					pw.println("You wrote incorrect data when adding patients to  "+ name+", please, check that you didn't add extra line break!");
					pw.println();
					continue;
				}
				
			}
			//удаляем пациентов
			if(str.equals("subPatient")) 
			{	
				String name = scan.nextLine();
				
				//проверяем имеется ли данное здание
				if(!HealthCare.containsName(name)) 
				{
					pw.println("There is no building with name "+name);
					pw.println();
					continue;
				}
				try
				{
					int numOfPeople = Integer.parseInt(scan.nextLine());
					String person = scan.nextLine();
					
					for(int i = 1;i <= numOfPeople; i++) 
					{
						int bool = HealthCare.get(name).subtractPatient(person);
					
						if(bool == -1) 
						{
							pw.println("There is no people with this name " + person+" in "+name);
							pw.println();
						}
					}
				}
				catch(NumberFormatException e) 
				{
					pw.println("You wrote incorect data when subtracting patients in "+ name);
					pw.println();
					continue;
				}
				catch(ArrayIndexOutOfBoundsException e) 
				{
					pw.println("You wrote incorrect data when subtracting patients in  "+ name+", please, check that you didn't add extra line break!");
					pw.println();
					continue;
				}
			}
			if(str.equals("disAllPosPeople")) 
			{	
				String name = scan.nextLine();
				
				if(!HealthCare.containsName(name)) 
				{
					pw.println("Theere is no building with name "+name);
					pw.println();
					continue;
				}
				
				pw.println(name+" can store "+HealthCare.get(name).displayAllPosiblePeople()+ " people");
				pw.println();
			}
			
			if(str.equals("disFloors")) 
			{
				String name = scan.nextLine();
				
				if(!HealthCare.containsName(name)) 
				{
					pw.println("Theere is no building with name "+name);
					pw.println();
					continue;
				}
				
				pw.println(name+" have "+HealthCare.get(name).displayFloors()+ " floors");
				pw.println();
			}
			
			if(str.equals("disArea"))
			{
				String name = scan.nextLine();
				
				//проверяем имеется ли данное здание
				if(!HealthCare.containsName(name)) 
				{
					pw.println("Theere is no building with name " + name);
					pw.println();
					continue;
				}
				
				pw.println(name+" has "+HealthCare.get(name).displayAllArea()+" area");
				pw.println();
			}
			
			if(str.equals("disAllRooms")) 
			{
				String name = scan.nextLine();
				
				//проверяем имеется ли данное здание
				if(!HealthCare.containsName(name))
				{
					pw.println("Theere is no building with name " + name);
					pw.println();
					continue;
				}
				
				pw.println(name+" has "+HealthCare.get(name).displayAllRooms()+" rooms");
				pw.println();
			}
			
			if(str.equals("addDrugs")) 
			{
				String name = scan.nextLine();
				
				//проверяем имеется ли данное здание
				if(!HealthCare.containsName(name))
				{
					pw.println("Theere is no building with name "+name);
					pw.println();
					continue;
				}
				
				try
				{
					String numOfRoom = scan.nextLine();
					String drugs = scan.nextLine();
				
					if(HealthCare.get(name).addDrugs(numOfRoom, drugs) == 0) 
					{
						pw.println("These building can't store drugs!");
						pw.println();
					}
				}
				catch(NumberFormatException e) 
				{
					pw.println("You wrote incorect data of room when adding drugs to "+ name);
					pw.println();
					continue;
				}
				catch(StringIndexOutOfBoundsException e) 
				{
					pw.println("You wrote incorrect data of drugs which are added to  "+ name+", please, check that you didn't add extra , ");
					pw.println();
					continue;
				}
				
			}
			if(str.equals("subDrugs")) 
			{
				String name = scan.nextLine();
				
				//проверяем имеется ли данное здание
				if(!HealthCare.containsName(name)) 
				{
					pw.println("Theere is no building with name "+name);
					pw.println();
					continue;
				}
				
				try
				{
					String numOfRoom = scan.nextLine();
					String drugs = scan.nextLine();
				
					HealthCare.get(name).subDrugs(numOfRoom, drugs);
				}
				catch(NumberFormatException e) 
				{
					pw.println("You wrote incorect data of room when subtracting drugs to "+ name);
					pw.println();
					continue;
				}
				catch(StringIndexOutOfBoundsException e) 
				{
					pw.println("You wrote incorrect data of drugs which are subtracted to  "+ name+", please, check that you didn't add extra , ");
					pw.println();
					continue;
				}
			}
			
			if(str.equals("disStaff")) 
			{
				String name = scan.nextLine();
				
				if(!HealthCare.containsName(name))
				{
					pw.println("Theere is no building with name "+name);
					pw.println();
					continue;
				}
				
				ArrayList<String> staffArr = HealthCare.get(name).getStaff();
				
				for(String staff:staffArr) 
					pw.println("Staff in "+name+": "+staff);
				pw.println();
			}
			
			if(str.equals("disPatients")) 
			{
				String name = scan.nextLine();
				
				if(!HealthCare.containsName(name))
				{
					pw.println("Theere is no building with name "+name);
					pw.println();
					continue;
				}
				
				ArrayList<String> patientsArr = HealthCare.get(name).getPatients();
				
				for(String patients:patientsArr) 
					pw.println("Patient in "+name+": "+patients);
				pw.println();
			}
			
			if(str.equals("disDrugs"))
			{
				String name = scan.nextLine();
				
				if(!HealthCare.containsName(name)) 
				{
					pw.println("There is no building with name "+name);
					pw.println();
					continue;
				}
				
				ArrayList<Drug> Drugs = HealthCare.get(name).disDrugs();
				Map<String, Integer> checked = new HashMap<String, Integer>();
				
				if(Drugs.isEmpty()) 
				{
					pw.println("There is no drugs in "+name+"!");
					pw.println();
					continue;
				}
				for(int i = 0;i < Drugs.size();i++) 
				{
				String nameDrug = Drugs.get(i).getName();
				int amount = Drugs.get(i).getAmount();
					if(checked.containsKey(nameDrug))
					{
						checked.put(nameDrug, amount + checked.get(nameDrug));
					} else 
						checked.put(nameDrug, amount);
				}
				pw.print("All drugs in "+name+" :"+checked);
				pw.println();
				pw.println();
			}
			
			if(str.equals("disAllBuildings")) 
			{
				ArrayList<Building> builds = HealthCare.getArrayVal();
				String string = "";
				
				if(builds.isEmpty())
				{
					continue;
				}
				
				pw.print("All buildings: ");
				
				for(Building build:builds) 
				{
					string = string.concat(build.getName()+" is "+build.getNameofClass()+", ");
				}
				pw.println(string.substring(0, string.lastIndexOf(", ")));
				pw.println();
			}
			
			if(str.equals("disBuild"))
			{
				String name = scan.nextLine();
				ArrayList<Building> builds = HealthCare.getArrayVal();
				
				if(builds.isEmpty())
				{
					continue;
				}
				
				String string = "";
				
				pw.print("You have next "+name+": ");
				
				for(Building build:builds) 
				{
					if(build.getNameofClass().equals(name))
					{
						string = string.concat(build.getName()+ ", ");
					}
				}
				pw.println(string.substring(0, string.lastIndexOf(", ")));
				pw.println();
			}
			
			if(str.equals("disAmountOfDrugs")) 
			{
				String name = scan.nextLine();
				
				if(!HealthCare.containsName(name)) 
				{
					pw.println("There is no building with name "+name);
					pw.println();
					continue;
				}
				pw.println("There are "+HealthCare.get(name).disAmountOfDrugs()+" drugs in "+name);
				pw.println();
			}
			
			if(str.equals("deleteBuilding"))
			{
				String name = scan.nextLine();
				
				if(!HealthCare.containsName(name)) 
				{
					pw.println("There is no building with name "+name);
					pw.println();
					continue;
				}
				HealthCare.delete(name);
			}
		}
		
		scan.close();
		fr.close();
		pw.close();
	}
}



