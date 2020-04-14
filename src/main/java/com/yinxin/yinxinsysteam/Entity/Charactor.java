package com.yinxin.yinxinsysteam.Entity;

/**  文字实体类
 * */
public class Charactor {

    private Integer Tid;
    private String Ttext;
    private Integer Imgid;
    private String Tdistinction;

    @Override
    public String toString() {
        return "Charactor{" +
                "Tid=" + Tid +
                ", Ttext='" + Ttext + '\'' +
                ", Imgid=" + Imgid +
                ", Tdistinction='" + Tdistinction + '\'' +
                '}';
    }

    public Integer getTid() {
        return Tid;
    }

    public void setTid(Integer tid) {
        Tid = tid;
    }

    public String getTtext() {
        return Ttext;
    }

    public void setTtext(String ttext) {
        Ttext = ttext;
    }

    public Integer getImgid() {
        return Imgid;
    }

    public void setImgid(Integer imgid) {
        Imgid = imgid;
    }

    public String getTdistinction() {
        return Tdistinction;
    }

    public void setTdistinction(String tdistinction) {
        Tdistinction = tdistinction;
    }
}
