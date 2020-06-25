package function;

public class SignUpBase {
    private String newID = "";
    private String newPass = "";
    private String newName = "";

    private SignUpBaseCallBack callBack;

    public SignUpBase() {
    }

    public void SetCallBack(SignUpBaseCallBack callBack) {
        this.callBack = callBack;
    }

    /**
     * 注册时回调
     */
    @Deprecated
    public interface SignUpBaseCallBack {

        /**
         * 从外部获取 新用户名 输入
         * 
         * @param name
         * @return
         */
        String OnRequireName(String name);
    }
}