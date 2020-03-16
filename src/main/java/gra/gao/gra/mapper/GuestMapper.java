package gra.gao.gra.mapper;

import gra.gao.gra.entity.Guest;
import gra.gao.gra.entity.GuestExample;
import java.util.List;

public interface GuestMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Guest record);

    int insertSelective(Guest record);

    List<Guest> selectByExample(GuestExample example);

    Guest selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Guest record);

    int updateByPrimaryKey(Guest record);
}