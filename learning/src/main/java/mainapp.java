import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class mainapp{

    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration = configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
//    	Adding data to database
//        Model m = new Model();
//        m.setEmpid(1);
//        m.setName("Abhishek");
//        m.setSal(25000);
//        session.persist(m);//or you can use session.save() or session.load()
//        System.out.println("Done successfully added..!!");
    	
    	
    	// fetching data from database
//        Model m=session.get(Model.class, 1);//row no which we want..
//        System.out.println(m.getEmpid()+"----"+m.getName()+"----"+m.getSal());
        
        //update database
        Model m=session.get(Model.class, 1);//row count which we want..
        m.setSal(35000);
        session.merge(m);
        System.out.println("Update Successfully..!!");
        
        transaction.commit();
        session.close();
        sessionFactory.close();

    }
}