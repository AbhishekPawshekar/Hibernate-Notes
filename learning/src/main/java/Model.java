

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@AllArgsConstructor
@Setter
@NoArgsConstructor
public class Model {
		private int empid;
          private String name;
          private float sal;
          public int getEmpid() {
      		return empid;
      	}
      	public void setEmpid(int empid) {
      		this.empid = empid;
      	}
      	public String getName() {
      		return name;
      	}
      	public void setName(String name) {
      		this.name = name;
      	}
      	public float getSal() {
      		return sal;
      	}
      	public void setSal(float sal) {
      		this.sal = sal;
      	}
          
}
