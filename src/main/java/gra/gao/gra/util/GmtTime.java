package gra.gao.gra.util;

import java.util.Calendar;
import java.util.Date;

/**
 * @author:gao
 * @date:2020/4/5
 * @time:22:28
 * @version:0.0.1
 * @description:none
 */

public class GmtTime {
    public static Date getTodayZeroClock(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }
}
