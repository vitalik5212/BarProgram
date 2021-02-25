import drinks.Alcohol;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SessionHibernate implements  AlcoholDAO
{

    @Override
    public void addAlcohol(Alcohol alcohol) throws SQLException {

    }

    @Override
    public void deleteAlcohol(Alcohol alcohol) throws SQLException {

    }

    @Override
    public List<Alcohol> getAll() throws SQLException
    {
        Session session = null;
        List<Alcohol> list = new ArrayList<>();

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            list = session.

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return list;
    }

    @Override
    public Collection getAllName() throws SQLException {
        return null;
    }
}
