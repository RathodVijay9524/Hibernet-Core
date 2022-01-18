package imageSave;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

public class AddressApp  {

    public static void main(String[] args) throws IOException {
        Address ad=new Address();
        ad.setCity("pune");
        ad.setStreet("Handewadi road");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(1234.234);

        FileInputStream fis=new FileInputStream("C:\\Users\\VR\\IdeaProjects\\HibernetCore\\src\\main\\resources\\vijay.png");
        byte[] data=new byte[fis.available()];
        fis.read(data);
        ad.setImage(data);

        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        cfg.addAnnotatedClass(Address.class);
        SessionFactory sessionFactory=cfg.buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.save(ad);
        session.getTransaction().commit();
        session.close();

    }
}
