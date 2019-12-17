import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;

public class Server {
    ServerSocket server = new ServerSocket(1101);
    Socket socket = server.accept();
    Scanner in = new Scanner(socket.getInputStream());
    Formatter out = new Formatter(socket.getOutputStream());


    {
    String next;
    do {
        next = in.next();
        String s = next;
        out.format(s);
        out.flush();
    }while (!next.equals("exit"));
    }

    public Server() throws IOException {
    }
}
