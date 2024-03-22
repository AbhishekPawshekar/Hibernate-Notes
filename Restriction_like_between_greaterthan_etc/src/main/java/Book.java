import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "bookidgenerator")
	@SequenceGenerator(name = "bookidgenerator",initialValue = 100, allocationSize = 100)
	private int bookid;
	private String bookname;
	private float bookprice;
	
	
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public float getBookprice() {
		return bookprice;
	}
	public void setBookprice(float bookprice) {
		this.bookprice = bookprice;
	}

}
