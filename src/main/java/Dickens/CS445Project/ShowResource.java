package Dickens.CS445Project;
import com.google.gson.Gson;


import com.google.gson.GsonBuilder;

import java.util.StringTokenizer;

import javax.annotation.PostConstruct;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import managers.ShowBoundaryInterface;
import managers.ShowManager;

import service.*;

//Resource for Shows
@Path("/shows")
public class ShowResource {
	
	private ShowBoundaryInterface sb=new ShowManager();
	
	public ShowResource()
	{
		
	}
	//Returns all shows
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllShows()
	{
		 Gson gson = new GsonBuilder().setPrettyPrinting().create();
	     String s = gson.toJson(sb.getAllShows());
	     return Response.status(Response.Status.OK).entity(s).build();   
	}

	//Adds show to hashmap
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response postShow(String json)
	{
		Gson gson=new Gson();
		Show s=gson.fromJson(json, Show.class);
		gson.toJson(sb.addShow(s));		
		Gson gson1=new GsonBuilder().setPrettyPrinting().create();
		String show=gson1.toJson(s);
		StringTokenizer str=new StringTokenizer(show, ",");
		String wid=str.nextToken();
		return Response.status(Response.Status.OK).entity(wid + '\n' + "}").build();
	}

	//Returns show based on showID
	@GET
	@Path("/{showID}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getShow(@PathParam("showID") int showID)
	{
		Show s=sb.getShow(showID);
		if(s.isNil())
		{
			return Response.status(Response.Status.NOT_FOUND).entity("Entity not found for ID: " + showID).build();
		}
		else {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();            
            String str=gson.toJson(s);
            return Response.ok(str).build();
        }
	}
	
	//Updates show from show given 
	@PUT
	@Path("/{showID}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void putShow(@Context UriInfo uriInfo, @PathParam("showID") int showID, String json)
	{
		Gson gson=new Gson();
		Show s=gson.fromJson(json, Show.class);
		
		int id;
		s.setShowID(showID);
		id=s.getShowID();
		
		sb.updateShow(s);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(id));
	}
	
	//Returns the sections for that show
	//Redirects to SectionResource
	@GET
	@Path("/{showID}/sections")
	@Produces(MediaType.APPLICATION_JSON)
	public Response gotoSections()
	{
		SectionResource sr=new SectionResource();
		return sr.getSection();
	}
	
	//Redirects to section resource and returns specific initial seating
	@GET
	@Path("/{showID}/sections/{sectionID}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response gotoChairs(@PathParam("sectionID") int sectionID)
	{
		SectionResource sr=new SectionResource();
		return sr.getSeatingSection(sectionID);
	}
	
	//Redirects to Donation Resource and Post Donation
	@POST
	@Path("/{showID}/donations")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response gotoDonations(String json)
	{
		DonationResource dr=new DonationResource();
		return dr.postDonation(json);
	}
	
	//Redirects to Donation Resource and Get Subscription
	@GET
	@Path("/{showID}/donations/{donationID}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response gotoSubscriptions(@PathParam("donationID") int donationID)
	{
		DonationResource dr=new DonationResource();
		return dr.getSubscription(donationID);
	
	}
	
	
	
	 @PostConstruct
	 public void postConstruct() 
	 {
	       
	 }
	
}
