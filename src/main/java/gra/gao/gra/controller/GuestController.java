package gra.gao.gra.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation("返回用户登录信息")
    @GetMapping("/login")
    public String clientLogin(){
        return null;
    }

    @ApiOperation("返回用户评论信息")
    @PostMapping("/comment")
    public String clientComment(){
        return null;
    }
}
