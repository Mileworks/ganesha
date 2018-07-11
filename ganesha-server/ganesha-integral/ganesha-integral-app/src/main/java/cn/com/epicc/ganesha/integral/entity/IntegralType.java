package cn.com.epicc.ganesha.integral.entity;

import cn.com.epicc.ganesha.integral.exception.IntegralException;
import cn.com.epicc.ganesha.integral.exception.constant.IntegralError;
import lombok.Getter;

/**
 * Description: 积分来源类型
 * Author: lishangmin
 * Created: 2018-07-06 17:34
 */
@Getter
public enum IntegralType {

    SIGN(0,"签到"),

    ACTIVITY(1,"活动"),

    TRANS(2,"转账")

    ;

    int type;

    String desc;

    IntegralType(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public static boolean isContain(IntegralType sourceType){
        IntegralType[] integralTypes = IntegralType.values();
        for (IntegralType in : integralTypes) {
            if(in.equals(sourceType)){
                return true;
            }
        }
        return false;
    }

    public static IntegralType convert(Integer sourceType){
        if(sourceType == null){
            throw new IntegralException(IntegralError.INTEGRAL_VALUE_ERROR);
        }
        IntegralType[] integralTypes = IntegralType.values();
        for (IntegralType in : integralTypes) {
            if(in.type == sourceType){
                return in;
            }
        }
        throw new IntegralException(IntegralError.INTEGRAL_VALUE_ERROR);
    }
}
