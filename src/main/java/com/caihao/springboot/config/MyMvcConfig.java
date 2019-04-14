package com.caihao.springboot.config;

import com.caihao.springboot.component.LoginHandlerInterceptor;
import com.caihao.springboot.component.MyLocalResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @author CaiHao
 * @create 2019-04-13 21:10:10
 */


//使用WebMvcConfigurerAdapter可以来扩展springmvc的功能

//@EnableWebMvc
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //super.addViewControllers(registry);
        //浏览器发送 /atcaihao   请求 来到success 界面
        registry.addViewController("atcaihao").setViewName("success");

    }


    //所有的 WebMvcConfigurerAdapter 组件都会一起起作用
    //
    @Bean //将自己定义的组件注册到容器中
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){

        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {

            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                //super.addViewControllers(registry);
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");

                //登录成功的 视图映射
                registry.addViewController("/main.html").setViewName("dashboard");

            }


            //注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //super.addInterceptors(registry);
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/index.html","/","/user/login");

            }
        };

        return adapter;
    }

    //把我们自定的区域化资源解析组件加到容器中
    @Bean
    public LocaleResolver localeResolver(){

        return new MyLocalResolver();
    }





}
