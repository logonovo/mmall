package com.mmall.common;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;

/**
 * @Author 小凡
 * Email: logonovo@gmail.com
 * @Date 2017/12/15 22:29
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
//保证序列化json时，如果为null，不显示key
public class ServerResponse<T>  implements Serializable{
    private int status;
    private String error;
    private T data;

    private ServerResponse(int status) {
        this.status = status;
    }

    private ServerResponse(int status, String error) {
        this.status = status;
        this.error = error;
    }

    private ServerResponse(int status, T data) {
        this.status = status;
        this.data = data;
    }

    private ServerResponse(int status, String error, T data) {
        this.status = status;
        this.error = error;
        this.data = data;
    }

    @JsonIgnore
    public boolean isSuccess(){
        return this.status == ResponseCode.SUCCESS.getCode();
    }

    public int getStatus(){
        return status;
    }

    public String getError() {
        return error;
    }

    public T getData() {
        return data;
    }

    public static <T> ServerResponse<T> createBySuccess(){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode());
    }

    public static <T> ServerResponse<T> createBySuccessMessage(String msg){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), msg);
    }

    public static <T> ServerResponse<T> createBySuccess(T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), data);
    }

    public static <T> ServerResponse<T> createBySuccess(String msg, T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), msg, data);
    }

    public static <T> ServerResponse<T> createByError(){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getDesc());
    }

    public static <T> ServerResponse<T> createByErrorMessage(String message){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),message);
    }

    public static <T> ServerResponse<T> createByErrorCodeMessage(int errorCode, String errorMessage){
        return new ServerResponse<T>(errorCode, errorMessage);
    }
}
