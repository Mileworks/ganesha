package cn.com.epicc.ganesha.front.design.proxy;

import lombok.extern.slf4j.Slf4j;

/**
 * Description:
 * Author: lishangmin
 * Created: 2018-07-09 17:50
 */
@Slf4j
public class Proxy {

    IGame iGame;

    public Proxy(IGame iGame){
        this.iGame = iGame;
    }

    public void execute(){
        log.info("11111");
        iGame.run();
        log.info("22222");
        iGame.jump();
        log.info("33333");
    }

}
