import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table
public class Question{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Question_Id;
	private String Question;
	private String difficulty_level;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "TopicQuestion",joinColumns = @JoinColumn(name="question_ref"),inverseJoinColumns =@JoinColumn(name="topic_ref") )
	List<Topic> TopicList;
	
	
	public void addTopic(Topic t) {
		if(TopicList==null)TopicList=new LinkedList<Topic>();
		TopicList.add(t);
	}
	
	
	
	public List<Topic> getTopicList() {
		return TopicList;
	}



	public void setTopicList(List<Topic> topicList) {
		TopicList = topicList;
	}



	public int getQuestion_Id() {
		return Question_Id;
	}
	public void setQuestion_Id(int question_Id) {
		Question_Id = question_Id;
	}
	public String getQuestion() {
		return Question;
	}
	public void setQuestion(String question) {
		Question = question;
	}
	public String getDifficulty_level() {
		return difficulty_level;
	}
	public void setDifficulty_level(String difficulty_level) {
		this.difficulty_level = difficulty_level;
	}
	
	
	
}