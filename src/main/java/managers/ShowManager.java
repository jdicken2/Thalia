package managers;
import java.util.ArrayList;
import java.util.Map;
import database.DatabaseClass;

import service.*;




public class ShowManager implements ShowBoundaryInterface 
{
	
	
	public Map<Integer, Show> shows=DatabaseClass.getShow();
	private int wid=308;
	
	public ShowManager()
	{
		
		
	}
	
	//Returns wid
	@Override
	public int getWid()
	{
		return wid;
	}
	
	//Returns all shows with some show info
	@Override 
	public ArrayList <someShowInfo> getAllShows()
	{
		
		ArrayList <someShowInfo> si=new ArrayList <someShowInfo>();
		
		for(int i=0;i<shows.size();i++)
		{
			Show_Info sh=shows.get(wid).getShowInfo();
			someShowInfo shi=new someShowInfo(wid,sh);
			si.add(shi);
			wid++;
		}
		return si;
	}
	
	//Returns show with all show info and specified ID
	@Override
	public Show getShow(int id)
	{
		return shows.get(id);
	}
	
	
	//Adds show to show hashmap, based on show id
	@Override
	public Show addShow(Show sh)
	{
		sh.setShowID(wid+(shows.size()));
		shows.put(sh.getShowID(), sh);
		return sh;
	}
	
	//Updates show by replacing old instance with new instance
	@Override
	public Show updateShow(Show sh)
	{
		if(sh.getShowID()<=0)
		{
			return null;
		}
		
		shows.put(sh.getShowID(), sh);
		return sh;
	}
	

	
	
	
	
}
