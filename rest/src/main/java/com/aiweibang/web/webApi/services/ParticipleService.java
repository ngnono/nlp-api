package com.aiweibang.web.webApi.services;

import com.aiweibang.web.webApi.models.ParticipleRequest;

/**
 * Created by lianghongpeng on 2016/8/29.
 */
public interface ParticipleService {
    /**
     * 分词处理
     * @param req
     * @return
     */
    String Process(ParticipleRequest req);

//    /**
//     *  精准，标准分词
//     * @param req
//     * @return
//     */
//    String ToAnalysis(ParticipleRequest req);
//
//    /**
//     * 用户自定义词典优先策略的分词
//     * @param req
//     * @return
//     */
//    String DicAnalysis(ParticipleRequest req);
//
//    /**
//     *
//     * @param req
//     * @return
//     */
//    String NlpAnalysis(ParticipleRequest req);
//
//    /**
//     * 面向索引的分词
//     *
//     * @param req
//     * @return
//     */
//    String  IndexAnalysis (ParticipleRequest req);
}
