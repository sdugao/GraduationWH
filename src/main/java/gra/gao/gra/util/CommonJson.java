package gra.gao.gra.util;

import lombok.Data;

import javax.annotation.security.DenyAll;

/**
 * @author:gao
 * @date:2020/3/16
 * @time:18:36
 * @version:0.0.1
 * @description:none
 */

@Data
public class CommonJson {
    private String message;
    private int code;
}
