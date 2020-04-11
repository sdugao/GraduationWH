package gra.gao.gra.controller;

import gra.gao.gra.dto.CommentDTO;
import gra.gao.gra.service.ArticleService;
import gra.gao.gra.service.CommentService;
import io.swagger.annotations.ApiOperation;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author:gao
 * @date:2020/3/16
 * @time:14:38
 * @version:0.0.1
 * @description:none
 */

@RestController
@RequestMapping("/articles")
@CrossOrigin
public class ArticleController {

    @Autowired
    ArticleService articleService;
    @Autowired
    CommentService commentService;


    @ApiOperation("返回文章目录信息")
    @GetMapping("/catalog/{page}")
    public String getArticlesCatalogByPage(@PathVariable Integer page){
        if(page==null){
            page = Integer.valueOf(1);
        }
        String catalogJSON = articleService.getArticleCatalog(page);
        return catalogJSON;
    }

    @ApiOperation("返回具体文章详细信息")
    @PostMapping("/details/{id}")
    public String getArticlesDetailsByID(@NonNull @PathVariable Long id){
        String detailsJSON = articleService.getArticleByID(id);
        return detailsJSON;
    }


    @ApiOperation("根据文章id查询评论")
    @PostMapping("/comment/{id}")
    public String getCommentByID(@NonNull @PathVariable Long id){
        String commentJSON = commentService.getCommentByArticleID(id);
        return commentJSON;
    }

    @ApiOperation("添加评论")
    @PostMapping("/comment/reply")
    public String getCommentByID(@NonNull @RequestBody CommentDTO dto){
        String replyStatusJSON= commentService.createComment(dto);
        return replyStatusJSON;
    }


    @ApiOperation("文章页数")
    @PostMapping("/catalog/pagenum")
    public String getCatalogPageNum(){
        String JSON= articleService.getCatalogPageNum();
        return JSON;
    }
}
