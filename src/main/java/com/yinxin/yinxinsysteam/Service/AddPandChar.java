package com.yinxin.yinxinsysteam.Service;

import com.yinxin.yinxinsysteam.Entity.Charactor;
import com.yinxin.yinxinsysteam.Entity.HomeImg;
import com.yinxin.yinxinsysteam.Entity.ImgAndCharactorEntity;
import com.yinxin.yinxinsysteam.Entity.IndexImgEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 添加图片和文字的接口
 * */
public interface AddPandChar {

    //主页添加图片
    int AddHomeImg(HttpServletRequest request,MultipartFile file,String directory);

    int OnlyAddImg(HttpServletRequest request,MultipartFile file,String img_distinction);


    //单独文字添加
    int AddOnly_Charactor(String text,String text_distinction);

    //图片文字添加功能
    int AddImgAndCharactor(HttpServletRequest request, MultipartFile file, IndexImgEntity indexImgEntity, Charactor charactor);

    //只获取文字的功能
    String FindlistCharactor(String t_distinction);

    //获取首页图片对象信息
    List<HomeImg> findAllImgByDistinction();

    //根据图片标识符，来获取指定图片
    List<IndexImgEntity> getOnlyImgByDistinction(String img_distinction);

    //根据唯一标识符，获取分页的图片+文字信息
    Map<String,Object> limitImgAndCharactor(String distinction, Integer page);

    //根据首页图片id，删除首页图片
    int deleteHomeImgById(Integer homeImgId);

    //根据标识符获取主页合作伙伴和核心业务的数据
    Map<String, Object> getAllYewuAndHuoban(String distinction);


    //根据图片id ，删除对应的图片和文字
    int deleteImgAndCharactorByid(Integer imgIds);


    //根据文字id ，删除文字数据
    int deleteOnlyCharactorById(Integer tid);
}
