package cn.com.epicc.ganesha.integral.service;

import cn.com.epicc.ganesha.activity.struct.ActivityStruct;
import cn.com.epicc.ganesha.common.result.Result;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Description: 活动模块服务
 * Author: lishangmin
 * Created: 2018-07-11 16:21
 */
@FeignClient("ACTIVITY-APP")
@Service
public interface IActivityService {

    @RequestMapping(value = "/activity/get", method = RequestMethod.GET)
    Result<ActivityStruct> getActivity(@RequestParam(value = "activityId")String activityId);

}
