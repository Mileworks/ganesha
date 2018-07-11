package cn.com.epicc.ganesha.activity.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * Description: 活动信息表
 * Author: lishangmin
 * Created: 2018-07-09 13:22
 */
@Data
@Builder
public class Activity {

    /**
     * ID
     */
    private Long id;

    /**
     * 操作者
     */
    private String operator;

    /**
     * 活动名称
     */
    private String name;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 修改时间
     */
    private Date mTime;

    /**
     * 创建时间
     */
    private Date cTime;

    public Activity() {
    }

    public Activity(Long id, String operator, String name, Date startTime, Date endTime, Date mTime, Date cTime) {
        this.id = id;
        this.operator = operator;
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.mTime = mTime;
        this.cTime = cTime;
    }
}
