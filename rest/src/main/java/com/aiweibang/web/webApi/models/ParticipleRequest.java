package com.aiweibang.web.webApi.models;

import java.util.Dictionary;
import java.util.List;

/**
 * Created by lianghongpeng on 2016/8/29.
 */
public class ParticipleRequest {

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 内容
     */
    private String content;

    public List<String> getFiltering() {
        return filtering;
    }

    public void setFiltering(List<String> filtering) {
        this.filtering = filtering;
    }

    /**
     *  分词前 过滤器
     *
     *  1.htmlTagFilter
     *  2.标准化
     *
     *
     *
     */
    private List<String> filtering;

    public List<String> getFiltered() {
        return filtered;
    }

    public void setFiltered(List<String> filtered) {
        this.filtered = filtered;
    }

    /**
     * 分词后 过滤
     */
    private List<String> filtered;

    public String getAnalyzer() {
        return analyzer;
    }

    public void setAnalyzer(String analyzer) {
        this.analyzer = analyzer;
    }

    /**
     * 分析器
     */
    private String analyzer;

//    public List<String> getResultPlus() {
//        return resultPlus;
//    }
//
//    public void setResultPlus(List<String> resultPlus) {
//        this.resultPlus = resultPlus;
//    }
//
//    /**
//     * 分词结果附加功能
//
//     */
//    private List<String> resultPlus;

    public Integer getTake() {
        return take;
    }

    public void setTake(Integer take) {
        this.take = take;
    }

    /**
     * 取的返回结果数，默认是所有
     */
    private Integer take;

    public Integer getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(Integer orderBy) {
        this.orderBy = orderBy;
    }

    /**
     * 排序方式
     * 0 ，null := 默认
     * 2 ，tf desc := 当附加TF时 可用，否则为默认，  根据TF 倒序排列
     * 1 ，tf asc  := 当附加TF时 可用，否则为默认，  根据TF 正序排列
     */
    private Integer orderBy;

    public Integer getSkip() {
        return skip;
    }

    public void setSkip(Integer skip) {
        this.skip = skip;
    }

    /**
     * 跳过的记录数 默认为0
     */
    private Integer skip;


    public Boolean getHasTf() {
        return hasTf;
    }

    public void setHasTf(Boolean hasTf) {
        this.hasTf = hasTf;
    }

    /**
     * 是否进行 TF计算
     */
    private Boolean hasTf;
}
