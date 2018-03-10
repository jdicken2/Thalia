package service;
//Service Class for sections used in ticket sales report
public class ticketSalesSections {
	private int sid;
	private String section_name;
	private int section_price;
	private int seats_available;
	private int seats_sold;
	private int section_revenue;
	
	public ticketSalesSections()
	{
		
	}
	
	public ticketSalesSections(int si, String sn, int pr, int seatAv, int seatSo, int sec)
	{
		sid=si;
		section_name=sn;
		section_price=pr;
		seats_available=seatAv;
		seats_sold=seatSo;
		section_revenue=sec;
		
	}

	public int getSid() {
		return sid;
	}

	public String getSection_name() {
		return section_name;
	}

	public int getSection_price() {
		return section_price;
	}

	public int getSeats_available() {
		return seats_available;
	}

	public int getSeats_sold() {
		return seats_sold;
	}

	public int getSection_revenue() {
		return section_revenue;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public void setSection_name(String section_name) {
		this.section_name = section_name;
	}

	public void setSection_price(int section_price) {
		this.section_price = section_price;
	}

	public void setSeats_available(int seats_available) {
		this.seats_available = seats_available;
	}

	public void setSeats_sold(int seats_sold) {
		this.seats_sold = seats_sold;
	}

	public void setSection_revenue(int section_revenue) {
		this.section_revenue = section_revenue;
	}
	
	
}
