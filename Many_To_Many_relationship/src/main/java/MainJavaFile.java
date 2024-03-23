import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainJavaFile{
	public static void main(String[] args) {
		Configuration configuration=new Configuration().configure().addAnnotatedClass(Topic.class).addAnnotatedClass(Question.class);
		SessionFactory sessionFactory=configuration.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
//		addData(session,transaction);
//		addTopicToExsistingQuestion(session,transaction);
		fetchData(session,transaction);
		sessionFactory.close();
	}
	

	private static void fetchData(Session session, Transaction transaction) {
		Criteria criteria=session.createCriteria(Topic.class);
		List<Topic> topic= criteria.list();
		for(Topic t:topic) {
			List<Question> q= t.getQuestionList();
			System.out.println("-----------\nTopic:"+t.getTopicName());
			for(Question qq:q) {
				System.out.println(qq.getQuestion()+"\n"+qq.getDifficulty_level());
			}
		}
		session.close();
		
	}


	private static void addTopicToExsistingQuestion(Session session, Transaction transaction) {
		
		Topic t= new Topic();
		t.setTopicName("polymorpism");
		Question q=session.get(Question.class, 1);
		q.addTopic(t);
		
		session.persist(q);
		
		System.out.println("Add Topic to exsisting Question successfull...!!");
		transaction.commit();
		session.close();
		
	}


	private static void addData(Session session, Transaction transaction) {
		
		Topic t=new Topic();
		t.setTopicName("Java");
		
		Question q=new Question();
		q.setQuestion("What is inheritance..?");
		q.setDifficulty_level("Easy");
//		q.addTopic(t);
		
		Question q1=new Question();
		q1.setQuestion("what is polymorphism.");
		q1.setDifficulty_level("Medium");
//		q1.addTopic(t);
		
		t.addQuestion(q1);
		t.addQuestion(q);
		
		session.save(t);
		session.save(q1);
		session.save(q);
		System.out.println("Data Added Successfully..");
		
		transaction.commit();
		session.close();
		
	}
}