package org.ansj.web.webApi.controllers;

import org.ansj.domain.Result;
import org.ansj.splitWord.analysis.NlpAnalysis;
import org.ansj.splitWord.analysis.ToAnalysis;
import org.ansj.web.common.models.ResponseData;
import org.ansj.web.common.models.StdResponseData;

import org.ansj.web.webApi.models.ParticipleRequest;
import org.nlpcn.commons.lang.util.StringUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by lianghongpeng on 2016/8/26.
 */
@RestController
@RequestMapping("/api/nlp")
public class NLPController extends BaseController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseData Test(HttpServletRequest request, HttpServletResponse response) {

        String str = "欢迎使用ansj_seg,(ansj中文分词)在这里如果你遇到什么问题都可以联系我.我一定尽我所能.帮助大家.ansj_seg更快,更准,更自由!";

        StdResponseData<Result> data = new StdResponseData<>();
        Result rst = ToAnalysis.parse(str);

        data.setData(rst);

        return data;
    }

    /**
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/participle", method = RequestMethod.POST)
    public ResponseData Participle(@RequestBody ParticipleRequest requestModel, HttpServletRequest request, HttpServletResponse response) {

        if (requestModel == null) {
            return ErrorParamsResponse("参数为空");
        }

        StdResponseData<Result> data = new StdResponseData<>();

        String content = requestModel.getContent();

        if (StringUtil.isBlank(content)) {
            return ErrorParamsResponse("content is not null");
        }

        List<String> filters = requestModel.getFilter();

        if (filters != null)
            for (String f : filters) {

                switch (f) {
                    case "removeHtmlTag":
                        content = StringUtil.rmHtmlTag(content);
                        break;
                }
            }

        String analyzer = requestModel.getAnalyzer();


        Result rst = null;
        switch (analyzer) {

            case "nlp":
            default:
                rst = NlpAnalysis.parse(content);
                break;
        }


        /**
         * { word:[],newWord:[],tfs: }
         *
         *
         *
         */


        data.setData(rst);

        return data;
    }


}
