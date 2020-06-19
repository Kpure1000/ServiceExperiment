package view;

import java.io.IOException;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import message.UserMessage;
import network.TaskCallBack;
import network.UserInfo;
import network.serviceNetwork;

/**
 * serviceView
 * 
 */
public class serviceView {

    /**
     * 网络层
     */
    serviceNetwork service;

    /**
     * 入口
     * 
     * @param args
     */
    public static void main(String[] args) {
        try {
            new serviceView();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 构造
     * 
     * @throws IOException
     */
    public serviceView() throws IOException {
        System.out.println("*服务端界面启动*");
        service = new serviceNetwork(new TaskCallBack() {

            @Override
            public void OnReceiveUserMessage(UserInfo userInfo, UserMessage msg) {
                // TODO 接收信息时要做的
                // 按照 时间->消息 的格式 显示消息
                System.out.println(dateFormat.format(Calendar.getInstance().getTime()) + "-> " + msg.getContent());
            }

            @Override
            public void OnUserOnLineSuccess(UserInfo userInfo) {
                // TODO 上线成功

            }

            @Override
            public void OnUserOnLineFailed(UserInfo userInfo) {
                // TODO 上线失败

            }

            @Override
            public void OnUserOffLine(UserInfo userInfo) {
                // TODO 用户下线

            }

            @Override
            public void OnClientConnect(Socket clientSocket) {
                // TODO 客户端连接
                System.out.println(
                        "客户端: " + clientSocket.getInetAddress().toString() + ":" + clientSocket.getPort() + " 连接服务");

            }

            @Override
            public void OnSendUserMessage(UserInfo userInfo) {
                // TODO 发送消息给用户

            }

            @Override
            public void OnMessageError() {
                // TODO Auto-generated method stub
                System.out.println("接收的消息为空");

            }
        });
    }

    private SimpleDateFormat dateFormat = new SimpleDateFormat("MM月dd日hh:mm:ss");
}