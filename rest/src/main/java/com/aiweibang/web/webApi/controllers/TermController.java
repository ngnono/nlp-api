package com.aiweibang.web.webApi.controllers;

import com.aiweibang.web.common.models.ResponseData;
import com.aiweibang.web.common.models.StdResponseData;
import com.aiweibang.web.webApi.models.ParticipleRequest;
import org.ansj.domain.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lianghongpeng on 2016/9/26.
 */
@RestController
@RequestMapping("/api/term")
public class TermController extends BaseController{

    /**
     * 文档词频
     * @param requestModel
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/tf", method = RequestMethod.POST)
    public ResponseData tf(@RequestBody ParticipleRequest requestModel, HttpServletRequest request, HttpServletResponse response) {

        if (requestModel == null) {
            return ErrorParamsResponse("参数为空");
        }

        StdResponseData<Result> data = new StdResponseData<>();

        return data;
    }
}
