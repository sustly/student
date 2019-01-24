package com.sinuonan.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    private static final String[] IGNORE_URI = {"/login"};

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        boolean flag = false;
        String servletPath = request.getServletPath();
        for(String s : IGNORE_URI) {
            if(servletPath.contains(s)) {
                flag = true;
                break;
            }
        }
        if(flag == false) {
            String id  = (String) request.getSession().getAttribute("id");
            if(id == null) {
                response.sendRedirect("/home/login");
            }else {
                flag = true;
            }
        }
        return flag;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
