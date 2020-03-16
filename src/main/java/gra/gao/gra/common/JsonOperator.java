package gra.gao.gra.common;

import com.alibaba.fastjson.JSON;

/**
 * @author:gao
 * @date:2020/3/16
 * @time:19:26
 * @version:0.0.1
 * @description:none
 */

public class JsonOperator {

    public static String getStatusJson(boolean success){
        String json;
        CommonJson cJson =new CommonJson();
        if(success) {
            cJson.setCode(CommonCode.SUCCESS);
            cJson.setMessage("success");
        }else{
            cJson.setCode(CommonCode.SUCCESS);
            cJson.setMessage("success");
        }
        json = JSON.toJSONString(cJson);
        return json;
    }


    public static String getMSGJson(Object msg,Integer code){
        String json;
        CommonJson cJson =new CommonJson();
        cJson.setCode(code);
        cJson.setMessage(JSON.toJSONString(msg));
        json = JSON.toJSONString(cJson);
        return json;
    }
}
