package com.awb.web.common.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by lianghongpeng on 2016/8/25.
 */
public class ResponseData implements java.io.Serializable {
    //状态码,
    @JsonProperty("code")
    protected int code = 200;

    /**
     * 状态 200～299 都是 true 其余 false
     */
    @JsonProperty("status")
    private boolean status = true;

    @JsonProperty("msg")
    private String msg = "";

    public ResponseData() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
        if (code >= 200 && code < 300) {
            this.setStatus(true);
        } else {
            this.setStatus(false);
        }
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}


