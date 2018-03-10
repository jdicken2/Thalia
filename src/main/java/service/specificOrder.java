package service;
import java.util.ArrayList;
//Service Class for Specific Order
public class specificOrder {
	private int oid;
	private int wid;
	private Show_Info show_info;
	private String date_ordered;
	private int order_amount;
	private int number_of_tickets;
	private Patron_Info patron_info;
	private ArrayList <Tickets> tickets;
	public specificOrder()
	{
		
	}
	
	public specificOrder(int oi, int wi, Show_Info show, String date, int ord, int num, Patron_Info pa, ArrayList <Tickets> tic)
	{
		oid=oi;
		wid=wi;
		show_info=show;
		date_ordered=date;
		order_amount=ord;
		number_of_tickets=num;
		patron_info=pa;
		tickets=tic;
	}
	public int getOid() {
		return oid;
	}
	public int getWid() {
		return wid;
	}
	public Show_Info getShow_info() {
		return show_info;
	}
	public String getDate_ordered() {
		return date_ordered;
	}
	public int getOrder_amount() {
		return order_amount;
	}
	
	public int getNumTickets()
	{
		return number_of_tickets;
	}
	
	public Patron_Info getPatron_info() {
		return patron_info;
	}
	public ArrayList <Tickets> getTickets() {
		return tickets;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public void setWid(int wid) {
		this.wid = wid;
	}
	public void setShow_info(Show_Info show_info) {
		this.show_info = show_info;
	}
	public void setDate_ordered(String date_ordered) {
		this.date_ordered = date_ordered;
	}
	public void setOrder_amount(int order_amount) {
		this.order_amount = order_amount;
	}
	
	public void setNumberTickets(int number_of_tickets)
	{
		this.number_of_tickets=number_of_tickets;
	}
	public void setPatron_info(Patron_Info patron_info) {
		this.patron_info = patron_info;
	}
	public void setTickets(ArrayList <Tickets> tickets) {
		this.tickets = tickets;
	}
	
	
	
}
