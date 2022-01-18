package EmpTest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmpApp {

    public static void main(String[] args) {
        Emp emp1=new Emp(333,"Seema","Accenture");
        Emp emp2=new Emp(444,"Rakesh","Vipro");

        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        cfg.addAnnotatedClass(Emp.class);
        SessionFactory sessionFactory=cfg.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction tx=session.beginTransaction();
        session.save(emp1);
        session.save(emp2);
        tx.commit();
        session.close();

    }
}
