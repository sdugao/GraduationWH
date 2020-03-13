package gra.gao.gra.service.impl;

import gra.gao.gra.exception.DataBaseException;
import gra.gao.gra.dto.AdminDTO;
import gra.gao.gra.entity.Admin;
import gra.gao.gra.mapper.AdminMapper;
import gra.gao.gra.service.AdminService;
import gra.gao.gra.util.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author:gao
 * @date:2020/3/13
 * @time:22:36
 * @version:0.0.1
 * @description:none
 */

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;

    public AdminDTO getAdminDTO(){
        Admin admin = adminMapper.selectByPrimaryKey(Long.getLong("1"));
        if(admin==null){
            throw new DataBaseException("Admin返回为空！");
        }
        AdminDTO adminDTO=new AdminDTO();
        //加上混淆
        adminDTO.setUsername(Common.UsernameFront+admin.getUsername()+Common.UsernameBack);
        String uuid=admin.getG_uuid();
        if(uuid==null){
            uuid= UUID.randomUUID().toString();
            //写数据库
            admin.setG_uuid(uuid);
            adminMapper.updateByPrimaryKey(admin);
        }
        adminDTO.setUUID(uuid);
        return adminDTO;

    }
}

