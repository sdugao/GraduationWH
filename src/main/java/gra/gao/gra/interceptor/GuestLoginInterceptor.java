package gra.gao.gra.interceptor;

import gra.gao.gra.dto.GuestDTO;
import gra.gao.gra.service.GuestService;
import gra.gao.gra.common.CommonConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author:gao
 * @date:2020/3/16
 * @time:16:49
 * @version:0.0.1
 * @description:none
 */

//@Component
public class GuestLoginInterceptor implements HandlerInterceptor {

    @Autowired
    GuestService guestService;
    //检查是否管理员是否登录
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("进入拦截器");
        //GuestDTO guestDTO = (GuestDTO) request.getSession().getAttribute(CommonConst.GuestCookie);
        Cookie[] cookies = request.getCookies();
        String cookie_str=null;
        if(cookies!=null&&cookies.length!=0)
            for(Cookie cookie : cookies){
                if(cookie.getName().equals(CommonConst.GuestCookie)){
                    cookie_str=cookie.getValue();
                }
            }

        boolean flag=false;
            if(cookie_str!=null&&cookie_str.equals(""))
                flag= guestService.determineGuestLogin(cookie_str);
        if(flag==false){
            String url = request.getRequestURI();
            System.out.println("拦截："+url);
        }
        return flag;
    }
}
