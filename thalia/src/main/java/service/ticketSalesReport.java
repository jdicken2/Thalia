package service;
import java.util.ArrayList;
//Service Clsas for ticket sales report 
public class ticketSalesReport {
	private int mrid;
	private String name;
	private int total_shows;
	private int total_seats;
	private int sold_seats;
	private int overall_revenue;
	private ArrayList <ticketSalesShow> shows;
	
	public ticketSalesReport()
	{
		
	}
	
	public ticketSalesReport(int mr, String na, int tot_sh, int tot_se, int so, int ove, ArrayList <ticketSalesShow> sh)
	{
		mrid=mr;
		name=na;
		total_shows=tot_sh;
		total_seats=tot_se;
		sold_seats=so;
		overall_revenue=ove;
		shows=sh;
	}

	public int getMrid() {
		return mrid;
	}

	public String getName() {
		return name;
	}

	public int getTotal_shows() {
		return total_shows;
	}

	public int getTotal_seats() {
		return total_seats;
	}

	public int getSold_seats() {
		return sold_seats;
	}

	public int getOverall_revenue() {
		return overall_revenue;
	}

	public ArrayList <ticketSalesShow> getShows() {
		return shows;
	}

	public void setMrid(int mrid) {
		this.mrid = mrid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTotal_shows(int total_shows) {
		this.total_shows = total_shows;
	}

	public void setTotal_seats(int total_seats) {
		this.total_seats = total_seats;
	}

	public void setSold_seats(int sold_seats) {
		this.sold_seats = sold_seats;
	}

	public void setOverall_revenue(int overall_revenue) {
		this.overall_revenue = overall_revenue;
	}

	public void setShows(ArrayList <ticketSalesShow> shows) {
		this.shows = shows;
	}
	
		

}
