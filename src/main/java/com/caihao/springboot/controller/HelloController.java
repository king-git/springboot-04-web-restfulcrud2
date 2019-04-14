package com.caihao.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author CaiHao
 * @create 2019-04-13 17:09:51
 */

@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){

        return "hello world!";
    }


    @RequestMapping("/success")
    public String success(HashMap<String, Object> map){
        map.put("hello","你好！");
        return "success";
    }

   /*
    //经过模板引擎重定义首页
    @RequestMapping({"/","index.html"})
    public String index(){
        return "index";
    }
    */




}
