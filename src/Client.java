import java.io.*;
import java.net.Socket;

public class Client implements Runnable {

    Socket s;
    DataOutputStream dos;
    DataInputStream din;
    BufferedReader br;
    String usr;
    Thread th;

    public Client() throws IOException {
        s = new Socket("localhost",3003);
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
                dos.writeUTF(usr);
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }

    public static void main(String[] args) throws IOException {
        try{
            new Client();

        }catch (Exception e){}
    }
}