package service;

import java.util.ArrayList;
//Service Class for Seating for the request that cannot be obtained
public class requestFailedSeating{
	private int wid;
	private Show_Info show_info;
	private int sid;
	private String section_name;
	private int starting_seat_id;
	private String status;
	private ArrayList <Seating> seating;
	
	public requestFailedSeating()
	{
		
	}
	
	public requestFailedSeating(int wi, Show_Info sh, int si, String section, int start, String stat, ArrayList<Seating> emptySeating)
	{
		wid=wi;
		show_info=sh;
		sid=si;
		section_name=section;
		starting_seat_id=start;
		status=stat;
		seating=emptySeating;
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

	public void setSeating(ArrayList <Seating> seating) {
		this.seating = seating;
	}
	
	
	
}
