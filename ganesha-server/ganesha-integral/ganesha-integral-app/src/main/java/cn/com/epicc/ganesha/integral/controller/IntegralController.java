package cn.com.epicc.ganesha.integral.controller;

import cn.com.epicc.ganesha.common.result.Result;
import cn.com.epicc.ganesha.integral.service.IIntegralService;
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
@RestController
@RequestMapping(value = "/integral")
@Slf4j
public class IntegralController {

    @Autowired
    IIntegralService iIntegralService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Result add(@Param("accountId") String accountId, @Param("integral") Long integral){
        log.info("add-accountId:{},integral:{}",accountId,integral);
        boolean isSuccess = iIntegralService.add(accountId,integral);
        return isSuccess?Result.createBySuccess():Result.createByError();
    }

    @RequestMapping(value = "/sub",method = RequestMethod.POST)
    public Result sub(@Param("accountId")String accountId,@Param("integral")Long integral){
        log.info("sub-accountId:{},integral:{}",accountId,integral);
        boolean isSuccess = iIntegralService.sub(accountId,integral);
        return isSuccess?Result.createBySuccess():Result.createByError();
    }

    @RequestMapping(value = "/trans",method = RequestMethod.POST)
    public Result trans(@Param("from")String from,@Param("to")String to,@Param("balance")Long balance){
        log.info("trans-from:{},to:{},balance:{}",from,to,balance);
        boolean isSuccess = iIntegralService.trans(from,to,balance);
        return isSuccess?Result.createBySuccess():Result.createByError();
    }

    @RequestMapping(value = "/getBalance",method = RequestMethod.GET)
    public Result<Long> getBalance(@Param("accountId")String accountId){
        log.info("getBalance-accountId:{}",accountId);
        long balance = iIntegralService.getBalance(accountId);
        return Result.createBySuccess(balance);
    }

}