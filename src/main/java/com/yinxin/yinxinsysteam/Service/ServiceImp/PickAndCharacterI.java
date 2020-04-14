package com.yinxin.yinxinsysteam.Service.ServiceImp;

import com.yinxin.yinxinsysteam.Entity.Charactor;
import com.yinxin.yinxinsysteam.Entity.HomeImg;
import com.yinxin.yinxinsysteam.Entity.ImgAndCharactorEntity;
import com.yinxin.yinxinsysteam.Entity.IndexImgEntity;
import com.yinxin.yinxinsysteam.MapperInterf.PickAndCharactorMapperInter;
import com.yinxin.yinxinsysteam.Service.AddPandChar;
import com.yinxin.yinxinsysteam.Utils.DeleteImgUtil;
import com.yinxin.yinxinsysteam.Utils.UpLoadFileUtil;
import org.apache.ibatis.javassist.bytecode.CodeAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 图片和文字操作 ，业务层
 * */

@Service
public class PickAndCharacterI implements AddPandChar {

    @Autowired
    private PickAndCharactorMapperInter pickAndCharactorMapperInter;

    //首页图片添加功能 ，接收图片路径和唯一标识符
    @Override
    public int AddHomeImg(HttpServletRequest request,MultipartFile file,String directory) {
        //插入图片时，应该根据图片的标识符来确定数据库是否已经有三张图片了
        int allImgNumber = pickAndCharactorMapperInter.findAllHomeImgNumber();
        System.out.println("llllllllll:"+allImgNumber
        );
        if (allImgNumber ==3){
            return -20;
        }
        String imgPath = UpLoadFileUtil.upLoadFile(request,file,directory); //调用图片保存工具类，获取图片路径
        System.out.println("获取保存的路径："+imgPath);

        return pickAndCharactorMapperInter.AddHomeImg(imgPath);
    }

    /**
     *  根据标识符，单独的图片添加
     * */
    @Override
    public int OnlyAddImg(HttpServletRequest request,MultipartFile file, String img_distinction) {
        if (img_distinction !=null && img_distinction !=""){
            String path = UpLoadFileUtil.upLoadFile(request,file,img_distinction);
           int result =  pickAndCharactorMapperInter.addOnlyImg(path,img_distinction);
           if (result > 0){
               return 200;
           }
        }

        return -500;
    }


    /**
     * 单独的文字添加功能
     * */
    @Override
    public int AddOnly_Charactor(String text, String text_distinction) {
        if (text !=null && text !="" && text_distinction !="" && text_distinction !=null){
                String charactorSize = pickAndCharactorMapperInter.FindOnlyText(text_distinction);
                if (charactorSize !=null && charactorSize !=""){
                    return -500;
                }
                    return pickAndCharactorMapperInter.addCharactor(text,text_distinction);
                }

        return -1;
    }

    /**
     * 添加图片+文字的功能
     * */
    @Override
    public int AddImgAndCharactor(HttpServletRequest request, MultipartFile file, IndexImgEntity indexImgEntity, Charactor charactor) {
        if (file !=null && indexImgEntity !=null  && charactor.getTtext() !=null && charactor.getTtext() !="" && charactor.getTdistinction() !=null && charactor.getTdistinction() !=""){

            String img_path = UpLoadFileUtil.upLoadFile(request,file,indexImgEntity.getImgdistinction()); //获取保存图片的路径
            //保存图片
            indexImgEntity.setImgurl(img_path);
            int img_id = pickAndCharactorMapperInter.addImgReturnId(indexImgEntity);
            if (img_id <1){
                return -200;
            }

            System.out.println("插入数据后获取该数据id："+img_id+"获取返回的主键id："+indexImgEntity.getImgid());
            //已获取插入图片表的id，直接保存到对象里面
            charactor.setImgid(indexImgEntity.getImgid());
            //将文字对象保存进数据库
            int allresult =  pickAndCharactorMapperInter.addText(charactor);
            if (allresult >=1){
                return allresult;
            }
        }
        return -200;
    }



    /**
     * 只获取文字的功能
     * */
    @Override
    public String FindlistCharactor(String t_distinction) {
        if (t_distinction !=null && t_distinction !=""){
            return pickAndCharactorMapperInter.FindOnlyText(t_distinction);

        }
        return null;
    }

