
package service;
import java.util.ArrayList;
//Service class for order that is returned for specific use cases
public class PostOrder {
	private int oid;
	private int wid;
	private Show_Info show_info;
	private String date_ordered;
	private int order_amount;
	private ArrayList <Integer> tickets;

	public PostOrder()
	{
		
	}
	
	public PostOrder(int oi, int wi, Show_Info s, String date, int order, ArrayList <Integer>tic)
	{
		oid=oi;
		wid=wi;
		show_info=s;
		date_ordered=date;
		order_amount=order;
		tickets=tic;
	}

	public int getOid() {
		return oid;
	}

	public int getWid() {
		return wid;
	}

	public Show_Info getSh() {
		return show_info;
	}

	public String getDate_ordered() {
		return date_ordered;
	}

	public int getOrder_amount() {
		return order_amount;
	}

	public ArrayList <Integer>getTickets() {
		return tickets;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public void setWid(int wid) {
		this.wid = wid;
	}

	public void setSh(Show_Info show_info) {
		this.show_info= show_info;
	}

	public void setDate_ordered(String date_ordered) {
		this.date_ordered = date_ordered;
	}

	public void setOrder_amount(int order_amount) {
		this.order_amount = order_amount;
	}

	public void setTickets(ArrayList <Integer> tickets) {
		this.tickets = tickets;
	}
	
	
}
