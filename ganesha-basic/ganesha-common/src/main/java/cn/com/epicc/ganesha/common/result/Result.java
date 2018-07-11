package cn.com.epicc.ganesha.common.result;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Description: 通用返回模板
 * Author: lishangmin
 * Created: 2018-05-21 15:41
 */
@SuppressWarnings("deprecation")
@Getter
@Setter
@JsonSerialize(include =  JsonSerialize.Inclusion.NON_NULL)
public class Result<T> implements Serializable {

    /**
     * 状态
     */
    private String status;

    /**
     * 信息
     */
    private String msg;

    /**
     * 内容
     */
    private T data;

    public Result() {
    }

    public Result(String status,String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public Result(String status,String msg) {
        this.status = status;
        this.msg = msg;
    }

    /**
     * 返回成功
     */
    public static <T> Result<T> success(){
        return new Result<>(ResultCode.SUCCESS.getStatus(),ResultCode.SUCCESS.getMsg());
    }

    public static <T> Result<T> successWithMsg(String msg){
        return new Result<>(ResultCode.SUCCESS.getStatus(),msg);
    }

    public static <T> Result<T> success(T data){
        return new Result<>(ResultCode.SUCCESS.getStatus(),ResultCode.SUCCESS.getMsg(),data);
    }

    public static <T> Result<T> success(String msg, T data){
        return new Result<>(ResultCode.SUCCESS.getStatus(),msg,data);
    }

    /**
     * 返回失败
     */
    public static <T> Result<T> error(){
        return new Result<>(ResultCode.ERROR.getStatus(),ResultCode.ERROR.getMsg());
    }

    public static <T> Result<T> error(String msg){
        return new Result<>(ResultCode.ERROR.getStatus(),msg);
    }

    public static <T> Result<T> error(String status, String msg){
        return new Result<>(status,msg);
    }

    public static <T> Result<T> error(ResultCode resultCode){
        return new Result<>(resultCode.getStatus(),resultCode.getMsg());
    }

    public static <T> Result<T> error(ResultCode resultCode,T data){
        return new Result<>(resultCode.getStatus(),resultCode.getMsg(),data);
    }

    //JackSon Ignore For RestController
    @JsonIgnore
    //FastJson Ignore For Normal Used
    @JSONField(serialize = false)
    public boolean isSuccess(){
        return this.status.equals(ResultCode.SUCCESS.getStatus());
    }
}
