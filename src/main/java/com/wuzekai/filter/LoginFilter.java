package com.wuzekai.filter;

import com.wuzekai.pojo.UserInfo;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //查看session中 有没有用户信息 
        HttpSession session  = httpServletRequest.getSession();
        
        //如果没有?如果有?
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        if(userInfo==null){
            //根据URI进行判定，如果是请求登录和注册，我就返回true，否则返回false
            String requestURI = httpServletRequest.getRequestURI();
            if(requestURI.equals("/loginUserInfo")||requestURI.equals("/registerUserInfo")||requestURI.equals("/login.html")||requestURI.equals("/reg.html")){
                    return true;
            }

        }else{
            return true;
        }
        return false;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
