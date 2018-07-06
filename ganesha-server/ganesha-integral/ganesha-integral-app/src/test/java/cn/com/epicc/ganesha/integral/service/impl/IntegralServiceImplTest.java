package cn.com.epicc.ganesha.integral.service.impl;

import cn.com.epicc.ganesha.integral.config.IntegralError;
import cn.com.epicc.ganesha.integral.service.IIntegralService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Description: 单元测试类
 * Author: lishangmin
 * Created: 2018-07-04 11:27
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
@Slf4j
public class IntegralServiceImplTest {

    @Autowired
    IIntegralService integralService;

    @Test
    //@Transactional
    //@Rollback
    public void add() throws Exception {
        boolean flag_1 = integralService.add("111",10L);
        Assert.assertTrue(flag_1);
        boolean flag_2 = integralService.add("333",10L);
        Assert.assertFalse(flag_2);
        try {
            integralService.add(null, 10L);
        }catch (Exception e){
            Assert.assertEquals(IntegralError.ACCOUNT_ID_ERROR.getMsg(),e.getMessage());
        }
        try {
            integralService.add("111", 0L);
        }catch (Exception e){
            Assert.assertEquals(IntegralError.INTEGRAL_VALUE_ERROR.getMsg(),e.getMessage());
        }
    }

    @Test
    public void sub() throws Exception {
        boolean flag_1 = integralService.sub("111",10L);
        Assert.assertTrue(flag_1);
    }

    @Test
    public void trans() throws Exception {

    }

    @Test
    public void getBalance() throws Exception {

    }

}