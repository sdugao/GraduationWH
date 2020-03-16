package gra.gao.gra.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author:gao
 * @date:2020/3/16
 * @time:15:22
 * @version:0.0.1
 * @description:none
 */

@Data
public class ArticleDTO {

    private Long id;

    private String tittle;

    private String content;

    private String g_type;

    private String tag;

    private Boolean deleted;
}
