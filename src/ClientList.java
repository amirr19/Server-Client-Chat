import java.util.ArrayList;
import java.util.List;

public class ClientList {
    private String userName;
    private long password;
    private String ip;
    private int port;

    public String getUserName() {
        return userName;
    }

    public long getPassword() {
        return password;
    }

    public String getIp() {
        return ip;
    }

    public int getPort() {
        return port;
    }

    public ClientList(String userName, long password, String ip, int port) {
        this.userName = userName;
        this.password = password;
        this.ip = ip;
        this.port = port;
    }

}
