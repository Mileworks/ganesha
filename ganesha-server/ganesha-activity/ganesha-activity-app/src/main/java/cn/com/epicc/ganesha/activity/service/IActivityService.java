package cn.com.epicc.ganesha.activity.service;


import cn.com.epicc.ganesha.activity.model.Activity;

import java.util.Date;

/**
 * Description: 活动模块服务
 * Author: lishangmin
 * Created: 2018-07-09 10:36
 */
public interface IActivityService {

    /**
     * 创建活动
     * @param operator  操作员
     * @param name      活动名称
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return 活动详情
     */
    Activity createActivity(String operator, String name, Date startTime, Date endTime);

    /**
     * 获取活动详情
     * @param activityId 活动ID
     */
    Activity getActivity(String activityId);

}
