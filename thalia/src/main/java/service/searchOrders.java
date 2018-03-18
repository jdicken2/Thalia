package service;
import java.util.ArrayList;
//Service class for users who want to search for orders
public class searchOrders {
	private ArrayList <Order> orders;
	
	public searchOrders()
	{
		
	}
	
	public searchOrders(ArrayList <Order> o)
	{
		orders=o;
	}

	public ArrayList<Order> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}
	
	
}

