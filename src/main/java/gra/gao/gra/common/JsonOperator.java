package gra.gao.gra.common;

import com.alibaba.fastjson.JSON;
import lombok.NonNull;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.List;

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

    public static String getMSGJson(@NonNull Object msg,@NonNull Integer code){
        String json;
        CommonJson cJson =new CommonJson();
        cJson.setCode(code);
        cJson.setMessage(msg);
        json = JSON.toJSONString(cJson);
        return json;
    }

}
