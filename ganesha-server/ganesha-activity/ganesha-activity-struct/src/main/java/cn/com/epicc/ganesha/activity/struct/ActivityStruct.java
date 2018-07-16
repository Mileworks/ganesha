package cn.com.epicc.ganesha.activity.struct;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;
import lombok.Data;

/**
 * Description: 活动详情
 * Author: lishangmin
 * Created: 2018-07-11 15:17
 */
@Data
@Builder
@SuppressWarnings("deprecation")
@JsonSerialize(include =  JsonSerialize.Inclusion.NON_NULL)
public class ActivityStruct {

    /**
     * 活动ID
     */
    private Long id;

    /**
     * 活动名称
     */
    private String name;

    /**
     * 开始时间
     */
    private Long startTime;

    /**
     * 结束时间
     */
    private Long endTime;

}
