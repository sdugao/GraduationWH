package gra.gao.gra.service.impl;

import gra.gao.gra.common.CommonCode;
import gra.gao.gra.common.JsonOperator;
import gra.gao.gra.entity.Log;
import gra.gao.gra.entity.LogExample;
import gra.gao.gra.exception.DataBaseException;
import gra.gao.gra.mapper.LogMapper;
import gra.gao.gra.service.VisitService;
import gra.gao.gra.util.GmtTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author:gao
 * @date:2020/3/16
 * @time:14:55
 * @version:0.0.1
 * @description:none
 */

@Service
public class VisitServiceImpl implements VisitService {

    @Autowired
    LogMapper logMapper;

    @Override
    public String getVisitToday() {
        LogExample le = new LogExample();
        LogExample.Criteria lec=le.createCriteria();
        Date zero = GmtTime.getTodayZeroClock();
        lec.andGmt_createdBetween(zero,new Date());
        int nums=0;
        int code= CommonCode.ERROR;
        try {
            List<Log> list_log = logMapper.selectByExample(le);
            nums=list_log.size();
            code=CommonCode.SUCCESS;
        }catch (DataBaseException e){
            e.printStackTrace();
        }
        String json=JsonOperator.getMSGJson(Integer.valueOf(nums),code);
        return json;
    }
}
