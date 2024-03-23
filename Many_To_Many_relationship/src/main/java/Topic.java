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
public class Topic{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int topicId;
	private String TopicName;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "TopicQuestion",joinColumns = @JoinColumn(name="topic_ref"),inverseJoinColumns =@JoinColumn(name="question_ref") )
	List<Question> questionList;
	
	public void addQuestion(Question q) {
		if(questionList==null)questionList=new LinkedList<Question>();
		questionList.add(q);
		
	}
	
	
	
	public int getTopicId() {
		return topicId;
	}
	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}
	public String getTopicName() {
		return TopicName;
	}
	public void setTopicName(String topicName) {
		TopicName = topicName;
	}



	public List<Question> getQuestionList() {
		return questionList;
	}



	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}
	
	
	
	
}