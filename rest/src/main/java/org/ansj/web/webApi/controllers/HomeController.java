package org.ansj.web.webApi.controllers;

import org.ansj.web.common.models.ResponseData;
import org.ansj.web.common.utils.NumberUtils;
import org.ansj.web.common.utils.StringUtils;
import org.ansj.web.common.utils.security.SecurityUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by lianghongpeng on 2016/8/25.
 */
@RestController
@RequestMapping("/api/home")
public class HomeController {

    @RequestMapping(value = "/a", method = RequestMethod.GET)
    public ResponseData index(HttpServletRequest request, HttpServletResponse response) {
        ResponseData data = new ResponseData();

        String orderPkIdStr = StringUtils.trimToEmpty(request.getParameter("id"));

        data.setData(orderPkIdStr);

        return data;
    }
}
