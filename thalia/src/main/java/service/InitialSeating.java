package service;
import java.util.ArrayList;
//Service class for more detailed Seating
public class InitialSeating {
	private int wid;
	private Show_Info show_info;
	private int sid;
	private String section_name;
	private int price;
	private ArrayList <service.Seating> seating;
	
	public InitialSeating()
	{
		
	}
	
	public InitialSeating(int wi, Show_Info sh, int si, String se, int pri, ArrayList<service.Seating> specificSeating1)
	{
		wid=wi;
		show_info=sh;
		sid=si;
		section_name=se;
		price=pri;
		seating=specificSeating1;
	}
	public int getWid()
	{
		return wid;
	}
	public Show_Info getShowInfo()
	{
		return show_info;
	}
	public int getSid() {
		return sid;
	}

	public String getSection_name() {
		return section_name;
	}
	public int getPrice()
	{
		return price;
	}
	public ArrayList<service.Seating> getSeating() {
		return seating;
	}

	/*public boolean getNoSeats()
	{
		return noSeats;
	}*/
	public void setWid(int wid)
	{
		this.wid=wid;
	}
	public void setShowInfo(Show_Info show_info)
	{
		this.show_info=show_info;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}

	public void setSection_name(String section_name) {
		this.section_name = section_name;
	}
	public void setPrice(int price)
	{
		this.price=price;
	}
	public void setSe(ArrayList<service.Seating> seating) {
		this.seating = seating;
	}
	public boolean isNil() {
        return false;
    }
	
	
}
