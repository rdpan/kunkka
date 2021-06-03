package com.hhl.kunkka.integration.feign;

import com.hhl.kunkka.common.constants.ClientConstant;
import com.hhl.kunkka.core.context.RootContext;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FeignReceiverHandleInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String xid = request.getHeader(ClientConstant.KEY_XID);
        if (!StringUtils.isEmpty(xid)) {
            RootContext.bindXID(xid);
        }
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        RootContext.unbindXID();
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }
}
