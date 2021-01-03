package buildings;

public class Polyclinic extends Building
{		
	public Polyclinic(int floats, String name, String roomsOnFloorStr[], String propOfRoomsStr[]) 
	{
		super(floats, name, roomsOnFloorStr, propOfRoomsStr);
		this.nameOfClass = "Polyclinic";
	}

	public int addPatient(String numOfRoom, String persone)
	{	
		int i = Integer.parseInt(numOfRoom.substring(0, numOfRoom.indexOf(" "))) - 1;
		int j = Integer.parseInt(numOfRoom.substring(numOfRoom.indexOf(" ") + 1)) - 1;
		
		if(Rooms[i][j].getStaffInt() < Rooms[i][j].getPatientsInt() + 1) 
			return 0;
		
		String[] person = persone.split(" ");
		return Rooms[i][j].addPatient(person[0], person[1], Integer.parseInt(person[2]), person[3]);
	}
}
