package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
    public static void main(String[] args) {
        int portNumber = 1111;
//        serverSocket = null;
        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
        } catch (IOException e) {
            System.err.println("Could not listen on port: "+ portNumber);
            System.exit(1);
        }
    }
    public static void acceptClients(ServerSocket serverSocket, int portnumber){
        ArrayList<ClientThread> clients = new ArrayList<ClientThread>();
        while(true){
            try{
                Socket socket = serverSocket.accept();
                ClientThread client = new ClientThread(socket);
                Thread thread = new Thread(client);
                thread.start();
                clients.add(client);
            }catch (IOException e){
                System.out.println("Accept failed on :" +portnumber);
            }
        }
    }
}
