package com.zxl.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
*@author zhangxiaolong
*@version createtime:2021年4月18日 下午11:08:10
*
*/
@Component
public  class AuthInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String requestUrl = request.getRequestURI();
        if (checkAuth(requestUrl)) {
            return  true;
        }

        return  false;
    }

    private boolean checkAuth(String requestUrl) {
        System.out.println("===权限校验===");
        return  true;
    }
}
