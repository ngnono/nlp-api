package com.awb.web.webApi.models;

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

    public List<String> getResultPlus() {
        return resultPlus;
    }

    public void setResultPlus(List<String> resultPlus) {
        this.resultPlus = resultPlus;
    }

    /**
     * 分词结果附加功能

     */
    private List<String> resultPlus;
}
