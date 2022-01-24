package oneToOneMapping;

import javax.persistence.*;

@Entity
@Table(name="question_table")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int question_id;
    private String question;

    @OneToOne
    @JoinColumn(name="a_id")
    private Answer answer;


    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

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

    public Question(int question_id, String question) {
        this.question_id = question_id;
        this.question = question;
    }

    public Question() {
        super();
    }

    @Override
    public String toString() {
        return "Question{" +
                "question_id=" + question_id +
                ", question='" + question + '\'' +
                '}';
    }
}
