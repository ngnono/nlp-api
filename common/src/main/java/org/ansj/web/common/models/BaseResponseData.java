package org.ansj.web.common.models;

public class BaseResponseData<T> implements java.io.Serializable{
    //状态码,
    private int code = 200;

    private String msg = "";

    private T data ;

    public BaseResponseData(){
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T d) {
        this.data = d;
    }
}
