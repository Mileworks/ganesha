package cn.com.epicc.ganesha.front.design.factory;

import lombok.extern.slf4j.Slf4j;

/**
 * Description:
 * Author: lishangmin
 * Created: 2018-07-09 16:12
 */
@Slf4j
public class BaoMaCar implements Car {
    @Override
    public void color() {
        log.info("蓝色");
    }

    @Override
    public void banner() {
        log.info("我是宝马");
    }
}
