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
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String AccountName;
	private String address;
	
	@OneToMany(mappedBy = "customerRef",cascade ={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private List<Account> accountholding;


	public void addAccount(Account acc,Nominee nominee) {
		if(accountholding==null) 
			accountholding=new LinkedList<Account>();
		acc.setCustomerRef(this);
		acc.setNomineeRef(nominee);
		accountholding.add(acc);
		
		
	}	
	
	//getter and setter

	public int getId() {
		return id;
	}


	public String getAccountName() {
		return AccountName;
	}

	public void setAccountName(String accountName) {
		AccountName = accountName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Account> getAccountholding() {
		return accountholding;
	}

}
