package Model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class CustomerTest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Cno;
	private String Cname;
	private String City;
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn
	private BranchTest branchRef;
	
	
	@OneToMany(mappedBy ="customerRef",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH} )
	private List<AccountTest> accountList;
	
	
	
	public void addAccount(AccountTest account) {
		if(accountList ==null) accountList=new LinkedList<AccountTest>();
	
			account.setCustomerRef(this);
			accountList.add(account);
			
	}
	
	
	
	public BranchTest getBranchRef() {
		return branchRef;
	}

	public void setBranchRef(BranchTest branchRef) {
		this.branchRef = branchRef;
	}
	public List<AccountTest> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<AccountTest> accountList) {
		this.accountList = accountList;
	}

	public void setCno(int cno) {
		Cno = cno;
	}	
	
	//getter and setter

	public int getCno() {
		return Cno;
	}


	public String getCname() {
		return Cname;
	}

	public void setCname(String cname) {
		Cname = cname;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public BranchTest getbranchRef() {
		return branchRef;
	}

	public void setbranchRef(BranchTest branchRef) {
		this.branchRef = branchRef;
	}
	
	

}
