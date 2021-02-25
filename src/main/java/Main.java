import drinks.Alcohol;

import java.sql.SQLException;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        ServerSQL.initialize();

        Thread thread = new Thread(new Menu());
        thread.start();

        SessionHibernate sessionHibernate = new SessionHibernate();
        List<Alcohol> list;

        try {
            list = sessionHibernate.getAll();
            for(Alcohol alcohol : list) {
                System.out.println(alcohol.getName());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try
        {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ServerSQL.shutDownConnection();
    }
}