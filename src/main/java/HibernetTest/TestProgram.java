package HibernetTest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class TestProgram {
    public static void main(String[] args) {

        Student st=new Student(444,"Kiran","pune");


        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        cfg.addAnnotatedClass(Student.class);   // <mapping class="HibernetTest.Student"/>

        SessionFactory sessionFactory=cfg.buildSessionFactory();

        Session session=sessionFactory.openSession();

        session.beginTransaction();
        session.save(st);
        session.getTransaction().commit();

    }

}
