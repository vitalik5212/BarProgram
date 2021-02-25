import drinks.Alcohol;

import java.sql.SQLException;
import java.util.Collection;

public interface AlcoholDAO
{
    void addAlcohol(Alcohol alcohol) throws SQLException;
    void deleteAlcohol(Alcohol alcohol) throws SQLException;
    Collection getAll() throws SQLException;
    Collection getAllName() throws SQLException;
}
