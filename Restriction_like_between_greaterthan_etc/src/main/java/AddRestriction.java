import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

class AddRestriction{
	public static void addRestric(Session s,Transaction t) {
		System.out.println("=================greaterthan===================");
		//greater than Restriction
		Criteria c=s.createCriteria(Book.class);
		c.add(Restrictions.gt("bookprice", Float.parseFloat("100")));
		List<Book> b=c.list();
		for(Book data:b)System.out.println(data.getBookname()+"---"+data.getBookprice());
		
		
		System.out.println("================less than and orderby ================");
		//lessthan
		Criteria c1=s.createCriteria(Book.class);
		c1.add(Restrictions.lt("bookprice", Float.parseFloat("300")));
		c1.addOrder(Order.asc("bookprice"));
		List<Book> b1=c1.list();
		for(Book data:b1)System.out.println(data.getBookname()+"---"+data.getBookprice());
		
		
		System.out.println("======================Between 500 to 800 price and book name end with t===");
		//between and Like 
		Criteria c2=s.createCriteria(Book.class);
		c2.add(Restrictions.between("bookprice", 500f,800f));
		c2.add(Restrictions.like("bookname", "%h"));
		c2.addOrder(Order.asc("bookprice"));
		List<Book> b2=c2.list();
		for(Book data:b2)System.out.println(data.getBookname()+"---"+data.getBookprice());
		
		
		//
	}
}