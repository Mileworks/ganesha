package cn.com.epicc.ganesha.integral.service;

import cn.com.epicc.ganesha.integral.entity.IntegralType;

/**
 * Description: 积分接口
 * Author: lishangmin
 * Created: 2018-07-01 23:46
 */
public interface IIntegralService {

    /**
     * 添加积分
     * @param operator     操作用户
     * @param accountId    用户ID
     * @param amount       增加积分数量
     * @param integralType 积分类型
     * @param activityId   活动ID
     * @return 是否成功
     */
    boolean add(String operator, String accountId, long amount, IntegralType integralType, String activityId);

    /**
     * 扣减积分
     * @param accountId  用户ID
     * @param amount     扣减积分数量
     * @return 是否成功
     */
    boolean sub(String accountId, long amount);

    /**
     * 转移积分
     * @param from   扣减账号
     * @param to     增减账户
     * @param amount 转移积分数量
     * @return 是否成功
     */
    boolean trans(String from, String to, long amount);

    /**
     * 查询积分余额
     * @param accountId 账户ID
     * @return 积分余额
     */
    Long getBalance(String accountId);
}
