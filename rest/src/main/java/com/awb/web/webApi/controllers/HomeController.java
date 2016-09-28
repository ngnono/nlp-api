package com.awb.web.webApi.controllers;

import com.awb.web.common.models.ResponseData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lianghongpeng on 2016/8/25.
 */
@RestController
@RequestMapping("/api/home")
public class HomeController extends BaseController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseData index(HttpServletRequest request, HttpServletResponse response) {

        return OkResponse("hello world!!!!");
    }
}
