package gra.gao.gra.interceptor;

import gra.gao.gra.entity.Log;
import gra.gao.gra.entity.Visit;
import gra.gao.gra.mapper.LogMapper;
import gra.gao.gra.mapper.VisitMapper;
import net.bytebuddy.dynamic.scaffold.MethodRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;
import java.net.SocketTimeoutException;
import java.util.Date;

/**
 * @author:gao
 * @date:2020/4/5
 * @time:18:19
 * @version:0.0.1
 * @description:none
 */

@Component
public class VisitInterceptor implements HandlerInterceptor {
    @Autowired
    LogMapper logMapper;
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        Log log = new Log();
        log.setContent("访问");
        log.setGmt_created(new Date());
        log.setGmt_updated(new Date());
        log.setOperated_by("none");
        log.setUrl(request.getRequestURI());
        log.setIp(request.getRemoteAddr());
        System.out.println("访问："+log.toString());
        logMapper.insert(log);
        return true;
    }
}
