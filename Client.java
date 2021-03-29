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

        PrintStream ps = getPrintStream(socket);        
        BufferedReader br = getBufferedReader(socket);

        ps.println(Command.GET_ALL_CONTACTS);
        getResaultFromServer(br);

        socket.close();
    }

    private static void addContact(String name, String phoneNumber) throws Exception {
        Socket socket = new Socket("localhost", 6666);

        PrintStream ps = getPrintStream(socket);        
        BufferedReader br = getBufferedReader(socket);

        ps.println(Command.ADD_CONTACT);
        ps.println(name + " - " + phoneNumber);

        getResaultFromServer(br);

        socket.close();
    }
    
    private static void searchByName(String name) throws Exception{
        Socket socket = new Socket("localhost", 6666);

        PrintStream ps = getPrintStream(socket);        
        BufferedReader br = getBufferedReader(socket);

        ps.println(Command.SEARCH);
        ps.println(name);

        getResaultFromServer(br);

        socket.close();
    }

    private static void searchAll(String name) throws Exception{
        Socket socket = new Socket("localhost", 6666);

        PrintStream ps = getPrintStream(socket);        
        BufferedReader br = getBufferedReader(socket);

        ps.println(Command.SEARCH_ALL);
        ps.println(name);

        getResaultFromServer(br);

        socket.close();

    }

    private static PrintStream getPrintStream(Socket socket) throws Exception{
        OutputStream os = socket.getOutputStream();
        PrintStream ps = new PrintStream(os, true);

        return ps;
    }

    private static BufferedReader getBufferedReader(Socket socket) throws Exception{
        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        return br;
    }

    private static void getResaultFromServer(BufferedReader br) throws Exception{
        String line = null;
        while (!"EOF".equals(line = br.readLine())) {
            System.out.println(line);
        }
    }
}



// Search by name