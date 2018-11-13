package persistance.configuration;
import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;


 class HibernateMySqlConfigurationTest {
    @Test
    void Save() {
        HibernateMySqlConfiguration configuration = new HibernateMySqlConfiguration();
        configuration.configure();
        configuration.addClass(User.class);
        configuration.buildSessionFactory();
        User user = new User();
        user.setName("Armel");
        user.setSurname("Sanou");
        SessionFactory sessionFactory = configuration.sessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
        System.out.println("New user id: " + user.getId());
    }

}
