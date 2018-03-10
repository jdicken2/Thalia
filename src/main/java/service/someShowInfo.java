package service;
//Service Class to return some of the show info
public class someShowInfo {
	private int wid;
	private Show_Info show_info;
	
	public someShowInfo()
	{
		
	}
	
	public someShowInfo(int wi, Show_Info sh)
	{
		wid=wi;
		show_info=sh;
	}
	public int getWid() {
		return wid;
	}
	public Show_Info getShow_info() {
		return show_info;
	}
	public void setWid(int wid) {
		this.wid = wid;
	}
	public void setShow_info(Show_Info show_info) {
		this.show_info = show_info;
	}
	
	
}
