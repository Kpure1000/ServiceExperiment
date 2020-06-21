package infomation;

import java.io.Serializable;

/**
 * 用户实例
 * 
 * @author Kpurek
 * @version 1.0
 */
public class UserInstance implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -3216052622759050855L;

    /**
     * 用户信息
     */
    UserInfo userInfo;

    /**
     * 用户状态枚举
     */
    public enum UserState {
        OFFLINE, ONLINE
    }

    /**
     * 用户状态
     */
    UserState userState;

    public UserInstance(String ID, String pass) {
        this.userInfo = new UserInfo(ID, "defualtName");
        this.userState = UserState.OFFLINE;
    }

    /**
     * 获取信息
     * 
     * @return
     */
    public UserInfo getInfo() {
        return userInfo;
    }

    /**
     * 获取状态
     * 
     * @return
     */
    public UserState getState() {
        return userState;
    }

    /**
     * 验证密码
     * @param pass
     * @return 返回密码正确性
     */
    public boolean checkPass(String pass) {
        if (userInfo == null) {
            return false;
        }
        if (String.valueOf(pass).equals(String.valueOf(userInfo.getPass()))) {
            return true;
        }
        return false;
    }
}