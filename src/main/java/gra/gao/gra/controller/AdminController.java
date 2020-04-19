package gra.gao.gra.controller;

import com.alibaba.fastjson.JSON;
import gra.gao.gra.dto.AdminDTO;
import gra.gao.gra.dto.AdminPWD_DTO;
import gra.gao.gra.dto.ArticleDTO;
import gra.gao.gra.dto.CommentDTO;
import gra.gao.gra.entity.Admin;
import gra.gao.gra.service.AdminService;
import gra.gao.gra.service.ArticleService;
import gra.gao.gra.common.CommonCode;
import gra.gao.gra.common.CommonConst;
import gra.gao.gra.common.CommonJson;
import gra.gao.gra.service.CommentService;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author:gao
 * @date:2020/3/16
 * @time:14:29
 * @version:0.0.1
 * @description:none
 */

@RestController()
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {

    @Autowired
    AdminService adminService;
    @Autowired
    ArticleService articleService;
    @Autowired
    CommentService commentService;

    @ApiOperation("返回管理员登录信息")
    @PostMapping("/login")
    public String adminLogin(@NonNull @RequestBody AdminDTO dto, HttpServletResponse response){

        String uuid = adminService.adminLogin(dto);
        String json;
        if(uuid == null){
            CommonJson commonJson = new CommonJson();
            commonJson.setMessage("账号或密码错误！");
            commonJson.setCode(CommonCode.ERROR);
            json = JSON.toJSONString(commonJson);
        }else {
//            dto.setUsername(CommonConst.AdminUsernameFront+dto.getUsername()+CommonConst.AdminUsernameBack);
//            dto.setPassword(null);
//            dto.setUUID(uuid);
//            request.getSession().setAttribute(CommonConst.AdminAttribute,dto);
//            request.getSession().setMaxInactiveInterval(60 * 60 * 24);
//            System.out.println(request.getSession().getAttribute(CommonConst.AdminAttribute));
            //设置token
            Cookie cookie = new Cookie(CommonConst.AdminCookie,uuid);
            cookie.setMaxAge(60*60*1);//一小时
            cookie.setPath("/");
            //cookie.setDomain("localhost");
            response.addCookie(cookie);
            CommonJson commonJson = new CommonJson();
            commonJson.setMessage("登录成功！");
            commonJson.setCode(CommonCode.SUCCESS);
            json = JSON.toJSONString(commonJson);
        }
        return json;
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


    @ApiOperation("删除文章")
    @PostMapping("articles/delete/{id}")
    public String deleteArticleByID(@NonNull @PathVariable Long id){
        String detailsJSON = articleService.deleteArticleByID(id);
        return detailsJSON;
    }


    @ApiOperation("恢复文章")
    @PostMapping("articles/recover/{id}")
    public String recoverArticleByID(@NonNull @PathVariable Long id){
        String detailsJSON = articleService.recoverArticleByID(id);
        return detailsJSON;
    }

    @ApiOperation("回收站文章页数")
    @PostMapping("articles/bin/catalog/pagenum")
    public String getCatalogPageNum(){
        String JSON= articleService.getCatalogPageNumInBin();
        return JSON;
    }

    @ApiOperation("返回垃圾桶文章目录信息")
    @GetMapping("articles/bin/catalog/{page}")
    public String getArticlesCatalogFromBinByPage(@PathVariable Integer page){
        if(page==null){
            page = Integer.valueOf(1);
        }
        String catalogJSON = articleService.getArticleCatalogFromBin(page);
        return catalogJSON;
    }

    @ApiOperation("获取今日评论数")
    @PostMapping("/articles/comment/today")
    public String getTodayCommentsCount(){
        String countJSON= articleService.getTodayCommentsCount();
        return countJSON;
    }

    @ApiOperation("注销登录")
    @PostMapping("/logout")
    public String logout(HttpServletResponse response){

        Cookie cookie = new Cookie(CommonConst.AdminCookie,"");
        cookie.setMaxAge(0);//一小时
        cookie.setPath("/");
        response.addCookie(cookie);
        //清空数据库的uuid
        String json =adminService.clearUUID();
        return json;
    }


    @ApiOperation("管理员获取具体文章详细信息（可获取已删除的）")
    @PostMapping("articles/details/{id}")
    public String getArticlesDetailsByID(@NonNull @PathVariable Long id){
        String detailsJSON = articleService.getArticleByIDForAdmin(id);
        return detailsJSON;
    }

    @ApiOperation("修改密码")
    @PostMapping("update/pwd")
    public String updataPWD(@NonNull @RequestBody AdminPWD_DTO dto){
        String detailsJSON = adminService.updatePWD(dto);
        return detailsJSON;
    }


    @ApiOperation("获取未读评论")
    @PostMapping("articles/comment/notread")
    public String getCommentNotRead(){
        String detailsJSON = commentService.back_getCommentNotRead();
        return detailsJSON;
    }

    @ApiOperation("获取指定日期前的评论")
    @PostMapping("articles/comment/after/{date}")
    public String getCommentAll(@PathVariable("date") Date date){
        String detailsJSON = commentService.back_getCommentAfterDate(date);
        return detailsJSON;
    }

    @ApiOperation("将评论标记为已读")
    @PostMapping("/articles/comment/delete/{id}")
    public String markRead(@PathVariable("id") Long id){
        String detailsJSON = commentService.markRead(id);
        return detailsJSON;
    }


    //String日期解析成Date
    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {

        //转换日期
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
    }
}