    /**
     * 只获取首页图片数据
     * */
    @Override
    public List<HomeImg> findAllImgByDistinction() {

        return pickAndCharactorMapperInter.findAllHomeImg();
    }

    /**
     *  根据图片的标识符， 来获取指定图片
     * */
    @Override
    public List<IndexImgEntity> getOnlyImgByDistinction(String img_distinction) {
        if (img_distinction !=null && img_distinction !=""){
            return pickAndCharactorMapperInter.getOnlyImgByDistinction(img_distinction);
        }
        return null;
    }


    /**
     * 根据唯一标识符，分页查询图片和文字信息
     * */
    @Override
    public Map<String,Object> limitImgAndCharactor(String distinction, Integer page) {
        if (page == null || page < 0){
            return  null;
        }
        page = page * 5;
        Map<String,Object> allObject = new HashMap<>();
        List<ImgAndCharactorEntity> array = pickAndCharactorMapperInter.limitImgAndCharactorByImg_distinction(distinction,page);
        int pageCounts = pickAndCharactorMapperInter.sellAllPage(distinction);
        int pageTotals = pageCounts % 5 == 0 ? pageCounts/5:pageCounts/5+1;
        System.out.println("获取总页数："+pageTotals);
        allObject.put("alldata",array);
        allObject.put("pagetotals",pageTotals);
        return allObject;
    }

    /**
     *   主页获取业务和伙伴数据
     * */
    @Override
    public Map<String, Object> getAllYewuAndHuoban(String distinction) {
        Map<String,Object> allObject = new HashMap<>();
        List<ImgAndCharactorEntity> array = pickAndCharactorMapperInter.getHuobanAndYewu(distinction);
        allObject.put("alldata",array);
        return allObject;
    }

    /**
     * 根据首页图片id，删除图片
     * */

    @Override
    @Transactional
    public int deleteHomeImgById(Integer homeImgId) {
        if (homeImgId == null || homeImgId <= 0 ){
            return -500;
        }
        try {
            String img_url = pickAndCharactorMapperInter.getImgUrlByImg_id(homeImgId);
            int deleteImgResult = DeleteImgUtil.delteImgByUrl(img_url);
            if (deleteImgResult != 200){
                return  -500;
            }
        }catch (RuntimeException e){
            return -500;
        }


        return pickAndCharactorMapperInter.deleteHomeImgById(homeImgId);
    }




    /**
     * 根据 图片id，删除图片和文字数据
     * */
    @Override
    @Transactional
    public int deleteImgAndCharactorByid(Integer imgIds) {
       /* List<Integer> imgsList = Arrays.asList(imgIds);
        if (imgsList.size() <=0){
            return -500;
        }
        for (int i = 0; i < imgsList.size(); i++) {
            System.out.println("获取数组数据："+imgIds[i]);
            int img_id = imgIds[i];
        }
        return -500;
        */
       if (imgIds ==null || imgIds <=0){
           return -500;
       }
        String img_url = pickAndCharactorMapperInter.getImgUrlByImg_id(imgIds);
        System.out.println("根据图片id获取到了图片路径："+img_url);
        try {
            int c_result = pickAndCharactorMapperInter.deleteCharactorByImg_id(imgIds);
            int i_result = pickAndCharactorMapperInter.deleteImgById(imgIds);
            int deleteimg_result =  DeleteImgUtil.delteImgByUrl(img_url);
            if (c_result > 0 || i_result > 0 && deleteimg_result > 0){
                return 200;
            }
        }catch (RuntimeException e){
            return  -500;
        }
        return -500;
    }

    /**
     *      根据文字id，删除文字数据
     * */
    @Override
    @Transactional
    public int deleteOnlyCharactorById(Integer tid) {
        if (tid == null || tid <= 0 ){
            return -500;
        }
        try {
            int result = pickAndCharactorMapperInter.deleteOnlyCharactorById(tid);
            if (result != 1){
                return -500;
            }
        }catch (RuntimeException e){
            return  -500;
        }

        return 200;
    }



}
