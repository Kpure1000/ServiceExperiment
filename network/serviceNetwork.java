package network;
/**
 * 
 * @author Kpurek
 * @version 1.0
 */

import java.net.ServerSocket;

public class serviceNetwork {
    ServerSocket serverSocket;

    private final String post = "127.0.0.0";

    private final int port = 12834;
    /**
     * 线上最大用户数
     */
    final int maxUserNumber = 10;

    public serviceNetwork(){
        serverSocket = new ServerSocket(port);
    }
    
}