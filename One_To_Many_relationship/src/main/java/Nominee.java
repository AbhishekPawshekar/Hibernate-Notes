import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Nominee{
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int  nId;
	private String nName;
	private int Age;
	private String nRelation;
	private String dob;
	
	
	public int getnId() {
		return nId;
	}

	public String getnName() {
		return nName;
	}
	public void setnName(String nName) {
		this.nName = nName;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getnRelation() {
		return nRelation;
	}
	public void setnRelation(String nRelation) {
		this.nRelation = nRelation;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}

	
	
	
}