//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class LogIn {
//    public static void main(String[] args) {
//        boolean loggedIn = false;
//        Scanner scanner = new Scanner(System.in);
//        ClientList cl1 = new ClientList("ali",123,"localhost" ,4444);
//        ClientList cl2 = new ClientList("mohammad",123,"localhost" ,4444);
//        List<ClientList> clientLists = new ArrayList<>();
//        clientLists.add(cl1);
//        clientLists.add(cl2);
//        System.out.println("please inter your user name");
//        String name = scanner.nextLine();
//        System.out.println("please inter your password");
//        long pass = scanner.nextLong();
//        System.out.println("please inter your ip");
//        String fill = scanner.nextLine();
//        String ip = scanner.nextLine();
//        System.out.println("please inter your port");
//        int port = scanner.nextInt();
//        for (ClientList clientList: clientLists
//             ) {
//            boolean nameTest = clientList.getUserName().equals(name);
//            boolean passTest =  clientList.getPassword()==pass;
//            boolean ipTest = clientList.getIp().equals(ip);
//            boolean portTest = clientList.getPort()==port;
//            if (nameTest && passTest && ipTest && portTest){
//                loggedIn = true;
//                System.out.println("You Logged in.");
//                break;
//            }
//        }
//        if (loggedIn==false)
//            System.out.println("u do not have account here!");
//    }
//
//
//}
