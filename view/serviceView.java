package view;

import java.io.IOException;
import java.net.Socket;

import network.TaskCallBack;
import network.UserInfo;
import network.UserMessage;
import network.serviceNetwork;

/**
 * serviceView
 * 
 */
public class serviceView {

    serviceNetwork service;

    public static void main(String[] args) {
        try {
            new serviceView();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public serviceView() throws IOException {
        System.out.println("*服务端界面启动*");
        service = new serviceNetwork(new TaskCallBack() {

            @Override
            public void OnReceiveUserMessage(UserInfo userInfo, UserMessage msg) {
                // TODO 发送信息时要做的

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

            }

            @Override
            public void OnSendUserMessage(UserInfo userInfo) {
                // TODO 发送消息给用户

            }
        });
    }
}