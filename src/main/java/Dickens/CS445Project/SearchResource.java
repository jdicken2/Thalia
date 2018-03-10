package Dickens.CS445Project;
import managers.searchBoundaryInterface;
import managers.searchManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

//Supposed Functionality
//Searches for different things within in the theater, using different keys and topics as search parameters.

//Current Functionality
//As of this version, it only searches for specific orders
@Path("/search")
public class SearchResource {
	searchBoundaryInterface sb=new searchManager();
	@GET
	@Produces
	public Response orderSearch(@QueryParam ("topic") String topic,
								@QueryParam ("key") int oid)
	{
		String s=" ";
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		topic="order";
		if(topic=="order")
		{
			s = gson.toJson(sb.orderSearch(oid));
		}
		return Response.status(Response.Status.OK).entity(s).build();  
	}

	
	
}
