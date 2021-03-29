import entity.Alcohol;
import entity.Alcohol_;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.List;

public class SessionHibernate
{
    private Session session;

    public SessionHibernate() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public List<Alcohol> getAll()
    {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Alcohol> criteriaQuery = criteriaBuilder.createQuery(Alcohol.class);
        Root<Alcohol> root = criteriaQuery.from(Alcohol.class);

        criteriaQuery.select(root);

        Query query = session.createQuery(criteriaQuery);

        List<Alcohol> list = query.getResultList();

        return list;
    }

    public List<Alcohol> getAll(String atribute, String like)
    {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Alcohol.class);
        Root<Alcohol> root = criteriaQuery.from(Alcohol.class);

        ParameterExpression<String> parameter = criteriaBuilder.parameter(String.class, "param1");

        criteriaQuery.select(root)
                .where(criteriaBuilder.like(parameter, root.get(atribute)));

        Query query = session.createQuery(criteriaQuery)
                .setParameter("param1", like);

        List<Alcohol> list = query.getResultList();

        return list;
    }

    public List<Alcohol> getAllName()
    {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Alcohol.class);
        Root<Alcohol> root = criteriaQuery.from(Alcohol.class);
        Selection[] selection = {root.get(Alcohol_.NAME)};

        criteriaQuery.select(criteriaBuilder.construct(Alcohol.class, selection));
        Query query = session.createQuery(criteriaQuery);

        List<Alcohol> list = query.getResultList();

        return list;
    }

    public void add(Alcohol alcohol)
    {
        Transaction transaction = session.getTransaction();
        transaction.begin();

        session.save(alcohol);

        transaction.commit();
    }



    public void sessionClose()
    {
        session.close();
    }
}
