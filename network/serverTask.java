package network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import message.*;

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
            UserMessage inobj;
            UserMessageReader userMessageReader = new UserMessageReader();
            // 接收消息
            while (true) {
                inobj = (UserMessage) objIn.readObject();
                if (inobj != null) {
                    // TODO 还要改这个回调
                    callBack.OnReceiveUserMessage(inobj);
                    userMessageReader.ReadMessage(inobj);
                    inobj=null;
                } else {
                    callBack.OnMessageError();
                    break;
                }
            }
        } catch (IOException e) {
            // 因为readObject始终会抛出异常，所以咱啥也不干
            // e.printStackTrace();
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

    /**
     * 对象输入流
     */
    ObjectInputStream objIn;

    /**
     * 任务回调
     */
    private TaskCallBack callBack;
}