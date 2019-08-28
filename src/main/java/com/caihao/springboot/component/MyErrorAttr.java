package com.caihao.springboot.component;

import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author CaiHao
 * @create 2019-08-28 22:10:22
 */

@Component
public class MyErrorAttr  extends DefaultErrorAttributes{

    @Override
    public Map<String, Object> getErrorAttributes(org.springframework.web.reactive.function.server.ServerRequest request, boolean includeStackTrace) {
        Map<String, Object> objectMap = super.getErrorAttributes(request, includeStackTrace);

        objectMap.put("company","caihao");


        return objectMap;
    }
}
