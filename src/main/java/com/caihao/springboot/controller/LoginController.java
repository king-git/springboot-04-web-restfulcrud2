package com.caihao.springboot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * @author CaiHao
 * @create 2019-04-14 17:17:03
 */
@Controller
public class LoginController {

    @PostMapping("/user/login")
    //@RequestMapping(value="/user/login",method = RequestMethod.POST)
    public String login(@RequestParam("username")String username,
                        @RequestParam("password")String password,
                        HashMap<String,Object> map,
                        HttpSession session)
    {
        if(!StringUtils.isEmpty(username) && "123456".equals(password)){
            //登录成功,为防止表单重复提交，可以重定向到目标页面
//            return "dashboard";
            session.setAttribute("loginuser",username);

            //重定向到视图映射的页面
            return "redirect:/main.html";
        }else {
            //登录失败
            map.put("msg","用户名或密码错误！");
            return "login";
        }
    }

}
