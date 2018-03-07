package Dickens.CS445Project;

import java.util.StringTokenizer;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;

import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import service.Donations;


import managers.DonationManager;
import service.Subscription;
import managers.donationBoundaryInterface;
import managers.orderBoundaryInterface;
import managers.OrderManager;

//Resource for Donations
public class DonationResource {
	
	
	donationBoundaryInterface db=new DonationManager();
	orderBoundaryInterface ob=new OrderManager();
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response postDonation(String json)
	{
		//Creates a Donation and Subscription
		//Adds donation to donation hashmap
		//Returns the donation did by using String Tokenizer
		Gson gson=new Gson();
		Donations d=gson.fromJson(json, Donations.class);
		gson.toJson(db.addDonations(d));
		Subscription s=db.getSingleSubscription();
		Gson gson1=new GsonBuilder().setPrettyPrinting().create();
		String stringSubscription=gson1.toJson(s);
		StringTokenizer str=new StringTokenizer(stringSubscription, ",");
		String stringdid=str.nextToken();
		
		return Response.status(Response.Status.OK).entity(stringdid + '\n' + "}").build();
	}
	
	
	//Returns subscription based on donation ID
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSubscription(@PathParam("donationID") int donationID)
	{
		Subscription s=db.getSubscription(donationID);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();            
        String str=gson.toJson(s);
        return Response.ok(str).build();
	}

	
}
