package network;

import java.net.Socket;

import infomation.UserInfo;
import message.UserMessage;


public interface TaskCallBack {
    /**
     * 当Clinet Socket连接成功
     */
    public void OnClientConnect(Socket clientSocket);

    /**
     * 当用户成功上线 即成功获取专属服务线程
     */
    public void OnUserOnLineSuccess(UserInfo userInfo);

    /**
     * 当用户上线失败 未能获取服务线程
     */
    public void OnUserOnLineFailed(UserInfo userInfo);

    /**
     * 当用户下线（包括主动和被动）
     */
    public void OnUserOffLine(UserInfo userInfo);

    /**
     * 当收到用户消息
     * 
     * @param userInfo 用户信息
     * @param msg      消息
     * // TODO 这个userInfo 可以去掉了
     */
    public void OnReceiveUserMessage(UserMessage msg);

    /**
     * 当发送消息给用户
     * 
     * @param userInfo 用户信息
     */
    public void OnSendUserMessage(UserInfo userInfo);

    /**
     * 当接收的消息错误
     */
	public void OnMessageError();
}