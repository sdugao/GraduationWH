package gra.gao.gra.interceptor;

import gra.gao.gra.dto.AdminDTO;
import gra.gao.gra.service.AdminService;
import gra.gao.gra.common.CommonConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author:gao
 * @date:2020/3/13
 * @time:22:22
 * @version:0.0.1
 * @description:none
 */

@Component
public class AdminLoginInterceptor implements HandlerInterceptor {

    @Autowired
    AdminService adminService;
    //检查是否管理员是否登录
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("进入管理员登录拦截器");
        AdminDTO adminDTO = (AdminDTO) request.getSession().getAttribute(CommonConst.AdminAttribute);
        String url = request.getRequestURI();
        if(adminDTO==null){

            System.out.println("拦截："+url);
            return  false;
        }
        boolean flag= adminService.determineAdminLogin(adminDTO);
        if(flag==false){
            System.out.println("拦截："+url);
        }
        else{
            System.out.println("放行："+url);
        }
        return flag;
    }
}
