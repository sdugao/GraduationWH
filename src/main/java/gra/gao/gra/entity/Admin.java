package gra.gao.gra.entity;

import java.util.Date;

public class Admin {
    private Long id;

    private Date gmt_created;

    private Date gmt_updated;

    private String username;

    private String nickname;

    private String g_password;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getG_password() {
        return g_password;
    }

    public void setG_password(String g_password) {
        this.g_password = g_password;
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
        sb.append(", username=").append(username);
        sb.append(", nickname=").append(nickname);
        sb.append(", g_password=").append(g_password);
        sb.append("]");
        return sb.toString();
    }
}