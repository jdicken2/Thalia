package service;
import java.util.ArrayList;
//Service class for requested seating 
public class requestSeating {
	private int wid;
	private Show_Info show_info;
	private int sid;
	private String section_name;
	private int starting_seat_id;
	private String status;
	private int total_amount;
	private ArrayList <Seating> seating;
	
	public requestSeating()
	{
		
	}
	
	public requestSeating(int wi, Show_Info sh, int si, String sec, int start, String stat, int tot, ArrayList <Seating> se)
	{
		wid=wi;
		show_info=sh;
		sid=si;
		section_name=sec;
		starting_seat_id=start;
		status=stat;
		total_amount=tot;
		seating=se;
	}

	public int getWid() {
		return wid;
	}

	public Show_Info getShow_info() {
		return show_info;
	}

	public int getSid() {
		return sid;
	}

	public String getSection_name() {
		return section_name;
	}

	public int getStarting_seat_id() {
		return starting_seat_id;
	}

	public String getStatus() {
		return status;
	}

	public int getTotal_amount() {
		return total_amount;
	}

	public ArrayList <Seating> getSeating() {
		return seating;
	}

	public void setWid(int wid) {
		this.wid = wid;
	}

	public void setShow_info(Show_Info show_info) {
		this.show_info = show_info;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public void setSection_name(String section_name) {
		this.section_name = section_name;
	}

	public void setStarting_seat_id(int starting_seat_id) {
		this.starting_seat_id = starting_seat_id;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setTotal_amount(int total_amount) {
		this.total_amount = total_amount;
	}

	public void setSeating(ArrayList <Seating> seating) {
		this.seating = seating;
	}
	
	
}
