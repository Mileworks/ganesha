package cn.com.epicc.ganesha.activity.service.impl;

import cn.com.epicc.ganesha.activity.dao.ActivityDao;
import cn.com.epicc.ganesha.activity.model.Activity;
import cn.com.epicc.ganesha.activity.service.IActivityService;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Description: 活动模块服务实现层
 * Author: lishangmin
 * Created: 2018-07-09 10:36
 */
@Service
@Slf4j
public class ActivityServiceImpl implements IActivityService{

    @Autowired
    ActivityDao activityDao;

    /**
     * 创建活动
     *
     * @param operator  操作员
     * @param name      活动名称
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return 活动详情
     */
    @Override
    public Activity createActivity(String operator, String name, Date startTime, Date endTime) {
        Activity activity = Activity.builder().operator(operator).name(name).
                startTime(startTime).endTime(endTime).build();
        log.info(JSON.toJSONString(activity));
        int rows = activityDao.insert(activity);
        return rows > 0 ? activity : null;
    }

    /**
     * 获取活动详情
     *
     * @param activityId 活动ID
     */
    @Override
    public Activity getActivity(String activityId) {
        return activityDao.selectByPrimaryKey(activityId);
    }

}
