package gra.gao.gra.service;

import gra.gao.gra.dto.CommentDTO;

import javax.xml.crypto.Data;
import java.util.Date;

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
    public String back_getCommentNotRead();
    public String back_getCommentAfterDate(Date date);
    public String markRead(Long id);
}
