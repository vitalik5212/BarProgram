import java.util.*;

public class Menu
        implements Runnable
{
    private final Scanner scanner = new Scanner(System.in);

    public Menu() {}

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
                    ServerSQL.remove(commandElement[1]);
                    break;
                case "list":
                    System.out.println("List alcohol:");
                    ServerSQL.getAllCollum();
                    break;
                case "listAll" :
                    ServerSQL.getAll();
                    break;
                case "search" :
                    ServerSQL.getLineByCollum("name", commandElement[1]);
                    break;
                case "size" :
                    System.out.println(ServerSQL.size());
                    break;
                case "editor" :
                    editor(commandElement[1]);
                    break;
                case "help" :
                    help();
                    break;
            }
        }
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
            String name;
            String land;
            int strength;

            System.out.print("Write info about alcohol\n name - ");
            name = scanner.nextLine();

            System.out.print("land - ");
            land = scanner.nextLine();

            System.out.print("strength - ");
            strength = scanner.nextInt();

            ServerSQL.write(name, land, strength);

            System.out.println("Completed");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }



    void editor(String key)
    {
        // TODO: Editor Object from base;
        System.out.println("This method have mark under development");
    }

}
