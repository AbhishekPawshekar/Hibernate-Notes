import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class createTableAndAddRecord {
	public static void main(String[] args) {
		Configuration configuration=new Configuration().configure();
		configuration.addAnnotatedClass(student_model.class);//need to add this class for implementing annotations.
		SessionFactory sessionFactory=configuration.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		student_model sm=new student_model();
		sm.setStud_id(1);
		sm.setName("abhishek");
		sm.setStud_address("pune");
		sm.setContactno(789654125);
		sm.setStud_percent(85);
		System.out.println("Operation completed..!!");
		session.persist(sm);//you can also use save();
		
		transaction.commit();
		session.close();
		sessionFactory.close();
		
		
	}

}
