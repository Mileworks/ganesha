package cn.com.epicc.ganesha.integral.service;

import cn.com.epicc.ganesha.integral.config.IntegralError;
import cn.com.epicc.ganesha.integral.exception.IntegralException;
import org.apache.commons.lang3.StringUtils;

/**
 * Description: 积分模块抽象类
 * Author: lishangmin
 * Created: 2018-07-05 13:56
 */
public abstract class IIntegralServiceAbstract implements IIntegralService{

    /**
     * 验证账户ID 不为Null 不为空
     * @param accountId 账户ID
     */
    public void validAccountId(String accountId){
        if(StringUtils.isEmpty(StringUtils.trim(accountId))){
            throw new IntegralException(IntegralError.ACCOUNT_ID_ERROR);
        }
    }

    /**
     * 验证积分数值 大于0 不为null
     * @param amount 积分数值
     */
    public void validIntegralValue(Long amount){
        if(amount == null || amount <=0){
            throw new IntegralException(IntegralError.INTEGRAL_VALUE_ERROR);
        }
    }

    /**
     * 验证账户ID 和 积分数值
     * @param accountIds 账户ID
     * @param amount     积分数值
     */
    public void validAccountIdAndIntegralValue(Long amount ,String... accountIds){
        for (String accountId: accountIds) {
            this.validAccountId(accountId);
        }
        this.validIntegralValue(amount);
    }

}
