import java.io.IOException;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;

public class Client {
    Socket socket = new Socket("localhost",1101);
    Scanner socketIn = new Scanner(socket.getInputStream());
    Formatter socketOut = new Formatter(socket.getOutputStream());
    Scanner systemIn = new Scanner(System.in);
    {
        String next;
        do {
            next = systemIn.next();
            socketOut.format(next+"\n");
            socketOut.flush();
            String received = socketIn.next();
            System.out.println("received: "+ received);
        }while (!next.equals("exit"));
    }

    public Client() throws IOException {
    }
}
