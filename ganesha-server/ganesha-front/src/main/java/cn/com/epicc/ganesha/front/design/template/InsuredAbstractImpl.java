package cn.com.epicc.ganesha.front.design.template;

import lombok.extern.slf4j.Slf4j;

/**
 * Description:
 * Author: lishangmin
 * Created: 2018-07-09 17:00
 */
@Slf4j
public class InsuredAbstractImpl extends InsuredAbstract {

    @Override
    protected void valid() {
        log.info("开始验证特别保单信息");
    }

    @Override
    protected void generation() {
        log.info("开始组织特别保单信息");
    }

}
