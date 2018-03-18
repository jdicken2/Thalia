package managers;
import java.util.ArrayList;

import java.util.List;
import java.util.Map;


import database.DatabaseClass;



import service.*;

public class SectionManager implements sectionBoundaryInterface {

	public Map<Integer, Section> sections=DatabaseClass.getSections();
	public Map<Integer, Show>shows=DatabaseClass.getShow(); 
	public Map<Integer, FirstInitialSeating> firstInitialSeating=DatabaseClass.getFirstInitialSeating();
	
	public SectionManager()
	{
		
		
		
		
	}
	
	
	//Returns all sections based on show
	@Override
	public ArrayList <Section> getSection()
	{
		ArrayList <Section> sect= new ArrayList<Section>();
		
		Object [] setWid=shows.keySet().toArray();
		Object oWid=setWid[0];
		String sWid=oWid.toString();
		int wid=Integer.parseInt(sWid);
		Show s=shows.get(wid);
		
		List <Seating_Info> listSeatingInfo0=s.getSeatingInfo();
		Seating_Info seatingInfo0=listSeatingInfo0.get(0);
		int sid0=seatingInfo0.getSeatingID();
		String sn0=firstInitialSeating.get(sid0).getSection_name();
		int price0=seatingInfo0.getPrice();
		Section se0=new Section(sid0,sn0,price0);
		sect.add(se0);
		sections.put(seatingInfo0.getSeatingID(), se0);
		
		List <Seating_Info> listSeatingInfo1=s.getSeatingInfo();
		Seating_Info seatingInfo1=listSeatingInfo1.get(1);
		int sid1=seatingInfo1.getSeatingID();
		String sn1=firstInitialSeating.get(sid1).getSection_name();
		int price1=seatingInfo1.getPrice();
		Section se1=new Section(sid1,sn1,price1);
		sect.add(se1);
		sections.put(seatingInfo1.getSeatingID(), se1);
		
		List <Seating_Info> listSeatingInfo2=s.getSeatingInfo();
		Seating_Info seatingInfo2=listSeatingInfo2.get(2);
		int sid2=seatingInfo2.getSeatingID();
		String sn2=firstInitialSeating.get(sid2).getSection_name();
		int price2=seatingInfo2.getPrice();
		Section se2=new Section(sid2,sn2,price2);
		sect.add(se2);
		sections.put(seatingInfo2.getSeatingID(), se2);
		
		return sect;
	}
	
	//Returns section based on id
	@Override
	public Section getFromSectionDatabase(int id)
	{
		return sections.get(id);
	}
	
	
	
	
}
