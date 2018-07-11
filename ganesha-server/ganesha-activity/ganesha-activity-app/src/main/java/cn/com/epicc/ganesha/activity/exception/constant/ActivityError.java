package cn.com.epicc.ganesha.activity.exception.constant;

import cn.com.epicc.ganesha.common.result.ResultCode;

/**
 * Description: 积分模块异常配置
 * Author: lishangmin
 * Created: 2018-07-05 13:52
 */
public class ActivityError extends ResultCode {

    public static final ActivityError TIME_FORMAT_ERROR = new ActivityError("300001","错误的日期格式");

    private ActivityError(String status, String msg) {
        super(status, msg);
    }
}
