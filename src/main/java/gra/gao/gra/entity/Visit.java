package gra.gao.gra.entity;

import java.util.Date;

public class Visit {
    private Long id;

    private Date gmt_time;

    private String ip;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getGmt_time() {
        return gmt_time;
    }

    public void setGmt_time(Date gmt_time) {
        this.gmt_time = gmt_time;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", gmt_time=").append(gmt_time);
        sb.append(", ip=").append(ip);
        sb.append("]");
        return sb.toString();
    }
}