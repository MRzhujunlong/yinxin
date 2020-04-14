package com.yinxin.yinxinsysteam.Utils;

/*平台管理专用*/
public class ManagerUtil {

    private Integer ok;
    private  String message;

    public Integer getOk() {
        return ok;
    }

    public void setOk(Integer ok) {
        this.ok = ok;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ManagerUtil() {
    }

    public ManagerUtil(Integer ok, String message) {
        this.ok = ok;
        this.message = message;
    }

    public static ManagerUtil ok(String message){
        return new ManagerUtil(200,message);
    }

    public static ManagerUtil error(String message){
        return new ManagerUtil(500,message);
    }

}
