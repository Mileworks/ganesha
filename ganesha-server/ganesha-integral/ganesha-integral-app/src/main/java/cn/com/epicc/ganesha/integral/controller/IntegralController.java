package cn.com.epicc.ganesha.integral.controller;

import cn.com.epicc.ganesha.activity.struct.ActivityStruct;
import cn.com.epicc.ganesha.common.result.Result;
import cn.com.epicc.ganesha.integral.entity.IntegralType;
import cn.com.epicc.ganesha.integral.exception.IntegralException;
import cn.com.epicc.ganesha.integral.exception.constant.IntegralError;
import cn.com.epicc.ganesha.integral.service.IActivityService;
import cn.com.epicc.ganesha.integral.service.IIntegralService;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: 积分服务控制层
 * Author: lishangmin
 * Created: 2018-07-02 00:00
 */
@Api("积分服务API")
@RestController
@RequestMapping(value = "/integral")
@Slf4j
public class IntegralController {

    @Autowired
    private IIntegralService iIntegralService;

    @Autowired
    private IActivityService iActivityService;

    @ApiOperation(value = "增加积分")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "accessToken", value = "授权ID" , paramType = "form"),
            @ApiImplicitParam(name = "accountId", value = "账户ID" , paramType = "form"),
            @ApiImplicitParam(name = "integral", value = "积分" , paramType = "form")
    })
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Result add(@Param("accessToken")String accessToken, @Param("accountId") String accountId,
                      @Param("integral") Long integral, @Param("integralType")Integer integralType,
                      @Param("activityId") String activityId
    ){
        log.info("add-accountId:{},integral:{}",accountId,integral);
        Result<ActivityStruct> activity = iActivityService.getActivity(activityId);
        log.info(JSON.toJSONString(activity));
        if(activity == null || !activity.isSuccess()){
            throw new IntegralException(IntegralError.ACTIVITY_ERROR);
        }
        boolean isSuccess = iIntegralService.add(accountId,accountId,integral,
                IntegralType.convert(integralType),activityId);
        return isSuccess?Result.success():Result.error();
    }

    @ApiOperation(value = "扣减积分")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "accessToken", value = "授权ID" , paramType = "form"),
            @ApiImplicitParam(name = "accountId", value = "账户ID" , paramType = "form"),
            @ApiImplicitParam(name = "integral", value = "积分" , paramType = "form")
    })
    @RequestMapping(value = "/sub",method = RequestMethod.POST)
    public Result sub(@Param("accessToken")String accessToken,@Param("accountId")String accountId,@Param("integral")Long integral){
        log.info("sub-accountId:{},integral:{}",accountId,integral);
        boolean isSuccess = iIntegralService.sub(accountId,integral);
        return isSuccess?Result.success():Result.error();
    }

    @ApiOperation(value = "转移积分")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "from", value = "源账户ID" , paramType = "form"),
            @ApiImplicitParam(name = "to", value = "目标账户ID" , paramType = "form"),
            @ApiImplicitParam(name = "integral", value = "积分" , paramType = "form")
    })
    @RequestMapping(value = "/trans",method = RequestMethod.POST)
    public Result trans(@Param("from")String from,@Param("to")String to,@Param("integral")Long integral){
        log.info("trans-from:{},to:{},balance:{}",from,to,integral);
        boolean isSuccess = iIntegralService.trans(from,to,integral);
        return isSuccess?Result.success():Result.error();
    }

    @ApiOperation(value = "查询账户余额")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "accountId", value = "账户ID" , paramType = "query")
    })
    @RequestMapping(value = "/getBalance",method = RequestMethod.GET)
    public Result<Long> getBalance(@Param("accountId") String accountId){
        log.info("getBalance-accountId:{}",accountId);
        long balance = iIntegralService.getBalance(accountId);
        return Result.success(balance);
    }

}
