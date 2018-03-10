package managers;
import service.specifiedReport;

//Boundary Interface for Reports
import service.ticketSalesReport;
import java.util.ArrayList;
public interface reportBoundaryInterface {
	public ArrayList <specifiedReport> getAllSpecifiedReports();
	public ticketSalesReport getTicketSalesReport(int wid);
}
