package buildings;

import java.util.ArrayList;
import parametrizeClases.Drug;

public abstract class Building 
{
	
	protected int floors, allRooms, allPeople; 
	protected Room Rooms[][];
	protected double allArea;
	protected String name, nameOfClass;
	
	public Building(int floors, String name, String roomsOnFloorStr[], String propOfRoomsStr[])
	{
		this.allRooms = 0;
		this.name = name;
		this.allArea = 0;
		this.allPeople = 0;
		this.floors = floors;
		this.Rooms = new Room[floors][];	
		
		for(int i = 0;i < roomsOnFloorStr.length;i++) 
		{
			int roomsOnFloor = Integer.parseInt(roomsOnFloorStr[i]);
			
			Rooms[i] = new Room[roomsOnFloor];
			allRooms += roomsOnFloor;
			
			//считывание свойств комнат на этаже
			String[] propOfRooms = propOfRoomsStr[i].split(", ");
			
			for(int k = 0;k < roomsOnFloor;k++)
			{				
				double area = Double.parseDouble(propOfRooms[k].substring(0, propOfRooms[k].indexOf(" ")));
				int people = Integer.parseInt(propOfRooms[k].substring(propOfRooms[k].indexOf(" " ) + 1));
				allArea += area;
				allPeople += people;
				Rooms[i][k] = new Room(area, people);
			}
		}
	}
	public ArrayList<String> getStaff() 
	{
		ArrayList<String> staffArr = new ArrayList<String>();
		
		for(int i = 0;i < Rooms.length;i++) 
		{
			for(int j = 0;j < Rooms[i].length;j++) 
			{
				if(Rooms[i][j].getStaffInt() == 0) 
					continue;
				int num = Rooms[i][j].getStaffInt();
				for(int l = 0;l < num;l++) 
				{
					staffArr.add(Rooms[i][j].getStaff(l));
				}
			}
		}
		return staffArr;
	}
	
	public ArrayList<String> getPatients() 
	{
		ArrayList<String> patientsArr = new ArrayList<String>();
		
		for(int i = 0;i < Rooms.length;i++) 
		{
			for(int j = 0;j < Rooms[i].length;j++) 
			{
				if(Rooms[i][j].getPatientsInt() == 0) 
					continue;
				int num = Rooms[i][j].getPatientsInt();
				for(int l = 0;l < num;l++) 
				{
					patientsArr.add(Rooms[i][j].getPatient(l));
				}
			}
		}
		return patientsArr;
	}
		
	public String getName() 
	{
		return name;
	}
	
	public int displayFloors()
	{
		return floors;
	}
	
	public int displayAllRooms()
	{
		return allRooms;
	}
	
	public int displayAllPosiblePeople()
	{
		return allPeople;
	}
	
	public double displayAllArea() 
	{
		return allArea;
	}
	
	public int addStaff(String numOfRoom, String persone)
	{
		int i = Integer.parseInt(numOfRoom.substring(0, numOfRoom.indexOf(" "))) - 1;
		int j = Integer.parseInt(numOfRoom.substring(numOfRoom.indexOf(" ") + 1)) - 1;
		String[] person = persone.split(" ");
		return Rooms[i][j].addStaff(person[0], person[1], Integer.parseInt(person[2]));
	}
	public int subtractStaff(String persone) 
	{	
		int bool = 0;
		String[] person = persone.split(" "); 
		for(int i = 0;i < Rooms.length;i++) 
		{
			for(int j = 0;j < Rooms[i].length;j++) 
			{
				if(Rooms[i][j].getStaffInt() == 0) 
					continue;
				bool = Rooms[i][j].subtractStaff(person[0], person[1]);
				if(bool == 1)
					return 1;
			}
		}
		return -1;
	}
	
	
	public int addPatient(String numOfRoom, String persone)
	{	
		int i = Integer.parseInt(numOfRoom.substring(0, numOfRoom.indexOf(" "))) - 1;
		int j = Integer.parseInt(numOfRoom.substring(numOfRoom.indexOf(" ") + 1)) - 1;
		String[] person = persone.split(" ");
		return Rooms[i][j].addPatient(person[0], person[1], Integer.parseInt(person[2]), person[3]);
	}
	
	public int subtractPatient(String persone) 
	{	
		int bool = 0;
		String[] person = persone.split(" "); 
		for(int i = 0;i < Rooms.length;i++) 
		{
			for(int j = 0;j < Rooms[i].length;j++) 
			{
				if(Rooms[i][j].getPatientsInt() == 0) 
					continue;
				bool = Rooms[i][j].subtractPatient(person[0], person[1]);
				if(bool == 1)
					return 1;
			}
		}
		return -1;
	}
	
	public int addDrugs(String numOfRoom, String strDrugs)
	{
		return 0;
	}
	
	public int subDrugs(String numOfRoom, String strDrugs)
	{
		return 0;
	}
	
	public ArrayList<Drug> disDrugs() 
	{
		ArrayList<Drug> drug = new ArrayList<>();
		return drug;
	}
	
	public int disAmountOfDrugs()
	{
		return 0;
	}
	
	public String getNameofClass() {
		return nameOfClass;
	}
}
