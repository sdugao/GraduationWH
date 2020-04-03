package gra.gao.gra.entity;

import java.util.Date;

public class Article {
    private Long id;

    private Date gmt_created;

    private Date gmt_updated;

    private String tittle;

    private String content;

    private String g_type;

    private String tag;

    private Boolean deleted;

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

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

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getG_type() {
        return g_type;
    }

    public void setG_type(String g_type) {
        this.g_type = g_type;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
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
        sb.append(", tittle=").append(tittle);
        sb.append(", content=").append(content);
        sb.append(", g_type=").append(g_type);
        sb.append(", tag=").append(tag);
        sb.append("]");
        return sb.toString();
    }
}