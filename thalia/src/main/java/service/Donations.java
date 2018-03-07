//Donations Service Class
package service;

public class Donations {
	private int wid;
	private int count;
	private Patron_Info patron_info;
	
	public Donations()
	{
		
	}
	
	public Donations(int wi, int co, Patron_Info pa)
	{
		wid=wi;
		count=co;
		patron_info=pa;
	}

	public int getWid() {
		return wid;
	}

	public int getCount() {
		return count;
	}

	public Patron_Info getPatron_info() {
		return patron_info;
	}

	public void setWid(int wid) {
		this.wid = wid;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setPatron_info(Patron_Info patron_info) {
		this.patron_info = patron_info;
	}
	
	
}
