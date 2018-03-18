//Service class used for the orders that are posted to the theater
package service;
import java.util.ArrayList;
public class bodyPostOrder {
	private int wid;
	private int sid;
	private ArrayList <differentSeating.seats> seats;
	private Patron_Info patron_info;
	public bodyPostOrder()
	{
		
	}
	
	public bodyPostOrder(int wi, int si, ArrayList <differentSeating.seats> sea, Patron_Info pa)
	{
		wid=wi;
		sid=si;
		seats=sea;
		patron_info=pa;
	}
	
	public int getWid() {
		return wid;
	}
	public int getSid() {
		return sid;
	}
	public ArrayList<differentSeating.seats> getSeats() {
		return seats;
	}
	public Patron_Info getPatron_info() {
		return patron_info;
	}
	public void setWid(int wid) {
		this.wid = wid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public void setSeats(ArrayList<differentSeating.seats> seats) {
		this.seats = seats;
	}
	public void setPatron_info(Patron_Info patron_info) {
		this.patron_info = patron_info;
	}
	
}
