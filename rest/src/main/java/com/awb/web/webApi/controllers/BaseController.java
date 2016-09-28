package com.awb.web.webApi.controllers;

import com.awb.web.common.models.ResponseData;
import com.awb.web.common.models.StdResponseData;

/**
 * Created by lianghongpeng on 2016/8/29.
 */
public abstract class BaseController {

    /**
     * 参数错误
     * @param msg
     * @return
     */
    protected ResponseData ErrorParamsResponse(String msg) {
        ResponseData rst = new ResponseData() {
        };
        rst.setCode(400);
        rst.setMsg(msg);

        return rst;
    }

    /**
     *  正确
     * @param data
     * @param <T>
     * @return
     */
    protected <T> ResponseData OkResponse(T data) {
        StdResponseData<T> rst = new StdResponseData();

        rst.setCode(200);
        rst.setData(data);

        return rst;
    }

    /**
     *  服务 SERVER
     * @param msg
     * @return
     */
    protected ResponseData ErrorServerResponse(String msg){
        ResponseData rst = new ResponseData();

        rst.setCode(500);
        rst.setMsg(msg);

        return rst;
    }

}
