package gra.gao.gra.service.impl;

import gra.gao.gra.dto.ArticleCatalogDTO;
import gra.gao.gra.dto.ArticleDTO;
import gra.gao.gra.entity.Article;
import gra.gao.gra.mapper.ArticleCatalogMapper;
import gra.gao.gra.mapper.ArticleMapper;
import gra.gao.gra.service.ArticleService;
import gra.gao.gra.common.CommonCode;
import gra.gao.gra.common.CommonConst;
import gra.gao.gra.common.JsonOperator;
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
    public String deleteArticleByID(Long id) {

        return null;
    }

    @Override
    public String getArticleCatalog(Integer pages) {
        pages--;
        List<ArticleCatalogDTO> list = articleCatalogMapper.selectCatalogByPage(pages, CommonConst.ArticleCatalogEveryPage);
        String json= JsonOperator.getMSGJson(list, CommonCode.SUCCESS);
        return json;
    }

    @Override
    public String getArticleByID(Long id) {
        Article article=articleMapper.selectByPrimaryKey(id);
        ArticleDTO articleDTO  =new ArticleDTO();
        //没设置删除功能，数据库中还未加上deleted
        /*
         if(article.getDeleted==true){
            return 没有
         }
         */
        articleDTO.setContent(article.getContent());
        articleDTO.setG_type(article.getG_type());
        articleDTO.setId(article.getId());
        articleDTO.setTag(article.getTag());
        articleDTO.setTittle(article.getTittle());
        articleDTO.setGmt_updated(article.getGmt_updated());
        String json=JsonOperator.getMSGJson(articleDTO,CommonCode.SUCCESS);
        return json;
    }
}
