import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="onetooneperson")
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int person_id;
	
	@OneToOne(cascade = {CascadeType.ALL,CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.REMOVE})
	@JoinColumn(name ="passref")
	private Passport passport_ref;
	
	private String name;
	
	
	
	public int getPerson_id() {
		return person_id;
	}
	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}
	public Passport getPassport_ref() {
		return passport_ref;
	}
	public void setPassport_ref(Passport passport_ref) {
		this.passport_ref = passport_ref;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
