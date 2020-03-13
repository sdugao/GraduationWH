package gra.gao.gra.interceptor;

import gra.gao.gra.dto.AdminDTO;
import gra.gao.gra.entity.Admin;
import gra.gao.gra.service.AdminService;
import org.omg.PortableInterceptor.Interceptor;
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
        System.out.println("进入拦截器");
        boolean flag=false;
        AdminDTO adminDTO = (AdminDTO) request.getSession().getAttribute("admin");
        if(adminDTO==null){
            flag=false;
        }else {
            AdminDTO dB_DTO=adminService.getAdminDTO();
            if(dB_DTO.equals(adminDTO)){
                flag=true;
            }else{
                flag=false;
            }
        }
        if(flag==false){
            String url = request.getRequestURI();
            System.out.println("拦截："+url);
        }
        return flag;
    }
}
