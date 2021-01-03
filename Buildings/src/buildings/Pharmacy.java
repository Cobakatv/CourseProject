package buildings;

import java.util.ArrayList;
import parametrizeClases.Drug;

public class Pharmacy extends Building
{
	public Pharmacy(int floats, String name, String roomsOnFloorStr[], String propOfRoomsStr[]) 
	{
		super(floats, name, roomsOnFloorStr, propOfRoomsStr);
		this.nameOfClass = "Pharmacy";
	}
	
	//переопределяем метод добaвления больных в аптеку
	public int addPatient(String numOfRoom, String persone) 
	{
		return -1;
	}
	
	public int subtractPatient(String person) {
		return -1;
	}
	
	public int addDrugs(String numOfRoom, String strDrugs) 
	{	
		int i = Integer.parseInt(numOfRoom.substring(0, numOfRoom.indexOf(" "))) - 1;
		int j = Integer.parseInt(numOfRoom.substring(numOfRoom.indexOf(" ") + 1)) - 1;
		
		String[] drugs = strDrugs.split(", ");
		
		for(int num = 0;num < drugs.length;num++) 
		{	
			String name = drugs[num].substring(0, drugs[num].indexOf(" "));
			int amount = Integer.parseInt(drugs[num].substring(drugs[num].indexOf(" ") + 1));
			
			Rooms[i][j].addDrug(name, amount);
		}
		return 1;
	}
	
	public int subDrugs(String numOfRoom, String strDrugs) 
	{	
		int i = Integer.parseInt(numOfRoom.substring(0, numOfRoom.indexOf(" "))) - 1;
		int j = Integer.parseInt(numOfRoom.substring(numOfRoom.indexOf(" ") + 1)) - 1;
		
		String[] drugs = strDrugs.split(", ");
		
		for(int num = 0;num < drugs.length;num++)
		{	
			String name = drugs[num].substring(0, drugs[num].indexOf(" "));
			int amount = Integer.parseInt(drugs[num].substring(drugs[num].indexOf(" ") + 1));
			
			Rooms[i][j].subtractDrug(name, amount);
		}
		return 1;
	}
	
	public ArrayList<Drug> disDrugs()
	{
		ArrayList<Drug> Drugs= new ArrayList<Drug>();
		
		for(int i = 0;i < Rooms.length;i++) 
		{
			for(int j = 0;j < Rooms[i].length;j++)
			{
				if(Rooms[i][j].getDrugsInt() == 0) 
					continue;
				int num = Rooms[i][j].drugsLength();
				for(int l = 0;l < num;l++) 
				{
					Drugs.add(Rooms[i][j].getDrug(l));
				}
			}
		}
		return Drugs;
	}
	
	public int disAmountOfDrugs() 
	{
		int amount = 0;
		for(int i = 0;i < Rooms.length;i++) 
		{
			for(int j = 0;j < Rooms[i].length;j++)
			{
				if(Rooms[i][j].getDrugsInt() == 0) 
					continue;
				amount += Rooms[i][j].getDrugsInt();
			}
		}
		return amount;
	}
}
