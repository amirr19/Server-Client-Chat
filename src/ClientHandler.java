import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ClientHandler implements Runnable {
    Scanner scn = new Scanner(System.in);
    private String name;
    final DataInputStream dis;
    final DataOutputStream dos;
    Socket s;
    boolean isLoggedIn;

    public ClientHandler(String name, DataInputStream dis, DataOutputStream dos, Socket s) {
        this.name = name;
        this.dis = dis;
        this.dos = dos;
        this.s = s;
        this.isLoggedIn = true;
    }

    @Override
    public void run() {
        String received;
        while (true) {
            try {
                received = dis.readUTF();
                System.out.println(received);
                if (received.equals("logout")) {
                    this.isLoggedIn = false;
                    this.s.close();
                    break;
                }
                StringTokenizer st = new StringTokenizer(received, "#");
                String MsgToSend = st.nextToken();
                String recipient = st.nextToken();

                for (ClientHandler mc : Server.ar) {
                    if (mc.name.equals(recipient) && mc.isLoggedIn == true) {
                        mc.dos.writeUTF(this.name + " : " + MsgToSend);
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
try {
    this.dis.close();
    this.dos.close();
} catch (IOException e) {
    e.printStackTrace();
}

    }
}
