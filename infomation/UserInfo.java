package infomation;

/**
 * userInfo
 * 
 * @author Kpurek
 * @version 1.0
 */
public class UserInfo extends InfoBase {

    /**
     *
     */
    private static final long serialVersionUID = -4159540016928697934L;

    private String password = "";

    public String email = "";

    public String phoneNumber = "";

    public UserInfo(String id, String name) {
        super(id, name);
    }

    public String getPass() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

}