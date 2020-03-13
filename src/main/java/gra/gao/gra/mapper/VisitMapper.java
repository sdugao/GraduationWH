package gra.gao.gra.mapper;

import gra.gao.gra.entity.Visit;
import gra.gao.gra.entity.VisitExample;
import java.util.List;

public interface VisitMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Visit record);

    int insertSelective(Visit record);

    List<Visit> selectByExample(VisitExample example);

    Visit selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Visit record);

    int updateByPrimaryKey(Visit record);
}