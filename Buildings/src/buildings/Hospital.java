package buildings;

public class Hospital extends Building
{	
	public Hospital(int floors, String name, String roomsOnFloorStr[], String propOfRoomsStr[]) 
	{
		super(floors, name, roomsOnFloorStr, propOfRoomsStr);
		this.nameOfClass = "Hospital";
	}

}
