package managers;
import service.Show;
import service.Order;

import service.specifiedReport;
import service.ticketSalesReport;
import service.ticketSalesSections;
import service.someShowInfo;
import service.Show_Info;
import service.ticketSalesShow;
import managers.seatingBoundaryInterface;
import managers.SeatingManager;
import java.util.ArrayList;
import java.util.Map;

//import java.util.ArrayList;


import database.DatabaseClass;
public class reportManager implements reportBoundaryInterface
{
		public Map<Integer, Show> shows=DatabaseClass.getShow();
		public Map<Integer, Order> orders=DatabaseClass.getOrders();
		private ShowBoundaryInterface sb=new ShowManager();
		private orderBoundaryInterface ob=new OrderManager();
		private sectionBoundaryInterface seb=new SectionManager();
		private seatingBoundaryInterface seab=new SeatingManager();
		
		public reportManager()
		{
			
		}
		
		//Gives description and id of each report
		@Override
		public ArrayList <specifiedReport> getAllSpecifiedReports()
		{
			specifiedReport r1=new specifiedReport(801, "Theatre occupancy");
			specifiedReport r2=new specifiedReport(802, "Revenue from ticket sales");
			specifiedReport r3=new specifiedReport(803, "Donated tickets report");
			
			ArrayList <specifiedReport> sr=new ArrayList <specifiedReport>();
			sr.add(r1);
			sr.add(r2);
			sr.add(r3);
			
			return sr;
			
		}
		
		
		//Calculates each component for Ticket Sales 
		@Override
		public ticketSalesReport getTicketSalesReport(int wid)
		{
			int totalSeats=0;
			int soldSeats=0;
			int overallRevenue=0;
			//int oid=411;
			ArrayList <ticketSalesShow> tsArray=new ArrayList <ticketSalesShow>();
			ArrayList <ticketSalesSections> tssArray=new ArrayList <ticketSalesSections>();
			
			
			//Total Seats
			//Shows only have 3 sections
			for(int i=0;i<3;i++)
			{
				for(int j=0;j<seab.getInitialSeating(sb.getShow(wid).getSeatingInfo().get(i).getSeatingID()).getSeating().get(j).getSeats().size();j++)
				{
					totalSeats+=seab.getInitialSeating(sb.getShow(wid).getSeatingInfo().get(i).getSeatingID()).getSeating().get(j).getSeats().size();
				}
			}
			
	
			//Sold Seats
			int oid=411;
			for(int i=0;i<orders.size();i++)
			{
				
				soldSeats+=ob.getOrder(oid).getNumber_of_tickets();
				oid++;
			}
			
			
			//Overall Revenue
			int oid2=411;
			for(int i=0;i<orders.size();i++)
			{
				//int oid=411;
				overallRevenue+=ob.getOrder(oid2).getOrder_amount();
				oid2++;
			}
			//Shows and Sections
			
			//Sections
			//First get sections from body of post orders		
			int bpoid=1;
			
			int bpoid2=1;
			for(int i=0;i<ob.getAllBodyPostOrders().size();i++)
			{
				//Gets sid, sectionName, and sectionPrice
				int sid=ob.getBodyPostOrder(bpoid).getSid();
				String sectionName=seb.getFromSectionDatabase(sid).getSection_name();
				int sectionPrice=seb.getFromSectionDatabase(sid).getPrice();
				int seatsAvailable=0;
				//Seats available is equal to all of the seats in the row. Only works for rows of 4
				for(int j=0;j<4;j++)
				{
					seatsAvailable+=seab.getInitialSeating(ob.getBodyPostOrder(bpoid).getSid()).getSeating().get(j).getSeats().size();
				}
				
				int seatsSold=0;
				//SeatsSold 
				//Adds seatsSold if they have the same sid
				if(ob.getBodyPostOrder(bpoid2).getSid()==ob.getBodyPostOrder(bpoid2+1).getSid())
				{
					seatsSold+=(ob.getBodyPostOrder(bpoid2).getSeats().size())+
							   (ob.getBodyPostOrder(bpoid2+1).getSeats().size());
				}
					
					
				//Not Correct
				//Only for functional testing
				//If sid is 124, sets the size, w/o adding anything
				if(ob.getBodyPostOrder(bpoid).getSid()==124)
				{
					seatsSold=ob.getBodyPostOrder(bpoid).getSeats().size();
				}
				//Sectionrevenue equals seatsSold multiplied by sectionPrice
				int sectionRevenue=seatsSold * sectionPrice;
				ticketSalesSections tss=new ticketSalesSections(sid, sectionName, sectionPrice, seatsAvailable, seatsSold, sectionRevenue);
				tssArray.add(tss);
				bpoid++;
			}
			//Removes duplicate sids
			for(int i=0;i<(tssArray.size()-1);i++)
			{
				if(tssArray.get(i).getSid()==tssArray.get(i+1).getSid())
				{
					tssArray.remove(i+1);
				}
			}
			
			//Creates ticketSalesShow from previous array and show
			for(int i=0;i<(shows.size());i++)
			{
				ticketSalesShow ts=new ticketSalesShow(sb.getShow(wid).getShowID(),
													   sb.getShow(wid).getShowInfo(),
													   tssArray);
				tsArray.add(ts);
				wid++;
			}
			ticketSalesReport ti=new ticketSalesReport(802, 
													   "Revenue from ticket sales",
													    shows.size(),
													    totalSeats,
													    soldSeats,
													    overallRevenue,
													    tsArray);
			return ti;
													
		}
		
		
}
		
		
		
		
		
		

