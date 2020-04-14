package com.yinxin.yinxinsysteam.Controller;

import com.yinxin.yinxinsysteam.Entity.Charactor;
import com.yinxin.yinxinsysteam.Entity.HomeImg;
import com.yinxin.yinxinsysteam.Entity.IndexImgEntity;
import com.yinxin.yinxinsysteam.Service.ServiceImp.PickAndCharacterI;
import com.yinxin.yinxinsysteam.Utils.ManagerUtil;
import jdk.nashorn.internal.ir.ReturnNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 添加图片和文字
 * */

@Controller
@RequestMapping("/host")
public class ImgAndCharController {

    @Autowired
    private PickAndCharacterI addPickAndCharacterI;

    /**
     * 首页添加图片 , 接收前端传进来参数（图片，目录名，图片唯一标识符）
     * */
    @RequestMapping("/addHome_Img")
    @ResponseBody
    public ManagerUtil addPAndC(HttpServletRequest request, MultipartFile file, String directory){
        if (file !=null && directory !=null && directory !=""){
            int addHome_Img = addPickAndCharacterI.AddHomeImg(request,file,directory);
            if (addHome_Img == 1){
                return ManagerUtil.ok("添加成功");
            }else if (addHome_Img == -20){
                return ManagerUtil.error("已经有三张图片了，请删除再添加");
            }
        }

        return ManagerUtil.error("添加失败");
    }

    /**
     *     单独的图片添加
     * */
    @RequestMapping("/onlyAddImg")
    @ResponseBody
    public ManagerUtil addOnlyImg(HttpServletRequest request,MultipartFile file,String img_distinction){
        int result = addPickAndCharacterI.OnlyAddImg(request,file,img_distinction);
        if (result > 0){
            return ManagerUtil.ok("添加成功");
        }
        return  ManagerUtil.error("添加失败");
    }



    /**
     *单独添加添加文字
     */

    @RequestMapping("/addCharactor")
    @ResponseBody
    public ManagerUtil addTextAndCharactor(String text,String text_distinction){
        System.out.println("获取文字介绍："+text+"获取文字表示符："+text_distinction);
        int addCharactorResult = addPickAndCharacterI.AddOnly_Charactor(text,text_distinction);
        if (addCharactorResult >=1){
            return ManagerUtil.ok("添加成功");
        }else if (addCharactorResult == -500){
            return ManagerUtil.error("已有文字了，请删除再添加");
        }
        return ManagerUtil.error("添加失败");
    }

    /**
     * 文字+图片的添加(获取的参数有：图片、图片标识符、文字内容、文字标识符)
     */
    @RequestMapping("/addImg_Charactor")
    @ResponseBody
    public ManagerUtil add_img_charactor(HttpServletRequest request, MultipartFile file, IndexImgEntity indexImgEntity, Charactor charactor){
        System.out.println("获取对象属性："+indexImgEntity.getImgdistinction());

       int result = addPickAndCharacterI.AddImgAndCharactor(request,file,indexImgEntity,charactor);
       if (result >=1){
           return ManagerUtil.ok("添加成功");
       }
        return ManagerUtil.error("添加失败");
    }


    /**
     * 查询           图片及文字
     * */

    /**
     * 返回指定标识符的文字数据
     * */
    @RequestMapping("/getText")
    @ResponseBody
    public String getText(String text_distinction){
        return addPickAndCharacterI.FindlistCharactor(text_distinction);
    }

    /**
     * 首页图片的获取
     * */
    @RequestMapping("/getHomeImg")
    @ResponseBody
    public List<HomeImg> getIndexImg(){
        System.out.println("获取首页图片");
        return addPickAndCharacterI.findAllImgByDistinction();
    }

    /**
     *  根据图片标识符，单独获取图片数据
     * */
    @RequestMapping("/getOnlyImg")
    @ResponseBody
    public List<IndexImgEntity> getOnlyImgByDistinction(String img_distinction){
        return addPickAndCharacterI.getOnlyImgByDistinction(img_distinction);
    }


    /**
     *  返回图片+文字 数据  ， 可能会用到分页
     * */
    @RequestMapping("/getImgAndCharactorByDistinction")
    @ResponseBody
    public Map<String,Object> limitGetImgAndCharactors(String Imgdistinction , Integer page){
        return addPickAndCharacterI.limitImgAndCharactor(Imgdistinction,page);
    }

    /**
     *  根据标识符，获取主页的核心业务和合作伙伴
     * */
    @RequestMapping("/getyewuAndHuoban")
    @ResponseBody
    public Map<String,Object> getAllHuobanYewu(String Imgdistinction){
        return addPickAndCharacterI.getAllYewuAndHuoban(Imgdistinction);
    }


    /**
     * 删除功能
     * */
    /**
     * 删除首页图片功能
     * */
    @RequestMapping("/deleteHomeImgByIdAndUrl")
    @ResponseBody
    public ManagerUtil deleteHomeImg(Integer homeImg_id){
        int result = addPickAndCharacterI.deleteHomeImgById(homeImg_id);
        if (result >= 1 ){
            return ManagerUtil.ok("删除成功");
        }
        return ManagerUtil.error("删除失败");
    }


    /**
     * 删除 文字 和图片 功能
     *
     *  批量删除，前端参数必须是 图片和文字的img_id
     * */
    @RequestMapping("/deleteImgAndCharactorById")
    @ResponseBody
    public ManagerUtil deleteImgAndCharactor(Integer imgIds){  //@RequestParam(value = "imgIds[]") Integer[]
        System.out.println("获取前端的参数"+imgIds);
        int result = addPickAndCharacterI.deleteImgAndCharactorByid(imgIds);
        if (result != 200){
            return  ManagerUtil.error("删除失败");
        }
        return ManagerUtil.ok("删除成功");
    }


    /**
     *  删除文字单独的文字内容
     *
     * */
    @RequestMapping("/deleteOnlyCharctorById")
    @ResponseBody
    public ManagerUtil deleteOnlyCharctorById(Integer Tid){
        int result = addPickAndCharacterI.deleteOnlyCharactorById(Tid);
        if (result != 200){
            return ManagerUtil.error("删除失败");
        }
        return ManagerUtil.ok("删除成功");
    }



}
