package com.yinxin.yinxinsysteam.Controller;

import jdk.nashorn.internal.ir.ReturnNode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class Yinxin_home {


    @RequestMapping("/index")
    public String come(){
        return "/IndexHtml/testhtml.html";
    }

    @RequestMapping("/manager")
    public String manager(){
        return "/IndexHtml/managerHtml.html";
    }

    @RequestMapping("/addhomeimg")
    public String addhomeimh(){
        return "/IndexHtml/AddHtml/addHomeImg.html";
    }

    @RequestMapping("/addchractor")
    public String addcharactor(){
        return "/IndexHtml/AddHtml/addCharactor.html";
    }

    @RequestMapping("/xinwenaddImgAndCharactor")
    public String addimgAndCharactor(){
        return "/IndexHtml/AddHtml/xinwenaddImgAndCharactor.html";
    }

    @RequestMapping("/projectAddCharactorAndImg")
    public String projectAddCharactorAndImg(){return "/IndexHtml/AddHtml/projectAddCharactorAndImg.html";}

    @RequestMapping("/deletehomeimg")
    public String delteHomeImg(){
        return "/IndexHtml/DeleteHtml/deletehomeimg.html";
    }

    @RequestMapping("/addHome_imgAndCharactor")
    public String addhomeimgandcharactor(){
        return "/IndexHtml/AddHtml/addHome_imgAndCharactor.html";
    }

    @RequestMapping("/test")
    public String test(){
        return "/IndexHtml/test/test1.html";
    }

    @RequestMapping("/onlyaddimg")
    public String addonlyimg(){
        return "/IndexHtml/AddHtml/addzizhiImg.html";
    }

    @RequestMapping("/deleteCharactorById")
    public String deleteCharactorById(){
        return "/IndexHtml/DeleteHtml/deleteCharactorById.html";
    }

    @RequestMapping("/deleteCharactorAndImgById")
    public String deletecharactorandimg(){
        return "/IndexHtml/DeleteHtml/deleteImgAndCharactorById.html";
    }

    @RequestMapping("/addpartner")
    public String addpartner(){
        return "/IndexHtml/AddHtml/addpartners.html";
    }

}
