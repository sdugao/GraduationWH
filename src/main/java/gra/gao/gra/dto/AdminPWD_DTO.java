package gra.gao.gra.dto;

import lombok.Data;

import javax.annotation.security.DenyAll;

/**
 * @author:gao
 * @date:2020/4/18
 * @time:14:08
 * @version:0.0.1
 * @description:none
 */

@Data
public class AdminPWD_DTO {
    private  String oldpwd;
    private String newpwd;
    //private String confirmpwd;
}
