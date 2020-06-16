package network;

/**
 * 
 * @author Kpurek
 * @version 1.0
 */

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class serviceNetwork {
    ServerSocket serverSocket;

    /**
     * 端口号
     */
    private int port = 12834;

    /**
     * 线上最大用户数
     */
    final int maxUserNumber = 10;

    private int curUserNumber = 0;

    public serviceNetwork() throws IOException {
        System.out.println("端口: " + port);
        serverSocket = new ServerSocket(port);
        try {
            while (true) {
                var client = serverSocket.accept();
                System.out.print("用户 " + client.getInetAddress().toString() + ":" + client.getPort() + " 上线: "
                        + client.toString());
                new Thread(new serverThread(client)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // TODO 关掉资源
        }

    }

}