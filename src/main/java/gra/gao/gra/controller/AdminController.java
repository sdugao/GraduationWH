package gra.gao.gra.controller;

import com.alibaba.fastjson.JSON;
import gra.gao.gra.dto.AdminDTO;
import gra.gao.gra.dto.ArticleDTO;
import gra.gao.gra.service.AdminService;
import gra.gao.gra.service.ArticleService;
import gra.gao.gra.common.CommonCode;
import gra.gao.gra.common.CommonConst;
import gra.gao.gra.common.CommonJson;
import io.swagger.annotations.ApiOperation;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author:gao
 * @date:2020/3/16
 * @time:14:29
 * @version:0.0.1
 * @description:none
 */

@RestController()
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;
    @Autowired
    ArticleService articleService;

    @ApiOperation("返回管理员登录信息")
    @PostMapping("/login")
    public String adminLogin(@NonNull @RequestBody AdminDTO dto, HttpServletRequest request){

        String uuid = adminService.adminLogin(dto);
        String json;
        if(uuid == null){
            CommonJson commonJson = new CommonJson();
            commonJson.setMessage("账号或密码错误！");
            commonJson.setCode(CommonCode.ERROR);
            json = JSON.toJSONString(commonJson);
        }else {
            dto.setUsername(CommonConst.AdminUsernameFront+dto.getUsername()+CommonConst.AdminUsernameBack);
            dto.setPassword(null);
            dto.setUUID(uuid);
            request.getSession().setAttribute(CommonConst.AdminAttribute,dto);
            CommonJson commonJson = new CommonJson();
            commonJson.setMessage("登录成功！");
            commonJson.setCode(CommonCode.SUCCESS);
            json = JSON.toJSONString(commonJson);
        }
        return json;
    }

    @ApiOperation("返回管理员主页信息")
    @PostMapping("/homepage")
    public String getHomepage(){
        return null;
    }

    @ApiOperation("返回管理员创建文章信息")
    @PostMapping("/articles/write")
    public String createArticles(@NonNull @RequestBody ArticleDTO articleDTO) {
        String status = articleService.writeArticle(articleDTO);
        return status;
    }


    @ApiOperation("返回管理员修改文章信息")
    @PostMapping("/articles/update")
    public String updateArticles(@NonNull @RequestBody ArticleDTO articleDTO) {
        String status = articleService.updateArticle(articleDTO);
        return status;
    }
}
