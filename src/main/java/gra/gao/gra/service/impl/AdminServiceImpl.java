package gra.gao.gra.service.impl;

import gra.gao.gra.common.JsonOperator;
import gra.gao.gra.dto.AdminPWD_DTO;
import gra.gao.gra.entity.AdminExample;
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

    public boolean determineAdminLogin(@NonNull String uuid) {
        Admin admin = adminMapper.selectByPrimaryKey(Long.valueOf(1));
        if (admin == null) {
            throw new DataBaseException("Admin返回为空！");
        }

        boolean flag = false;
        if (uuid.equals(admin.getG_uuid())) flag = true;
        return flag;

    }

    @Override
    public String adminLogin(@NonNull AdminDTO adminDTO) {
        Admin admin = adminMapper.selectByPrimaryKey(Long.valueOf(1));
        if (admin != null && admin.getUsername().equals(adminDTO.getUsername()) &&
                admin.getG_password().equals(adminDTO.getPassword())) {
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

    @Override
    public String clearUUID() {
        Admin admin =new Admin();
        admin.setId(Long.valueOf(1));
        admin.setG_uuid("");
        int i=-1;
        try {
            i=adminMapper.updateByPrimaryKeySelective(admin);
        }catch (DataBaseException e){
            e.printStackTrace();
            i=-1;
        }
        if(i==1){
            return JsonOperator.getStatusJson(true);
        }
        return JsonOperator.getStatusJson(false);
    }

    @Override
    public String updatePWD(@NonNull AdminPWD_DTO dto) {

        boolean success =false;
        try{
            Admin admin =adminMapper.selectByPrimaryKey(Long.valueOf(1));
            if(admin!=null&&admin.getG_password().equals(dto.getOldpwd())){
                if(dto.getNewpwd()!=null&&!dto.getNewpwd().equals("")) {
                    admin.setG_password(dto.getNewpwd());
                    int i =adminMapper.updateByPrimaryKeySelective(admin);
                    if(i==1){
                        success=true;
                    }
                }
            }
        }catch (DataBaseException e){
            e.printStackTrace();
        }
        String json =JsonOperator.getStatusJson(success);
        return json;
    }
}

