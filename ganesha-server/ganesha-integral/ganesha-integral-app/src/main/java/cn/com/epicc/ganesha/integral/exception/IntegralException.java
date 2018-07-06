package cn.com.epicc.ganesha.integral.exception;

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
public class IntegralException extends RuntimeException {

    //错误代码
    private String code;

    public IntegralException() {
    }

    public IntegralException(String code) {
        this.code = code;
    }

    public IntegralException(String code, String message) {
        super(message);
        this.code = code;
    }

    public IntegralException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public IntegralException(Throwable cause, String code) {
        super(cause);
        this.code = code;
    }

    public IntegralException(Throwable cause) {
        super(cause);
    }

    public IntegralException(ResultCode resultCode){
        super(resultCode.getMsg());
        this.code = resultCode.getStatus();
    }
}
