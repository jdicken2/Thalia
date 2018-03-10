package service;
import java.util.ArrayList;
//Service Class for Subscription
public class Subscription {

	private static int currentID=758;
	private int did;
	private int wid;
	private int count;
	private String status;
	private ArrayList <Integer> tickets;
	private Patron_Info patron_info;
	
	public Subscription()
	{
		
	}
	
	public Subscription(int wi, int co, String stat, ArrayList <Integer> tick, Patron_Info pa)
	{
		currentID++;
		did=currentID;
		//did=di;
		wid=wi;
		count=co;
		status=stat;
		tickets=tick;
		patron_info=pa;
	}
	
	public int getCurrentID()
	{
		return currentID;
	}

	public int getDid() {
		return did;
	}

	public int getWid() {
		return wid;
	}

	public int getCount() {
		return count;
	}

	public String getStatus()
	{
		return status;
	}
	
	public ArrayList <Integer>getTickets()
	{
		return tickets;
	}
	public Patron_Info getPatron_info() {
		return patron_info;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public void setWid(int wid) {
		this.wid = wid;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public void setTickets(ArrayList <Integer> tickets)
	{
		this.tickets=tickets;
	}
	
	public void setPatron_info(Patron_Info patron_info) {
		this.patron_info = patron_info;
	}
	
	public void setStatus(String status)
	{
		this.status=status;
	}
	
	/*public void setCurrentID(int currentID)
	{
		this.currentID=currentID;
	}*/
	//Change status
	/*public String changeStatus()
	{
		
		return status;
	}*/
	
	
}
