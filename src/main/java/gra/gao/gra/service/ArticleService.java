package gra.gao.gra.service;

import gra.gao.gra.dto.ArticleDTO;

public interface ArticleService {

    public String  writeArticle(ArticleDTO articleDTO);
    public String updateArticle(ArticleDTO articleDTO);
    public String getArticleCatalog(Integer pages);
}
