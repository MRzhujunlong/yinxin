package com.yinxin.yinxinsysteam.Entity;

public class HomeImg {
    private Integer Himgid;
    private String Himgurl;


    @Override
    public String toString() {
        return "HomeImg{" +
                "Himgid=" + Himgid +
                ", Himgurl='" + Himgurl + '\'' +
                '}';
    }

    public Integer getHimgid() {
        return Himgid;
    }

    public void setHimgid(Integer himgid) {
        Himgid = himgid;
    }

    public String getHimgurl() {
        return Himgurl;
    }

    public void setHimgurl(String himgurl) {
        Himgurl = himgurl;
    }
}
