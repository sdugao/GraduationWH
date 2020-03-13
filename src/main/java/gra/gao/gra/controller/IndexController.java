package gra.gao.gra.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:gao
 * @date:2020/3/13
 * @time:21:10
 * @version:0.0.1
 * @description:none
 */

@RestController
public class IndexController {

    @ApiOperation("首页，显示博客文章列表界面")
    @GetMapping({"/","index"})
    public String index(){
        return "hello world!";
    }
}
