package service;
//Service Class for Orders
public class Order 
{
	private int oid;
	private int wid;
	private Show_Info show_info;
	private String date_ordered;
	private int order_amount;
	private int number_of_tickets;
	private Patron_Info patron_info;
	
	public Order()
	{
		
	}
	
	public Order(int o, int w, Show_Info s, String da, int or, int nu, Patron_Info p)
	{
		oid=o;
		wid=w;
		show_info=s;
		date_ordered=da;
		order_amount=or;
		number_of_tickets=nu;
		patron_info=p;
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

	public int getNumber_of_tickets() {
		return number_of_tickets;
	}

	public Patron_Info getPi() {
		return patron_info;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public void setWid(int wid) {
		this.wid = wid;
	}

	public void setSh(Show_Info sh) {
		this.show_info = sh;
	}

	public void setDate_ordered(String date_ordered) {
		this.date_ordered = date_ordered;
	}

	public void setOrder_amount(int order_amount) {
		this.order_amount = order_amount;
	}

	public void setNumber_of_tickets(int number_of_tickets) {
		this.number_of_tickets = number_of_tickets;
	}

	public void setPi(Patron_Info pi) {
		this.patron_info= pi;
	}
	
	public boolean isNil() {
        return false;
    }
}
