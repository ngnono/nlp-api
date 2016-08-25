package org.ansj.web.common.models;

/**
 * Created by lianghongpeng on 2016/8/25.
 */
public class ResponseData extends BaseResponseData<Object>{
    //状态码,
    private int code = 200;

    private String msg = "";

    private Object data = "";

    public ResponseData(){
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}


