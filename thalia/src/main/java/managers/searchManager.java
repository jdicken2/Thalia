package managers;
import java.util.ArrayList;
import service.Order;
import service.searchOrders;
//Searches for different topics and ids within the theater
//Only searches for orders in this version
public class searchManager implements searchBoundaryInterface {
	orderBoundaryInterface ob=new OrderManager();
	@Override
	public searchOrders orderSearch(int oid)
	{
		Order o=ob.getOrder(oid);
		ArrayList <Order> os=new ArrayList <Order>();
		os.add(o);
		searchOrders so=new searchOrders();
		so.setOrders(os);
		return so;
		
	}
	
}
