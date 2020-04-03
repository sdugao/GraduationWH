package gra.gao.gra.entity;

public class ArticleWithBLOBs extends Article {
    private String content;

    private byte[] deleted;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public byte[] getDeleted() {
        return deleted;
    }

    public void setDeleted(byte[] deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", content=").append(content);
        sb.append(", deleted=").append(deleted);
        sb.append("]");
        return sb.toString();
    }
}