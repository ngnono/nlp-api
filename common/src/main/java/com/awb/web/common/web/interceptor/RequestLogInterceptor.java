package com.awb.web.common.web.interceptor;

import com.awb.web.common.Constant;
import com.awb.web.common.utils.WebUtils;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lianghongpeng on 2016/8/25.
 */
public class RequestLogInterceptor extends HandlerInterceptorAdapter {
    private static Logger log = Logger.getLogger(RequestLogInterceptor.class);


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String requestId = WebUtils.getRequestId();
        String ip = WebUtils.getIpAddr(request);
        String uri = request.getRequestURI();
        String para = WebUtils.getParaStr(request);
        String ticket = WebUtils.getCookieValue(Constant.COOKIE_LOGIN_TICKET, request);
        log.info("access_log, ticket="+ ticket +", requestId=" + requestId + ", ip=" + ip + ", uri=" + uri + ", para=(" + para + "), handler=" + handler);
        return true;
    }


    @Override
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {
    }


    @Override
    public void afterCompletion(
            HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }

    @Override
    public void afterConcurrentHandlingStarted(
            HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
    }
}
