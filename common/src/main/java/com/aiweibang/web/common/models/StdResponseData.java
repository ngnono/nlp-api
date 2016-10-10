package com.aiweibang.web.common.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StdResponseData<T> extends ResponseData {
    /**
     * 数据
     */
    @JsonProperty("data")
    private T data;

    public StdResponseData() {
    }

    public T getData() {
        return data;
    }

    public void setData(T d) {
        this.data = d;
    }
}
