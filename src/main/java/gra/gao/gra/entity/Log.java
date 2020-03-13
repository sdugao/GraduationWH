package gra.gao.gra.entity;

import java.util.Date;

public class Log {
    private Long id;

    private Date gmt_created;

    private Date gmt_updated;

    private String url;

    private String ip;

    private String content;

    private String operated_by;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOperated_by() {
        return operated_by;
    }

    public void setOperated_by(String operated_by) {
        this.operated_by = operated_by;
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
        sb.append(", url=").append(url);
        sb.append(", ip=").append(ip);
        sb.append(", content=").append(content);
        sb.append(", operated_by=").append(operated_by);
        sb.append("]");
        return sb.toString();
    }
}