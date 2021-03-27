import java.io.*;
import java.util.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws Exception {
        Phonebook pb = new Phonebook();

        ServerSocket ss = new ServerSocket(6666);

        while (true) {
            Socket socket = ss.accept();

            new Thread(new CommandExecutor(socket, pb)).start();
            
        }
    }
}

class CommandExecutor implements Runnable {

    private final Phonebook pb;
    private final Socket socket;

    public CommandExecutor(Socket socket, Phonebook pb) {
        this.socket = socket;
        this.pb = pb;
    }

    @Override
    public void run() {
        Contact[] contacts = pb.getContacts();
        try {
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String command = br.readLine();
            System.out.printf("Received command: %s from Socket: %s\n", command, socket);

            if (command == null) {
                return;
            }

            OutputStream os = socket.getOutputStream();
            PrintStream ps = new PrintStream(os, true);

            switch (command.toUpperCase()) {
                case "GET ALL CONTACTS": {
                    for (int i = 0; i < pb.getCount(); i++) {
                        ps.println(contacts[i].toString());
                    }
                    ps.println("EOF");
                    break;
                }
                case "ADD CONTACT": {
                    String contactAsLine = br.readLine();
                    System.out.println(contactAsLine);

                    pb.addContact(new Contact(contactAsLine));

                    ps.println("ADDED");
                    ps.println("EOF");
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
