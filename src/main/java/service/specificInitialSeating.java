package service;
import differentSeating.Seating;
import java.util.ArrayList;
//Service class for specificInitialSeating
public class specificInitialSeating {
	private int sid;
	private String section_name;
	private ArrayList <Seating> seating;
	public specificInitialSeating()
	{
		
	}
	
	public specificInitialSeating(int si, String sec_name, ArrayList <Seating> seat)
	{
		sid=si;
		section_name=sec_name;
		seating=seat;
	}
	public int getSid() {
		return sid;
	}
	public String getSection_name() {
		return section_name;
	}
	public ArrayList<Seating> getSeating() {
		return seating;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public void setSection_name(String section_name) {
		this.section_name = section_name;
	}
	public void setSeating(ArrayList<Seating> seating) {
		this.seating = seating;
	}
	
	
	
}
