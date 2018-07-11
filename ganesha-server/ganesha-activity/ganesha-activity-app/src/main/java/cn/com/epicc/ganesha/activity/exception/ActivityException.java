package cn.com.epicc.ganesha.activity.exception;

import cn.com.epicc.ganesha.common.result.ResultCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Description: 自定义异常
 * Author: lishangmin
 * Created: 2018-07-05 13:39
 */
@Setter
@Getter
public class ActivityException extends RuntimeException {

    //错误代码
    private String code;

    public ActivityException() {
    }

    public ActivityException(String code) {
        this.code = code;
    }

    public ActivityException(String code, String message) {
        super(message);
        this.code = code;
    }

    public ActivityException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public ActivityException(Throwable cause, String code) {
        super(cause);
        this.code = code;
    }

    public ActivityException(Throwable cause) {
        super(cause);
    }

    public ActivityException(ResultCode resultCode){
        super(resultCode.getMsg());
        this.code = resultCode.getStatus();
    }
}
