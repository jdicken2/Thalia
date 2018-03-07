package Dickens.CS445Project;
import service.requestFailedSeating;



import service.Seats;

import javax.ws.rs.GET;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;


import managers.seatingBoundaryInterface;

import service.Seating;
import managers.SeatingManager;
import managers.ShowBoundaryInterface;
import managers.ShowManager;
import managers.sectionBoundaryInterface;
import managers.SectionManager;
import service.requestSeating;

import service.specificInitialSeating;
@Path("/seating")
//Resource for Seating
public class SeatingResource {

	private seatingBoundaryInterface seb=new SeatingManager();
	private ShowBoundaryInterface shb=new ShowManager();  
	private sectionBoundaryInterface secb=new SectionManager();
	ArrayList<Seating> testSeating=new ArrayList <Seating>();
	ArrayList <Seating> newSeating=new ArrayList <Seating>();
	//Not best practice upon further reflection
	//The Query Params should be in getInitialSeating
	//Query only works for functional testing 
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllInitialSeating(@QueryParam("show") int wid,
										@QueryParam("section") int sid,
										@QueryParam("count") int count,
										@QueryParam("starting_seat_id") int starting_seat_id)
	{
		String stringCount=Integer.toString(count);
		String status=new String();
		 Gson gson = new GsonBuilder().setPrettyPrinting().create();
		if(count>=5)
		//Only works for the rows who's seat size is 4. 
		//If 5 or higher, returns an error
		{
			
			status=stringCount + " " + "continguous seats not available";
			ArrayList <Seating> emptySeating=new ArrayList <Seating>();
			requestFailedSeating rfs=new requestFailedSeating(wid, 
															  shb.getShow(wid).getShowInfo(), 
															  sid, 
															  secb.getFromSectionDatabase(sid).getSection_name(),
															  seb.getInitialSeating(sid).getSeating().get(0).getSeats().get(0).getChairID(),
															  status,
															  emptySeating);
			String fs=gson.toJson(rfs);
			return Response.status(Response.Status.OK).entity(fs).build(); 
		}
		
		//If 4, returns the entire row
		else if(count==4 && count!=0)
		{
			status="ok";
			ArrayList <Seating> seating=seb.getInitialSeating(sid).getSeating();
			int chairID=seb.getInitialSeating(sid).getSeating().get(0).getSeats().get(0).getChairID();
			Seating seating2=new Seating();
			seating2=seating.get(1);
			Seating seating1=seating.remove(0);
			ArrayList <Seating> newSeating=new ArrayList <Seating>();
			ArrayList <Seating> nextSeating=new ArrayList <Seating>();
			newSeating.add(seating1);
			nextSeating.add(seating2);
			requestSeating rs=new requestSeating(wid, 
												 shb.getShow(wid).getShowInfo(),
												 sid,
												 secb.getFromSectionDatabase(sid).getSection_name(),
												 chairID,
												 status,
												 seb.getInitialSeating(sid).getPrice()*count,
												 newSeating);
			if(starting_seat_id!=0 && starting_seat_id!=rs.getSeating().get(0).getSeats().get(0).getChairID())
			{
				rs.setSeating(nextSeating);
				rs.setStarting_seat_id(starting_seat_id);
			}
			String fs=gson.toJson(rs);
			return Response.status(Response.Status.OK).entity(fs).build(); 
			
		}
		//If 3, returns every chair besides the first chair
		else if(count==3 && count!=0)
		{
			status="ok";
			ArrayList <Seating> seating=seb.getInitialSeating(sid).getSeating();
			int chairID=seb.getInitialSeating(sid).getSeating().get(0).getSeats().get(0).getChairID();
			Seating seating1=seating.remove(0);
			ArrayList <Seating> newSeating=new ArrayList <Seating>();
			newSeating.add(seating1);
			Seats possibleFutureSeats=newSeating.get(0).getSeats().get(count);
			newSeating.get(0).getSeats().remove(count);
			requestSeating rs=new requestSeating(wid, 
					 							shb.getShow(wid).getShowInfo(),
					 							sid,
					 							secb.getFromSectionDatabase(sid).getSection_name(),
					 							chairID,
					 							status,
					 							seb.getInitialSeating(sid).getPrice()*count,
					 							newSeating);
			if(starting_seat_id!=0 && starting_seat_id!=rs.getSeating().get(0).getSeats().get(0).getChairID())
			{
				rs.setStarting_seat_id(starting_seat_id);
				rs.getSeating().get(0).getSeats().remove(0);
				rs.getSeating().get(0).getSeats().add(possibleFutureSeats);
			}
			String fs=gson.toJson(rs);
			return Response.status(Response.Status.OK).entity(fs).build(); 
			
		}
		//If 2, returns every chair except for the first 2
		else if(count==2 && count!=0)
		{
			status="ok";
			ArrayList <Seating> seating=seb.getInitialSeating(sid).getSeating();
			int chairID=seb.getInitialSeating(sid).getSeating().get(0).getSeats().get(0).getChairID();
			Seating seating1=seating.remove(0);
			ArrayList <Seating> newSeating=new ArrayList <Seating>();
			newSeating.add(seating1);
			newSeating.get(0).getSeats().remove(3);
			newSeating.get(0).getSeats().remove(2);
			requestSeating rs=new requestSeating(wid, 
												 shb.getShow(wid).getShowInfo(),
												 sid,
												 secb.getFromSectionDatabase(sid).getSection_name(),
												 chairID,
												 status,
												 seb.getInitialSeating(sid).getPrice()*count,
												 newSeating);
			String fs=gson.toJson(rs);
			return Response.status(Response.Status.OK).entity(fs).build(); 
		}
		//If 1, returns only the last chair
		else if(count==1 && count!=0)
		{
			status="ok";
			ArrayList <Seating> seating=seb.getInitialSeating(sid).getSeating();
			int chairID=seb.getInitialSeating(sid).getSeating().get(0).getSeats().get(0).getChairID();
			Seating seating1=seating.remove(0);
			ArrayList <Seating> newSeating=new ArrayList <Seating>();
			newSeating.add(seating1);
			newSeating.get(0).getSeats().remove(3);
			newSeating.get(0).getSeats().remove(2);
			newSeating.get(0).getSeats().remove(1);
			requestSeating rs=new requestSeating(wid, 
					 							 shb.getShow(wid).getShowInfo(),
					 							 sid,
					 							 secb.getFromSectionDatabase(sid).getSection_name(),
					 							 chairID,
					 							 status,
					 							 seb.getInitialSeating(sid).getPrice()*count,
					 							 newSeating);
			String fs=gson.toJson(rs);
			return Response.status(Response.Status.OK).entity(fs).build(); 
		}
		
	     String s = gson.toJson(seb.getAllInitialSeating());
	     return Response.status(Response.Status.OK).entity(s).build(); 
	}
	//Returns the initialSeating tied to the seatingID 
	@GET
	@Path("/{seatingID}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSpecificInitialSeating(@PathParam("seatingID") int seatingID)
	{
		specificInitialSeating s=seb.getSpecificSeating(seatingID);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();            
        String str=gson.toJson(s);    
        return Response.ok(str).build();
	}
}
