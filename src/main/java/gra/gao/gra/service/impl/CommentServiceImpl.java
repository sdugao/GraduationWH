package gra.gao.gra.service.impl;

import gra.gao.gra.common.CommonCode;
import gra.gao.gra.common.JsonOperator;
import gra.gao.gra.dto.CommentDTO;
import gra.gao.gra.entity.Comment;
import gra.gao.gra.entity.CommentExample;
import gra.gao.gra.entity.Guest;
import gra.gao.gra.entity.GuestExample;
import gra.gao.gra.mapper.CommentMapper;
import gra.gao.gra.mapper.GuestMapper;
import gra.gao.gra.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author:gao
 * @date:2020/3/16
 * @time:14:54
 * @version:0.0.1
 * @description:none
 */

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper commentMapper;
    @Autowired
    GuestMapper guestMapper;

    @Override
    public String  getCommentByArticleID(Long id) {
        //先不做parent标签功能
        CommentExample ce = new CommentExample();
        CommentExample.Criteria criteria=ce.createCriteria();
        criteria.andArticle_idEqualTo(id);
        List<Comment> parentList=commentMapper.selectByExample(ce);
        List<CommentDTO> commentDTOList = new LinkedList<>();
        //封装返回列表
        for(Comment comment:parentList){
            CommentDTO commentDTO = new CommentDTO();
            commentDTO.setAuthor_id(comment.getAuthor_id());
            //查找用户名
            Guest guest=guestMapper.selectByPrimaryKey(comment.getArticle_id());
            commentDTO.setAuthor_username(guest.getUsername());

            commentDTO.setContent(comment.getContent());
            commentDTO.setGmt_updated(comment.getGmt_updated());
            commentDTO.setId(commentDTO.getId());
            commentDTO.setChild_comment(null);//没做
            commentDTOList.add(commentDTO);
        }
        String reJ=JsonOperator.getMSGJson(commentDTOList, CommonCode.SUCCESS);
        return reJ;
    }

    @Override
    public String createComment(CommentDTO dto) {
        Comment comment = new Comment();
        comment.setArticle_id(dto.getArticle_id());
        comment.setAuthor_id(dto.getAuthor_id());
        comment.setContent(dto.getContent());
        comment.setDeleted(false);
        //comment.setParent_id(null);
        Date date =new Date();
        comment.setGmt_created(date);
        comment.setGmt_updated(date);
        //comment.setId();
        if(0==commentMapper.insertSelective(comment)){
            //失败
            //返回错误
            return JsonOperator.getStatusJson(false);
        }
        return JsonOperator.getStatusJson(true);
    }
}
