package com.yinxin.yinxinsysteam.Utils;


import java.io.File;

/**
 *     根据图片路径，删除真实图片
 *
 * */
public class DeleteImgUtil {

    public static int delteImgByUrl(String img_url) {
        String allpath = "D:\\tomcat\\apache-tomcat-8.5.50\\webapps";
        String IMG_PATH = allpath+img_url;

            System.out.println("删除图片开始");
            System.out.println("开始执行，图片路径为" + IMG_PATH);
            File file = new File(IMG_PATH);
            //判断文件是否存在
            if (file.exists() == true) {
                System.out.println("图片存在，可执行删除操作");
                Boolean flag = false;
                flag = file.delete();
                if (flag) {
                    System.out.println("成功删除图片" + file.getName());
                    return 200;
                } else {
                    System.out.println("删除失败");
                    return -500;
                }
            } else {
                System.out.println("图片不存在，终止操作");
                return -500;
            }

    }
}
