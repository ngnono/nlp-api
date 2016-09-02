package org.ansj.web.webApi.models;

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

    public List<String> getFilter() {
        return filter;
    }

    public void setFilter(List<String> filter) {
        this.filter = filter;
    }

    /**
     * 内容
     */
    private String content;

    /**
     * 过滤器
     *
     *  1.htmlTagFilter
     *
     *
     */
    private List<String> filter;

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
}
