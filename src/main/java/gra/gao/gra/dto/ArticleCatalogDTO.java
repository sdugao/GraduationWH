package gra.gao.gra.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

/**
 * @author:gao
 * @date:2020/3/16
 * @time:20:41
 * @version:0.0.1
 * @description:none
 */

@Data
public class ArticleCatalogDTO {

    private Long id;
    private String Tittle;
    @JSONField(format = "yyyy-MM-dd HH:mm")
    private String gmt_updated;
}
