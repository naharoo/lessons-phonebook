import java.net.Socket;
import java.io.*;

public class Client {
    public static void main(String[] args) throws Exception {
        getAndPrintAllContacts();
        addContact("Armen", "077-77-77-77");
        searchByName("Poghosik");
        searchAll("Armen");
    }

    private static void getAndPrintAllContacts() throws Exception {
        Socket socket = new Socket("localhost", 6666);

        PrintStream ps = Util.getPrintStream(socket);        
        BufferedReader br = Util.getBufferedReader(socket);

        ps.println(Command.GET_ALL_CONTACTS);
        Util.getResaultFromServer(br);

        socket.close();
    }

    private static void addContact(String name, String phoneNumber) throws Exception {
        Socket socket = new Socket("localhost", 6666);

        PrintStream ps = Util.getPrintStream(socket);        
        BufferedReader br = Util.getBufferedReader(socket);

        ps.println(Command.ADD_CONTACT);
        ps.println(name + " - " + phoneNumber);

        Util.getResaultFromServer(br);

        socket.close();
    }
    
    private static void searchByName(String name) throws Exception{
        Socket socket = new Socket("localhost", 6666);

        PrintStream ps = Util.getPrintStream(socket);        
        BufferedReader br = Util.getBufferedReader(socket);

        ps.println(Command.SEARCH);
        ps.println(name);

        Util.getResaultFromServer(br);

        socket.close();
    }

    private static void searchAll(String name) throws Exception{
        Socket socket = new Socket("localhost", 6666);

        PrintStream ps = Util.getPrintStream(socket);        
        BufferedReader br = Util.getBufferedReader(socket);

        ps.println(Command.SEARCH_ALL);
        ps.println(name);

        Util.getResaultFromServer(br);

        socket.close();

    }

}



// Search by name