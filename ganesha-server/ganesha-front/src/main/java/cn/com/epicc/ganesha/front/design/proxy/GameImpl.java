package cn.com.epicc.ganesha.front.design.proxy;


import lombok.extern.slf4j.Slf4j;

/**
 * Description:
 * Author: lishangmin
 * Created: 2018-07-09 17:50
 */
@Slf4j
public class GameImpl implements IGame {

    @Override
    public void run() {
        log.info("开始跑步...");
    }

    @Override
    public void jump() {
        log.info("开始跳跃...");
    }
}
