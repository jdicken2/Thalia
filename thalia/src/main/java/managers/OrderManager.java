package managers;

import service.PostOrder;
import service.Order;
import service.specificOrder;
import service.bodyPostOrder;
import java.util.ArrayList;
import java.util.Map;
import database.DatabaseClass;
public class OrderManager implements orderBoundaryInterface {
	public Map<Integer, Order> orders=DatabaseClass.getOrders();
	public Map<Integer, specificOrder> specificOrders=DatabaseClass.getSpecificOrders();
	public Map<Integer, bodyPostOrder> bodyPostOrders=DatabaseClass.getBodyPostOrders();
	public Map<Integer, PostOrder> postOrders=DatabaseClass.getPostOrders();
	int startingTicket;
	
	
	private int oid=411;
	private int oid2=411;
	private int bpoid=1;
	
	//Returns oid and sets oid
	@Override
	public int getOid()
	{
		return oid;
	}
	
	@Override
	public void setOid(int oid)
	{
		this.oid=oid;
	}
	
	@Override
	public int getOid2()
	{
		return oid2;
	}
	@Override
	public void setOid2(int oid2)
	{
		this.oid2=oid2;
	}
	
	//Returns oid of body post order and sets 
	@Override
	public int getBpoid()
	{
		return bpoid;
	}
	@Override
	public void setBpoid(int bpoid)
	{
		this.bpoid=bpoid;
	}
	
	//Adds order to hashmap
	@Override
	public Order addOrder(Order o)
	{	
		o.setOid(oid+(orders.size()));
		orders.put(o.getOid(), o);
		return o;
	}
	
	//Adds specific order to hashmap
	@Override
	public specificOrder addSpecificOrder(specificOrder so)
	{
		so.setOid(oid + (specificOrders.size()));
		specificOrders.put(so.getOid(), so);
		return so;
	}
	
	//Returns order based on oid
	@Override
	public Order getOrder(int id)
	{
		return orders.get(id);
	}
	
	//Returns all orders from hashp from an Array list
	@Override
	public ArrayList <Order>getAllOrders()
	{
		
		return new ArrayList<Order>(orders.values());
	}
	
	//Returns specific order from oid and hashmap
	@Override
	public specificOrder getSpecificOrder(int id)
	{
		return  specificOrders.get(id);
	}
	
	//Returns body of post oder from bpoid and hashmap
	@Override
	public bodyPostOrder getBodyPostOrder(int id)
	{
		return bodyPostOrders.get(id);
	}
	
	//Returns all body of post orders in an Arraylist 
	@Override
	public ArrayList <bodyPostOrder> getAllBodyPostOrders()
	{
		return new ArrayList<bodyPostOrder>(bodyPostOrders.values()); 
	}
	
	//Adds bodypostorder and changes key based on the size of the hashmap
	@Override
	public bodyPostOrder addBodyPostOrder(bodyPostOrder bpo)
	{
		this.setBpoid(bpoid+ (bodyPostOrders.size()));
		bodyPostOrders.put(this.getBpoid(),bpo);
		return bpo;
	}
	
	//Adds Post Order and changes key based on the size of the hashmap
	@Override
	public PostOrder addPostOrder(PostOrder po)
	{
		po.setOid(oid+(postOrders.size()));		
		postOrders.put(po.getOid(), po);
		return po;
	}
	
}
	
	
	
	
	

