package cn.com.epicc.ganesha.integral.service.impl;

import cn.com.epicc.ganesha.integral.entity.IntegralType;
import cn.com.epicc.ganesha.integral.exception.constant.IntegralError;
import cn.com.epicc.ganesha.integral.service.IIntegralService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

    private final static int threadCount = 100;

    @Test
    //@Transactional
    //@Rollback
    public void add() throws Exception {
        boolean flag_1 = integralService.add("111","111",10L, IntegralType.SIGN,"11");
        Assert.assertTrue(flag_1);
        boolean flag_2 = integralService.add("111","333",10L,IntegralType.SIGN,"11");
        Assert.assertFalse(flag_2);
        try {
            integralService.add("111",null, 10L,IntegralType.SIGN,"11");
        }catch (Exception e){
            Assert.assertEquals(IntegralError.ACCOUNT_ID_ERROR.getMsg(),e.getMessage());
        }
        try {
            integralService.add("111","111", 0L,IntegralType.SIGN,"11");
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

        //测试死锁
        ExecutorService exec = Executors.newCachedThreadPool();
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            exec.execute(()->{
                try{
                    if (threadNum % 2 == 0) {
                        integralService.trans("111", "222", 10);
                    }else{
                        integralService.trans("222", "111", 10);
                    }
                    log.info("Thread:{}",threadNum);
                }finally {
                    countDownLatch.countDown();
                    log.info("count:{}",countDownLatch.getCount());
                }
            });
        }
        countDownLatch.await();
        exec.shutdown();


    }

    @Test
    public void getBalance() throws Exception {

    }

}