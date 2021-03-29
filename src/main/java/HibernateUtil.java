import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil
{
    private static SessionFactory sessionFactory;

    static {
        final StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try {
            sessionFactory = new MetadataSources(standardServiceRegistry).buildMetadata().buildSessionFactory();
        } catch (Throwable ex) {
            StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
