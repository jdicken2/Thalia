package Dickens.CS445Project;


import javax.ws.rs.GET;


import javax.ws.rs.Path;

import javax.ws.rs.QueryParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import managers.reportBoundaryInterface;
import managers.reportManager;

@Path("/reports")
//Resource Report
public class ReportResource {
	private reportBoundaryInterface rb=new reportManager();
	//Returns the description and ids of every report
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllSpecifedReports( )
	{
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String s = gson.toJson(rb.getAllSpecifiedReports());
	    return Response.status(Response.Status.OK).entity(s).build();
	}
	
	//The only report in this version is the ticketSalesReport
	@GET
	@Path("/{mrid2}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTicketSalesReport( @QueryParam("show") int wid)
	{
		Gson gson=new GsonBuilder().setPrettyPrinting().create();
		String s=gson.toJson(rb.getTicketSalesReport(wid));
		return Response.status(Response.Status.OK).entity(s).build();
	}
	
	
	
}
