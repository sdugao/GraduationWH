package gra.gao.gra.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author:gao
 * @date:2020/4/3
 * @time:21:08
 * @version:0.0.1
 * @description:none
 */

@Data
public class CommentDTO {
    private Long id;//comment得id
    private Long article_id;//文章id
    @JSONField(format = "yyyy-MM-dd HH:mm")
    private Date gmt_updated;
    private String content;
    private Long author_id;//便于回复时找到作者
    private String author_username;
    private List<CommentDTO> child_comment;
}
