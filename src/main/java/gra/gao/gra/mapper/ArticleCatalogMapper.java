package gra.gao.gra.mapper;

import gra.gao.gra.dto.ArticleCatalogDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author:gao
 * @date:2020/3/16
 * @time:20:39
 * @version:0.0.1
 * @description:none
 */

@Mapper
public interface ArticleCatalogMapper {

    @Select("select id,tittle,gmt_updated from g_article where deleted != 1 limit #{start}, #{items} ")
    public List<ArticleCatalogDTO> selectCatalogByPage(@Param("start") Integer start,@Param("items") Integer items);

    @Select("select id,tittle,gmt_updated from g_article where deleted == 1 limit #{start}, #{items} ")
    public List<ArticleCatalogDTO> selectCatalogFromBinByPage(@Param("start") Integer start,@Param("items") Integer items);

}
