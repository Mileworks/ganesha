package cn.com.epicc.ganesha.front.design.singleton;

import lombok.extern.slf4j.Slf4j;

/**
 * Description:
 * Author: lishangmin
 * Created: 2018-07-09 14:11
 */
@Slf4j
public class King {

    private King() {
    }

    public void say(){
        log.info("I am the King:{}",this.hashCode());
    }

    private static King king;

    public static King getInstance(){
        if (king == null){
            log.info("11111");
            king = new King();
            return king;
        }
        log.info("22222");
        return king;
    }

    public static King getInstance4(){
        if (king == null){
            synchronized (King.class) {
                if(king == null) {
                    log.info("11111");
                    king = new King();
                    return king;
                }
            }
        }
        log.info("22222");
        return king;
    }

    public static King getInstance2(){
        return Singleton.INSTANCE.getInstance();
    }

    private static King king2 = new King();

    public static King getInstance3(){
        return king2;
    }

    private enum Singleton {
        INSTANCE;

        private King singleton;

        // JVM保证这个方法绝对只调用一次
        Singleton() {
            singleton = King.getInstance();
        }

        public King getInstance() {
            return singleton;
        }
    }
}
