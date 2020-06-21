package network;

/**
 * 
 * @author Kpurek
 * @version 1.0
 */

import java.io.IOException;
import java.net.ServerSocket;

public class serviceNetwork {
    ServerSocket serverSocket;

    /**
     * 端口号
     */
    private int port = 12834;

    private TaskCallBack callBack;

    /**
     * 构造
     * <p>
     * 在内部监听ServerSocket阻塞，向服务线程池中加入任务
     * @param callBack 
     * @throws IOException
     */
    public serviceNetwork(TaskCallBack callBack) throws IOException {
        this.callBack = callBack;
        serverSocket = new ServerSocket(port);
        try {
            while (true) {
                // socket连接请求
                var client = serverSocket.accept();
                callBack.OnClientConnect(client);
                // 任务加入线程池
                serverThreadPool.getInstance().pushTask(new serverTask(client, this.callBack));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}