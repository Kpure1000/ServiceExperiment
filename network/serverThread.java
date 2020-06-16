package network;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 服务器服务线程
 * 
 * @author Kpurek
 * @version 1.0
 */
public class serverThread implements Runnable {
    @Override
    public void run() {
        try {
            String inputMsg = "";
            while (socket != null && socket.isConnected()==true) {
                var input = new DataInputStream(socket.getInputStream());
                if(inputMsg!=null){
                    inputMsg = input.readUTF();
                }
                // 按照 时间->消息 的格式 显示消息
                System.out.println(dateFormat.format(Calendar.getInstance().getTime()) + "->" + inputMsg);
            }
            if(socket.isConnected()==false){
                socket.close();
            }
            System.out.println(socket.getInetAddress() + ": 连接断开");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public serverThread(Socket socket) {
        this.socket = socket;
    }

    public Socket socket;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("hh-mm-ss");

}