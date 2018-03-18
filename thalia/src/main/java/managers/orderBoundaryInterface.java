package managers;
import service.specificOrder;



import java.util.ArrayList;
import service.Order;
import service.bodyPostOrder;
import service.PostOrder;

//Boundary Interface for Orders
public interface orderBoundaryInterface {

	public Order addOrder(Order o);
	public Order getOrder(int id);
	public ArrayList <Order> getAllOrders();
	public specificOrder getSpecificOrder(int id);
	public specificOrder addSpecificOrder(specificOrder so);
	public bodyPostOrder getBodyPostOrder(int id);
	public ArrayList <bodyPostOrder> getAllBodyPostOrders();
	public bodyPostOrder addBodyPostOrder(bodyPostOrder bpo);
	public int getOid();
	public void setOid(int oid);
	public int getBpoid();
	public void setBpoid(int bpoid);
	public PostOrder addPostOrder(PostOrder po);
	public int getOid2();
	public void setOid2(int oid2);
}
