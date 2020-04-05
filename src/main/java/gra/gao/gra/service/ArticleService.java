package gra.gao.gra.service;

import gra.gao.gra.dto.ArticleDTO;

public interface ArticleService {

    public String writeArticle(ArticleDTO articleDTO);
    public String updateArticle(ArticleDTO articleDTO);
    public String deleteArticleByID(Long id);
    public String getArticleCatalog(Integer pages);
    public String getArticleByID(Long id);
    public String getArticleCatalogFromBin(Integer pages);
    public String recoverArticleByID(Long id);
    public String getTodayCommentsCount();
}
