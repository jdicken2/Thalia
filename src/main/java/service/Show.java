//Service Class for Show
package service;

import java.util.*;
public class Show {
	
	private int wid;
	private Show_Info show_info;
	private List <Seating_Info> seating_info;
	public Show()
	{
		
	}
	public Show(int sID, Show_Info sh, List <Seating_Info> seat)
	{
		wid=sID;
		show_info=sh;
		seating_info=seat;
	}
	public int getShowID() {
		return wid;
	}
	public Show_Info getShowInfo() {
		return show_info;
	}
	public List <Seating_Info> getSeatingInfo()
	{
		return seating_info;
	}
	public void setShowID(int showID) {
		wid = showID;
	}
	public void setShowInfo(Show_Info showInfo) {
		show_info = showInfo;
	}
	public void setSeatingInfo(List <Seating_Info> seat)
	{
		seating_info=seat;
	}
	
	 public boolean isNil() {
	        return false;
	    }
	
	
}
