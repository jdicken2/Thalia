package managers;
import java.util.*;
//Boundary Interface for Sections
import service.*;
public interface sectionBoundaryInterface {

	public ArrayList <Section> getSection();
	public Section getFromSectionDatabase(int id);
}
