package com.aiweibang.web.webApi.controllers;

import com.aiweibang.web.common.TfIdf;
import com.aiweibang.web.common.utils.CollectionUtils;
import com.aiweibang.web.webApi.models.ParticipleRequest;
import com.aiweibang.web.webApi.models.ParticipleModel;
import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.NlpAnalysis;
import com.aiweibang.web.common.models.ResponseData;
import com.aiweibang.web.common.models.StdResponseData;

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
     * 过滤 无用的 TERM
     *
     * @param filtered
     * @param t
     * @return
     */
    private static boolean Filtered(List<String> filtered, Term t) {
        boolean isFilterd = false;

        for (String f : filtered) {
            switch (f) {
                case "termNatures-w":
                    if (StringUtil.isNotBlank(t.getNatureStr()) && t.getNatureStr().startsWith("w")) {
                        isFilterd = true;
                    }

                    break;
                case "termNatures-null":
                    if (StringUtil.isBlank(t.getNatureStr())) {
                        isFilterd = true;
                    }
                    break;
            }
        }

        return isFilterd;
    }

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

        // 分词后过滤
        List<String> filtered = requestModel.getFiltered();
        // 是否TF
        Boolean hasTf = requestModel.getHasTf();
        Collection<String> documents = new ArrayList<>();
        Map<String, ParticipleModel> dict = new HashMap<>();

        for (Term t : rst) {

            //标点过滤
            //只有 词性时根据词性 过滤
            boolean isFilterd = false;
            if (filtered != null) {
                isFilterd = Filtered(filtered, t);
            }

            if (isFilterd) {
                continue;
            }

            String n = t.getName();
            //filter
            if (StringUtil.isBlank(n)) {
                continue;
            }

            if (hasTf != null && hasTf) {
                documents.add(t.getName());
            }

            ParticipleModel pm = new ParticipleModel();
            pm.setName(t.getName());
            pm.setIsNewWord(t.isNewWord());
            //
            pm.setTermNatures(t.getNatureStr());

            //后一个替换前一个
            dict.put(t.getName(), pm);
        }


        //分词结果 过滤
        if (hasTf != null && hasTf) {
            Map<String, Double> tf = TfIdf.tf(documents);

            for (String key : dict.keySet()) {

                Double tfValue = tf.getOrDefault(key, 0d);

                dict.get(key).setTf(tfValue.intValue());
            }
        }

        StdResponseData<ArrayList<ParticipleModel>> data = new StdResponseData<>();

        /**
         * {
         *     status:true,code:200,data:{[{name:"",},]}
         * }
         */

        Collection<ParticipleModel> cls = dict.values();

        ArrayList<ParticipleModel> list = CollectionUtils.toArray(cls);

        /**
         * order and top , skip
         */

        if (requestModel.getOrderBy() != null && hasTf != null && hasTf) {
            //asc
            switch (requestModel.getOrderBy()) {
                case 1: //tf asc
                    Collections.sort(list, (l, r)
                            -> l.getTf() - r.getTf());
                    break;
                case 2://tf desc
                    Collections.sort(list, (l, r)
                            -> r.getTf() - l.getTf());
                    break;
                default:
                    break;
            }
        }

        if (requestModel.getTake() != null) {
            list = CollectionUtils.take(list, requestModel.getTake());
        }

        data.setCode(200);
        data.setData(list);

        return data;
    }
}
