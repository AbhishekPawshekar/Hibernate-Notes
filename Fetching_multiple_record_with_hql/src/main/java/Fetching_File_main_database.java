import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

class Fetching_File_main_database{
	public static void main(String[] args) {
		Configuration configuration=new Configuration().configure().addAnnotatedClass(student_model.class);
		SessionFactory sessionFactory=configuration.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		//fetch all record with help of hql
		Query query=session.createQuery("from student_model s");
		List<student_model>  data=query.getResultList();
		for (student_model s:data) {
			System.out.println(s.getStud_id()+"--"+s.getContactno()+"--"+s.getName()+"--"+s.getStud_percent());
		}
		
		//fetching distinct record.
		Query query1=session.createQuery("select distinct s.name from student_model s");
		List<student_model>  data1=query.getResultList();
		for (student_model s:data1) {
			System.out.println(s.getStud_id()+"--"+s.getContactno()+"--"+s.getName()+"--"+s.getStud_percent());
		}
		
		
		//updating record..
		Query query2=session.createQuery("update student_model s set s.stud_percent=75 where s.stud_id=1 ");
//		query2.executeUpdate();
		
		
		transaction.commit();
		session.close();
		sessionFactory.close();
		
	}
}