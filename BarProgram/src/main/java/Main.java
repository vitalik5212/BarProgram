public class Main
{
    public static void main(String[] args)
    {
        ServerSQL.initialize();

        Thread thread = new Thread(new Menu());
        thread.start();

        try
        {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ServerSQL.shutDownConnection();
    }
}