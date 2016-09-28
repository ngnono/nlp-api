package com.awb.web.webApi.controllers;

import com.awb.web.common.TfIdf;
import com.awb.web.webApi.models.ParticipleModel;
import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.NlpAnalysis;
import com.awb.web.common.models.ResponseData;
import com.awb.web.common.models.StdResponseData;

import com.awb.web.webApi.models.ParticipleRequest;
import org.nlpcn.commons.lang.util.StringUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Created by lianghongpeng on 2016/8/26.
 */
@RestController
@RequestMapping("/api/nlp")
public class NLPController extends BaseController {
    /**
     * 分词
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/participle", method = RequestMethod.POST)
    public ResponseData participle(@RequestBody ParticipleRequest requestModel, HttpServletRequest request, HttpServletResponse response) {

        if (requestModel == null) {
            return ErrorParamsResponse("参数为空");
        }



        String content = requestModel.getContent();

        if (StringUtil.isBlank(content)) {
            return ErrorParamsResponse("content is not null");
        }

        List<String> filters = requestModel.getFiltering();

        if (filters != null)
            for (String f : filters) {

                switch (f) {
                    case "removeHtmlTag":
                        content = StringUtil.rmHtmlTag(content);
                        break;
                }
            }

        String analyzer = requestModel.getAnalyzer();

        analyzer = StringUtil.isBlank(analyzer) ? "" : analyzer;

        Result rst = null;

        switch (analyzer) {
            case "nlp":
            default:
                rst = NlpAnalysis.parse(content);
                break;
        }

        Collection<String> documents = new ArrayList<>();
        Map<String, ParticipleModel> dict = new HashMap<>();

        for (Term t : rst) {

            String n = t.getName();
            //filter
            if (StringUtil.isBlank(n)) {
                continue;
            }

            documents.add(t.getName());
            ParticipleModel pm = new ParticipleModel();
            pm.setName(t.getName());
            pm.setIsNewWord(t.isNewWord());
            //
            pm.setTermNatures(t.getNatureStr());

            //后一个替换前一个
            dict.put(t.getName(), pm);
        }

        List<String> resultPlus = requestModel.getResultPlus();
        if (resultPlus != null) {
            Map<String, Double> tf = null;

            for (String p : resultPlus) {
                switch (p) {
                    case "tf":
                        tf = TfIdf.tf(documents);
                        break;
                }
            }

            if (tf != null) {

                for (String key : dict.keySet()) {

                    Double tfValue = tf.getOrDefault(key, 0d);

                    dict.get(key).setTf(tfValue.intValue());
                }
            }
        }

        StdResponseData<Collection<ParticipleModel>> data = new StdResponseData<>();

        /**
         * {
         *     status:true,code:200,data:{[{name:"",},]}
         * }
         *
         *
         *
         */

        Collection<ParticipleModel> c =  dict.values();

        data.setData(c);

        return data;
    }
}
