package managers;

import java.util.Map;


import database.DatabaseClass;
import service.Donations;

import service.Subscription;
import service.Ticket;
import java.util.ArrayList;
//Manager for Donations
public class DonationManager implements donationBoundaryInterface
{	
	Map<Integer, Subscription> subscriptions=DatabaseClass.getSubsciptions();
	Ticket tickets=DatabaseClass.getTicket();
	orderBoundaryInterface ob=new OrderManager();
	private Subscription s;
	
	//Returns single subscription used for Donations
	@Override
	public Subscription getSingleSubscription()
	{
		return s;
	}
	
	//Adds subscription to hashmap, and returns the donation
	@Override 
	public Donations addDonations(Donations d)
	{
		ArrayList <Integer> tickets=new ArrayList <Integer>();	
		s=new Subscription(d.getWid(), d.getCount(),"pending", tickets, d.getPatron_info());
		subscriptions.put(s.getDid(), s);
		return d;
	}
	
	//Returns subscription, which is mapped to the did
	@Override
	public Subscription getSubscription(int did)
	{
		return subscriptions.get(did);
		
	}
	
	//Returns all subscriptions
	@Override
	public ArrayList <Subscription> getAllSubscriptions()
	{
		return new ArrayList<Subscription>(subscriptions.values());
	}
	
}
