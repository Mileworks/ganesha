package cn.com.epicc.ganesha.integral.service.impl;

import cn.com.epicc.ganesha.integral.dao.AccountIntegralDAO;
import cn.com.epicc.ganesha.integral.service.IIntegralService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description: 积分服务实现
 * Author: lishangmin
 * Created: 2018-07-01 23:59
 */
@Service
@Slf4j
public class IntegralServiceImpl implements IIntegralService {

    @Autowired
    AccountIntegralDAO accountIntegralDAO;

    /**
     * 添加积分
     *
     * @param accountId 用户ID
     * @param value     增加积分数量
     * @return 是否成功
     */
    @Override
    public boolean add(String accountId, long value) {
        log.info("accountId:{},value:{}",accountId,value);
        if (value <= 0 || accountId == null){
            return false;
        }
        int updateRows = accountIntegralDAO.updateIntegralByAccountId(accountId,value);
        log.info("updateRows:{}",updateRows);
        return updateRows > 0;
    }

    /**
     * 扣减积分
     *
     * @param accountId 用户ID
     * @param value     扣减积分数量
     * @return 是否成功
     */
    @Override
    public boolean sub(String accountId, long value) {
        return false;
    }

    /**
     * 转移积分
     *
     * @param from  扣减账号
     * @param to    增减账户
     * @param value 转移积分数量
     * @return 是否成功
     */
    @Override
    public boolean trans(String from, String to, long value) {
        return false;
    }

    /**
     * 查询积分余额
     *
     * @param accountId 账户ID
     * @return 积分余额
     */
    @Override
    public Long getBalance(String accountId) {
        return null;
    }
}
