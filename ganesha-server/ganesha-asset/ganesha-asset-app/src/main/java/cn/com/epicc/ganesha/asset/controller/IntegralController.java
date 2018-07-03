package cn.com.epicc.ganesha.asset.controller;

import cn.com.epicc.ganesha.asset.service.IIntegralService;
import cn.com.epicc.ganesha.common.result.Result;
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
        log.info("accountId:{},integral:{}",accountId,integral);
        boolean isSuccess = iIntegralService.add(accountId,integral);
        return isSuccess?Result.createBySuccess():Result.createByError();
    }

}
