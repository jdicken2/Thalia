package managers;
import service.*;
import java.util.ArrayList;
//Boundary Interface for Show
public interface ShowBoundaryInterface 
{
	public int getWid();
	public ArrayList <someShowInfo> getAllShows();
	public Show getShow(int id);
	public Show addShow(Show sh);
	public Show updateShow(Show sh);	
}
