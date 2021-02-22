import java.sql.*;
import java.util.Scanner;

public class ServerSQL
{
    private final static String url = "jdbc:postgresql://localhost:5432/BarProgram";
    private final static String user = "postgres";
    private final static String password = "root";

    private static Connection connection = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;

    private static final String EXECUTE_DELETE = "DELETE FROM \"Alcohol\" WHERE ? = '?'";

    public static void initialize()
    {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try
        {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
                    );
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



    public static void shutDownConnection()
    {

        try {
            statement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



    public static int size()
    {
        try {
            resultSet = statement.executeQuery("SELECT count(1) FROM \"Alcohol\"");
            resultSet.next();

            return resultSet.getInt(1);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0;
        } finally {
            resultSet = null;
        }
    }



    public static void write(String name, String land, int strenght)
    {
        String SQL = ("INSERT INTO public.\"Alcohol\"(name, land, strenght) VALUES ('" + name + "','" + land + "'," + strenght + ");");

        try {
            statement.execute(SQL);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }



    public static void remove(String name)
    {
        try {
            statement.execute("DELETE FROM \"Alcohol\" WHERE name='" + name + "';");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }



    public static void removeWhichArguments(String argument, String element)
    {
        try {
            Statement prepareStatement = connection.prepareStatement(EXECUTE_DELETE);

            prepareStatement.addBatch(argument);
            prepareStatement.addBatch(element);


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }



    public static void getLineByCollum(String collumName, String line)
    {
        try
        {
            resultSet = statement.executeQuery("SELECT * FROM \"Alcohol\" WHERE " + collumName + "='" + line + "';");
            printResultSet(resultSet);
            resultSet = null;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



    public static void getAllCollum()
    {
        try
        {
            resultSet = statement.executeQuery("SELECT(name) FROM \"Alcohol\"");

            while (resultSet.next())
            {
                System.out.println(resultSet.getString(1));
            }
            System.out.println();

            resultSet = null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



    public static void getAll()
    {
        try {
            resultSet = statement.executeQuery("SELECT * FROM \"Alcohol\";");
            printResultSet(resultSet);
            resultSet = null;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }



    private static void printResultSet(ResultSet resultSet) throws SQLException
    {

        while (resultSet.next())
        {
            System.out.println();
            System.out.println("Name = " + resultSet.getString(2) + ";");
            System.out.println("Land = " + resultSet.getString(3) + ";");
            System.out.println("Strength = " + resultSet.getInt(4) + ";");
            System.out.println();
        }
    }
}
