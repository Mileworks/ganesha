package cn.com.epicc.ganesha.integral.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * Description: 积分增加事件表
 * Author: lishangmin
 * Created: 2018-07-06 16:30
 */
@Data
@Builder
public class IntegralAddEvent {

    /**
     * ID
     */
    private Long id;

    /**
     * 账户ID
     */
    private String accountId;

    /**
     * 总额
     */
    private Long amount;

    /**
     * 操作用户ID
     */
    private String operator;

    /**
     * 积分来源
     */
    private Integer source;

    /**
     * 活动ID
     */
    private String activityId;

    /**
     * 修改时间
     */
    private Date mTime;

    /**
     * 创建时间
     */
    private Date cTime;

}
