package com.awb.web.webApi.models;

import java.io.Serializable;

/**
 * Created by lianghongpeng on 2016/8/29.
 */
public class ParticipleModel implements Serializable {
    private static final long serialVersionUID = 1L;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTermNatures() {
        return termNatures;
    }

    public void setTermNatures(String termNatures) {
        this.termNatures = termNatures;
    }

    public Integer getTf() {
        return tf;
    }

    public void setTf(Integer tf) {
        this.tf = tf;
    }

    public boolean getIsNewWord() {
        return this.isNewWord;
    }

    public void setIsNewWord(boolean isNewWord) {
        this.isNewWord = isNewWord;
    }

    /**
     * 词
     */
    private String name;

    /**
     * 词性
     */
    private String termNatures;

    /**
     * 词频
     */
    private Integer tf;

    /**
     * 是否 新词
     */
    private boolean isNewWord;
}
