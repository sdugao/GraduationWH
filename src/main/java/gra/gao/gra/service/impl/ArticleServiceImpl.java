package gra.gao.gra.service.impl;

import gra.gao.gra.dto.ArticleCatalogDTO;
import gra.gao.gra.dto.ArticleDTO;
import gra.gao.gra.entity.Article;
import gra.gao.gra.mapper.ArticleCatalogMapper;
import gra.gao.gra.mapper.ArticleMapper;
import gra.gao.gra.service.ArticleService;
import gra.gao.gra.util.CommonCode;
import gra.gao.gra.util.CommonConst;
import gra.gao.gra.util.JsonOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author:gao
 * @date:2020/3/16
 * @time:14:54
 * @version:0.0.1
 * @description:none
 */

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    ArticleCatalogMapper articleCatalogMapper;

    @Override
    public String writeArticle(ArticleDTO articleDTO) {

        Article article =new Article();
        article.setContent(articleDTO.getContent());
        article.setG_type(articleDTO.getG_type());
        article.setGmt_created(new Date());
        article.setGmt_updated(new Date());
        article.setTag(articleDTO.getTag());
        article.setTittle(articleDTO.getTittle());

        int i;
        try {
            i = articleMapper.insertSelective(article);
        }catch (Exception e){
            i=0;
            e.printStackTrace();
        }
        String json;
        if(i==1){
            json= JsonOperator.getStatusJson(true);
        }
        else{
            json = JsonOperator.getStatusJson(false);
        }
        return json;
    }

    @Override
    public String updateArticle(ArticleDTO articleDTO) {
        Article article =new Article();
        article.setContent(articleDTO.getContent());
        article.setG_type(articleDTO.getG_type());
        article.setGmt_updated(new Date());
        article.setTag(articleDTO.getTag());
        article.setTittle(articleDTO.getTittle());
        article.setId(articleDTO.getId());

        int i;
        try {
            i = articleMapper.updateByPrimaryKeySelective(article);
        }catch (Exception e){
            i=0;
            e.printStackTrace();
        }
        String json;
        if(i==1){
            json= JsonOperator.getStatusJson(true);
        }
        else{
            json = JsonOperator.getStatusJson(false);
        }
        return json;
    }

    @Override
    public String getArticleCatalog(Integer pages) {
        pages--;
        List<ArticleCatalogDTO> list = articleCatalogMapper.selectCatalogByPage(pages, CommonConst.ArticleCatalogEveryPage);
        String json= JsonOperator.getMSGJson(list, CommonCode.SUCCESS);
        return json;
    }
}
