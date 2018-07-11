package cn.com.epicc.ganesha.activity.controller;

import cn.com.epicc.ganesha.activity.converter.Generation;
import cn.com.epicc.ganesha.activity.model.Activity;
import cn.com.epicc.ganesha.activity.service.IActivityService;
import cn.com.epicc.ganesha.activity.struct.ActivityStruct;
import cn.com.epicc.ganesha.common.date.DateUtil;
import cn.com.epicc.ganesha.common.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: 活动模块控制层
 * Author: lishangmin
 * Created: 2018-07-09 10:34
 */
@RestController
@Slf4j
@RequestMapping(value = "/activity")
public class ActivityController {

    @Autowired
    IActivityService iActivityService;

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public Result<ActivityStruct> createActivity(String operator, String name,
                                                 long startTime, long endTime){
        log.info("开始创建活动");
        Activity activity = iActivityService.createActivity(operator,name,DateUtil.toDate(startTime),DateUtil.toDate(endTime));
        if(activity == null){
            return Result.error();
        }
        return Result.success(Generation.converter(activity));
    }

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public Result getActivity(String activityId){
        log.info("开始获取活动");
        Activity activity = iActivityService.getActivity(activityId);
        if(activity == null){
            return Result.error();
        }
        return Result.success(Generation.converter(activity));
    }

}
