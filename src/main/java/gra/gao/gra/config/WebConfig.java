package gra.gao.gra.config;

import gra.gao.gra.interceptor.AdminLoginInterceptor;
import gra.gao.gra.interceptor.VisitInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author:gao
 * @date:2020/3/13
 * @time:23:21
 * @version:0.0.1
 * @description:none
 */

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    VisitInterceptor visitInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截全部请求，做访问统计
        registry.addInterceptor(visitInterceptor).excludePathPatterns("/admin/**").addPathPatterns("/");
        //拦截访问后台的接口
        registry.addInterceptor(new AdminLoginInterceptor())
                    .excludePathPatterns("/admin/login")
                    .addPathPatterns("/admin/**");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //registry.addViewController("/admin/login").setViewName("/html/adminLogin.html");
        registry.addViewController("/").setViewName("/html/atcCatalog.html");
    }


}

