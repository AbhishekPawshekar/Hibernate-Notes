package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Model.Product;

@WebServlet("/productinfo")
public class ServletController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pn=req.getParameter("pn");
		double pp=Double.parseDouble(req.getParameter("pp"));
		String pc=req.getParameter("pc");
		int pq=Integer.parseInt(req.getParameter("pq"));
		Product p=new Product();
		p.setProductName(pn);
		p.setProductCategory(pc);
		p.setProductPrice(pp);
		p.setProductQty(pq);
//		System.out.println(p.getProductName()+p.getProductCategory());
		addToDatabase(p);
	}

	private void addToDatabase(Product p) {
		Configuration configuration=new Configuration().configure("./hibernate.cfg.xml").addAnnotatedClass(Product.class);
		SessionFactory sessionFactory=configuration.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		session.save(p);
		transaction.commit();
		session.close();
		sessionFactory.close();
		
	}
	

}
