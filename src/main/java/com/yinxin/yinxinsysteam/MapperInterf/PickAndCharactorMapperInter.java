package com.yinxin.yinxinsysteam.MapperInterf;

import com.yinxin.yinxinsysteam.Entity.Charactor;
import com.yinxin.yinxinsysteam.Entity.HomeImg;
import com.yinxin.yinxinsysteam.Entity.ImgAndCharactorEntity;
import com.yinxin.yinxinsysteam.Entity.IndexImgEntity;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 图片文字操作dao层
 * */

public interface PickAndCharactorMapperInter {

    //主页图片数据 存进数据库
    int AddHomeImg(String imgPath);

    /**
     * 单独添加图片，保存唯一标识符
     * */
    int addOnlyImg(@Param("path") String path,@Param("img_distinction") String img_distinction);

    /**文字添加功能
     * */
    int addCharactor(String text,String text_distinction);

    /**插入图片后就获取该数据的id，根据图片标识符获取图片id
     * */
    int addImgReturnId(IndexImgEntity indexImgEntity);

    /**
     * 将文字信息保存进数据库
     * */
    int addText(Charactor charactor);

    /**
     * 只获取文字数据
     * */
    String FindOnlyText(String t_distinction);

    /**
     * 只查询首页图片数据
     * */
    List<HomeImg> findAllHomeImg();



    /**
     * 查询首页图片的数量
     * */
    int findAllHomeImgNumber();

    /**
     * 根据唯一标识符和分页信息，查询图片+文字信息
     * */
    List<ImgAndCharactorEntity> limitImgAndCharactorByImg_distinction(@Param("distinction") String distinction,@Param("page") Integer page);

    /**
     *  获取总页数
     * */
    int sellAllPage(String img_distinction);

    /**
     * 根据图片唯一标识符，获取图片
     * */
    List<IndexImgEntity> getOnlyImgByDistinction(String img_distinction);

    /**
     * 根据首页图片id 删除图片
     * */
    int deleteHomeImgById(Integer homeImgId);


    /**
     * 根据图片id 删除 图片
     * */
    int deleteImgById(Integer imgid);

    /**
     * 根据图片id 删除文字
     * */
    int deleteCharactorByImg_id(Integer imgid);


    /**
     *   根据文字id 删除数据
     *
     * */
    int deleteOnlyCharactorById(int tid);

    /**
     * 根据图片id，获取图片url
     * */
    String getImgUrlByImg_id(int img_id);


    /**
     *  根据标识符，获取核心业务及合作伙伴
     * */
    List<ImgAndCharactorEntity> getHuobanAndYewu(String distinction);
}
