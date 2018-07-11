package cn.com.epicc.ganesha.integral.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * Description: 用户积分表
 * Author: lishangmin
 * Created: 2018-07-01 23:37
 */
@Data
@Builder
public class Integral {

    /**
     * ID
     */
    private Long id;

    /**
     * 账户ID
     */
    private String accountId;

    /**
     * 积分余额
     */
    private Long balance;

    /**
     * 是否冻结 Y：冻结，N：解锁
     */
    private String freeze;

    /**
     * 更新时间
     */
    private Date mTime;

    /**
     * 保存时间
     */
    private Date cTime;


}
