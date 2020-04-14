package com.yinxin.yinxinsysteam.Entity;

public class ImgAndCharactorEntity {
    private Integer Imgid;
    private String Imgurl;
    private String Imgdistinction;
    private Charactor charactor;



    @Override
    public String toString() {
        return "ImgAndCharactorEntity{" +
                ", Imgid=" + Imgid +
                ", Imgurl='" + Imgurl + '\'' +
                ", Imgdistinction='" + Imgdistinction + '\'' +
                ", charactor=" + charactor +
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

    public Charactor getCharactor() {
        return charactor;
    }

    public void setCharactor(Charactor charactor) {
        this.charactor = charactor;
    }
}
