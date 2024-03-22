import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class main_class_to_load {
public static void main(String[] args) {
	Configuration configuration=new Configuration().configure().addAnnotatedClass(Book.class);
	SessionFactory sessionFactory=configuration.buildSessionFactory();
	Session session=sessionFactory.openSession();
	Transaction transaction=session.beginTransaction();
	
	
	Display_Data_through_criteria_interface.displayData(session, transaction);

	session.close();
	sessionFactory.close();
}
}
