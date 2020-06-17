package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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
            BufferedReader bufferReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
            String line = null;
            // 接收消息
            while ((line = bufferReader.readLine()) != null) {
                // 按照 时间->消息 的格式 显示消息
                System.out.println(dateFormat.format(Calendar.getInstance().getTime()) + "-> " + line);
                if (socket==null||socket.isConnected() == false) {
                    System.out.println(socket.getInetAddress().toString() + "断开连接");
                    bufferReader.close();
                    break;
                }
            }
            while(true)
            if (socket==null||socket.isConnected() == false) {
                System.out.println(socket.getInetAddress().toString() + "断开连接");
                bufferReader.close();
                return;
            }
            // br.close();
        } catch (IOException e) {
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

    private SimpleDateFormat dateFormat = new SimpleDateFormat("hh-mm-ss");

    private TaskCallBack callBack;
}