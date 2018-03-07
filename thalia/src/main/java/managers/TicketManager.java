package managers;

import database.DatabaseClass;

import service.Ticket;
import java.util.ArrayList;

public class TicketManager implements ticketBoundaryInterface{
	
	
	public Ticket tickets=DatabaseClass.getTicket();
	
	orderBoundaryInterface ob=new OrderManager();
	donationBoundaryInterface db=new DonationManager();
	@Override
	//Adds ticket and sets ticket to each subscription
	public Ticket addTickets(Ticket tick)
	{
		int did=759;
		tickets=tick;
		for(int j=0;j<tickets.getTickets().size();j++)
		{
			
			db.getSubscription(did).setStatus("assigned");
			Integer singleTicket=tickets.getTickets().get(j);
			ArrayList <Integer> arrayListTicket=new ArrayList <Integer>();
			arrayListTicket.add(singleTicket);
			db.getSubscription(did).setTickets(arrayListTicket);
			did++;
		}
	
		//Always assuming orders will come first, no null condition necessary
		//Sets status of order to donated once tickets are donated
		for(int h=0;h<ob.getAllOrders().size();h++)
		{
			int oid=411;
			int did2=759;
			for(int i=0;i<db.getAllSubscriptions().size();i++)
			{
				//Assuming the size of each ticket array in a subscription is one
				int ticketID=db.getSubscription(did2).getTickets().get(0);
				for(int j=0;j<ob.getSpecificOrder(oid).getNumTickets();j++)
				{
					if(ticketID==ob.getSpecificOrder(oid).getTickets().get(j).getTid())
					{
						ob.getSpecificOrder(oid).getTickets().get(j).setStatus("donated");
					}
					
				}
				did2++;
				
			}
			oid++;
		}
		
		
		return tick;
		
		
	}
	
}
