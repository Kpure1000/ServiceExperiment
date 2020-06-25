package infomation;

import java.util.HashMap;
/**
 * 信息管理器
 * <p>
 * 单例
 * @author Kpurek
 * @version 1.0
 */
public class InfoManager {

    /**
     * 实例
     */
    private static InfoManager instance = new InfoManager();

    private InfoManager() {
    }

    /**
     * 懒加载实例
     * 
     * @return 单例
     */
    public static InfoManager getInstance() {
        if (instance == null) {
            instance = new InfoManager();
            return instance;
        }
        return instance;
    }
    
    /*----------------------------------------------------------------------*/

    /**
     * 用户散列表
     */
    HashMap<String, UserInstance> userMap = new HashMap<String, UserInstance>();

    /**
     * 获取用户实例
     * 
     * @param ID
     * @return 返回用户容器中的实例，空则返回null
     */
    public UserInstance getUser(String ID) {
        if (checkID(ID)) {
            return userMap.get(ID);
        }
        return null;
    }

    /**
     * 校验ID
     * 
     * @param ID ID
     * @return 是否存在ID
     */
    public boolean checkID(String ID) {
        if (userMap.containsKey(ID)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 校验密码
     * 
     * @param ID ID
     * @return 是否存在ID
     */
    public boolean checkPass(String ID, String pass) {
        try {
            // 判断存在ID
            if (userMap.containsKey(ID)) {
                // 判断存在密码
                if (userMap.get(ID).checkPass(pass)) {
                    return true;
                }
                return false;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}