package UsingWithCollections;

import imageSave.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManagerFactory;

public class CollectionsApp {
    public static void main(String[] args) {

        SessionFactory sessionFactory=new Configuration()
                .configure()
                .addAnnotatedClass(Address.class)
                .buildSessionFactory();

        Session session=sessionFactory.openSession();
        session.beginTransaction();

        session.getTransaction().commit();
        session.close();

    }

}
