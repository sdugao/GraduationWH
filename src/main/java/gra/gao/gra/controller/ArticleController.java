package gra.gao.gra.controller;

import gra.gao.gra.service.ArticleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author:gao
 * @date:2020/3/16
 * @time:14:38
 * @version:0.0.1
 * @description:none
 */

@RestController()
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @ApiOperation("返回文章目录信息")
    @GetMapping("/catalog/{page}")
    public String getArticlesCatalogByPage(@PathVariable Integer page){
        String catalogJSON = articleService.getArticleCatalog(page);
        return catalogJSON;
    }


    @ApiOperation("返回具体文章详细信息")
    @PostMapping("/details/{id}")
    public String getArticlesDetailsByID(){
        return null;
    }
}
