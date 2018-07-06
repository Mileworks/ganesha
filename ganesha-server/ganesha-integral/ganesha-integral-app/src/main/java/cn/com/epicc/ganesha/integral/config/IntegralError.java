package cn.com.epicc.ganesha.integral.config;

import cn.com.epicc.ganesha.common.result.ResultCode;

/**
 * Description: 积分模块异常配置
 * Author: lishangmin
 * Created: 2018-07-05 13:52
 */
public class IntegralError extends ResultCode {

    public static IntegralError ACCOUNT_ID_ERROR = new IntegralError("200001","错误的账号ID");

    public static IntegralError INTEGRAL_VALUE_ERROR = new IntegralError("200002","错误的积分数值");

    public static IntegralError TRANS_ERROR = new IntegralError("200003","积分转移失败");

    public static IntegralError SAME_ACCOUNT_ID_ERROR = new IntegralError("200004","相同的账户ID");

    public IntegralError(String status, String msg) {
        super(status, msg);
    }
}
