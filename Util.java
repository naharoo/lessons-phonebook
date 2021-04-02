import java.io.*;

import java.net.Socket;

public class Util {
    
     static PrintStream getPrintStream(Socket socket) throws Exception{
        OutputStream os = socket.getOutputStream();
        PrintStream ps = new PrintStream(os, true);

        return ps;
    }

     static BufferedReader getBufferedReader(Socket socket) throws Exception{
        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        return br;
    }

     static void getResaultFromServer(BufferedReader br) throws Exception{
        String line = null;
        while (!"EOF".equals(line = br.readLine())) {
            System.out.println(line);
        }
    }
}

