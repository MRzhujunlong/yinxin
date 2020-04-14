package com.yinxin.yinxinsysteam.Entity;
/**
 * 图片实体类
 * */

public class IndexImgEntity {
    private Integer Imgid;
    private String Imgurl;
    private String Imgdistinction;

    @Override
    public String toString() {
        return "IndexImgEntity{" +
                "Imgid=" + Imgid +
                ", Imgurl='" + Imgurl + '\'' +
                ", Imgdistinction='" + Imgdistinction + '\'' +
                '}';
    }

    public Integer getImgid() {
        return Imgid;
    }

    public void setImgid(Integer imgid) {
        Imgid = imgid;
    }

    public String getImgurl() {
        return Imgurl;
    }

    public void setImgurl(String imgurl) {
        Imgurl = imgurl;
    }

    public String getImgdistinction() {
        return Imgdistinction;
    }

    public void setImgdistinction(String imgdistinction) {
        Imgdistinction = imgdistinction;
    }
}
