package network;

public class UserInfo extends Info {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public UserInfo(InfoType infoType, String id) {
        super.infoType = infoType;
        super.ID = id;
    }

    public void setID(String id) {
        super.ID = id;
    }

    public String getID() {
        return super.ID;
    }

    public void setName(String name) {
        super.Name = name;
    }

    public String getName() {
        return super.Name;
    }
}
