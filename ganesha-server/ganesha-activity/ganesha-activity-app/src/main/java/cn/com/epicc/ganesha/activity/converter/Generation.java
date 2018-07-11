package cn.com.epicc.ganesha.activity.converter;

import cn.com.epicc.ganesha.activity.model.Activity;
import cn.com.epicc.ganesha.activity.struct.ActivityStruct;

/**
 * Description: 组织请求报文
 * Author: lishangmin
 * Created: 2018-07-11 15:56
 */
public class Generation {

    /**
     * 转换成活动报文实体
     * @param activity 活动表实体
     */
    public static ActivityStruct converter(Activity activity){
        return ActivityStruct
                .builder()
                .id(activity.getId())
                .name(activity.getName())
                .startTime(activity.getStartTime().getTime())
                .endTime(activity.getEndTime().getTime())
                .build();
    }
}
