import java.util.List;
import java.util.Objects;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

public class Display_Data_through_criteria_interface {
	public static void displayData(Session s,Transaction t) {
		//get all col
		Criteria crt=s.createCriteria(Book.class);
		List<Book> data=crt.list();
		for(Book b:data)System.out.println(b.getBookname()+"----Price: "+b.getBookprice());
		
		//get only 1 column and multiple rows.
		System.out.println("=====================");
		Criteria crt2=s.createCriteria(Book.class);
		crt2.setProjection(Projections.property("bookname"));
		List< Book> data2=crt2.list();
		for(Book b:data)System.out.println(b.getBookname());
		
		//set multiple column
		System.out.println("==========mul===========");
		Criteria crt3=s.createCriteria(Book.class);
		ProjectionList pl=Projections.projectionList();
		pl.add(Projections.property("bookname"));
		pl.add(Projections.property("bookprice"));
		crt3.setProjection(pl);
		List<Object> data3=crt3.list();
		
		for(Object b:data3) {
			Object[] d3=(Object[]) b;
			System.out.println(d3[0]+"===="+d3[1]);
			}
		
		// display by order
		System.out.println("============order by=========");
		Criteria crt4=s.createCriteria(Book.class);
		crt4.addOrder(Order.asc("bookprice"));
		List< Book> data4=crt4.list();
		for(Book b:data4)System.out.println(b.getBookname()+"\t"+b.getBookprice());
		
		
	}

}
