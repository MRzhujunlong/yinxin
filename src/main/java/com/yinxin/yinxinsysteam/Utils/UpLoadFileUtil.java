package com.yinxin.yinxinsysteam.Utils;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;


/**
 * 图片路径保存
 * */
public class UpLoadFileUtil {
    public static String upLoadFile(HttpServletRequest request, MultipartFile imgName, String mypath){
        System.out.println("====================file名字===="+imgName.getName());
        ServletContext context = request.getServletContext();
        String path=context.getRealPath("/img/"+mypath+"/");
        System.out.println("获取path值："+path);
        //String path="/yinxin/img/"+mypath+"/";
        //String path ="D:\\img\\"+mypath+"\\";  //本地测试 可用，图片上传服务器 还需要更改标识符
         //String path ="G:\\tomcat安装目录\\apache-tomcat-8.5.50\\webapps\\yinxin\\uploads\\"+mypath+"\\";   //本地图片保存路径
        //String getImgPath = "localhost:8080/yinxin/uploads/"+mypath+"/"; //本地存进数据库在前端界面获取图片的路径


        //判断这个文件夹是否存在，不存在则创建
        File mainfile = new File(path);
        if (!mainfile.exists()) {
            mainfile.mkdirs();
        }



        //1.先得到名字
        String fileName = UUID.randomUUID().toString();
        String fileNames=imgName.getOriginalFilename();
        //2.得到扩展名
        String extend = fileNames.substring(fileNames.lastIndexOf("."));
        //3.得到完整文件名
        fileName+=extend;
        File fileover=new File(mainfile+"\\"+fileName);   //文件上传到服务器  还需要更改
        System.out.println("===================================开始保存文件");
        try {
            imgName.transferTo(fileover);
        } catch (IOException e) {
            e.printStackTrace();
        }
      /*  System.out.println("====================================开始复制文件");
        try {
            FileCopyUtils.copy(fileover, new File(mainpath+fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        System.out.println(path+"前面是本地路径"+fileName);
        //String source = getImgPath+fileName; //服务器上所需要的最终图片访问路径
       // System.out.println("获取访问服务器上面图片地址的路径："+source);

        String source="/yinxin/img/"+mypath+"/"+fileName;  //服务器本地图片的保存路径
        //String source = path+fileName;
        return source;
    }
}
