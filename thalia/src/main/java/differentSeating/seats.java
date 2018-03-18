package differentSeating;
//Seats structure used for differentSeating
//Not best practive
//Should have just been named something else
public class seats {
	private int cid;
	private int seat;
	public seats()
	{
		
	}
	
	public seats (int ci, int se)
	{
		cid=ci;
		seat=se;
	}
	public int getCid() {
		return cid;
	}
	public int getSeat() {
		return seat;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public void setSeat(int seat) {
		this.seat = seat;
	}
	
	
}
