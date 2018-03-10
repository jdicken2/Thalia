package managers;
import service.Donations;
//BoundaryInterface for Donations 
import service.Subscription;
import java.util.ArrayList;
public interface donationBoundaryInterface {

	public Donations addDonations(Donations d);
	public Subscription getSubscription(int did);
	public Subscription getSingleSubscription();
	public ArrayList <Subscription> getAllSubscriptions();
}
