import entity.Alcohol;
import entity.Alcohol_;

import java.sql.SQLOutput;
import java.util.*;

public class Menu
        implements Runnable
{
    private Scanner scanner;
    private SessionHibernate database;

    public Menu()
    {
        scanner = new Scanner(System.in);
        database = new SessionHibernate();
    }

    @Override
    public void run()
    {
        boolean run = true;

        System.out.println("Base alcohol, write command for work");

        while (run)
        {
            String[] commandElement = scanner.nextLine().split("\\s", 2);
            switch (commandElement[0])
            {
                case "exit":
                    run = false;
                    break;
                case "add" :
                    add();
                    break;
                case "remove" :
                    break;
                case "list":
                    System.out.println("List alcohol:");
                    printAllName();
                    break;
                case "listAll" :
                    System.out.println("All list with alcohol:");
                    printAllList();
                    break;
                case "search" :
                    System.out.println("Result");
                    printAllList(commandElement[1]);
                    break;
                case "size" :
                    break;
                case "editor" :
                    break;
                case "help" :
                    help();
                    break;
            }
        }
        database.sessionClose();
    }


    void help()
    {
        System.out.println(
                "Command:\n" +
                "add\n" +
                "remove [element name]\n" +
                "editor [element name] (under development)\n" + // TODO: This method have mark under development
                "search [element name]\n" +
                "list\n" +
                "listAll\n" +
                "size\n" +
                "help\n" +
                "exit");
    }


    void add()
    {
        try {
            Alcohol alcohol = new Alcohol();

            System.out.print("Write info about alcohol\n name - ");
            alcohol.setName(scanner.nextLine());

            System.out.print("land - ");
            alcohol.setLand(scanner.nextLine());

            System.out.print("strength - ");
            alcohol.setStrenght(scanner.nextInt());

            database.add(alcohol);

            System.out.println("Completed");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void printAllList()
    {
        System.out.println("Name\t\t\t{Land\t\tStrenght}");
        for (Alcohol alcohol : database.getAll()) {
            System.out.println(alcohol.getName() + "\t\t\t{" + alcohol.getLand() + "\t\t" + alcohol.getStrenght() + "}");
        }
        System.out.println("///////////////////////");
    }

    void printAllList(String name)
    {
        System.out.println("Name\t\t\t{Land\t\tStrenght}");
        for (Alcohol alcohol : database.getAll(Alcohol_.NAME, name)) {
            System.out.println(alcohol.getName() + "\t\t\t{" + alcohol.getLand() + "\t\t" + alcohol.getStrenght() + "}");
        }
        System.out.println("///////////////////////");
    }

    void printAllName()
    {
        for (Alcohol alcohol : database.getAllName()) {
            System.out.println(alcohol.getName());
        }
        System.out.println("///////////////////////");
    }



    void editor(String key)
    {
        // TODO: Editor Object from base;
        System.out.println("This method have mark under development");
    }

}
