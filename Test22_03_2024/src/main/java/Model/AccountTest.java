package Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class AccountTest {
	@Id
	private long A_no;
	private String A_type;
	private long contact_number;
	private double Balance;
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn
	private CustomerTest customerRef;

	
	
	
	//getter and setter


	public String getA_type() {
		return A_type;
	}

	public long getA_no() {
		return A_no;
	}

	public void setA_no(long a_no) {
		A_no = a_no;
	}

	public void setA_type(String a_type) {
		A_type = a_type;
	}



	public long getContact_number() {
		return contact_number;
	}

	public void setContact_number(long contact_number) {
		this.contact_number = contact_number;
	}

	public double getBalance() {
		return Balance;
	}

	public void setBalance(double balance) {
		Balance = balance;
	}

	public CustomerTest getCustomerRef() {
		return customerRef;
	}

	public void setCustomerRef(CustomerTest customerRef) {
		this.customerRef = customerRef;
	}

	
	
	
	
	
	

}