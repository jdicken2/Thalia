package service;
import java.util.ArrayList;
//Show for Ticket Sales Show
public class ticketSalesShow {

	private int wid;
	private Show_Info show_info;
	private ArrayList <ticketSalesSections> sections;
	
	public ticketSalesShow()
	{
		
	}
	
	public ticketSalesShow(int wi, Show_Info sh, ArrayList <ticketSalesSections> sec) 
	{
		wid=wi;
		show_info=sh;
		sections=sec;
	}

	public int getWid() {
		return wid;
	}

	public Show_Info getShow_info() {
		return show_info;
	}

	public ArrayList <ticketSalesSections> getSections() {
		return sections;
	}

	public void setWid(int wid) {
		this.wid = wid;
	}

	public void setShow_info(Show_Info show_info) {
		this.show_info = show_info;
	}

	public void setSections(ArrayList <ticketSalesSections> sections) {
		this.sections = sections;
	}
	
	
	
}
