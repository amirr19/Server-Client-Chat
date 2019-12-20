import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {
    ServerSocket server;
    Socket s;
    DataOutputStream dos;
    DataInputStream din;
    BufferedReader br;
    String usr;
    Thread th;

    public Server() throws IOException {
        server = new ServerSocket(3003);
        s = server.accept();
        dos = new DataOutputStream(s.getOutputStream());
        din = new DataInputStream(s.getInputStream());
        br = new BufferedReader(new InputStreamReader(System.in));
        th = new Thread(this);
        th.start();
        while (true) {
            System.out.println(din.readUTF());
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                usr = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                dos.writeUTF(usr);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        try {
            new Server();
        } catch (Exception e) {

        }
    }
}
