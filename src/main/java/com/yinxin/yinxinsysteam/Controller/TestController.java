package com.yinxin.yinxinsysteam.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/")
    public String index(){

        return "/yinxin_home/index.html";
    }

    @RequestMapping("/about")
    public String about(){

        return "/yinxin_home/about.html";
    }

    @RequestMapping("/news")
    public String news(){

        return "/yinxin_home/news.html";
    }

    @RequestMapping("/profile")
    public String profile(){

        return "/yinxin_home/profile.html";
    }
    @RequestMapping("/solution")
    public String solution(){

        return "/yinxin_home/solution.html";
    }

}
