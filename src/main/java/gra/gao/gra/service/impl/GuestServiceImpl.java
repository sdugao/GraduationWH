package gra.gao.gra.service.impl;

import gra.gao.gra.common.CommonCode;
import gra.gao.gra.common.CommonJson;
import gra.gao.gra.common.JsonOperator;
import gra.gao.gra.dto.GuestDTO;
import gra.gao.gra.entity.Guest;
import gra.gao.gra.entity.GuestExample;
import gra.gao.gra.exception.DataBaseException;
import gra.gao.gra.mapper.GuestMapper;
import gra.gao.gra.service.GuestService;
import gra.gao.gra.common.CommonConst;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springfox.documentation.spring.web.json.Json;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author:gao
 * @date:2020/3/16
 * @time:14:54
 * @version:0.0.1
 * @description:none
 */

@Service
public class GuestServiceImpl implements GuestService {

    @Autowired
    GuestMapper guestMapper;

    @Override
    public boolean determineGuestLogin(@NonNull GuestDTO pGuestDTO) {
        GuestExample guestExample = new GuestExample();
        GuestExample.Criteria criteria = guestExample.createCriteria();
        criteria.andUsernameEqualTo(pGuestDTO.getUsername());
        Guest guest = guestMapper.selectByExample(guestExample ).get(0);
        if(guest==null){
            throw new DataBaseException("guest返回为空！");
        }
        GuestDTO guestDTO=new GuestDTO();
        //加上混淆
        guestDTO.setUsername(CommonConst.GuestUsernameFront +guest.getUsername()+ CommonConst.GuestUsernameBack);
        String uuid=guest.getG_uuid();
//        if(uuid==null){
//            uuid= UUID.randomUUID().toString();
//            //写数据库
//            guest.setG_uuid(uuid);
//            guestMapper.updateByPrimaryKey(guest);
//        }
        guestDTO.setUUID(uuid);

        boolean flag=false;
        if(guestDTO!=null&&guestDTO.getUsername().equals(pGuestDTO.getUsername())&&
                    guestDTO.getUUID().equals(pGuestDTO.getUUID())){
                flag=true;
        }
        return flag;

    }


    @Override
    public GuestDTO guestLogin(@NonNull GuestDTO guestDTO) {
        GuestExample guestExample = new GuestExample();
        GuestExample.Criteria criteria = guestExample.createCriteria();
        criteria.andG_passwordEqualTo(guestDTO.getPassword());
        criteria.andUsernameEqualTo(guestDTO.getUsername());
        try {
            List<Guest> list = guestMapper.selectByExample(guestExample);
            if(list!=null&&!list.isEmpty()) {
                Guest guest =list.get(0);
                if (guest != null) {
                    guestDTO.setNickname(guest.getNickname());
                    guestDTO.setPassword(null);
                    String uuid = UUID.randomUUID().toString();
                    guestDTO.setUUID(uuid);
                    guestDTO.setId(guest.getId());
                    guest.setG_password(null);
                    guest.setG_uuid(uuid);
                    guest.setNickname(null);
                    guest.setGmt_updated(new Date());
                    guest.setGmt_created(null);
                    guest.setUsername(null);
                    guestMapper.updateByPrimaryKeySelective(guest);
                }
            }else{
                guestDTO=null;
            }
        }catch (DataBaseException e){
            e.printStackTrace();
            guestDTO=null;
        }
        return guestDTO;
    }

    @Override
    public String guestLoginByUUID(@NonNull String uuid) {
        GuestExample ge = new GuestExample();
        GuestExample.Criteria criteria =ge.createCriteria();
        criteria.andG_uuidEqualTo(uuid);
        String json=null;
        try {
            List<Guest> list = guestMapper.selectByExample(ge);
            if(list!=null&&!list.isEmpty()) {
                Guest guest = list.get(0);
                if (guest != null) {
                    GuestDTO guestDTO = new GuestDTO();
                    guestDTO.setUsername(guest.getUsername());
                    guestDTO.setId(guest.getId());
                    guestDTO.setNickname(guest.getNickname());
                    json = JsonOperator.getMSGJson(guestDTO, CommonCode.SUCCESS);
                }
            }
        }catch (DataBaseException e){
            e.printStackTrace();
        }
        if(json==null){
            json = JsonOperator.getStatusJson(false);
        }
        return json;
    }
}
