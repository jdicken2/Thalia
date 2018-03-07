package database;

//Database used to store the shows, seating, etc. in the theater
//Most structures are hashmaps, except for the ticket structure, and the arraylist for specifiedReport
//This is obviously not best practice, for a real database.
import java.util.*;

import service.*;


public class DatabaseClass {
	
	private static Map<Integer, Show> shows=new HashMap<>();
	private static Map<Integer, Section>sections=new HashMap<>();
	private static Map<Integer, InitialSeating>initialSeating=new HashMap<>();
	private static Map<Integer, Order> orders=new HashMap<>();
	//private static Map<Integer, Seats[]> seats=new HashMap<>();
	private static Map<InitialSeating, ArrayList <Seating>> seating=new HashMap<>();
	private static Map<Integer, FirstInitialSeating> firstInitialSeating=new HashMap<>();
	private static Map<Integer, Donations> donations=new HashMap<>();
	private static Map<Integer, Subscription> subscriptions=new HashMap<>();
	private static Map<Integer, specificInitialSeating> specificInitialSeating=new HashMap<>();
	private static Map<Integer, specificOrder> specificOrders=new HashMap<>();
	private static Ticket tickets=new Ticket();
	private static Map<Integer, bodyPostOrder> bodyPostOrders=new HashMap<>();
	private static ArrayList <specifiedReport> specifiedReports=new ArrayList <specifiedReport>();
	private static Map<Integer, PostOrder> postOrders=new HashMap<>();
	
	public static Map<Integer, FirstInitialSeating> getFirstInitialSeating()
	{
		return firstInitialSeating;
	}
	public static Map<Integer, Show> getShow()
	{
		return shows;
	}
	
	
	public static Map<Integer, Section> getSections()
	{
		return sections;
	}
	
	public static Map<Integer, InitialSeating> getInitialSeating()
	{
		return initialSeating;
	}
	public static Map<Integer, Order> getOrders()
	{
		return orders;
	}
	
	/*public static Map<Integer, Seats[]> getSeats()
	{
		return seats;
	}*/
	
	public static Map<InitialSeating, ArrayList <Seating>> getSeating()
	{
		return seating;
	}
	
	public static Map<Integer, Donations> getDonations()
	{
		return donations;
	}
	
	public static Map<Integer, Subscription> getSubsciptions()
	{
		return subscriptions; 
	}
	
	public static Ticket getTicket()
	{
		return tickets;
	}
	
	public static Map <Integer, specificInitialSeating> getSpecificInitialSeating()
	{
		return specificInitialSeating;
	}
	
	public static Map <Integer, specificOrder> getSpecificOrders()
	{
		return specificOrders;
	}
	public static Map <Integer, bodyPostOrder> getBodyPostOrders()
	{
		return bodyPostOrders;
	}
	public static ArrayList <specifiedReport> getSpecifiedReports()
	{
		return specifiedReports;
	}
	
	public static Map <Integer, PostOrder> getPostOrders()
	{
		return postOrders;
	}
}
