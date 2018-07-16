package cn.com.epicc.ganesha.integral.service.impl;

import cn.com.epicc.ganesha.common.util.CommonUtil;
import cn.com.epicc.ganesha.integral.dao.IntegralAddEventDao;
import cn.com.epicc.ganesha.integral.dao.IntegralDao;
import cn.com.epicc.ganesha.integral.entity.IntegralType;
import cn.com.epicc.ganesha.integral.exception.IntegralException;
import cn.com.epicc.ganesha.integral.exception.constant.IntegralError;
import cn.com.epicc.ganesha.integral.model.IntegralAddEvent;
import cn.com.epicc.ganesha.integral.service.IIntegralServiceAbstract;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Description: 积分服务实现
 * Author: lishangmin
 * Created: 2018-07-01 23:59
 */
@Service
@Slf4j
public class IntegralServiceImpl extends IIntegralServiceAbstract {

    @Autowired
    private IntegralDao integralDao;

    @Autowired
    private IntegralAddEventDao integralAddEventDao;

    /**
     * 添加积分
     *
     * @param operator     操作用户
     * @param accountId    用户ID
     * @param amount       增加积分数量
     * @param integralType 积分类型
     * @param activityId   活动ID
     * @return 是否成功
     */
    @Override
    @Transactional
    public boolean add(String operator, String accountId, long amount, IntegralType integralType, String activityId) {
        this.validAccountIdAndIntegralValue(amount,accountId,operator);
        IntegralAddEvent integralAddEvent = IntegralAddEvent
                .builder()
                .accountId(accountId)
                .amount(amount)
                .operator(operator)
                .source(integralType.getType())
                .activityId(activityId)
                .build();
        int insertRows = integralAddEventDao.insert(integralAddEvent);
        int updateRows = integralDao.addIntegralByAccountId(accountId,amount);
        return updateRows > 0 && insertRows > 0;
    }

    /**
     * 扣减积分
     *
     * @param accountId 用户ID
     * @param amount     扣减积分数量
     * @return 是否成功
     */
    @Override
    @Transactional
    public boolean sub(String accountId, long amount) {
        this.validAccountIdAndIntegralValue(amount,accountId);
        int updateRows = integralDao.subIntegralByAccountId(accountId,amount);
        return updateRows > 0;
    }

    /**
     * 转移积分
     *
     * @param from   扣减账号
     * @param to     增加账户
     * @param amount 转移积分数量
     * @return 是否成功
     */
    @Override
    @Transactional
    public boolean trans(String from, String to, long amount) {
        log.info("from :{},to :{}",from,to);
        this.validAccountIdAndIntegralValue(amount,from,to);
        if(from.equals(to)){
            throw new IntegralException(IntegralError.SAME_ACCOUNT_ID_ERROR);
        }
        Integer fromDigital = CommonUtil.strToDigital(from);
        Integer toDigital = CommonUtil.strToDigital(to);
        int updateFrom;
        int updateTo;
        //防止死锁问题
        if(fromDigital > toDigital){
            updateFrom = integralDao.subIntegralByAccountId(from,amount);
            updateTo = integralDao.addIntegralByAccountId(to,amount);
        }else{
            updateTo = integralDao.addIntegralByAccountId(to,amount);
            updateFrom = integralDao.subIntegralByAccountId(from,amount);
        }
        if(updateFrom <= 0 || updateTo <=0){
            throw new IntegralException(IntegralError.TRANS_ERROR);
        }
        return true;
    }

    /**
     * 查询积分余额
     *
     * @param accountId 账户ID
     * @return 积分余额
     */
    @Override
    public Long getBalance(String accountId) {
        this.validAccountId(accountId);
        return integralDao.selectBalanceByAccountId(accountId);
    }
}
