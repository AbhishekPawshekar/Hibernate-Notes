import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class MainApp{
	public static Transaction transaction;
	public static Session session;
	public static SessionFactory sessionFactory;
	static{
		Configuration configuration=new Configuration();
		configuration=configuration.configure();
		sessionFactory=configuration.buildSessionFactory();
		 session=sessionFactory.openSession();
		transaction=session.beginTransaction();
	}
	
	public static void main(String args[]) {
		
		Scanner sc=new Scanner(System.in);
		while(true) {
		System.out.println("-----------------Product CLI---------------\n1.Add data\n2.Get Data\n3.Update Data\n4.Delete data\n5.Exit\n Operation on Product Table...\nEnter your Choice...!!!");
		switch (sc.nextInt()) {
		case 1:
			addData(sc);
			break;
		case 2:
			getData(sc);
			break;
		case 3:
			updateData(sc);
			break;
		case 4:
			deleteData(sc);
			break;
		case 5:
			transaction.commit();
			session.close();
			sessionFactory.close();
			System.exit(0);
			break;
		default:
			System.out.println("Enter Correct Choice..!!!");
		}
		}
	}

	private static void deleteData(Scanner sc) {
		System.out.println("Enter product Id:");
		Product_Model pm=session.get(Product_Model.class, sc.nextInt());
		session.delete(pm);
		System.out.println("DElete data successfully...!!");
	}

	private static void updateData(Scanner sc) {
		System.out.println("---------------------Product update Data-------------------");
		System.out.println("Enter product Id:");
		Product_Model pm=session.get(Product_Model.class, sc.nextInt());
		System.out.println("Enter product name:");
		pm.setProduct_Name(sc.next());
		System.out.println("Enter product category:");
		pm.setProduct_cat(sc.next());
		System.out.println("Enter product qty:");
		pm.setQty(sc.nextInt());
		System.out.println("Enter product Price:");
		pm.setPrice(sc.nextDouble());
		session.merge(pm);//or use update()
		System.out.println("Successfully update to database..!!");
	}

	private static void getData(Scanner sc) {
		System.out.println("------------------Product Get Data-------------");
		System.out.println("Enter product Id:");
		int n=sc.nextInt();
		Product_Model pm=session.get(Product_Model.class,n);
		System.out.println("Name: "+pm.getProduct_Name()+"\nCategory: "+pm.getProduct_cat()+"\nqty: "+pm.getQty()+"\nprice: "+pm.getPrice());
	}

	private static void addData(Scanner sc) {
		System.out.println("---------------------Product Add Data-------------------");
		Product_Model pm=new Product_Model();
		System.out.println("Enter product id:");
		pm.setProduct_id(sc.nextInt());
		System.out.println("Enter product name:");
		pm.setProduct_Name(sc.next());
		System.out.println("Enter product category:");
		pm.setProduct_cat(sc.next());
		System.out.println("Enter product qty:");
		pm.setQty(sc.nextInt());
		System.out.println("Enter product Price:");
		pm.setPrice(sc.nextDouble());
		session.persist(pm);//or use save()
		System.out.println("Successfully Add to database..!!");
		
	}
}