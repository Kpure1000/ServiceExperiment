package message;

/**
 * 用户消息解释器
 * <p>
 * 这是服务器行为，服务器仅拥有解析权 解析消息对象的类型和内容，做出相应行为 // TODO 还没写完：如何定义行为？
 */
public class UserMessageReader {

    /**
     * 消息
     */
    private UserMessage userMessage;

    /**
     * 构造
     * 
     * @param userMessage 读取的目标消息
     */
    public UserMessageReader(UserMessage userMessage) {
        this.userMessage = userMessage;
    }

    /**
     * 由消息确定行为
     */
    public void ReadMessage() {
        switch (userMessage.messageType) {
            case CHECK_ID:
                break;
            case CHECK_PASS:
                break;
            case REQUIRE_OFFLINE:
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
}