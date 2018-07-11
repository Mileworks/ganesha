package cn.com.epicc.ganesha.front.design.template;

import lombok.extern.slf4j.Slf4j;

/**
 * Description:
 * Author: lishangmin
 * Created: 2018-07-09 16:57
 */
@Slf4j
public abstract class InsuredAbstract implements IInsured{

    protected void valid(){
        //do something
    }

    protected void generation(){
        //do something
    }

    @Override
    public void insert() {
        valid();
        generation();
        log.info("beginning to insert...");
    }
}
