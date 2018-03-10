package Dickens.CS445Project;
import javax.ws.rs.Path;

import javax.ws.rs.POST;

import javax.ws.rs.core.*;

import com.google.gson.Gson;


import managers.TicketManager;
import service.Ticket;

//Adds tickets to Ticket Data Structure
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
@Path("/tickets/donations")
public class TicketResource {
	private TicketManager tb=new TicketManager();
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void postTickets(String json)
	{
		Gson gson=new Gson();
		Ticket tic=gson.fromJson(json, Ticket.class);
		tb.addTickets(tic);
		
	}
}
