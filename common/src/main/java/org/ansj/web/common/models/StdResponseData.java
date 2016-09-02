package org.ansj.web.common.models;

public class StdResponseData<T> extends ResponseData {
    /**
     * 数据
     */
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
