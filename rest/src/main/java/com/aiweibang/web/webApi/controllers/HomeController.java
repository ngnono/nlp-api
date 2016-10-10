package com.aiweibang.web.webApi.controllers;

import com.aiweibang.web.common.models.ResponseData;
import com.aiweibang.web.common.models.StdResponseData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lianghongpeng on 2016/8/25.
 */
@RestController
@RequestMapping(value = {"/", "/api", "/home"})
public class HomeController extends BaseController {

    /**
     * 首页
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseData index(HttpServletRequest request, HttpServletResponse response) {
        StdResponseData<Object> data = new StdResponseData<>();
        data.setCode(200);
        data.setData("ok");

        return data;
    }

    /**
     * 状态
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = {"/status", "status", "/status.html"}, method = RequestMethod.GET)
    public String status(HttpServletRequest request, HttpServletResponse response) {

        return "running";
    }
}
