import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientEx {

    public static void main(String[] args) {

        String host;
        if (args.length > 0)
            host = args[0];
        else
            host = "localhost";

        int port;
        if (args.length > 1)
            port = Integer.parseInt(args[1]);
        else
            port = 4444;

        //logging!______________________
        logIn();

        try (Socket socket = new Socket(host, port);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

            Thread input = new Thread(() -> {
                String msg;
                try {
                    while ((msg = in.readLine()) != null) {
                        System.out.println(msg);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            input.start();

            String userName = "User" + ((int) (Math.random() * 200));
            String msg;
            try {
                while ((msg = stdIn.readLine()) != null) {
                    for (int i = 0; i < msg.length(); i++)
                        System.out.print("\b");
                    out.write(userName + ": " + msg + "\n");
                    out.flush();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static boolean logIn(){
        boolean loggedIn = false;
        Scanner scanner = new Scanner(System.in);
        ClientList cl1 = new ClientList("ali",123,"localhost" ,4444);
        ClientList cl2 = new ClientList("mohammad",123,"localhost" ,4444);
        List<ClientList> clientLists = new ArrayList<>();
        clientLists.add(cl1);
        clientLists.add(cl2);
        System.out.println("please inter your user name");
        String name = scanner.nextLine();
        System.out.println("please inter your password");
        long pass = scanner.nextLong();
        System.out.println("please inter your ip");
        String fill = scanner.nextLine();
        String ip = scanner.nextLine();
        System.out.println("please inter your port");
        int port = scanner.nextInt();
        for (ClientList clientList: clientLists
        ) {
            boolean nameTest = clientList.getUserName().equals(name);
            boolean passTest =  clientList.getPassword()==pass;
            boolean ipTest = clientList.getIp().equals(ip);
            boolean portTest = clientList.getPort()==port;
            if (nameTest && passTest && ipTest && portTest){
                loggedIn = true;
                System.out.println("You Logged in.");
                break;
            }
        }
        if (loggedIn==false)
            System.out.println("u do not have account here!");
        return loggedIn;
    }

}