package cn.com.epicc.ganesha.activity.controller;

import cn.com.epicc.ganesha.activity.converter.Generation;
import cn.com.epicc.ganesha.activity.model.Activity;
import cn.com.epicc.ganesha.activity.service.IActivityService;
import cn.com.epicc.ganesha.activity.struct.*;
import cn.com.epicc.ganesha.common.date.DateUtil;
import cn.com.epicc.ganesha.common.result.Result;
import cn.com.epicc.ganesha.common.util.CommonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

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

    @RequestMapping(value = "/sample",method = RequestMethod.GET)
    public Packet Sample(){
        Head head = Head.builder()
                        .requestType("10001")
                        .insureType("100")
                        .from("HuiZe")
                        .sessionId(CommonUtil.getUUID())
                        .sendTime(String.valueOf(System.currentTimeMillis()))
                        .build();

        Inputs inputBase = Inputs.builder().inputs(
                Arrays.asList(
                        Input.builder().name("productNo").value("1001").build(),
                        Input.builder().name("productCode").value("0615").build(),
                        Input.builder().name("productName").value("旅游险").build(),
                        Input.builder().name("accessTime").value("127999998").build(),
                        Input.builder().name("startTime").value("23242342").build(),
                        Input.builder().name("endTime").value("23423421").build(),
                        Input.builder().name("agentCode").value("1001").build(),
                        Input.builder().name("special").value("448_59546").build()
                )
        ).type("base").build();

        Inputs inputSpecials = Inputs.builder().inputs(
                Arrays.asList(
                        Input.builder().name("appName").value("张帆").build()
                )
        ).type("special").build();

        Inputs inputApp = Inputs.builder().inputs(
                Arrays.asList(
                        Input.builder().name("appName").value("张帆").build()
                )
        ).type("applicant").build();

        Inputs inputTgt = Inputs.builder().inputs(
                Arrays.asList(
                        Input.builder().name("travCountry").value("韩国").build()
                )
        ).type("tgt").build();

        InputList inputList_1 = InputList.builder().type("request").inputs(
                Arrays.asList(
                        inputBase,inputApp,inputTgt
                )
        ).build();

        Request request = Request.builder().inputLists(
                Arrays.asList(inputList_1)
        ).build();

        return Packet.builder().head(head).request(request).build();
    }

}
