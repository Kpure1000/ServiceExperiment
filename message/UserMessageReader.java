package message;

/**
 * 用户消息解释器
 * <p>
 * 这是服务器行为，服务器仅拥有解析权
 * 解析消息对象的类型和内容，做出相应行为
 * // TODO 还没写完：如何定义行为？
 */
public class UserMessageReader {
    
    private UserMessage userMessage;

    public UserMessageReader() {
        this.userMessage = new UserMessage();
    }
}