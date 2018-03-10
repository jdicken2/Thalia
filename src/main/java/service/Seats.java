package service;
//Service Class for Seats
public class Seats {
	
	private int cid;
	private String seat;
	private String status; 
	
	public Seats()
	{
		
	}
	
	public Seats(int chid, String se, String state)
	{
		cid=chid;
		seat=se;
		status=state;
	}
	public int getChairID() {
		return cid;
	}

	public String getSeat() {
		return seat;
	}

	public String getStatus() {
		return status;
	}
	
	public void setChairID(int cid) {
		this.cid = cid;
	}

	public void setSeats(String seat) {
		this.seat= seat;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
