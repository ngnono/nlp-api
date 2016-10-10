package com.aiweibang.web.common;

import com.aiweibang.web.common.utils.WebUtils;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lianghongpeng on 2016/8/25.
 */
public class ApplicationHandlerExceptionResolver extends AbstractHandlerExceptionResolver {

    private static Logger log = Logger.getLogger(ApplicationHandlerExceptionResolver.class);

    @Override
    public ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        String requestId = WebUtils.getRequestId();
        String ip = WebUtils.getIpAddr(request);
        String uri = request.getRequestURI();
        String para = WebUtils.getParaStr(request);
        log.error("error_log, requestId=" + requestId + ", ip=" + ip + ", uri=" + uri + ", para=(" + para + "), handler=" + handler, ex);
        ModelAndView mv = new ModelAndView("jsonView");
        mv.addObject("code", -1);
        mv.addObject("msg", "系统异常["+ex.getMessage()+"]");
        mv.addObject("data","");
        response.setStatus(500);
        return mv;
    }
}
