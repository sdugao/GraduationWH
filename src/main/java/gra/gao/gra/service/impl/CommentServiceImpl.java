package gra.gao.gra.service.impl;

import ch.qos.logback.classic.db.DBAppender;
import gra.gao.gra.common.CommonCode;
import gra.gao.gra.common.CommonConst;
import gra.gao.gra.common.JsonOperator;
import gra.gao.gra.dto.CommentDTO;
import gra.gao.gra.entity.Comment;
import gra.gao.gra.entity.CommentExample;
import gra.gao.gra.entity.Guest;
import gra.gao.gra.entity.GuestExample;
import gra.gao.gra.exception.DataBaseException;
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
           CommentDTO commentDTO =getDTOByComment(comment);
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

    //通过comment 获取commentDTO
    public CommentDTO getDTOByComment(Comment comment){
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setAuthor_id(comment.getAuthor_id());
        commentDTO.setId(comment.getId());
        try {
            //查找用户名
            Guest guest = guestMapper.selectByPrimaryKey(comment.getAuthor_id());
            if(guest==null) return null;
            commentDTO.setAuthor_username(guest.getUsername());
            commentDTO.setAuthor_nickname(guest.getNickname());
            commentDTO.setContent(comment.getContent());
            commentDTO.setGmt_updated(comment.getGmt_updated());
            commentDTO.setId(commentDTO.getId());
            commentDTO.setChild_comment(null);//没做
        }catch (DataBaseException e){
            e.printStackTrace();
            commentDTO=null;
        }
        return  commentDTO;
    }

    public String getCommenList(CommentExample ce){

        try{
            List<Comment> list = commentMapper.selectByExample(ce);
            List<CommentDTO> list_DTO =new LinkedList<>();
            for(Comment comment:list){
                CommentDTO c = getDTOByComment(comment);
                if(c!=null)list_DTO.add(c);
            }
            return JsonOperator.getMSGJson(list_DTO, CommonCode.SUCCESS);
        }catch (DataBaseException e){
            e.printStackTrace();
        }
        return JsonOperator.getStatusJson(false);
    }

    @Override
    public String back_getCommentNotRead() {
        CommentExample ce = new CommentExample();
        CommentExample.Criteria cc = ce.createCriteria();
        cc.andDeletedEqualTo(false);
        return getCommenList(ce);
    }

    @Override
    public String back_getCommentAfterDate(Date date) {
        if(date == null){
            date =new Date();
            date.setTime(0);
        }
        CommentExample ce = new CommentExample();
        CommentExample.Criteria cc = ce.createCriteria();
        Date date2= new Date();
        cc.andGmt_updatedBetween(date,date2);
        return getCommenList(ce);
    }

    @Override
    public String markRead(Long id) {
        Comment comment = new Comment();
        comment.setId(Long.valueOf(id));
        comment.setDeleted(true);
        boolean success = false;
        try{
            int i= commentMapper.updateByPrimaryKeySelective(comment);
            if(i==1) success=true;
        }catch (DataBaseException e){
            e.printStackTrace();
        }
        return JsonOperator.getStatusJson(success);
    }
}
