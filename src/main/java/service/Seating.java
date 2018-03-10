package service;
//Service class for Seating 
import java.util.ArrayList;

public class Seating {
	private int row;
	private ArrayList <Seats> seats;
	
	public Seating()
	{
		
	}
	
	public Seating(int r, ArrayList<Seats> se)
	{
		row=r;
		seats=se;
	}
	public int getRow() {
		return row;
	}

	public ArrayList<Seats> getSeats()
	{
		return seats;
	}
	public void setRow(int row) {
		this.row = row;
	}

	public void setRow(ArrayList <Seats> seats)
	{
		this.seats=seats;
	}
}
