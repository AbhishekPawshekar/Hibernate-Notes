package Model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class BranchTest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Bid;
	private String Brname;
	private String Brcity;
	
	@OneToMany(mappedBy ="branchRef",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH} )
	private List<CustomerTest> customerList;
	
	public void addCustomer(CustomerTest customer) {
		if(customerList ==null) customerList=new LinkedList<CustomerTest>();
		
			customer.setbranchRef(this);
			customerList.add(customer);
		
	}
	
	
	
	//getter and setter

	public int getBid() {
		return Bid;
	}



	public String getBrname() {
		return Brname;
	}

	public void setBrname(String brname) {
		Brname = brname;
	}

	public String getBrcity() {
		return Brcity;
	}

	public void setBrcity(String brcity) {
		Brcity = brcity;
	}

	public List<CustomerTest> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<CustomerTest> customerList) {
		this.customerList = customerList;
	}
	
	
	
	
	
	
	
	
	
	
}