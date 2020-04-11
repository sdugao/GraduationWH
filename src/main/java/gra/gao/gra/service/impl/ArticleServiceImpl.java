package gra.gao.gra.service.impl;

import com.alibaba.fastjson.JSONObject;
import gra.gao.gra.common.CommonJson;
import gra.gao.gra.dto.ArticleCatalogDTO;
import gra.gao.gra.dto.ArticleDTO;
import gra.gao.gra.entity.Article;
import gra.gao.gra.entity.Comment;
import gra.gao.gra.entity.CommentExample;
import gra.gao.gra.entity.Visit;
import gra.gao.gra.exception.DataBaseException;
import gra.gao.gra.mapper.ArticleCatalogMapper;
import gra.gao.gra.mapper.ArticleMapper;
import gra.gao.gra.mapper.CommentMapper;
import gra.gao.gra.mapper.VisitMapper;
import gra.gao.gra.service.ArticleService;
import gra.gao.gra.common.CommonCode;
import gra.gao.gra.common.CommonConst;
import gra.gao.gra.common.JsonOperator;
import gra.gao.gra.util.GmtTime;
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
    @Autowired
    CommentMapper commentMapper;


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
            //System.out.println("I:  "+i);
        }

        String json;
        if(i==1){
            json= JsonOperator.getStatusJson(true);
        }
        else{
            json = JsonOperator.getStatusJson(false);
        }
        //System.out.println(json);
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
        Article record = new Article();
        record.setId(id);
        record.setDeleted(true);
        int items;
        try {
             items = articleMapper.updateByPrimaryKeySelective(record);
        }catch (DataBaseException e){
            items=0;
            e.printStackTrace();
        }
        if(items==1){
            return JsonOperator.getStatusJson(true);
        }
        return JsonOperator.getStatusJson(false);
    }

    @Override
    public String getArticleCatalog(Integer pages) {

        pages--;
        List<ArticleCatalogDTO> list = articleCatalogMapper.selectCatalogByPage(pages*CommonConst.ArticleCatalogEveryPage, CommonConst.ArticleCatalogEveryPage);
        String json= JsonOperator.getMSGJson(list, CommonCode.SUCCESS);
        return json;
    }

    @Override
    public String getArticleByID(Long id) {
        Article article=articleMapper.selectByPrimaryKey(id);
        ArticleDTO articleDTO  =new ArticleDTO();
         if(article.getDeleted()==true){
            return JsonOperator.getStatusJson(false);
         }

        articleDTO.setContent(article.getContent());
        articleDTO.setG_type(article.getG_type());
        articleDTO.setId(article.getId());
        articleDTO.setTag(article.getTag());
        articleDTO.setTittle(article.getTittle());
        articleDTO.setGmt_updated(article.getGmt_updated());
        String json=JsonOperator.getMSGJson(articleDTO,CommonCode.SUCCESS);
        return json;
    }

    @Override
    public String getArticleCatalogFromBin(Integer pages) {
        pages--;
        List<ArticleCatalogDTO> list = articleCatalogMapper.selectCatalogFromBinByPage(pages, CommonConst.ArticleCatalogEveryPage);
        String json= JsonOperator.getMSGJson(list, CommonCode.SUCCESS);
        return json;
    }

    @Override
    public String recoverArticleByID(Long id) {
        Article record = new Article();
        record.setId(id);
        record.setDeleted(false);
        int items;
        try {
            items = articleMapper.updateByPrimaryKeySelective(record);
        }catch (DataBaseException e){
            items=0;
            e.printStackTrace();
        }
        if(items==1){
            return JsonOperator.getStatusJson(true);
        }
        return JsonOperator.getStatusJson(false);
    }

    @Override
    public String getTodayCommentsCount() {
        CommentExample ce = new CommentExample();
        CommentExample.Criteria cec = ce.createCriteria();
        Date zero = GmtTime.getTodayZeroClock();
        cec.andGmt_updatedBetween(zero,new Date());
        int code=CommonCode.ERROR;
        int nums=0;
        try {
            List<Comment> list_comment = commentMapper.selectByExample(ce);
            code=CommonCode.SUCCESS;
            nums=list_comment.size();
        }catch (DataBaseException e){
            e.printStackTrace();
        }
        String json = JsonOperator.getMSGJson(Integer.valueOf(nums),code);
        return json;
    }

    @Override
    public String getCatalogPageNum() {

        Integer pageNum;
        try {
            pageNum=articleCatalogMapper.selectArticleNum();
        }catch (DataBaseException e){
            e.printStackTrace();
            pageNum=-1;
        }
        String json;
        if(pageNum!=-1){
            pageNum--;
            pageNum/=CommonConst.ArticleCatalogEveryPage;
            pageNum++;
            json=JsonOperator.getMSGJson(pageNum, CommonCode.SUCCESS);
        }
        else{
            json=JsonOperator.getMSGJson(pageNum, CommonCode.ERROR);
        }
        return json;
    }

}
