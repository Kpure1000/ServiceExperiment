package function;

import infomation.InfoManager;

/**
 * 身份验证器
 * <p>
 * 验证ID以及密码
 * 
 * @author Kpurek
 * @version 1.0
 */
public class Authentication {

    /**
     * ID缓存
     */
    private String ID = "";

    /**
     * 验证密码
     * 
     * @param ID
     * @return ID正确与否
     */
    public boolean checkID(String ID) {
        if (InfoManager.getInstance().checkID(ID)) {
            this.ID = ID;
            return true;
        }
        return false;
    }

    /**
     * 验证密码
     * 
     * @param pass
     * @return 密码正确与否
     */
    public boolean checkPass(String pass) {
        if (String.valueOf(ID).equals(String.valueOf("")) == false) {
            return InfoManager.getInstance().checkPass(ID, pass);
        }
        return false;
    }
}