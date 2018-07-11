package cn.com.epicc.ganesha.front.design.factory;

import lombok.extern.slf4j.Slf4j;

/**
 * Description:
 * Author: lishangmin
 * Created: 2018-07-09 16:13
 */
@Slf4j
public class BenChiCar implements Car{
    @Override
    public void color() {
        log.info("红色");
    }

    @Override
    public void banner() {
        log.info("我是奔驰");
    }
}
