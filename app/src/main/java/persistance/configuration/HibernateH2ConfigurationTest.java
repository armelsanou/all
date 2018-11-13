package persistance.configuration;
import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HibernateH2ConfigurationTest {
    private Logger logger = LoggerFactory.getLogger(HibernateH2ConfigurationTest.class);

    @Test
    void Save() {
        HibernateH2Configuration configuration = new HibernateH2Configuration();
        configuration.configure();
        configuration.addClass(User.class);
        configuration.buildSessionFactory();
        User user = new User();
        user.setName("Sanou");
        user.setSurname("Armel");
        SessionFactory sessionFactory = configuration.sessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
        //System.out.println("New user id: " + user.getId());
        logger.info("New user id: " + user.getId());
    }

}
