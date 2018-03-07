package service;
import java.util.ArrayList;
//Ticket is a collection of Integers 
public class Ticket 
{
	private ArrayList <Integer> tickets;
	public Ticket()
	{
		
	}
	
	public Ticket (ArrayList <Integer> tic)
	{
		tickets=tic;
	}
	public ArrayList <Integer >getTickets() {
		return tickets;
	}

	public void setTickets(ArrayList <Integer> tickets) {
		this.tickets = tickets;
	}	
}
