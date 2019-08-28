package com.caihao.springboot.controller;

import com.caihao.springboot.exception.UserNoException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author CaiHao
 * @create 2019-08-28 21:46:15
 */

@ControllerAdvice
public class MyExceptionHandler {


    //浏览器和客户端 返回的都是json数据
    /*@ResponseBody
    @ExceptionHandler(UserNoException.class)
    public Map<String,Object> handleException(Exception e){
        Map<String,Object> map = new HashMap<>();
        map.put("code","user.notexist");
        map.put("message",e.getMessage());
        return map;
    }*/




    @ExceptionHandler(UserNoException.class)
    public String handleException(Exception e,HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();

        //传入我们自己的错误状态码，4xx，5xx,否则就不会进入定制错误页面的解析流程
        request.setAttribute("javax.servlet.error.status_code",500);

        map.put("code","user.notexist");
        map.put("message",e.getMessage());

        request.setAttribute("ext",map);
        //转发到 /error
        return "forward:/error";
    }




}
