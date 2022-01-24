package oneToManyMapping;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

public class MainClass {

    public static void main(String[] args) {




        Question q1=new Question();
        q1.setQuestion("What is HTML");
        Answer ans1=new Answer();
        ans1.setAnswer("HTML stands for Hipertest programing lanuguage");

        Answer ans2=new Answer();
        ans2.setAnswer("Html we use in java");


        Answer ans3=new Answer();
        ans3.setAnswer("help of HTML we desigin page");


        List<Answer> list=new ArrayList<>();
        list.add(ans1);
        list.add(ans2);
        list.add(ans3);
        q1.setAnswers(list);




        SessionFactory sessionFactory=new Configuration().configure().addAnnotatedClass(Question.class).addAnnotatedClass(Answer.class).buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();

         session.save(q1);
         session.save(ans1);
        session.save(ans2);
        session.save(ans3);

        Question newQ=session.get(Question.class,1);
        System.out.println(newQ.getQuestion());
        for(Answer a:newQ.getAnswers()){
            System.out.println(a.getAnswer());
        }

        session.getTransaction().commit();
        sessionFactory.close();
        session.close();
    }
}
