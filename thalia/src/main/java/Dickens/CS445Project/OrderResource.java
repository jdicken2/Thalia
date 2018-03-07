package Dickens.CS445Project;

import javax.ws.rs.Consumes;




import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.QueryParam;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import database.DatabaseClass;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import managers.OrderManager;

import managers.ShowBoundaryInterface;
import managers.ShowManager;
import managers.orderBoundaryInterface;


import service.Order;
import service.PostOrder;


import service.Section;
import service.bodyPostOrder;
import service.specificOrder;

import service.Tickets;
@Path("/orders")
//Resource for Orders
public class OrderResource {

	private orderBoundaryInterface ob=new OrderManager();
	private ShowBoundaryInterface sb=new ShowManager();
	public Map<Integer, Section> sections=DatabaseClass.getSections();
	public Map<Integer, PostOrder> postOrders=DatabaseClass.getPostOrders();
	specificOrder so=new specificOrder();
	private ArrayList <Integer> tickets=new ArrayList <Integer>();
	private ArrayList <Tickets> tic=new ArrayList <Tickets>();
	int startingTicket;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response postOrder(String json) 
	{
		//BodypostOrders is the body of the order that is posted
		//Adds BodypostOrder for later
		//Creates the orderAmount, date, etc for the postOrder
		Gson gson=new Gson();
		bodyPostOrder bpo=gson.fromJson(json, bodyPostOrder.class);
		ob.addBodyPostOrder(bpo);
		int ticSize=bpo.getSeats().size();
		int orderAmount=(sections.get(bpo.getSid()).getPrice())*(ticSize);
		Date d=new Date();
		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String realStringDate=sd.format(d);
		PostOrder po=new PostOrder(ob.getOid2(), bpo.getWid(), sb.getShow(bpo.getWid()).getShowInfo(), realStringDate, orderAmount, tickets);
		po.setOid(ob.getOid2()+postOrders.size());
		//Only good for functional testing, should be fixed for future development
		if(po.getOid()==411)
		{
			startingTicket=729;
			for(int i=0;i<ticSize;i++)
			{
				
				Tickets tick=new Tickets();
				tickets.add(startingTicket);
				tick.setTid(startingTicket);
				tick.setStatus("open");
				tic.add(tick);
				startingTicket++;
			}
		}
		
		else if(po.getOid()==412)
		{
			startingTicket=737;
			for(int i=0;i<ticSize;i++)
			{
				
				Tickets tick=new Tickets();
				tickets.add(startingTicket);
				tick.setTid(startingTicket);
				tick.setStatus("open");
				tic.add(tick);
				startingTicket++;
			}
			
		}
		else if(po.getOid()==413)
		{
			startingTicket=739;
			for(int i=0;i<ticSize;i++)
			{
				
				Tickets tick=new Tickets();
				tickets.add(startingTicket);
				tick.setTid(startingTicket);
				tick.setStatus("open");
				tic.add(tick);
				startingTicket++;
			}
			
		}
		//Creats order from postOrder
		Order o=new Order(po.getOid(), po.getWid(), sb.getShow(po.getWid()).getShowInfo(), po.getDate_ordered(), po.getOrder_amount(), ticSize, bpo.getPatron_info());
		//Uses for Credit Card, has to mask it for display
		String endCC=o.getPi().getCc_number().substring(12);
		String maskedCC="xxxxxxxxxxxx".concat(endCC);
		o.getPi().setCc_number(maskedCC);
		
		String s=gson.toJson(ob.addPostOrder(po));
		ob.addOrder(o);
		//Adds specific order
		so=new specificOrder(ob.getOid(), o.getWid(), o.getSh(), o.getDate_ordered(), o.getOrder_amount(), o.getNumber_of_tickets(), o.getPi(), tic);
		ob.addSpecificOrder(so); 
		
		//Returns postOrder
		return Response.status(Response.Status.OK).entity(s).build();
	}
	
	
	//Returns all orders
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllOrders(@QueryParam("order") String start_date, 
													  String end_date)
	{
		
		 Gson gson = new GsonBuilder().setPrettyPrinting().create();
	     String s = gson.toJson(ob.getAllOrders());
	     return Response.status(Response.Status.OK).entity(s).build();   
	}
	
	//Returns the specific order 
	@GET
	@Path("/{orderID}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOrder(@PathParam("orderID") int orderID)
	{
		specificOrder so=ob.getSpecificOrder(orderID);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();            
        String str=gson.toJson(so);
        return Response.ok(str).build();
	}
}
