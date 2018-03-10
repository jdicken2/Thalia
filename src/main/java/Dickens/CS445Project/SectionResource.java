package Dickens.CS445Project;

import managers.*;





import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
//import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import service.InitialSeating;


public class SectionResource
{
	private sectionBoundaryInterface seb=new SectionManager();
	private seatingBoundaryInterface se=new SeatingManager();
	private orderBoundaryInterface ob=new OrderManager();
	public SectionResource()
	{
		
	}
	
	//Returns all sections
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSection()
	{
		 Gson gson = new GsonBuilder().setPrettyPrinting().create();
	     String s = gson.toJson(seb.getSection());
	     return Response.status(Response.Status.OK).entity(s).build();
	}
	
	//Returns specific Seating. Used for second instruction. 
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSeatingSection(@PathParam("sectionID") int sectionID) 
	{
		if(ob.getBodyPostOrder(ob.getBpoid())==null)
		{
			Gson gson=new GsonBuilder().setPrettyPrinting().create();
			InitialSeating s=se.getInitialSeating(sectionID);
			String str=gson.toJson(s);
			return Response.ok(str).build();
		}
		
		//Attempts to change the status of the Seating
		//However, it is not complete
		//This is the only component that does not pass functional testing
		else 
		{
			
				int seatIndex=0;
				int h=0;
				
				InitialSeating s=se.getInitialSeating(sectionID);
				while(seatIndex<ob.getBodyPostOrder(ob.getBpoid()).getSeats().size())
				{
					int chairID=ob.getBodyPostOrder(ob.getBpoid()).getSeats().get(seatIndex).getCid();
					for(int i=0;i<s.getSeating().get(h).getSeats().size();i++)
					{
						if (chairID==s.getSeating().get(h).getSeats().get(i).getChairID())
						{
							s.getSeating().get(h).getSeats().get(i).setStatus("sold");
									
						}
									
					}
					seatIndex++;
						
						
					}
					int seatIndex2=0;
					while(seatIndex2<ob.getBodyPostOrder(ob.getBpoid()).getSeats().size())
					{
						int chairID=ob.getBodyPostOrder(ob.getBpoid()).getSeats().get(seatIndex2).getCid();
						for(int i=0;i<s.getSeating().get(1).getSeats().size();i++)
						{
							if (chairID==s.getSeating().get(1).getSeats().get(i).getChairID())
							{
								s.getSeating().get(1).getSeats().get(i).setStatus("sold");
									
							}
									
						}
						seatIndex2++;			
					}
					Gson gson=new GsonBuilder().setPrettyPrinting().create();
					String str=gson.toJson(s);
					return Response.ok(str).build();
			}		
		}
	}
        