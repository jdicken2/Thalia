package service;
//Service Class for Seating Info
public class Seating_Info 
{
	
	private int sid;
	private int price;
	
	
	
	
	public Seating_Info()
	{
		
		
		
		
	}
	
	public Seating_Info (int sN, int pr)
	{
		sid=sN;
		price=pr;
		
	}

	public int getSeatingID() {
		return sid;
	}

	public int getPrice() {
		return price;
	}

	public void setSeatingID(int seatingID) {
		sid = seatingID;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
	 

