package network;

import java.io.Serializable;

abstract class Info implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -1776320323960104084L;

    public enum InfoType{
        User,
        Group
    }

    public InfoType infoType;

    public String ID;

    public String Name;
}
