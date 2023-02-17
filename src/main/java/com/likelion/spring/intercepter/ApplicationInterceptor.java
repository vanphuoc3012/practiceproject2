package com.likelion.spring.intercepter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class ApplicationInterceptor implements HandlerInterceptor {

    private final Logger LOG = LoggerFactory.getLogger(ApplicationInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LOG.info("PreHandle method is calling");

        request.setAttribute("startTime", System.currentTimeMillis());
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        LOG.info("PostHandle method is calling");

        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        LOG.info("AfterCompletion method is calling");
        long startTime = (long) request.getAttribute("startTime");
        long executeTime = System.currentTimeMillis() - startTime;
        LOG.info("Calling '{}' take: {} ms", request.getServletPath(), executeTime);
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
