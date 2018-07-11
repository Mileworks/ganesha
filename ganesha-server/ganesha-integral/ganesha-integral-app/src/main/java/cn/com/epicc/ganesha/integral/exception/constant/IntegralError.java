package cn.com.epicc.ganesha.integral.exception.constant;

import cn.com.epicc.ganesha.common.result.ResultCode;

/**
 * Description: 积分模块异常配置
 * Author: lishangmin
 * Created: 2018-07-05 13:52
 */
public class IntegralError extends ResultCode {

    public static final IntegralError ACCOUNT_ID_ERROR = new IntegralError("200001","错误的账号ID");

    public static final IntegralError INTEGRAL_VALUE_ERROR = new IntegralError("200002","错误的积分数值");

    public static final IntegralError TRANS_ERROR = new IntegralError("200003","积分转移失败");

    public static final IntegralError SAME_ACCOUNT_ID_ERROR = new IntegralError("200004","相同的账户ID");

    public static final IntegralError SOURCE_TYPE_ERROR = new IntegralError("200005","错误的积分类型");

    public static final IntegralError ACTIVITY_ERROR = new IntegralError("200005","积分活动不存在");

    private IntegralError(String status, String msg) {
        super(status, msg);
    }
}
