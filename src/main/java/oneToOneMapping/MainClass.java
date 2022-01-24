package oneToOneMapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainClass {

    public static void main(String[] args) {

        Question q=new Question();
        Question q1=new Question();
        q.setQuestion("What is java");
        q1.setQuestion("What Spring Boot");

        Answer ans=new Answer();
        Answer ans1=new Answer();
        ans.setAnswer("java is programing launguage");
        ans1.setAnswer("Spring boot is a set of configuration");
        ans.setAnswer_id(111);
        ans1.setAnswer_id(222);
        q.setAnswer(ans);
        q1.setAnswer(ans1);

        SessionFactory sessionFactory=new Configuration().configure().addAnnotatedClass(Answer.class).addAnnotatedClass(Question.class).buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.save(q);
        session.save(q1);
        Question newQ=session.get(Question.class, 2);
        System.out.println(newQ.getQuestion());
        System.out.println(newQ.getQuestion_id());
        System.out.println(newQ.getAnswer().getAnswer());












    }
}
