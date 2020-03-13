package gra.gao.gra.entity;

import java.util.Date;

public class Comment {
    private Long id;

    private Date gmt_created;

    private Date gmt_updated;

    private String content;

    private Boolean deleted;

    private Long author_id;

    private Long article_id;

    private Long parent_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getGmt_created() {
        return gmt_created;
    }

    public void setGmt_created(Date gmt_created) {
        this.gmt_created = gmt_created;
    }

    public Date getGmt_updated() {
        return gmt_updated;
    }

    public void setGmt_updated(Date gmt_updated) {
        this.gmt_updated = gmt_updated;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Long getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Long author_id) {
        this.author_id = author_id;
    }

    public Long getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Long article_id) {
        this.article_id = article_id;
    }

    public Long getParent_id() {
        return parent_id;
    }

    public void setParent_id(Long parent_id) {
        this.parent_id = parent_id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", gmt_created=").append(gmt_created);
        sb.append(", gmt_updated=").append(gmt_updated);
        sb.append(", content=").append(content);
        sb.append(", deleted=").append(deleted);
        sb.append(", author_id=").append(author_id);
        sb.append(", article_id=").append(article_id);
        sb.append(", parent_id=").append(parent_id);
        sb.append("]");
        return sb.toString();
    }
}