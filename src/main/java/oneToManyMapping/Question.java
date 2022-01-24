package oneToManyMapping;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="question_table")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int question_id;
    private String question;

    @OneToMany(mappedBy = "question")
    private List<Answer> answers;

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question_id=" + question_id +
                ", question='" + question + '\'' +
                ", answers=" + answers +
                '}';
    }
}
