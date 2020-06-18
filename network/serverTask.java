package network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import infomation.UserMessage;

/**
 * 服务器任务
 * 
 * @author Kpurek
 * @version 1.0
 */
public class serverTask implements Runnable {
    /**
     * 任务
     */
    @Override
    public void run() {
        try {
            objIn = new ObjectInputStream(socket.getInputStream());
            UserMessage inobj = new UserMessage();
            // 接收消息
            while ((inobj = (UserMessage) objIn.readObject()) != null) {
                callBack.OnReceiveUserMessage(null, inobj);
            }
        } catch (IOException e) {
            // 因为
            //e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 构造
     * 
     * @param socket 客户端socket
     */
    public serverTask(Socket socket, TaskCallBack callBack) {
        this.socket = socket;
        this.callBack = callBack;
    }

    /**
     * 客户端socket
     */
    private Socket socket;

    ObjectInputStream objIn;

    private TaskCallBack callBack;
}