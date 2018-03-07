package service;
//Service Class for Tickets
public class Tickets {
	private int tid;
	private String status;
	public Tickets()
	{
	
	}
	
	public Tickets(int ti, String stat)
	{
		tid=ti;
		status=stat;
	}
	public int getTid() {
		return tid;
	}
	public String getStatus() {
		return status;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
