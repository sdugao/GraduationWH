package gra.gao.gra.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.deploy.net.HttpResponse;
import gra.gao.gra.common.CommonCode;
import gra.gao.gra.common.CommonConst;
import gra.gao.gra.common.JsonOperator;
import gra.gao.gra.dto.GuestDTO;
import gra.gao.gra.service.GuestService;
import io.swagger.annotations.ApiOperation;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;

/**
 * @author:gao
 * @date:2020/3/16
 * @time:14:41
 * @version:0.0.1
 * @description:none
 */

@RestController()
@RequestMapping("guest")
@CrossOrigin
public class GuestController {

    @Autowired
    GuestService guestService;

    @ApiOperation("返回用户登录信息")
    @PostMapping("/login")
    public String guestLogin(@NonNull @RequestBody GuestDTO guestDTO, HttpServletResponse response){
        GuestDTO dto=guestService.guestLogin(guestDTO);
        String json;
        if(dto!=null){
            json = JsonOperator.getMSGJson(dto, CommonCode.SUCCESS);
            Cookie cookie = new Cookie(CommonConst.GuestCookie,dto.getUUID());
            cookie.setMaxAge(60*60*24*7);//7天
            cookie.setPath("/");
            response.addCookie(cookie);
        }
        else{
            json = JsonOperator.getStatusJson(false);
        }
        return json;
    }

    @ApiOperation("uuid判断登录，获取登录信息")
    @PostMapping("/determineLogin")
    public String determineLogin(HttpServletRequest request) {
        Cookie[] cookies=request.getCookies();
        String uuid="";
        for(Cookie cookie : cookies){
            if(cookie.getName().equals(CommonConst.GuestCookie)){
                uuid = cookie.getValue();
            }
        }
        String  json =guestService.guestLoginByUUID(uuid);
        return json;
    }

    @ApiOperation("返回用户评论信息")
    @PostMapping("/comment")
    public String clientComment(){
        return null;
    }
}
