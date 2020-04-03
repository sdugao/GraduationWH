package gra.gao.gra.service;

import gra.gao.gra.dto.CommentDTO;

/**
 * @author:gao
 * @date:2020/3/16
 * @time:14:19
 * @version:0.0.1
 * @description:none
 */

public interface CommentService {

    public String  getCommentByArticleID(Long id);
    public String createComment(CommentDTO dto);
}
