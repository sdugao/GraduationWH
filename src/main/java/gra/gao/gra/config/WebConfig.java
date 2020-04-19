package gra.gao.gra.config;

import gra.gao.gra.entity.Guest;
import gra.gao.gra.interceptor.AdminLoginInterceptor;
import gra.gao.gra.interceptor.GuestLoginInterceptor;
import gra.gao.gra.interceptor.VisitInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @author:gao
 * @date:2020/3/13
 * @time:23:21
 * @version:0.0.1
 * @description:none
 */

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截全部请求，做访问统计
        registry.addInterceptor(getVI()).excludePathPatterns("/admin/**").addPathPatterns("/html/*.html");
        //拦截访问后台的接口
        registry.addInterceptor(getALI())
                    .excludePathPatterns("/admin/login")
                    .addPathPatterns("/admin/**");
        //拦截修改用户信息，判断登录
        registry.addInterceptor(getGL()).addPathPatterns("/guest/updateGuestInfo");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("/html/atcCatalog.html");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("POST", "GET")
                .maxAge(30*60)
                .allowCredentials(true);//设置成允许操作cookie
    }

    @Bean
    public AdminLoginInterceptor getALI(){
        return new AdminLoginInterceptor();
    }

    @Bean
    public VisitInterceptor getVI(){
        return new VisitInterceptor();
    }

    @Bean
    public GuestLoginInterceptor getGL(){
        return new GuestLoginInterceptor();
    }
}

