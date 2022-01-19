package EmbededObject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UserApp {
    public static void main(String[] args) {
        UserDetails ud=new UserDetails();
        ud.setUserId(22);
        ud.setUserName("Kiran More");
        ud.setUserCompany("Google");

        Address address=new Address();
        address.setCity("Aurangabad");
        address.setStreet("Bpat road");
        address.setState("Bemglor");
        address.setPinCode("34567");

        ud.setAddress(address);

         //	<mapping class="EmbededObject.UserDetails"/>
        SessionFactory sessionFactory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(UserDetails.class)
                .buildSessionFactory();

        Session session=sessionFactory.openSession();
        session.beginTransaction();
       // session.save(ud);
        session.getTransaction().commit();
        session.close();


       ud=null;
        session=sessionFactory.openSession();
        session.beginTransaction();
        ud=session.get(UserDetails.class,11);
        System.out.println("user name retrived is = "+ud.getUserName());
        System.out.println("user state retrived is = "+ud.getAddress().getState());
        System.out.println("user City retrived is = "+ud.getAddress().getCity());
        session.close();



    }
}
