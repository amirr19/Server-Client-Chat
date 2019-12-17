package Client;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        Socket socket = null;
        int portNumber = 1111;
        try {
            socket = new Socket("localhost",portNumber);
        } catch (IOException e) {
            System.err.println("Fatal Connection error!");
            e.printStackTrace();
        }

    }
}
