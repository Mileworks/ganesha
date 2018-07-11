package cn.com.epicc.ganesha.front.design.template;

import lombok.extern.slf4j.Slf4j;

/**
 * Description:
 * Author: lishangmin
 * Created: 2018-07-09 17:02
 */
@Slf4j
public class InsuredNormalImpl extends InsuredAbstract {

    @Override
    protected void valid() {
        log.info("开始验证普通单信息");
    }

    @Override
    protected void generation() {
        log.info("开始组织普通单信息");
    }

}
