package gra.gao.gra.service.impl;

import gra.gao.gra.exception.DataBaseException;
import gra.gao.gra.dto.AdminDTO;
import gra.gao.gra.entity.Admin;
import gra.gao.gra.mapper.AdminMapper;
import gra.gao.gra.service.AdminService;
import gra.gao.gra.common.CommonConst;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    public boolean determineAdminLogin(@NonNull AdminDTO pAdminDTO){
        Admin admin = adminMapper.selectByPrimaryKey(Long.getLong("1"));
        if(admin==null){
            throw new DataBaseException("Admin返回为空！");
        }
        AdminDTO adminDTO=new AdminDTO();
        //加上混淆
        adminDTO.setUsername(CommonConst.AdminUsernameFront +admin.getUsername()+ CommonConst.AdminUsernameBack);
        String uuid=admin.getG_uuid();
        adminDTO.setUUID(uuid);

        boolean flag=false;
        if(adminDTO!=null&&adminDTO.getUsername().equals(pAdminDTO.getUsername())&&
            adminDTO.getUUID().equals(pAdminDTO.getUUID())){
                flag=true;
        }
        return flag;

    }

    @Override
    public String adminLogin(@NonNull AdminDTO adminDTO) {
        Admin admin = adminMapper.selectByPrimaryKey(Long.valueOf(1));
        if(admin!=null&&admin.getUsername().equals(adminDTO.getUsername())&&
            admin.getG_password().equals(adminDTO.getPassword())){
            String uuid = UUID.randomUUID().toString();
            admin.setG_password(null);
            admin.setG_uuid(uuid);
            admin.setGmt_created(null);
            admin.setGmt_updated(new Date());
            admin.setUsername(null);
            adminMapper.updateByPrimaryKeySelective(admin);
            return uuid;
        }
        return null;
    }
}

