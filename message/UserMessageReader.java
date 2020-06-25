package message;

import function.Authentication;

/**
 * 用户消息解释器，要放在服务功能类中(function.server?)
 * <p>
 * 这是服务器行为，服务器仅拥有解析权 解析消息对象的类型和内容，做出相应行为
 * <p>
 * // TODO 还没写完：目前行为使用接口定义
 */
public class UserMessageReader {

    /**
     * 读取信息，触发行为
     * 
     * @param userMessage
     */
    public void ReadMessage(UserMessage userMessage) {
        if (messageFeedBack == null)
            return;
        Authentication authentication = new Authentication();
        switch (userMessage.messageType) {
            case CHECK_ID:
                if (authentication.checkID(userMessage.getContent())) {
                    messageFeedBack.OnIDExist();
                } else {
                    messageFeedBack.OnIDNotExsit();
                }
                break;
            case CHECK_PASS:
                if (authentication.checkPass(userMessage.getContent())) {
                    messageFeedBack.OnPassCorrent();
                } else {
                    messageFeedBack.OnPassError();
                }
                break;
            case REQUIRE_OFFLINE:
                messageFeedBack.OnRequireOffLine();
                break;
            case SET_NAME:
                break;
            case SET_PASS:
                break;
            case CREATE_COUNT:
                break;
            case MSG_PRIVATE:
                break;
            case MSG_GROUP:
                break;
            case MSG_TEST:
                break;
            default:
                break;
        }
    }

    /** 接收消息后的反馈 */
    public interface MessageFeedBack {
        /** 当 ID存在 */
        public void OnIDExist();

        /** 当 ID不存在 */
        public void OnIDNotExsit();

        /** 当 密码正确 */
        public void OnPassCorrent();

        /** 当 密码错误 */
        public void OnPassError();

        /** 当 请求下线 */
        public void OnRequireOffLine();

        /** 当 接收私聊消息请求 */
        public void OnReceivePrivateMsg();

        /** 当 接收群聊消息请求 */
        public void OnReceiveGroupMsg();

        public void OnReceiveTestMsg();

    }

    /** 反馈实例 */
    MessageFeedBack messageFeedBack;
}