package managers;
import service.*;

import java.util.*;
//Boundary Interface for Seating
public interface seatingBoundaryInterface {
	public void makeSeating();
	public void makeDetailedSeating();
	public List <FirstInitialSeating> getAllInitialSeating();
	public InitialSeating getInitialSeating(int id);
	//public ArrayList <Seating> getAllSeating();
	//public ArrayList <Seating> getSeating(InitialSeating in);
	public specificInitialSeating getSpecificSeating(int id);
}
