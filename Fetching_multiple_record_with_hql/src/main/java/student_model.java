import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity//entity and table annotation is import ....
@Table(name="studentinfo")//name is optional here if we not provide it will create table on class name
public class student_model{
	
	@Column(name="stud_name")
	private String name;
	@Id
	@Column(name ="studId")//if we not give name then it will create column name as variable name;
//	for generating identity as auto increment by one 
	@GeneratedValue(strategy = GenerationType.IDENTITY)//this is for generation auto increment constraint..
														// we can also use sequence instead of identity if database not support auto-increment.
														//if we don't know that that database support auto-increment or not then use auto.
	
	// for sequence generations who not support auto_increment in database
//	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "subjectIdGenerator")
//	@SequenceGenerator(name="subjectIdGenerator",initialValue = 101,allocationSize = 100)//increment by 100  
	private int stud_id;
	
	@Column(name="studPercent")
	private float stud_percent;
	@Column(name="studAddress")
	private String stud_address;
	@Column(name="contact")
	private int contactno;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStud_id() {
		return stud_id;
	}
	public void setStud_id(int stud_id) {
		this.stud_id = stud_id;
	}
	public float getStud_percent() {
		return stud_percent;
	}
	public void setStud_percent(float stud_percent) {
		this.stud_percent = stud_percent;
	}
	public String getStud_address() {
		return stud_address;
	}
	public void setStud_address(String stud_address) {
		this.stud_address = stud_address;
	}
	public int getContactno() {
		return contactno;
	}
	public void setContactno(int contactno) {
		this.contactno = contactno;
	}

	
}