import java.net.Socket;
import java.io.*;
import java.util.Arrays;

public class Client {
    public static void main(String[] args) throws Exception {
        getAndPrintAllContacts();
        addContact();
        getAndPrintAllContacts();
    }

    private static void getAndPrintAllContacts() throws Exception {
        Socket socket = new Socket("127.0.0.1", 6666);
        OutputStream os = socket.getOutputStream();
        PrintStream ps = new PrintStream(os, true);

        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        ps.println("GET ALL CONTACTS");
        String line = null;
        while (!"EOF".equals(line = br.readLine())) {
            System.out.println(line);
        }

        socket.close();
    }

    private static void addContact() throws Exception {
        Socket socket = new Socket("127.0.0.1", 6666);

        OutputStream os = socket.getOutputStream();
        PrintStream ps = new PrintStream(os, true);

        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        System.out.println(1);
        ps.println("ADD CONTACT");
        System.out.println(2);
        ps.println("Poghosik - 011-23-42-78");
        System.out.println(3);

        String line = null;
        while (!"EOF".equals(line = br.readLine())) {
            System.out.println(line);
        }

        socket.close();
    }
}



// Search by name