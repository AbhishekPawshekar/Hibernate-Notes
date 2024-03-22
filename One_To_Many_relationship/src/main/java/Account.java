import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "acccountIDGenerator")
	@SequenceGenerator(name = "acccountIDGenerator",initialValue = 100,allocationSize = 1)
	private int AccountId;
	
	private long accoutNumber;
	
	private String holderName;
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn
	private Customer customerRef;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private Nominee nomineeRef;
	
	//getter and setter
	
	public Nominee getNomineeRef() {
		return nomineeRef;
	}


	public void setNomineeRef(Nominee nomineeRef) {
		this.nomineeRef = nomineeRef;
	}


	public int getAccountId() {
		return AccountId;
	}


	public long getAccoutNumber() {
		return accoutNumber;
	}

	public void setAccoutNumber(long accoutNumber) {
		this.accoutNumber = accoutNumber;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public Customer getCustomerRef() {
		return customerRef;
	}

	public void setCustomerRef(Customer customerRef) {
		this.customerRef = customerRef;
	}

	
	

}
