package differentSeating;
import java.util.ArrayList;
//Different seating used for the seating data structure
//Not best practice
//Should have just been named something differently
public class Seating {
	private int row;
	private ArrayList <Integer> seats;
	
	public Seating()
	{
		
	}
	
	public Seating(int r, ArrayList <Integer> se)
	{
		row=r;
		seats=se;
	}
	public int getRow() {
		return row;
	}
	public ArrayList<Integer> getSeats() {
		return seats;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public void setSeats(ArrayList<Integer> seats) {
		this.seats = seats;
	}
	
	
}
