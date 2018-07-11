package cn.com.epicc.ganesha.activity.service.impl;

import cn.com.epicc.ganesha.activity.model.Activity;
import cn.com.epicc.ganesha.activity.service.IActivityService;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * Description: 活动单元测试类
 * Author: lishangmin
 * Created: 2018-07-10 11:18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
@Slf4j
public class ActivityServiceImplTest {

    @Autowired
    IActivityService iActivityService;

    @Test
    public void createActivity() throws Exception {
        Activity activity = iActivityService.createActivity("111","签到", DateTime.now().toDate(),new Date());
        log.info(JSON.toJSONString(activity));
        Assert.assertNotNull(activity.getId());
    }

    @Test
    public void getActivity() throws Exception {
        Activity activity = iActivityService.getActivity("1");
        log.info(JSON.toJSONString(activity));
        Assert.assertNotNull(activity.getId());
    }

}